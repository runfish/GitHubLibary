/**
 * 
 */
package net.dfrz.supershop01.services;

import net.dfrz.supershop01.domain.CartItem;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.ShoppingCart;

/**                
 * Project: supershop01-01
 * ClassName: ShoppingCartService                                                        
 * Module ID: 4.6  
 * Comments: 购物车管理业务层
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-2-6
 * @see net.dfrz.supershop01.domain.CartItem
 * @see net.dfrz.supershop01.domain.Goods
 * @see net.dfrz.supershop01.domain.ShoppingCart
 * @see #addGoodsToCart(Goods, ShoppingCart)
 * @see #removeGoodsFromCart(CartItem, ShoppingCart)
 * @see #updateCartAmount(CartItem, ShoppingCart, String)
 * @author J1205-HongHG                                                    
 * @version Version 292 
 */
public interface ShoppingCartService {
	
	/**
	 * 添加商品信息到购物车
	 * @param goods -要增加到购物车的商品信息对象
	 * @param cart -当前用户对象的购物车对象
	 */
	void addGoodsToCart(Goods goods,ShoppingCart cart);
	/**
	 * 从购物车移除商品信息
	 * @param item -要移除的购物车条目对象
	 * @param cart -当前用户对象的购物车对象
	 */
	void removeGoodsFromCart(CartItem item,ShoppingCart cart);
	/**
	 * 更新购物车的所有商品的总金额
	 * @param item -最后一次增加的购物车条目对象
	 * @param cart -当前用户对象的购物车对象
	 * @param type -购物车中的商品数量的操作类型
	 */
	void updateCartAmount(CartItem item,ShoppingCart cart,String type);

}
