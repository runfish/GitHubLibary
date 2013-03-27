/**
 * 
 */
package net.dfrz.supershop01.domain;

/**                
 * Project: supershop01-02
 * ClassName: Administrator                                                       
 * Module ID: 4.6  
 * Comments: ����Ա������
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-9
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
	 * ���캯��
	 */
	public Administrator() {
		// TODO Auto-generated constructor stub
	}
    /**
     * ����Ա���
     */
	private int administratorId;
	/**
	 * ����Ա�ʺ�
	 */
	private String administratorName;
	/**
	 * ����Ա�ʺ�����
	 */
	private String administratorPassword;
	/**
	 * ����Ա��ʵ����
	 */
	private String realName;
	/**
	 * ����Ա��������
	 */
	private String birthday;
	/**
	 * ����Ա��������
	 */
	private String email;
	/**
	 * ����Ա��ϵ��ʽ
	 */
	private String telNum;
	/**
	 * ����Աסַ
	 */
	private String address;
	/**
	 * ����Ա���ڵص���������
	 */
	private String postCode;
	/**
	 * �Ƿ��ǳ�������Ա
	 */
	private boolean isSuperAdministrator;
	/**
	 * ����Ա�ʺ�Ȩ���Ƿ񱻶���
	 */
	private boolean isFreeze;
	
	
	



	/**
	 * �鿴����ԱȨ���Ƿ񱻶���
	 * @return Boolean
	 */
	public boolean getIsFreeze() {
		return isFreeze;
	}

	/**
	 * ���ù���ԱȨ��
	 * @param isFreeze -��ǰ�û���Ȩ��״̬
	 */
	public void setIsFreeze(boolean isFreeze) {
		this.isFreeze = isFreeze;
	}

	/**
	 * ������Ա����Ϊ��������Ա
	 * @param isSuperAdministrator -��ǰ�û��Ƿ�Ϊ��������Ա�ı�־
	 */
	public void setSuperAdministrator(boolean isSuperAdministrator) {
		this.isSuperAdministrator = isSuperAdministrator;
	}
    /**
     * ��ȡ��ǰ����Ա�ı��
     * @return int
     */
	public int getAdministratorId() {
		return administratorId;
	}
    /**
     * �޸ĵ�ǰ����Ա�ı��
     * @param administratorId -��ǰ����Ա�ı��
     */
	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}
	/**
	 * ��ȡ��ǰ����Ա���ʺ�
	 * @return String
	 */
	public String getAdministratorName() {
		return administratorName;
	}
    /**
     * �޸ĵ�ǰ����Ա���ʺ�
     * @param administratorName -��ǰ����Ա���ʺ�
     */
	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}
    /**
     * ��ȡ����Ա�ʺŵ�����
     * @return String
     */
	public String getAdministratorPassword() {
		return administratorPassword;
	}
    /**
     * �޸Ĺ���Ա�ʺŵ�����
     * @param administratorPassword -��ǰ����Ա���ʺ�����
     */
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}
    /**
     * ��ǰ����Ա����ʵ����
     * @return String
     */
	public String getRealName() {
		return realName;
	}
	/**
	 * �޸Ĺ���Ա����ʵ����
	 * @param realName -��ǰ����Ա����ʵ����
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
   /**
    * ��ȡ��ǰ����Ա�ĳ�������
    * @return String
    */
	public String getBirthday() {
		return birthday;
	}
    /**
     * �޸ĵ�ǰ����Ա�ĳ�������
     * @param birthday -��ǰ����Ա���õĳ�������
     */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
    /**
     * ��ȡ��ǰ����Ա���õĵ�������
     * @return String
     */
	public String getEmail() {
		return email;
	}
    /**
     * �޸ĵ�ǰ����Ա���õĵ�������
     * @param email
     */
	public void setEmail(String email) {
		this.email = email;
	}
    /**
     * ��ȡ��ǰ����Ա����ϵ��ʽ
     * @return String
     */
	public String getTelNum() {
		return telNum;
	}
    /**
     * �޸ĵ�ǰ����Ա����ϵ��ʽ
     * @param telNum -��ǰ����Ա���õ���ϵ��ʽ
     */
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
    /**
     * ��ȡ��ǰ����Ա��סַ
     * @return String
     */
	public String getAddress() {
		return address;
	}
   /**
    * �޸ĵ�ǰ����Ա��סַ
    * @param address -��ǰ����Ա��סַ
    */
	public void setAddress(String address) {
		this.address = address;
	}
    /**
     * ��ȡ��ǰ����Ա�����ڵص���������
     * @return String
     */
	public String getPostCode() {
		return postCode;
	}
    /**
     * �޸ĵ�ǰ����Ա�����ڵص���������
     * @param postCode -��ǰ����Ա�����ڵص���������
     */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
    /**
     * ��ȡ��ǰ����Ա�Ƿ�Ϊ��������Ա��־
     * @return Boolean
     */
	public boolean getIsSuperAdministrator() {
		return isSuperAdministrator;
	}
    /**
     * �޸ĵ�ǰ����Ա�Ƿ�Ϊ��������Ա��־
     * @param isSuperAdministrator2 -��ǰ����Ա�Ƿ�Ϊ��������Ա��־
     */
	public void setSuperAdministrator(Boolean isSuperAdministrator2) {
		this.isSuperAdministrator = isSuperAdministrator2;
	}
}
