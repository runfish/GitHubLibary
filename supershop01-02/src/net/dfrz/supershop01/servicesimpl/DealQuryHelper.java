/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import net.dfrz.supershop01.domain.ObjectValue;

/**                
 * Project: supershop01-02
 * ClassName: dealQuryHelper                                                        
 * Module ID: 4.6  
 * Comments: ������Ʒ������ϲ�ѯ��ģ��  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-8    
 * @see #dealId                                          
 * @see #dealDate
 * @see #dealStatus
 * @see #dealSum 
 * @see #dealGoodsQty 
 * @see #dealGoodsId 
 * @see #dealCustomerId  
 * @see #dealAdminId
 * @see #getDealId() 
 * @see #getDealDate() 
 * @see #getDealStatus()
 * @see #getDealSum()
 * @see #getDealGoodsQty()
 * @see #getDealGoodsId()
 * @see #getDealCustomerId()
 * @see #getDealAdminId()
 * @see #setDealId() 
 * @see #setDealDate(String)  
 * @see #setDealStatus(String)
 * @see #setDealSum(Double)
 * @see #setDealGoodsQty(Integer)
 * @see #setDealGoodsId(Integer)
 * @see #setDealCustomerId(Integer)
 * @see #setDealAdminId(Integer)                                   
 * @Author J1205-HongHG                                                      
 * @version Version 1                                        
*/
public class DealQuryHelper extends ObjectValue {
    /**
     * �������
     */
	private Integer dealId;
	/**
	 * �µ�ʱ��
	 */
	private String dealDate; 
	/**
	 * ����״̬
	 */
	private String dealStatus; 
	/**
	 * �������
	 */
	private Double dealSum;  
	/**
	 * ������Ʒ����
	 */
	private Integer dealGoodsQty;
	/**
	 * ������Ʒ���
	 */
	private Integer dealGoodsId; 
	/**
	 * �����û����
	 */
	private Integer dealCustomerId;
	/**
	 * ��������Ա���
	 */
	private Integer dealAdminId;
	/**
	 * ��������״̬
	 */
	private Integer isAccept;
	/**
	 * ��ȡ��Ʒ�����ı��
	 * @return Integer
	 */
	public Integer getDealId() {
		return dealId;
	}
	/**
	 * �޸���Ʒ�����ı��
	 * @param dealId  -��Ʒ�������
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	/**
    * ��ȡ�µ�ʱ��
	* @return String
	*/
	public String getDealDate() {
		return dealDate;
	}
	/**
	 * �޸��µ�ʱ��
	 * @param dealTime  --�µ�ʱ��
	 */
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	/**
	 * ��ȡ������ǰ״̬
	 * @return String
	 */
	public String getDealStatus() {
		return dealStatus;
	}
	/**
	 * �޸ĵ�ǰ�Ķ���״̬
	 * @param dealStatus -����״̬
	 */
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	/**
	 * ��ȡ�������
	 * @return Double
	 */
	public Double getDealSum() {
		return dealSum;
	}
	/**
	 * �޸Ķ������
	 * @param dealSum -�������
	 */
	public void setDealSum(Double dealSum) {
		this.dealSum = dealSum;
	}
	/**
	 * ��ȡ��������Ʒ����
	 * @return Integer
	 */
	public Integer getDealGoodsQty() {
		return dealGoodsQty;
	}
	/**
	 * �޸Ķ�������Ʒ����
	 * @param dealGoodsQty -������Ʒ����
	 */
	public void setDealGoodsQty(Integer dealGoodsQty) {
		this.dealGoodsQty = dealGoodsQty;
	}
	/**
	 * ��ȡ��������Ʒ��������Ʒ����Ʒ���
	 * @return Integer
	 */
	public Integer getDealGoodsId() {
		return dealGoodsId;
	}
	/**
	 * �޸Ķ�������Ʒ��������Ʒ����Ʒ���
	 * @param dealGoodsId -����������Ʒ���
	 */
	public void setDealGoodsId(Integer dealGoodsId) {
		this.dealGoodsId = dealGoodsId;
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
	 * ��ȡ����������Ʒ�����Ĺ���Ա���
	 * @return Integer
	 */
	public Integer getDealAdminId() {
		return dealAdminId;
	}
	/**
	 * �޸Ĺ���������Ʒ�Ĺ���Ա���
	 * @param dealAdminId  -���������Ĺ���Ա���
	 */
	public void setDealAdminId(Integer dealAdminId) {
		this.dealAdminId = dealAdminId;
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
	 * @param isAccept -��ǰ��������״̬
	 */
	public void setIsAccept(Integer isAccept) {
		this.isAccept = isAccept;
	}
	
}