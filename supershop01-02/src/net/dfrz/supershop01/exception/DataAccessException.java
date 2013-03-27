package net.dfrz.supershop01.exception;

/**                
 * Project: supershop01-02
 * ClassName: DataAccessException                                                          
 * Comments: 封装处理数据层异常  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-8
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see #DataAccessException()
 * @see #DataAccessException(String)
 * @see #DataAccessException(Throwable)
 * @see #DataAccessException(String, Throwable)
 * @author J1205-HongHG
 * @version 5
 */
public class DataAccessException extends ApplicationException {
	/**
	 *数据层异常的默认构造函数
	 */
	public DataAccessException() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 数据层异常的带参构造函数
	 * @param message -异常信息
	 */
	public DataAccessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 数据层异常的带参构造函数
	 * @param cause -异常对象
	 */
	public DataAccessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 数据层异常的带参构造函数
	 * @param message -异常信息
	 * @param cause -异常对象
	 */
	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
