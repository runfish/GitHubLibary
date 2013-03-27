package net.dfrz.supershop01.exception;

public class ApplicationException extends RuntimeException {

	/**                
	 * Project: supershop01-02
	 * ClassName: ApplicationException                                                          
	 * Comments: 封装处理应用程序异常  
	 * JDK :jdk1.6.0_10 
	 * Create Date： 2013-1-8
	 * @see RuntimeException
	 * @see #ApplicationException()
	 * @see #ApplicationException(String)
	 * @see #ApplicationException(Throwable)
	 * @see #ApplicationException(String, Throwable)
	 * @author J1205-HongHG
	 * @version 5
	 */
	private static final long serialVersionUID = 1L;
   /**
    * 应用程序异常的默认构造函数
    */
	public ApplicationException() {
		// TODO Auto-generated constructor stub
	}
   /**
    * 应用程序异常的带参构造函数
    * @param message -异常信息
    */
	public ApplicationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
   /**
    * 应用程序异常的带参构造函数
    * @param cause -异常对象
    */
	public ApplicationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
  /**
   * 应用程序异常的带参构造函数
   * @param message @param message -异常信息
   * @param cause -异常对象
   */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
