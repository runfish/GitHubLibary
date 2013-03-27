/**
 * 
 */
package net.dfrz.supershop01.domain;


/**                
 * Project: supershop01-01
 * ClassName: DealItem                                                       
 * Module ID: 4.6  
 * Comments: ������Ʒ������Ŀ�����ģ��  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-2-1
 * @see #itemId
 * @see #dealId
 * @see #itemGoodsPrice
 * @see #itemGoodsQty
 * @see #dealGoodsId
 * @see #dealGoodsCtgId
 * @see #dealAdminId 
 * @see #getItemId()
 * @see #getDealId()
 * @see #getItemGoodsPrice()
 * @see #getItemGoodsQty()
 * @see #getDealGoodsId()
 * @see #getDealGoodsCtgId()
 * @see #getDealAdminId()
 * @see #setItemId(Integer)
 * @see #setDealId(Integer)
 * @see #setItemGoodsPrice(Double)
 * @see #setItemGoodsQty(Integer)
 * @see #setDealGoodsId(Integer)
 * @see #setDealGoodsCtgId(Integer)
 * @see #setDealAdminId(Integer)                                      
 * @see #toString()                            
 * @author J1205-HongHG                                                      
 * @version Version 361                                        
*/

public class DealItem extends ObjectValue {
	/**
	 * ������Ŀ���
	 */
	private Integer itemId; 
	/**
	 * �������
	 */
	private Integer dealId;
	/**
	 * ��Ʒ����
	 */
	private Double itemGoodsPrice;
	/**
	 * ������Ʒ����
	 */
	private Integer itemGoodsQty;
	/**
	 * ������Ʒ���
	 */
	private Integer dealGoodsId; 
	/**
	 * ������Ʒ���ͱ��
	 */
	private Integer dealGoodsCtgId;
	/**
	 * ��������Ա���
	 */
	private Integer dealAdminId;
	/**
	 * ��ȡ������Ŀ���
	 * @return Integer
	 */
	public Integer getItemId() {
		return itemId;
	}
    /**
     * �޸Ķ�����Ŀ���
     * @param itemId -��ǰ������Ŀ���
     */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
    /**
     * ��ȡ������Ŀ���������ı��
     * @return Integer
     */
	public Integer getDealId() {
		return dealId;
	}
    /**��
     * �޸Ķ�����Ŀ�����Ķ����ı��
     * @param dealId
     */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
   /**
    * ��ȡ������Ŀ�е���Ʒ�ĵ���
    * @return Double
    */
	public Double getItemGoodsPrice() {
		return itemGoodsPrice;
	}
    /**
     * �޸Ķ�����Ŀ�е���Ʒ�ĵ���
     * @param itemGoodsPrice -��ǰ������Ŀ�е���Ʒ�ĵ���
     */
	public void setItemGoodsPrice(Double itemGoodsPrice) {
		this.itemGoodsPrice = itemGoodsPrice;
	}
   /**
    * ��ȡ������Ŀ�е���Ʒ������
    * @return Integer
    */
	public Integer getItemGoodsQty() {
		return itemGoodsQty;
	}
    /**
     * �޸Ķ�����Ŀ�е���Ʒ������
     * @param itemGoodsQty
     */
	public void setItemGoodsQty(Integer itemGoodsQty) {
		this.itemGoodsQty = itemGoodsQty;
	}
   /**
    * ��ȡ��������Ŀ�е���Ʒ����Ʒ���
    * @return Integer
    */
	public Integer getDealGoodsId() {
		return dealGoodsId;
	}
    /**
     * �޸Ķ�������Ŀ�е���Ʒ����Ʒ���
     * @param dealGoodsId -��ǰ������Ŀ�е���Ʒ���
     */
	public void setDealGoodsId(Integer dealGoodsId) {
		this.dealGoodsId = dealGoodsId;
	}
   /**
    * ��ȡ��������Ŀ�е���Ʒ������С�����
    * @return Integer
    */
	public Integer getDealGoodsCtgId() {
		return dealGoodsCtgId;
	}
   /**
    * �޸Ķ�������Ŀ�е���Ʒ������С�����
    * @param dealGoodsCtgId -��ǰ������Ŀ�е���Ʒ������С�����
    */
	public void setDealGoodsCtgId(Integer dealGoodsCtgId) {
		this.dealGoodsCtgId = dealGoodsCtgId;
	}
   /**
    * ��ȡ¼�붩����Ŀ��Ʒ�Ĺ���Ա���
    * @return Integer
    */
	public Integer getDealAdminId() {
		return dealAdminId;
	}
   /**
    * �޸�¼�붩����Ŀ��Ʒ�Ĺ���Ա���
    * @param dealAdminId -¼����Ʒ�Ĺ���Ա���
    */
	public void setDealAdminId(Integer dealAdminId) {
		this.dealAdminId = dealAdminId;
	}

	/**
	 * ��������ĸ�ʽ����ʽ���
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return this.itemId+":"+this.itemGoodsPrice+":"+this.itemGoodsQty+":"
		     +":"+this.dealGoodsId+":"+this.dealGoodsCtgId;
	}
	
}
