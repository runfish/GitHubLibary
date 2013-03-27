/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.DealItem;

/**                
 * Project: supershop01-01
 * ClassName: DealItemDao                                                        
 * Module ID: 4.6  
 * Comments: 在数据层为订单条目类对象提供数据删除、修改、分页显示的功能  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-8
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.DealItem
 * @see #add(DealItem)
 * @see #update(DealItem)
 * @see #delete(DealItem)
 * @see #getDealItemById(Integer)
 * @see #loadPage(int,int,DealQuryHelper)
 * @see #countDealItem(DealQuryHelper)
 * @see #deleteDealItemByDealId(Integer)
 * @author J1205-HongHG                                                      
 * @version Version 5      
 */
public interface DealItemDao {

	/**
	 * 增加订单条目对象
	 * @param dealItem -订单条目对象
	 * @throws net.dfrz.supershop01.exception.DataAccessException -当订单对象不存在时抛出异常
	 */
	void add(DealItem dealItem);
	/**
	 * 订单条目对象的修改
	 * @param dealItem -订单条目对象
	 * @throws net.dfrz.supershop01.exception.DataAccessException -当订单对象不存在时抛出异常
	 */
	void update(DealItem dealItem);
	/**
	 * 订单条目对象的删除
	 * @param dealItem -订单条目对象
	 * @throws net.dfrz.supershop01.exception.DataAccessException -当订单对象不存在时抛出异常
	 */
	void delete(DealItem dealItem);
	/**
	 * 根据订单条目对象的编号获取对应的订单条目对象
	 * @param itemId -查找的订单条目的编号
	 * @throws net.dfrz.supershop01.exception.DataAccessException -当订单对象不存在时抛出异常
	 * @return DealItem
	 */
	DealItem getDealItemById(Integer itemId);
	/**
	 * 批量订单对象的分页显示
	 * @param startIndex   -页面开始的记录起始位置
	 * @param endIndex   -页面结束的最后一条记录的位置
	 * @param dealId -商品订单条目组合查询条件封装的帮助对象
	 * @throws net.dfrz.supershop01.exception.DataAccessException -当订单对象不存在时抛出异常
	 * @return List<DealItem>  
	 */
	List<DealItem> loadPage(int startIndex,int endIndex,int dealId);
	/**
	 * 统计数据库集中订单的总数
	 * @param dealId -商品订单组合查询条件封装的帮助对象
	 * @throws net.dfrz.supershop01.exception.DataAccessException -当订单对象不存在时抛出异常
	 * @return dealId
	 */
	int countDealItem(int dealId);
	/**
	 * 删除指定订单编号下的所有订单条目
	 * @param dealId -订单编号
	 * @throws net.dfrz.supershop01.exception.DataAccessException -当订单对象不存在时抛出异常
	 */
	void deleteDealItemByDealId(Integer dealId);
}
