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
 * Comments: ���ﳵ����ҵ���
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-2-6
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
	 * �����Ʒ��Ϣ�����ﳵ
	 * @param goods -Ҫ���ӵ����ﳵ����Ʒ��Ϣ����
	 * @param cart -��ǰ�û�����Ĺ��ﳵ����
	 */
	void addGoodsToCart(Goods goods,ShoppingCart cart);
	/**
	 * �ӹ��ﳵ�Ƴ���Ʒ��Ϣ
	 * @param item -Ҫ�Ƴ��Ĺ��ﳵ��Ŀ����
	 * @param cart -��ǰ�û�����Ĺ��ﳵ����
	 */
	void removeGoodsFromCart(CartItem item,ShoppingCart cart);
	/**
	 * ���¹��ﳵ��������Ʒ���ܽ��
	 * @param item -���һ�����ӵĹ��ﳵ��Ŀ����
	 * @param cart -��ǰ�û�����Ĺ��ﳵ����
	 * @param type -���ﳵ�е���Ʒ�����Ĳ�������
	 */
	void updateCartAmount(CartItem item,ShoppingCart cart,String type);

}
