/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import java.util.List;
import net.dfrz.supershop01.dao.DaoFactory;
import net.dfrz.supershop01.dao.DealDao;
import net.dfrz.supershop01.dao.DealItemDao;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.services.DealService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.Page;
import net.dfrz.supershop01.utils.TransactionManager;

/**
 * Project: supershop01-02
 * ClassName: DealServiceImpl                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为订单类对象提供数据删除，修改，分页显示的功能,DealService的实现类  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.util.List;
 * @see net.dfrz.supershop01.dao.DaoFactory
 * @see net.dfrz.supershop01.dao.DealDao
 * @see net.dfrz.supershop01.dao.DealItemDao
 * @see net.dfrz.supershop01.domain.Deal
 * @see net.dfrz.supershop01.services.DealService
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see net.dfrz.supershop01.utils.Page
 * @see net.dfrz.supershop01.utils.TransactionManager
 * @author J1205-HongHG
 * @version Version 159
 */
public class DealServiceImpl implements DealService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealService#deleteDeal(net.dfrz.supershop01.domain.Deal)
	 */
	public void deleteDeal(Deal deal) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			DealDao dealDao=(DealDao)DaoFactory.getDao("DealDao");
			DealItemDao dealItemDao=(DealItemDao)DaoFactory.getDao("DealItemDao");
			dealItemDao.deleteDealItemByDealId(deal.getDealId());
			dealDao.delete(deal);
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealService#updateDeal(net.dfrz.supershop01.domain.Deal)
	 */
	public void updateDeal(Deal deal) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			DealDao dealDao=(DealDao)DaoFactory.getDao("DealDao");
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
	 * @see net.dfrz.supershop01.services.DealService#getDealById(java.lang.Integer)
	 */
	public Deal getDealById(Integer dealId) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		Deal deal=null;
		try
		{
			manager.beginTransaction();
			DealDao dealDao=(DealDao)DaoFactory.getDao("DealDao");
			deal=dealDao.getDealById(dealId);
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		return deal;
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealService#loadAll()
	 */
	public List<Deal> loadAll() {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		List<Deal>dealList=null;
		try
		{
			manager.beginTransaction();
			DealDao dealDao=(DealDao)DaoFactory.getDao("DealDao");
			dealList=dealDao.loadAll();
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		return dealList;
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealService#loadPage(net.dfrz.supershop01.utils.Page, net.dfrz.supershop01.servicesimpl.DealQuryHelper)
	 */
	public Page loadPage(Page pagedDeal, DealQuryHelper helper) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			DealDao dealDao=(DealDao)DaoFactory.getDao("DealDao");
			int totalRecNum=dealDao.countDeal(helper);
			pagedDeal.setTotalRecNum((long)totalRecNum);
			pagedDeal.setPageContent(dealDao.loadPage(pagedDeal.getStartIndex(),pagedDeal.getEndIndex(),helper));
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		return pagedDeal;
	}
}
