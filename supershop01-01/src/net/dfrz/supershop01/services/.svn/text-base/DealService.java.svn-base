/**
 * 
 */
package net.dfrz.supershop01.services;

import java.util.List;

import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.ShoppingCart;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.utils.Page;
/**                
 * Project: supershop01-01
 * ClassName: DealService                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为订单类对象提供数据删除，修改、查找的功能  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.domain.Deal
 * @see net.dfrz.supershop01.domain.ShoppingCart
 * @see net.dfrz.supershop01.servicesimpl.DealQuryHelper
 * @see net.dfrz.supershop01.utils.Page
 * @see #addDeal(Deal)
 * @see #updateDeal(Deal)
 * @see #deleteDeal(Deal)
 * @see #getDealById(Integer)
 * @see #loadPage(Page, DealQuryHelper)
 * @see #loadAll()
 * @see #changeCartItemToDeal(Deal,ShoppingCart)
 * @author J1205-HongHG                                                      
 * @version Version 150 
 */
public interface DealService {
	/**
	 * 增加订单对象到数据库
	 * @param deal -新增订单对象
	 * @param cart -当前购物车对象
	 * @param customer -当前的用户对象
	 */
	void addDeal(Deal deal,ShoppingCart cart,Customer customer);
	/**
	 * 订单对象的修改
	 * @param deal -要修改的订单对象
	 */
	void updateDeal(Deal deal);
	/**
	 * 订单对象的删除
	 * @param deal -要删除的订单对象
	 */
	void deleteDeal(Deal deal);
	/**
	 * 根据订单编号获取对应的订单信息
	 * @param dealId -查询的订单的订单编号
	 */
	Deal getDealById(Integer dealId);
	/**
	 * 批量显示订单对象的分页功能
	 * @param pagedDeal   -页面对象
	 * @param helper -商品订单组合查询条件封装的帮助对象
	 * @return Page  
	 */
	Page loadPage(Page pagedDeal,DealQuryHelper helper);
	/**
	 * 获取所有的商品订单信息
	 * @return List<Deal>
	 */
	List<Deal>loadAll();
	/**
	 * 将购物车中的商品信息转换成订单信息
	 * @param cart -当前购物车对象
	 *@param deal -新增的订单对象
	 */
	void changeCartItemToDeal(Deal deal ,ShoppingCart cart,Customer customer);
}
