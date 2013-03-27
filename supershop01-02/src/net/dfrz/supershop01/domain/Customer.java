/**
 * 
 */
package net.dfrz.supershop01.domain;

/**
 * Project: supershop01-01 ClassName: Customer Module ID: 4.6 Comments: 前台用户类
 * JDK :jdk1.6.0_10 Create Date： 2013-1-9
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
	 * 构造函数
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 用户编号
	 */
	private String customerId;
	/**
	 * 用户帐号名称
	 */
	private String customerName;
	/**
	 * 用户密码
	 */
	private String customerPassword;
	/**
	 * 用户的账户
	 */
	private double customerAccount;
	
	/**
	 * 用户真实姓名
	 */
	private String customerRealname;
	/**
	 * 用户的出生日期
	 */
	private String customerBirthday;
	/**
	 * 用户的电子邮箱
	 */
	private String customerMail;
	/**
	 * 用户的联系方式
	 */
	private String customerTel;
	/**
	 * 用户的住址
	 */
	private String customerAddress;
	/**
	 * 用户所在地的邮政编码
	 */
	private String customerPostCode;
	/**
	 * 该用户帐号是否被冻结
	 */
	private int isFreeze;
	/**
	 * 该用户是否被冻结
	 */
	private int isMember;
	/**
	 * 当前用户帐号的购物积分
	 */
	private double customerScore;

	/**
	 * 获取用户当前的购物积分
	 * 
	 * @return double
	 */
	public double getCustomerScore() {
		return customerScore;
	}

	/**
	 * 设置用户的购物积分
	 * 
	 * @param customerScore
	 *            -当前用户的购物积分
	 */
	public void setCustomerScore(double customerScore) {
		this.customerScore = customerScore;
	}

	/**
	 * 查看当前用户是否为会员
	 * 
	 * @return int
	 */
	public int getIsMember() {
		return isMember;
	}

	/**
	 * 升级用户为会员（默认初始值为0，该用户为普通用户）
	 * 
	 * @param isMember
	 *            -当前用户是否为会员的标志
	 */
	public void setIsMember(int isMember) {
		this.isMember = isMember;
	}

	/**
	 * 查看当前用户是否被冻结
	 * 
	 * @return int
	 */
	public int getIsFreeze() {
		return isFreeze;
	}

	/**
	 * 修改当前用户的冻结状态
	 * 
	 * @param isFreeze
	 *            -当前用户是否被冻结的标志
	 */
	public void setIsFreeze(int isFreeze) {
		this.isFreeze = isFreeze;
	}

	/**
	 * 获取当前用户在数据库中的编号
	 * 
	 * @return String
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * 修改当前用户在数据库中的编号
	 * 
	 * @param customerId
	 *            -当前用户的编号
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * 获取当前用户的帐号名
	 * 
	 * @return String
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * 修改当前用户的用户名（暂时无此项功能支持）
	 * 
	 * @param customerName
	 *            -当前用户的帐号名
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * 获取用户当前所使用的密码
	 * 
	 * @return String
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}

	/**
	 * 修改用户当前所使用的密码
	 * 
	 * @param customerPassword
	 *            -当前用户所使用的密码
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	/**
	 * 获取当前用户的真实姓名
	 * 
	 * @return String
	 */
	public String getCustomerRealname() {
		return customerRealname;
	}

	/**
	 * 修改当前用户的真实姓名
	 * 
	 * @param customerRealname
	 *            -当前用户的真实姓名
	 */
	public void setCustomerRealname(String customerRealname) {
		this.customerRealname = customerRealname;
	}

	/**
	 * 获取当前用户设置的出生日期
	 * 
	 * @return String
	 */
	public String getCustomerBirthday() {
		return customerBirthday;
	}

	/**
	 * 修改当前用户所设置的出生日期
	 * 
	 * @param customerBirthday
	 *            -当前用户设置的出生日期
	 */
	public void setCustomerBirthday(String customerBirthday) {
		this.customerBirthday = customerBirthday;
	}

	/**
	 * 获取用户的电子邮箱信息
	 * 
	 * @return String
	 */
	public String getCustomerMail() {
		return customerMail;
	}

	/**
	 * 修改当前用户的电子邮箱信息
	 * 
	 * @param customerMail
	 *            -当前用户的电子邮箱信息
	 */
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}

	/**
	 * 获取当前用户的联系方式
	 * 
	 * @return String
	 */
	public String getCustomerTel() {
		return customerTel;
	}

	/**
	 * 设置当前用户的联系方式
	 * 
	 * @param customerTel
	 *            -当前用户的联系方式
	 */
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}

	/**
	 * 获取当前用户的住址
	 * 
	 * @return String
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * 修改当前用户的住址
	 * 
	 * @param customerAddress
	 *            -当前用户的住址
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 * 获取当前用户所在地的邮政编码
	 * 
	 * @return String
	 */
	public String getCustomerPostCode() {
		return customerPostCode;
	}

	/**
	 * 修改当前用户所在地的邮政编码
	 * 
	 * @param customerPostCode
	 *            -当前用户的所在地的邮政编码
	 */
	public void setCustomerPostCode(String customerPostCode) {
		this.customerPostCode = customerPostCode;
	}

	/**
	 * 获取用户的账户余额
	 * @return  customerAccount
	 */
	public double getCustomerAccount() {
		return customerAccount;
	}

	/**
	 * 为账户充值
	 * @param customerAccount the customerAccount to set
	 */
	public void setCustomerAccount(double customerAccount) {
		this.customerAccount = customerAccount;
	}
	
	

}
