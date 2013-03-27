/**
 * 
 */
package net.dfrz.supershop01.domain;

/**
 * Project: supershop01-01 ClassName: Customer Module ID: 4.6 Comments: ǰ̨�û���
 * JDK :jdk1.6.0_10 Create Date�� 2013-1-9
 * 
 * @see #customerId
 * @see #customerName
 * @see #customerRealname
 * @see #customerPassword
 * @see #customerAccount
 * @see #customerMail
 * @see #customerTel
 * @see #customerBirthday
 * @see #customerAddress
 * @see #customerPostCode
 * @see #isFreeze
 * @see #isMember
 * @see #customerScore
 * @see #getCustomerId()
 * @see #getCustomerName()
 * @see #getCustomerRealname()
 * @see #getCustomerPassword()
 * @see #getCustomerMail()
 * @see #getCustomerTel()
 * @see #getCustomerBirthday()
 * @see #getCustomerAddress()
 * @see #getCustomerPostCode()
 * @see #getIsFreeze()
 * @see #getIsMember()
 * @see #getCustomerScore()
 * @see #getCustomerAccount()
 * @see #setCustomerAccount(double)
 * @see #setCustomerId(Integer)
 * @see #setCustomerName(String)
 * @see #setCustomerRealname(String)
 * @see #setCustomerPassword(String)
 * @see #setCustomerMail(String)
 * @see #setCustomerTel(String)
 * @see #setCustomerBirthday(String)
 * @see #setCustomerAddress(String)
 * @see #setCustomerPostCode(String)
 * @see #setIsFreeze(int)
 * @see #setIsMember(int)
 * @see #setCustomerScore(double)
 * @author J1205-YDP    
 * @version Version 10
 */
public class Customer extends ObjectValue {

	/**
	 * ���캯��
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * �û����
	 */
	private String customerId;
	/**
	 * �û��ʺ�����
	 */
	private String customerName;
	/**
	 * �û�����
	 */
	private String customerPassword;
	/**
	 * �û����˻�
	 */
	private double customerAccount;
	
	/**
	 * �û���ʵ����
	 */
	private String customerRealname;
	/**
	 * �û��ĳ�������
	 */
	private String customerBirthday;
	/**
	 * �û��ĵ�������
	 */
	private String customerMail;
	/**
	 * �û�����ϵ��ʽ
	 */
	private String customerTel;
	/**
	 * �û���סַ
	 */
	private String customerAddress;
	/**
	 * �û����ڵص���������
	 */
	private String customerPostCode;
	/**
	 * ���û��ʺ��Ƿ񱻶���
	 */
	private int isFreeze;
	/**
	 * ���û��Ƿ񱻶���
	 */
	private int isMember;
	/**
	 * ��ǰ�û��ʺŵĹ������
	 */
	private double customerScore;

	/**
	 * ��ȡ�û���ǰ�Ĺ������
	 * 
	 * @return double
	 */
	public double getCustomerScore() {
		return customerScore;
	}

	/**
	 * �����û��Ĺ������
	 * 
	 * @param customerScore
	 *            -��ǰ�û��Ĺ������
	 */
	public void setCustomerScore(double customerScore) {
		this.customerScore = customerScore;
	}

	/**
	 * �鿴��ǰ�û��Ƿ�Ϊ��Ա
	 * 
	 * @return int
	 */
	public int getIsMember() {
		return isMember;
	}

	/**
	 * �����û�Ϊ��Ա��Ĭ�ϳ�ʼֵΪ0�����û�Ϊ��ͨ�û���
	 * 
	 * @param isMember
	 *            -��ǰ�û��Ƿ�Ϊ��Ա�ı�־
	 */
	public void setIsMember(int isMember) {
		this.isMember = isMember;
	}

	/**
	 * �鿴��ǰ�û��Ƿ񱻶���
	 * 
	 * @return int
	 */
	public int getIsFreeze() {
		return isFreeze;
	}

	/**
	 * �޸ĵ�ǰ�û��Ķ���״̬
	 * 
	 * @param isFreeze
	 *            -��ǰ�û��Ƿ񱻶���ı�־
	 */
	public void setIsFreeze(int isFreeze) {
		this.isFreeze = isFreeze;
	}

	/**
	 * ��ȡ��ǰ�û������ݿ��еı��
	 * 
	 * @return String
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * �޸ĵ�ǰ�û������ݿ��еı��
	 * 
	 * @param customerId
	 *            -��ǰ�û��ı��
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * ��ȡ��ǰ�û����ʺ���
	 * 
	 * @return String
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * �޸ĵ�ǰ�û����û�������ʱ�޴����֧�֣�
	 * 
	 * @param customerName
	 *            -��ǰ�û����ʺ���
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * ��ȡ�û���ǰ��ʹ�õ�����
	 * 
	 * @return String
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}

	/**
	 * �޸��û���ǰ��ʹ�õ�����
	 * 
	 * @param customerPassword
	 *            -��ǰ�û���ʹ�õ�����
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	/**
	 * ��ȡ��ǰ�û�����ʵ����
	 * 
	 * @return String
	 */
	public String getCustomerRealname() {
		return customerRealname;
	}

	/**
	 * �޸ĵ�ǰ�û�����ʵ����
	 * 
	 * @param customerRealname
	 *            -��ǰ�û�����ʵ����
	 */
	public void setCustomerRealname(String customerRealname) {
		this.customerRealname = customerRealname;
	}

	/**
	 * ��ȡ��ǰ�û����õĳ�������
	 * 
	 * @return String
	 */
	public String getCustomerBirthday() {
		return customerBirthday;
	}

	/**
	 * �޸ĵ�ǰ�û������õĳ�������
	 * 
	 * @param customerBirthday
	 *            -��ǰ�û����õĳ�������
	 */
	public void setCustomerBirthday(String customerBirthday) {
		this.customerBirthday = customerBirthday;
	}

	/**
	 * ��ȡ�û��ĵ���������Ϣ
	 * 
	 * @return String
	 */
	public String getCustomerMail() {
		return customerMail;
	}

	/**
	 * �޸ĵ�ǰ�û��ĵ���������Ϣ
	 * 
	 * @param customerMail
	 *            -��ǰ�û��ĵ���������Ϣ
	 */
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}

	/**
	 * ��ȡ��ǰ�û�����ϵ��ʽ
	 * 
	 * @return String
	 */
	public String getCustomerTel() {
		return customerTel;
	}

	/**
	 * ���õ�ǰ�û�����ϵ��ʽ
	 * 
	 * @param customerTel
	 *            -��ǰ�û�����ϵ��ʽ
	 */
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}

	/**
	 * ��ȡ��ǰ�û���סַ
	 * 
	 * @return String
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * �޸ĵ�ǰ�û���סַ
	 * 
	 * @param customerAddress
	 *            -��ǰ�û���סַ
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 * ��ȡ��ǰ�û����ڵص���������
	 * 
	 * @return String
	 */
	public String getCustomerPostCode() {
		return customerPostCode;
	}

	/**
	 * �޸ĵ�ǰ�û����ڵص���������
	 * 
	 * @param customerPostCode
	 *            -��ǰ�û������ڵص���������
	 */
	public void setCustomerPostCode(String customerPostCode) {
		this.customerPostCode = customerPostCode;
	}

	/**
	 * ��ȡ�û����˻����
	 * @return  customerAccount
	 */
	public double getCustomerAccount() {
		return customerAccount;
	}

	/**
	 * Ϊ�˻���ֵ
	 * @param customerAccount the customerAccount to set
	 */
	public void setCustomerAccount(double customerAccount) {
		this.customerAccount = customerAccount;
	}
	
	

}
