package net.dfrz.supershop01.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends ObjectValue{

	/**
	 * 购物车条目信息
	 */
	List<CartItem>cartList=new ArrayList<CartItem>();
	/**
	 * 购物车条目数量
	 */
	Integer cartItemAmount;
	/**
	 * 购物车总金额
	 */
	Double totalAmount;
	public List<CartItem> getCartList() {
		return cartList;
	}
	public void setCartList(List<CartItem> cartList) {
		this.cartList = cartList;
	}
	public Integer getCartItemAmount() {
		return cartItemAmount;
	}
	public void setCartItemAmount(Integer cartItemAmount) {
		this.cartItemAmount = cartItemAmount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
  