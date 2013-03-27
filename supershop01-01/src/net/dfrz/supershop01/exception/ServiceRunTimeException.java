/**
 * 
 */
package net.dfrz.supershop01.exception;

/**                
 * Project: supershop01-01
 * ClassName: ServiceRunTimeException                                                          
 * Comments: ��װ����ҵ���߼����쳣  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-8
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
	 *ҵ���߼����쳣��Ĭ�Ϲ��캯��
	 */
	public ServiceRunTimeException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ҵ���߼����쳣�Ĵ��ι��캯��
	 * @param message -�쳣��Ϣ
	 */
	public ServiceRunTimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * ҵ���߼����쳣�Ĵ��ι��캯��
	 * @param cause -�쳣����
	 */
	public ServiceRunTimeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * ҵ���߼����쳣�Ĵ��ι��캯��
	 * @param message -�쳣��Ϣ
	 * @param cause -�쳣����
	 */
	public ServiceRunTimeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
