/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import net.dfrz.supershop01.domain.CartItem;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.ShoppingCart;
import net.dfrz.supershop01.services.ShoppingCartService;

/**                
 * Project: supershop01-01
 * ClassName: ShoppingCartService                                                        
 * Module ID: 4.6  
 * Comments: 购物车管理业务层实现类
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-2-6
 * @see net.dfrz.supershop01.domain.CartItem
 * @see net.dfrz.supershop01.domain.Goods
 * @see net.dfrz.supershop01.domain.ShoppingCart
 * @see net.dfrz.supershop01.services.ShoppingCartService
 * @author J1205-HongHG                                                    
 * @version Version 292 
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.ShoppingCartService#addGoodsToCart(net.dfrz.supershop01.domain.Goods, net.dfrz.supershop01.domain.ShoppingCart)
	 */
	public void addGoodsToCart(Goods goods, ShoppingCart cart) {
		// TODO Auto-generated method stub
		/**
		 * 创建订单条目对象并加入购物车对象
		 */
		Boolean flag=false;
		
		for(CartItem item:cart.getCartList())
		{
			if(item.getGoodsId()==goods.getGoodsId())
			{   
				int index=cart.getCartList().indexOf(item);
				item.setGoodsQty(item.getGoodsQty()+1);
				cart.getCartList().set(index,item);
				flag=true;
			}
		}
		if(!flag)
		{
			CartItem cartItem=new CartItem();
			cartItem.setGoodsId(goods.getGoodsId());
			cartItem.setGoodsCtgId(goods.getGoodsCtgId());
			cartItem.setGoodsPrice(goods.getGoodsPrice());
			cartItem.setGoodsQty(1);
			cartItem.setAdminId(goods.getGoodsAdminId());
			cart.getCartList().add(cartItem);
		}
		cart.setCartItemAmount(cart.getCartItemAmount()+1);
		
		/**
		 * 统计订单中所有商品的总金额
		 */
		Double totalAmount=0.0;
		for(CartItem item:cart.getCartList())
		{
			totalAmount+=(item.getGoodsPrice()*item.getGoodsQty());
		}
		cart.setTotalAmount(totalAmount);
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.ShoppingCartService#removeGoodsFromCart(net.dfrz.supershop01.domain.CartItem, net.dfrz.supershop01.domain.ShoppingCart)
	 */
	public void removeGoodsFromCart(CartItem item, ShoppingCart cart) {
		// TODO Auto-generated method stub
		Double totalAmount=cart.getTotalAmount();
		cart.setTotalAmount(totalAmount-item.getGoodsPrice()*item.getGoodsQty());
		cart.setCartItemAmount(cart.getCartItemAmount()-item.getGoodsQty());
		cart.getCartList().remove(item);
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.ShoppingCartService#updateCartAmount(net.dfrz.supershop01.domain.CartItem, net.dfrz.supershop01.domain.ShoppingCart, java.lang.String)
	 */
	public void updateCartAmount(CartItem item , ShoppingCart cart, String type) {
		// TODO Auto-generated method stub

		if(type.equals("add"))
		{
			/**
			 * 修改购买的商品数量以及总商品
			 */
			item.setGoodsQty(item.getGoodsQty()+1);
			cart.setCartItemAmount(cart.getCartItemAmount()+1);
			/**
			 * 修改购物车总金额
			 */
			cart.setTotalAmount(cart.getTotalAmount()+item.getGoodsPrice());
			
		}
		else if(type.equals("sub"))
		{
			/**
			 * 修改购买的商品数量以及总商品
			 */
			item.setGoodsQty(item.getGoodsQty()-1);
			cart.setCartItemAmount(cart.getCartItemAmount()-1);
			/**
			 * 修改购物车总金额
			 */
			cart.setTotalAmount(cart.getTotalAmount()-item.getGoodsPrice());
		}
	}
}
