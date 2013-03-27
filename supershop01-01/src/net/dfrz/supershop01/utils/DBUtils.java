/**
 * 
 */
package net.dfrz.supershop01.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.dfrz.supershop01.utils.TransactionManager;
import net.dfrz.supershop01.exception.DataAccessException;
/**                
 * Project: supershop01-01
 * ClassName: DBUtils                                                       
 * Module ID: 4.6  
 * Comments: ���ݿ����ӻ�ȡ������ 
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-9
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
 * @author J1205-supershop01                                                      
 * @version Version 10 
 */
public class DBUtils {
	
	
private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();	
	
   /**
    * ���ݿ����ӳػ�ȡ�����൥��
    */
	private static DBUtils me=new DBUtils();
	/**
	 * ���캯��
	 */
	private DBUtils() {}
	/**
	 * �������ݿ����ӳػ�ȡ������ĵ���
	 * @return DBUtils
	 */
	public static DBUtils getInstance()
	{
		return me;
	}
	
	//һ����̬���ڸ��౻���ص�ʱ���Զ�����һ�Σ�Ȼ�󽫲������С�
	static {
		try {			
			//�鿴��·�����Ƿ����������������
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}		
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return Connection
	 */
	public static synchronized Connection getConn()
	{
		
		//�ȴӵ�ǰ�߳���ȡ������ʵ��
		Connection conn = tl.get();	
		
		//�����ǰ�߳���û��Connection��ʵ�� 
		if(null == conn){ 				
			try {
				//�����ӳ���ȡ��һ������ʵ�� 
				conn = DriverManager.getConnection("proxool.supershop01-ds");
				//�����󶨵���ǰ�߳���
				tl.set(conn); 
			} catch (SQLException e) {					
				throw new DataAccessException("��ȡ����ʱ�쳣",e);
			}
		
		}
		
			
		return conn;
		
	}
	
	/**
	 * �ͷ����ݿ���Դ
	 * @param conn -���ݿ����Ӷ���
	 */
	public void releaseConn(Connection conn){
		if(conn!=null)  {
			tl.remove(); //�ͷŸ��߳��ϵ����Ӱ���
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * �ͷ����ݿ���Դ
	 * @param conn -���ݿ����Ӷ���
	 * @param pstmt -���ݿ�SQL׼�����
	 * @param rset -���ݿ��ѯ�����
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
	 * ��ȡ���ﴦ������
	 * @return TransactionManager
	 */
	public static synchronized TransactionManager getTranManager(){
		return new TransactionManager();
	}
	

}