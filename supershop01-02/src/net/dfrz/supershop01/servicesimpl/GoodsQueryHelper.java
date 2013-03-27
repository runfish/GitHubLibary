/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import java.util.List;

import net.dfrz.supershop01.domain.SmallCategory;

/**                
 * Project: supershop01-02
 * ClassName: GoodsQuryHelper                                                        
 * Module ID: 4.6  
 * Comments: 定义商品组合查询的模版  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-8    
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.SmallCategory
 * @see #goodsCtgId
 * @see #goodsIsEmpty
 * @see #goodsName
 * @see #maxGoodsPrice
 * @see #minGoodsPrice
 * @see #goodsCtgs
 * @see #getGoodsCtgId()
 * @see #getGoodsIsEmpty()
 * @see #getGoodsName()
 * @see #getMaxGoodsPrice()
 * @see #getMinGoodsPrice()
 * @see #getGoodsCtgs()
 * @see #setGoodsCtgId(Integer)
 * @see #setGoodsIsEmpty(String)
 * @see #setGoodsName(String)
 * @see #setMaxGoodsPrice(Double)
 * @see #setMinGoodsPrice(Double)
 * @see #setGoodsCtgs(List)
 * @author J1205-YDP                                                                                                                       
 * @version: Version 1                                        
*/
public class GoodsQueryHelper {
	
	private String goodsName;//商品名称
	
	private Double minGoodsPrice;//商品最低价格
	
	private Double maxGoodsPrice;//商品最低价格
	
	private String goodsIsEmpty;//商品是否缺货
	
	private Integer goodsCtgId;//商品所属类别编号
	
	private List<SmallCategory>goodsCtgs; //商品类别数组

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getMinGoodsPrice() {
		return minGoodsPrice;
	}

	public void setMinGoodsPrice(Double Price) {
		this.minGoodsPrice = Price;
	}

	public Double getMaxGoodsPrice() {
		return maxGoodsPrice;
	}

	public void setMaxGoodsPrice(Double maxGoodsPrice) {
		this.maxGoodsPrice = maxGoodsPrice;
	}

	public String getGoodsIsEmpty() {
		return goodsIsEmpty;
	}

	public void setGoodsIsEmpty(String goodsIsEmpty) {
		this.goodsIsEmpty = goodsIsEmpty;
	}

	public Integer getGoodsCtgId() {
		return goodsCtgId;
	}

	public void setGoodsCtgId(Integer goodsCtgId) {
		this.goodsCtgId = goodsCtgId;
	}

	public List<SmallCategory> getGoodsCtgs() {
		return goodsCtgs;
	}

	public void setGoodsCtgs(List<SmallCategory> goodsCtgs) {
		this.goodsCtgs = goodsCtgs;
	}

    
	
	
	

}
