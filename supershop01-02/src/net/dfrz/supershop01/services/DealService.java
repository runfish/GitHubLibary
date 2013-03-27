/**
 * 
 */
package net.dfrz.supershop01.services;

import java.util.List;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.utils.Page;

/**                
 * Project: supershop01-02
 * ClassName: DealService                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为订单类对象提供数据删除，修改、查找的功能  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Deal
 * @see net.dfrz.supershop01.servicesimpl.DealQuryHelper
 * @see net.dfrz.supershop01.utils.Page
 * @see #updateDeal(Deal)
 * @see #deleteDeal(Deal)
 * @see #getDealById(Integer)
 * @see #loadAll()
 * @see #loadPage(Page, DealQuryHelper)
 * @Author J1205-HongHG                                                      
 * @version Version 5 
 */
public interface DealService {
	/**
	 * 订单对象的修改
	 * @param deal -订单对象
	 */
	void updateDeal(Deal deal);
	/**
	 * 订单对象的删除
	 * @param deal -订单对象
	 */
	void deleteDeal(Deal deal);
	/**
	 * 根据订单编号获取对应的订单信息
	 */
	Deal getDealById(Integer dealId);
	/**
	 * 批量订单对象的分页显示
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
}
