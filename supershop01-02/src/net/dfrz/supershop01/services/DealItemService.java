
package net.dfrz.supershop01.services;

import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.utils.Page;

/**                
 * Project: supershop01-02
 * ClassName: DealItemService                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为订单条目类对象提供数据删除，修改，分页显示的功能  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-2-1
 * @see net.dfrz.supershop01.domain.DealItem
 * @see net.dfrz.supershop01.servicesimpl.DealQuryHelper
 * @see net.dfrz.supershop01.utils.Page
 * @see #updateDealItem(DealItem)
 * @see #deleteDealItem(DealItem)
 * @see #loadPage(Page, DealQuryHelper)
 * @see #loadAll()
 * @see #getDealItemById(Integer)
 * @see #deleteAllDealItems(Integer)
 * @Author J1205-HongHG                                                      
 * @version Version 5 
 */
public interface DealItemService {
	/**
	 * 订单条目对象的修改
	 * @param dealItem -订单对象
	 */
	void updateDealItem(DealItem dealItem);
	/**
	 * 订单条目对象的删除
	 * @param dealItem -订单对象
	 */
	void deleteDealItem(DealItem dealItem);
	/**
	 * 批量订单条目对象的分页显示
	 * @param pagedDealItem   -页面对象
	 * @param helper -商品订单组合查询条件封装的帮助对象
	 * @return Page  
	 */
	Page loadPage(Page pagedDealItem,int dealId);
	/**
	 * 根据订单条目编号获取对应的订单信息
	 */
	DealItem getDealItemById(Integer itemId);
	/**
	 * 根据订单编号删除所有的订单条目信息
	 */
	void deleteAllDealItems(Integer dealId);
}
