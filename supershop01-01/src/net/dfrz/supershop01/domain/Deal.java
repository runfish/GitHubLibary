/**
 * 
 */
package net.dfrz.supershop01.domain;

import java.sql.Date;

/**                
 * Project: supershop01-01
 * ClassName: Deal                                                     
 * Module ID: 4.6  
 * Comments: ������Ʒ���������ģ��  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-8
 * @see java.sql.Date    
 * @see #baseDealId                                          
 * @see #dealId 
 * @see #dealCustomerId  
 * @see #consigneeInfo
 * @see #payPattern
 * @see #receivePattern
 * @see #itemAmount
 * @see #isAccept
 * @see #dealSum
 * @see #getDealId()
 * @see #getBaseDealId()
 * @see #getDealCustomerId()
 * @see #getConsigneeInfo()
 * @see #getPayPattern()
 * @see #getReceivePattern()
 * @see #getItemAmount()
 * @see #getIsAccept()
 * @see #getDealSum()
 * @see #setDealId(Integer) 
 * @see #setDealCustomerId(Integer) 
 * @see #setConsigneeInfo(String)
 * @see #setPayPattern(String)
 * @see #setReceivePattern(String)
 * @see #setItemAmount(Integer)
 * @see #setIsAccept(Integer)
 * @see #setDealSum(Double)
 * @see #toString()                            
 * @author J1205-HongHG                                                      
 * @version Version 138                                       
*/

public class Deal extends ObjectValue {
	/**
	 * ������ʼ���
	 */
	private static Integer baseDealId=1022600;
	/**
	 * �������
	 */
	private Integer dealId; 
	/**
	 * �����û����
	 */
	private Integer dealCustomerId;
	/**
	 * �����ջ�����Ϣ�������ջ�����������ϵ��ʽ���ջ���ַ���������롢�������䣩
	 */
	private String consigneeInfo;
	/**
	 * �������ʽ
	 */
	private String  payPattern;
	/**
	 * ������Ʒ�ջ���ʽ
	 */
	private String receivePattern;
	/**
	 * ������Ŀ����
	 */
	private Integer itemAmount;
	/**
	 * ����״̬
	 */
	private String dealStatus;
	/**
	 * �µ�����
	 */
	private Date dealDate;
	/**
	 * �������ʱ��
	 */
	private Date dealExamDate;
	/**
	 * �����Ƿ��Ѿ�����
	 */
	private Integer isAccept;
	/**
	 * �����ܽ��
	 */
	private Double dealSum;
   /**
    * ��ȡ�����ı��
    * @return Integer
    */
	public Integer getDealId() {
		return dealId;
	}
	/**
	 * ��ö����������
	 * @return Integer
	 */
	public static Integer getBaseDealId() {
	return baseDealId;
   }
	/**
	 * �޸Ķ������
	 * @param dealId -�������
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	/**
	 * ��ȡ�µ����û����
	 * @return Integer
	 */
	public Integer getDealCustomerId() {
		return dealCustomerId;
	}
	/**
	 * �޸��µ����û����
	 * @param dealCustomerId -���������û����
	 */
	public void setDealCustomerId(Integer dealCustomerId) {
		this.dealCustomerId = dealCustomerId;
	}
	/**
	 * ��ȡ�������ջ�����Ϣ
	 * @return String
	 */
	public String getConsigneeInfo() {
		return consigneeInfo;
	}
	/**
	 * �޸Ķ������ջ�����Ϣ
	 * @param consigneeInfo -�������ջ�����Ϣ
	 */
	public void setConsigneeInfo(String consigneeInfo) {
		this.consigneeInfo = consigneeInfo;
	}
	/**
	 * ��ȡ�����ĸ��ʽ
	 * @return String
	 */
	public String getPayPattern() {
		return payPattern;
	}
	/**
	 * �޸Ķ����ĸ��ʽ
	 * @param payPattern -�����ĸ��ʽ
	 */
	public void setPayPattern(String payPattern) {
		this.payPattern = payPattern;
	}
	/**
	 * ��ȡ������Ʒ���ջ���ʽ
	 * @return String
	 */
	public String getReceivePattern() {
		return receivePattern;
	}
	/**
	 * �޸Ķ�����Ʒ���ջ���ʽ
	 * @param receivePattern -������Ʒ���ջ���ʽ
	 */
	public void setReceivePattern(String receivePattern) {
		this.receivePattern = receivePattern;
	}
	/**
	 * ��ȡ������Ŀ����
	 * @return Integer
	 */
	public Integer getItemAmount() {
		return itemAmount;
	}
	/**
	 * �޸Ķ�����Ŀ����
	 * @param itemAmount -��ǰ������������Ŀ����
	 */
	public void setItemAmount(Integer itemAmount) {
		this.itemAmount = itemAmount;
	}
	/**
	 * ��ȡ����״̬
	 * @return String
	 */
	public String getDealStatus() {
		return dealStatus;
	}
	/**
	 * �޸Ķ���״̬
	 * @param dealStatus -��ǰ����״̬
	 */
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	/**
	 * ��ȡ�����µ�ʱ��
	 * @return Date
	 */
	public Date getDealDate() {
		return dealDate;
	}
	/**
	 * �޸Ķ����µ�ʱ��
	 * @param dealDate -�����µ�ʱ��
	 */
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	/**
	 * ��ȡ�������ʱ��
	 * @return Date
	 */
	public Date getDealExamDate() {
		return dealExamDate;
	}
	/**
	 * �޸Ķ������ʱ��
	 * @param dealExamDate -�������ʱ��
	 */
	public void setDealExamDate(Date dealExamDate) {
		this.dealExamDate = dealExamDate;
	}
	/**
	 * ��ȡ��������״̬
	 * @return Integer
	 */
	public Integer getIsAccept() {
		return isAccept;
	}
	/**
	 * �޸Ķ�������״̬
	 * @param isAccept -��������״̬
	 */
	public void setIsAccept(Integer isAccept) {
		this.isAccept = isAccept;
	}
	/**
	 * ��ȡ����������Ʒ���ܽ��
	 * @return Double
	 */
	public Double getDealSum() {
		return dealSum;
	}
	/**
	 * �޸Ķ�������Ʒ�ܶ�
	 * @param dealSum
	 */
	public void setDealSum(Double dealSum) {
		this.dealSum = dealSum;
	}
	/**
	 * ��������ĸ�ʽ����ʽ���
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return this.consigneeInfo+":"+this.payPattern+":"+this.receivePattern;
	}
}
