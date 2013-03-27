/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import net.dfrz.supershop01.dao.DaoFactory;
import net.dfrz.supershop01.dao.DealDao;
import net.dfrz.supershop01.dao.DealItemDao;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.services.DealItemService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.Page;
import net.dfrz.supershop01.utils.TransactionManager;

/**
 * Project: supershop01-01
 * ClassName: DealItemServiceImpl                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为订单类对象提供数据删除，修改，分页显示的功能,DealService的实现类  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see net.dfrz.supershop01.dao.DaoFactory
 * @see net.dfrz.supershop01.dao.DealDao
 * @see net.dfrz.supershop01.dao.DealItemDao
 * @see net.dfrz.supershop01.domain.Deal
 * @see net.dfrz.supershop01.domain.DealItem
 * @see net.dfrz.supershop01.services.DealItemService
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see net.dfrz.supershop01.utils.Page
 * @see net.dfrz.supershop01.utils.TransactionManager
 * @see #deleteAllDealItems(Integer)
 * @see #updateDealItem(DealItem)
 * @see #loadPage(Page, int)
 * @see #getDealItemById(Integer)
 * @see #deleteAllDealItems(Integer)
 *@author J1205-HongHG
 *@version Version 1
 */
public class DealItemServiceImpl implements DealItemService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealItemService#deleteDealItem(net.dfrz.supershop01.domain.DealItem)
	 */
	public void deleteDealItem(DealItem dealItem) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			/**
			 * 将要删除的订单条目对象删除
			 */
			DealItemDao dealItemDao=(DealItemDao)DaoFactory.getDao("DealItemDao");
			dealItemDao.delete(dealItem);
			/**
			 * 删除完订单条目后修改该条目所属的订单的条目数量的值（因无批量删除操作此处一次只做减一操作）
			 */
			DealDao dealDao=(DealDao)DaoFactory.getDao("DealDao");
			Deal deal=dealDao.getDealById(dealItem.getDealId());
			int itemAmount=deal.getItemAmount();
			itemAmount--;
			deal.setItemAmount(itemAmount);
			dealDao.update(deal);
			
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealItemService#loadPage(net.dfrz.supershop01.utils.Page, java.lang.Integer)
	 */
	public Page loadPage(Page pagedDealItem ,int dealId) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			DealItemDao dealItemDao=(DealItemDao)DaoFactory.getDao("DealItemDao");
			int totalRecNum=dealItemDao.countDealItem(dealId);
			pagedDealItem.setTotalRecNum((long)totalRecNum);
			pagedDealItem.setPageContent(dealItemDao.loadPage(pagedDealItem.getStartIndex(),pagedDealItem.getEndIndex(),dealId));
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		return pagedDealItem;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealItemService#updateDealItem(net.dfrz.supershop01.domain.DealItem)
	 */
	public void updateDealItem(DealItem dealItem) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			DealItemDao dealItemDao=(DealItemDao)DaoFactory.getDao("DealItemDao");
			dealItemDao.update(dealItem);
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealItemService#getDealItemById(java.lang.Integer)
	 */
	public DealItem getDealItemById(Integer dealId) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		DealItem dealItem=null;
		try
		{
			manager.beginTransaction();
			DealItemDao dealItemDao=(DealItemDao)DaoFactory.getDao("DealItemDao");
			dealItem=dealItemDao.getDealItemById(dealId);
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		return dealItem;
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealItemService#getDealItemById(java.lang.Integer)
	 */
	public void deleteAllDealItems(Integer dealId) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			DealItemDao dealItemDao=(DealItemDao)DaoFactory.getDao("DealItemDao");
			dealItemDao.deleteDealItemByDealId(dealId);
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
	}
}
