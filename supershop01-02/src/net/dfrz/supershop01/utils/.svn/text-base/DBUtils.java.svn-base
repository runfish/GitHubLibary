
package net.dfrz.supershop01.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.dfrz.supershop01.utils.TransactionManager;
import net.dfrz.supershop01.exception.DataAccessException;
/**                
 * Project: supershop01-02
 * ClassName: DBUtils                                                       
 * Module ID: 4.6  
 * Comments: 数据库连接获取工具类 
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.sql.Connection
 * @see java.sql.DriverManager
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see net.dfrz.supershop01.utils.TransactionManager
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see #me
 * @see #DBUtils()
 * @see #getInstance()
 * @see #getConn()
 * @see #releaseConn(Connection)
 * @see #ReleaseRes(Connection, PreparedStatement, ResultSet)
 * @see #getTranManager()
 * @Author J1205-supershop01                                                      
 * @version Version 10 
 */
public class DBUtils {
	
	
private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();	
	
   /**
    * 数据库连接池获取工具类单例
    */
	private static DBUtils me=new DBUtils();
	/**
	 * 构造函数
	 */
	private DBUtils() {}
	/**
	 * 返回数据库连接池获取工具类的单例
	 * @return DBUtils
	 */
	public static DBUtils getInstance()
	{
		return me;
	}
	
	//一个静态块在该类被加载的时候，自动运行一次，然后将不再运行。
	static {
		try {			
			//查看类路径中是否存在这个驱动入口类
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}		
	}
	
	/**
	 * 获取数据库连接
	 * @return Connection
	 */
	public static synchronized Connection getConn()
	{
		
		//先从当前线程上取出连接实例
		Connection conn = tl.get();	
		
		//如果当前线程上没有Connection的实例 
		if(null == conn){ 				
			try {
				//从连接池中取出一个连接实例 
				conn = DriverManager.getConnection("proxool.supershop01-ds");
				//把它绑定到当前线程上
				tl.set(conn); 
			} catch (SQLException e) {					
				throw new DataAccessException("获取连接时异常",e);
			}
		
		}
		
			
		return conn;
		
	}
	
	/**
	 * 释放数据库资源
	 * @param conn -数据库连接对象
	 */
	public void releaseConn(Connection conn){
		if(conn!=null)  {
			tl.remove(); //释放该线程上的连接绑定器
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 释放数据库资源
	 * @param conn -数据库连接对象
	 * @param pstmt -数据库SQL准备语句
	 * @param rset -数据库查询结果集
	 */
	public void ReleaseRes(Connection conn,PreparedStatement pstmt,ResultSet rset)
	{
		try{
		  if(rset!=null) rset.close();
		  if(pstmt!=null) pstmt.close();
		 // if(conn !=null) conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * 获取事物处理的类
	 * @return TransactionManager
	 */
	public static synchronized TransactionManager getTranManager(){
		return new TransactionManager();
	}
	

}
