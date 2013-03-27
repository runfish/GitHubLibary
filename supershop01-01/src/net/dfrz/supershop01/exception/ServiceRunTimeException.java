/**
 * 
 */
package net.dfrz.supershop01.exception;

/**                
 * Project: supershop01-01
 * ClassName: ServiceRunTimeException                                                          
 * Comments: 封装处理业务逻辑层异常  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-8
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see #ServiceRunTimeException()
 * @see #ServiceRunTimeException(String)
 * @see #ServiceRunTimeException(Throwable)
 * @see #ServiceRunTimeException(String, Throwable)
 * @author J1205-HongHG
 * @version 3
 */
public class ServiceRunTimeException extends ApplicationException {

	/**
	 *业务逻辑层异常的默认构造函数
	 */
	public ServiceRunTimeException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 业务逻辑层异常的带参构造函数
	 * @param message -异常信息
	 */
	public ServiceRunTimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 业务逻辑层异常的带参构造函数
	 * @param cause -异常对象
	 */
	public ServiceRunTimeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 业务逻辑层异常的带参构造函数
	 * @param message -异常信息
	 * @param cause -异常对象
	 */
	public ServiceRunTimeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
