/**
 * 
 */
package net.dfrz.supershop01.domain;

/**                
 * Project: supershop01-02
 * ClassName: Administrator                                                       
 * Module ID: 4.6  
 * Comments: 管理员对象类
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see #administratorId
 * @see #administratorName
 * @see #administratorPassword
 * @see #realName
 * @see #birthday
 * @see #email
 * @see #telNum
 * @see #address
 * @see #postCode
 * @see #isFreeze
 * @see #isSuperAdministrator
 * @see #getAdministratorId()
 * @see #getAdministratorName()
 * @see #getAdministratorPassword()
 * @see #getBirthday()
 * @see #getEmail()
 * @see #getTelNum()
 * @see #getAddress()
 * @see #getPostCode()
 * @see #getIsFreeze()
 * @see #getIsSuperAdministrator()
 * @see #setAdministratorId(int)
 * @see #setAdministratorName(String)
 * @see #setAdministratorPassword(String)
 * @see #setBirthday(String)
 * @see #setEmail(String)
 * @see #setTelNum(String)
 * @see #setAddress(String)
 * @see #setPostCode(String)
 * @see #setIsFreeze(Boolean)
 * @see #setIsSuperAdministrator(Boolean)
 * @author J1205-YDP                                                      
 * @version Version 10 
 */
public class Administrator extends ObjectValue {

	/**
	 * 构造函数
	 */
	public Administrator() {
		// TODO Auto-generated constructor stub
	}
    /**
     * 管理员编号
     */
	private int administratorId;
	/**
	 * 管理员帐号
	 */
	private String administratorName;
	/**
	 * 管理员帐号密码
	 */
	private String administratorPassword;
	/**
	 * 管理员真实姓名
	 */
	private String realName;
	/**
	 * 管理员出生日期
	 */
	private String birthday;
	/**
	 * 管理员电子邮箱
	 */
	private String email;
	/**
	 * 管理员联系方式
	 */
	private String telNum;
	/**
	 * 管理员住址
	 */
	private String address;
	/**
	 * 管理员所在地的邮政编码
	 */
	private String postCode;
	/**
	 * 是否是超级管理员
	 */
	private boolean isSuperAdministrator;
	/**
	 * 管理员帐号权限是否被冻结
	 */
	private boolean isFreeze;
	
	
	



	/**
	 * 查看管理员权限是否被冻结
	 * @return Boolean
	 */
	public boolean getIsFreeze() {
		return isFreeze;
	}

	/**
	 * 设置管理员权限
	 * @param isFreeze -当前用户的权限状态
	 */
	public void setIsFreeze(boolean isFreeze) {
		this.isFreeze = isFreeze;
	}

	/**
	 * 将管理员升级为超级管理员
	 * @param isSuperAdministrator -当前用户是否为超级管理员的标志
	 */
	public void setSuperAdministrator(boolean isSuperAdministrator) {
		this.isSuperAdministrator = isSuperAdministrator;
	}
    /**
     * 获取当前管理员的编号
     * @return int
     */
	public int getAdministratorId() {
		return administratorId;
	}
    /**
     * 修改当前管理员的编号
     * @param administratorId -当前管理员的编号
     */
	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}
	/**
	 * 获取当前管理员的帐号
	 * @return String
	 */
	public String getAdministratorName() {
		return administratorName;
	}
    /**
     * 修改当前管理员的帐号
     * @param administratorName -当前管理员的帐号
     */
	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}
    /**
     * 获取管理员帐号的密码
     * @return String
     */
	public String getAdministratorPassword() {
		return administratorPassword;
	}
    /**
     * 修改管理员帐号的密码
     * @param administratorPassword -当前管理员的帐号密码
     */
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}
    /**
     * 当前管理员的真实姓名
     * @return String
     */
	public String getRealName() {
		return realName;
	}
	/**
	 * 修改管理员的真实姓名
	 * @param realName -当前管理员的真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
   /**
    * 获取当前管理员的出生日期
    * @return String
    */
	public String getBirthday() {
		return birthday;
	}
    /**
     * 修改当前管理员的出生日期
     * @param birthday -当前管理员设置的出生日期
     */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
    /**
     * 获取当前管理员设置的电子邮箱
     * @return String
     */
	public String getEmail() {
		return email;
	}
    /**
     * 修改当前管理员设置的电子邮箱
     * @param email
     */
	public void setEmail(String email) {
		this.email = email;
	}
    /**
     * 获取当前管理员的联系方式
     * @return String
     */
	public String getTelNum() {
		return telNum;
	}
    /**
     * 修改当前管理员的联系方式
     * @param telNum -当前管理员设置的联系方式
     */
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
    /**
     * 获取当前管理员的住址
     * @return String
     */
	public String getAddress() {
		return address;
	}
   /**
    * 修改当前管理员的住址
    * @param address -当前管理员的住址
    */
	public void setAddress(String address) {
		this.address = address;
	}
    /**
     * 获取当前管理员的所在地的邮政编码
     * @return String
     */
	public String getPostCode() {
		return postCode;
	}
    /**
     * 修改当前管理员的所在地的邮政编码
     * @param postCode -当前管理员的所在地的邮政编码
     */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
    /**
     * 获取当前管理员是否为超级管理员标志
     * @return Boolean
     */
	public boolean getIsSuperAdministrator() {
		return isSuperAdministrator;
	}
    /**
     * 修改当前管理员是否为超级管理员标志
     * @param isSuperAdministrator2 -当前管理员是否为超级管理员标志
     */
	public void setSuperAdministrator(Boolean isSuperAdministrator2) {
		this.isSuperAdministrator = isSuperAdministrator2;
	}
}
