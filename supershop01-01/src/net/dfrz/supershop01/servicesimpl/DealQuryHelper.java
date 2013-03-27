/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import net.dfrz.supershop01.domain.ObjectValue;

/**                
 * Project: supershop01-01
 * ClassName: dealQuryHelper                                                        
 * Module ID: 4.6  
 * Comments: 定义商品订单组合查询的模版  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-8
 * @see net.dfrz.supershop01.domain.ObjectValue   
 * @see #dealId                                          
 * @see #dealDate
 * @see #dealStatus
 * @see #dealSum 
 * @see #dealGoodsQty 
 * @see #dealGoodsId 
 * @see #dealCustomerId  
 * @see #dealAdminId
 * @see #isAccept
 * @see #getDealId() 
 * @see #getDealDate() 
 * @see #getDealStatus()
 * @see #getDealSum()
 * @see #getDealGoodsQty()
 * @see #getDealGoodsId()
 * @see #getDealCustomerId()
 * @see #getDealAdminId()
 * @see #getIsAccept()
 * @see #setDealDate(String)  
 * @see #setDealStatus(String)
 * @see #setDealSum(Double)
 * @see #setDealGoodsQty(Integer)
 * @see #setDealGoodsId(Integer)
 * @see #setDealCustomerId(Integer)
 * @see #setDealAdminId(Integer)   
 * @see #setIsAccept(Integer)                                
 * @author J1205-HongHG                                                      
 * @version Version 1                                        
*/
public class DealQuryHelper extends ObjectValue {
    /**
     * 订单编号
     */
	private Integer dealId;
	/**
	 * 下单时间
	 */
	private String dealDate; 
	/**
	 * 订单状态
	 */
	private String dealStatus; 
	/**
	 * 订单金额
	 */
	private Double dealSum;  
	/**
	 * 订单商品总数
	 */
	private Integer dealGoodsQty;
	/**
	 * 订单商品编号
	 */
	private Integer dealGoodsId; 
	/**
	 * 订单用户编号
	 */
	private Integer dealCustomerId;
	/**
	 * 订单管理员编号
	 */
	private Integer dealAdminId;
	/**
	 * 订单接收状态
	 */
	private Integer isAccept;
	/**
	 * 获取商品订单的编号
	 * @return Integer
	 */
	public Integer getDealId() {
		return dealId;
	}
	/**
	 * 修改商品订单的编号
	 * @param dealId  -商品订单编号
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	/**
    * 获取下单时间
	* @return String
	*/
	public String getDealDate() {
		return dealDate;
	}
	/**
	 * 修改下单时间
	 * @param dealDate  --下单时间
	 */
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	/**
	 * 获取订单当前状态
	 * @return String
	 */
	public String getDealStatus() {
		return dealStatus;
	}
	/**
	 * 修改当前的订单状态
	 * @param dealStatus -订单状态
	 */
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	/**
	 * 获取订单金额
	 * @return Double
	 */
	public Double getDealSum() {
		return dealSum;
	}
	/**
	 * 修改订单金额
	 * @param dealSum -订单金额
	 */
	public void setDealSum(Double dealSum) {
		this.dealSum = dealSum;
	}
	/**
	 * 获取订单的商品数量
	 * @return Integer
	 */
	public Integer getDealGoodsQty() {
		return dealGoodsQty;
	}
	/**
	 * 修改订单的商品数量
	 * @param dealGoodsQty -订单商品数量
	 */
	public void setDealGoodsQty(Integer dealGoodsQty) {
		this.dealGoodsQty = dealGoodsQty;
	}
	/**
	 * 获取订单的商品所属的商品的商品编号
	 * @return Integer
	 */
	public Integer getDealGoodsId() {
		return dealGoodsId;
	}
	/**
	 * 修改订单的商品所属的商品的商品编号
	 * @param dealGoodsId -订单所属商品编号
	 */
	public void setDealGoodsId(Integer dealGoodsId) {
		this.dealGoodsId = dealGoodsId;
	}
	/**
	 * 获取下单的用户编号
	 * @return Integer
	 */
	public Integer getDealCustomerId() {
		return dealCustomerId;
	}
	/**
	 * 修改下单的用户编号
	 * @param dealCustomerId -订单所属用户编号
	 */
	public void setDealCustomerId(Integer dealCustomerId) {
		this.dealCustomerId = dealCustomerId;
	}
	/**
	 * 获取管理该类商品订单的管理员编号
	 * @return Integer
	 */
	public Integer getDealAdminId() {
		return dealAdminId;
	}
	/**
	 * 修改管理该类商品的管理员编号
	 * @param dealAdminId  -订单所属的管理员编号
	 */
	public void setDealAdminId(Integer dealAdminId) {
		this.dealAdminId = dealAdminId;
	}
	/**
	 * 获取订单接收状态
	 * @return Integer
	 */
	public Integer getIsAccept() {
		return isAccept;
	}
	/**
	 * 修改订单接收状态
	 * @param isAccept -当前订单接收状态
	 */
	public void setIsAccept(Integer isAccept) {
		this.isAccept = isAccept;
	}
	
}
