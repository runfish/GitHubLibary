/**
 * 
 */
package net.dfrz.supershop01.domain;

/**
 * @author hhg0012
 *
 */
public class CartItem extends ObjectValue {
	/**
	 * 商品单价
	 */
	private Double goodsPrice;
	/**
	 * 商品数量
	 */
	private Integer goodsQty;
	/**
	 * 商品编号
	 */
	private Integer goodsId; 
	/**
	 * 商品类型编号
	 */
	private Integer goodsCtgId;
	/**
	 * 管理员编号
	 */
	private Integer adminId;
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getGoodsQty() {
		return goodsQty;
	}
	public void setGoodsQty(Integer goodsQty) {
		this.goodsQty = goodsQty;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getGoodsCtgId() {
		return goodsCtgId;
	}
	public void setGoodsCtgId(Integer goodsCtgId) {
		this.goodsCtgId = goodsCtgId;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
}
