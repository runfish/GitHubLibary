/**
 * 
 */
package net.dfrz.supershop01.domain;

import java.sql.Date;

/**                
 * Project: supershop01-01
 * ClassName: Deal                                                     
 * Module ID: 4.6  
 * Comments: 定义商品订单对象的模版  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-8
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
	 * 订单起始编号
	 */
	private static Integer baseDealId=1022600;
	/**
	 * 订单编号
	 */
	private Integer dealId; 
	/**
	 * 订单用户编号
	 */
	private Integer dealCustomerId;
	/**
	 * 订单收货人信息（包括收获人姓名、联系方式、收货地址、邮政编码、电子邮箱）
	 */
	private String consigneeInfo;
	/**
	 * 订单付款方式
	 */
	private String  payPattern;
	/**
	 * 订单商品收货方式
	 */
	private String receivePattern;
	/**
	 * 订单条目数量
	 */
	private Integer itemAmount;
	/**
	 * 订单状态
	 */
	private String dealStatus;
	/**
	 * 下单日期
	 */
	private Date dealDate;
	/**
	 * 订单审核时间
	 */
	private Date dealExamDate;
	/**
	 * 订单是否已经接收
	 */
	private Integer isAccept;
	/**
	 * 订单总金额
	 */
	private Double dealSum;
   /**
    * 获取订单的编号
    * @return Integer
    */
	public Integer getDealId() {
		return dealId;
	}
	/**
	 * 获得订单基础编号
	 * @return Integer
	 */
	public static Integer getBaseDealId() {
	return baseDealId;
   }
	/**
	 * 修改订单编号
	 * @param dealId -订单编号
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
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
	 * 获取订单的收货人信息
	 * @return String
	 */
	public String getConsigneeInfo() {
		return consigneeInfo;
	}
	/**
	 * 修改订单的收货人信息
	 * @param consigneeInfo -订单的收货人信息
	 */
	public void setConsigneeInfo(String consigneeInfo) {
		this.consigneeInfo = consigneeInfo;
	}
	/**
	 * 获取订单的付款方式
	 * @return String
	 */
	public String getPayPattern() {
		return payPattern;
	}
	/**
	 * 修改订单的付款方式
	 * @param payPattern -订单的付款方式
	 */
	public void setPayPattern(String payPattern) {
		this.payPattern = payPattern;
	}
	/**
	 * 获取订单商品的收货方式
	 * @return String
	 */
	public String getReceivePattern() {
		return receivePattern;
	}
	/**
	 * 修改订单商品的收货方式
	 * @param receivePattern -订单商品的收货方式
	 */
	public void setReceivePattern(String receivePattern) {
		this.receivePattern = receivePattern;
	}
	/**
	 * 获取订单条目数量
	 * @return Integer
	 */
	public Integer getItemAmount() {
		return itemAmount;
	}
	/**
	 * 修改订单条目数量
	 * @param itemAmount -当前订单所属的条目数量
	 */
	public void setItemAmount(Integer itemAmount) {
		this.itemAmount = itemAmount;
	}
	/**
	 * 获取订单状态
	 * @return String
	 */
	public String getDealStatus() {
		return dealStatus;
	}
	/**
	 * 修改订单状态
	 * @param dealStatus -当前订单状态
	 */
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	/**
	 * 获取订单下单时间
	 * @return Date
	 */
	public Date getDealDate() {
		return dealDate;
	}
	/**
	 * 修改订单下单时间
	 * @param dealDate -订单下单时间
	 */
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	/**
	 * 获取订单审核时间
	 * @return Date
	 */
	public Date getDealExamDate() {
		return dealExamDate;
	}
	/**
	 * 修改订单审核时间
	 * @param dealExamDate -订单审核时间
	 */
	public void setDealExamDate(Date dealExamDate) {
		this.dealExamDate = dealExamDate;
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
	 * @param isAccept -订单接收状态
	 */
	public void setIsAccept(Integer isAccept) {
		this.isAccept = isAccept;
	}
	/**
	 * 获取订单所有商品的总金额
	 * @return Double
	 */
	public Double getDealSum() {
		return dealSum;
	}
	/**
	 * 修改订单的商品总额
	 * @param dealSum
	 */
	public void setDealSum(Double dealSum) {
		this.dealSum = dealSum;
	}
	/**
	 * 订单对象的格式化形式输出
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return this.consigneeInfo+":"+this.payPattern+":"+this.receivePattern;
	}
}
