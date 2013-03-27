package net.dfrz.supershop01.utils;


import java.sql.Connection;
import java.sql.SQLException;
import net.dfrz.supershop01.exception.DataAccessException;

/**                
 * Project: supershop01-02
 * ClassName: TransactionManager                                                        
 * Module ID: 4.6  
 * Comments: ������  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-9
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
	 * ��������
	 * @throws DAOException
	 */
	public void beginTransaction(){
		try {
			 //�������ύ��ʽ��Ϊ�ֹ��ύ
			 conn.setAutoCommit(false); 
		} catch (SQLException e) {
			throw new DataAccessException("��ʼ����ʱ�����쳣",e);
		}
	}
	
	/**
	 * �ύ����
	 * @throws DAOException
	 */
	public void commitAndClose(){
		try {
			conn.commit();
		} catch (SQLException e) {
			throw new DataAccessException("�ύ����ʱ�����쳣",e);
		}finally{
			DBUtils.getInstance().releaseConn(conn);
		}
	}
	
	/**
	 * �ع�����
	 * @throws DAOException
	 */
	public void rollbackAndClose(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			throw new DataAccessException("�ع�����ʱ�����쳣",e);
		}finally{
			DBUtils.getInstance().releaseConn(conn);
		}
	}
}
