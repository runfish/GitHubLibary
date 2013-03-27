package net.dfrz.supershop01.utils;


import java.sql.Connection;
import java.sql.SQLException;
import net.dfrz.supershop01.exception.DataAccessException;

/**                
 * Project: supershop01-02
 * ClassName: TransactionManager                                                        
 * Module ID: 4.6  
 * Comments: 事务处理  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.sql.Connection
 * @see java.sql.SQLException
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see #conn
 * @see #TransactionManager()
 * @see #beginTransaction()
 * @see #commitAndClose()
 * @see #rollbackAndClose()
 * @Author J1205-supershop01                                                      
 * @version Version 10 
 */
public class TransactionManager {
	

	private Connection conn;
	
	public TransactionManager() {
		this.conn = DBUtils.getInstance().getConn();
	}

	/**
	 * 开启事务
	 * @throws DAOException
	 */
	public void beginTransaction(){
		try {
			 //把事务提交方式改为手工提交
			 conn.setAutoCommit(false); 
		} catch (SQLException e) {
			throw new DataAccessException("开始事务时出现异常",e);
		}
	}
	
	/**
	 * 提交事务
	 * @throws DAOException
	 */
	public void commitAndClose(){
		try {
			conn.commit();
		} catch (SQLException e) {
			throw new DataAccessException("提交事务时出现异常",e);
		}finally{
			DBUtils.getInstance().releaseConn(conn);
		}
	}
	
	/**
	 * 回滚事务
	 * @throws DAOException
	 */
	public void rollbackAndClose(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			throw new DataAccessException("回滚事务时出现异常",e);
		}finally{
			DBUtils.getInstance().releaseConn(conn);
		}
	}
}
