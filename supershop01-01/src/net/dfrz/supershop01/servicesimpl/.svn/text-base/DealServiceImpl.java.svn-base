/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import java.util.List;

import net.dfrz.supershop01.dao.CustomerDao;
import net.dfrz.supershop01.dao.DaoFactory;
import net.dfrz.supershop01.dao.DealDao;
import net.dfrz.supershop01.dao.DealItemDao;
import net.dfrz.supershop01.dao.GoodsDao;
import net.dfrz.supershop01.daoimpl.CustomerDaoJDBCImpl;
import net.dfrz.supershop01.daoimpl.DealDaoJDBCImpl;
import net.dfrz.supershop01.daoimpl.GoodsDaoJDBCImpl;
import net.dfrz.supershop01.domain.CartItem;
import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.ShoppingCart;
import net.dfrz.supershop01.services.DealService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.Page;
import net.dfrz.supershop01.utils.TransactionManager;

/**
 * Project: supershop01-01
 * ClassName: DealServiceImpl                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为订单类对象提供数据删除，修改，分页显示的功能,DealService的实现类  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.dao.DaoFactory
 * @see net.dfrz.supershop01.dao.DealDao
 * @see net.dfrz.supershop01.dao.DealItemDao
 * @see net.dfrz.supershop01.dao.GoodsDao
 * @see net.dfrz.supershop01.daoimpl.GoodsDaoJDBCImpl
 * @see net.dfrz.supershop01.domain.CartItem
 * @see net.dfrz.supershop01.domain.Deal
 * @see net.dfrz.supershop01.domain.DealItem
 * @see net.dfrz.supershop01.domain.Goods
 * @see net.dfrz.supershop01.domain.ShoppingCart
 * @see net.dfrz.supershop01.services.DealService
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see net.dfrz.supershop01.utils.Page
 * @see net.dfrz.supershop01.utils.TransactionManager
 * @see #addDeal(Deal, ShoppingCart)
 * @see #deleteDeal(Deal)
 * @see #updateDeal(Deal)
 * @see #getDealById(Integer)
 * @see #loadAll()
 * @see #loadPage(Page, DealQuryHelper)
 * @see #changeCartItemToDeal(Deal, ShoppingCart)
 *@author J1205-HongHG
 *@version Version 159
 */
public class DealServiceImpl implements DealService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealService#addDeal(net.dfrz.supershop01.domain.Deal, net.dfrz.supershop01.domain.ShoppingCart, net.dfrz.supershop01.domain.Customer)
	 */
	public void addDeal(Deal deal,ShoppingCart cart,Customer customer)
	{
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			DealDao dealDao=(DealDao)DaoFactory.getDao("DealDao");
			DealQuryHelper helper=new DealQuryHelper();
			/**
			 * 获取当前数据库中编号最大的订单编号
			 */
			if(dealDao.countDeal(helper)!=0)
			{
				int maxId=dealDao.getMaxDealId(helper);
				deal.setDealId(maxId+1);
			}
			else
			{
				deal.setDealId(Deal.getBaseDealId()+1);
			}
			/**
			 * 未将购物车中的条目对象转换成订单条目对象时订单中的条目数量默认设置成零
			 */
			deal.setItemAmount(0);
			/**
			 * 将订单对象先行保存到数据库中
			 */
			dealDao.add(deal);
			/**
			 * 进行购物车中购物车条目对象转化成订单条目对象并保存入数据库
			 */
			changeCartItemToDeal(deal, cart,customer);
			
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
	}
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
			/**
			 * 删除订单信息时，先根据订单编号，将该订单下的所有订单条目信息删除
			 */
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
	 * @see net.dfrz.supershop01.services.DealService#loadAll
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
	 * @see net.dfrz.supershop01.services.DealService#loadPage(net.dfrz.supershop01.utils.Page, net.dfrz.supershop01.serviceImpl.DealQuryHelper helper)
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
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealService#changeCartItemToDeal(net.dfrz.supershop01.domain.Deal ,net.dfrz.supershop01.domain.ShoppingCart)
	 */
	public void changeCartItemToDeal(Deal deal, ShoppingCart cart,Customer customer) {
		// TODO Auto-generated method stub
		
		try
		{  
			/**
			 * 设置订单的条目数量,以及订单的商品总金额
			 */
			deal.setItemAmount(cart.getCartList().size());
			deal.setDealSum(cart.getTotalAmount());
			DealDao dealDao = new DealDaoJDBCImpl();
			dealDao.update(deal);
			/**
			 * 修改当前商品的库存数量
			 */
			GoodsDao goodsDao = new GoodsDaoJDBCImpl();
			
			for(CartItem item:cart.getCartList())
			{
				Goods goods = goodsDao.getGoodsById(item.getGoodsId());
				goods.setGoodsQty(goods.getGoodsQty()-item.getGoodsQty());
			    goodsDao.update(goods);
				/**
				 * 封装并存储订单条目信息
				 */
			    DealItemDao dealItemDao = (DealItemDao)DaoFactory.getDao("DealItemDao"); 
				DealItem dealItem = new DealItem();
				
				dealItem.setDealAdminId(item.getAdminId());
				dealItem.setDealGoodsCtgId(item.getGoodsCtgId());
				dealItem.setDealGoodsId(item.getGoodsId());
				dealItem.setItemGoodsPrice(item.getGoodsPrice());
				dealItem.setItemGoodsQty(item.getGoodsQty());
				dealItem.setDealId(deal.getDealId());
				dealItemDao.add(dealItem);
			}
			/**
			 * 订单条目保存成功后修改用户的账户金额
			 */
			CustomerDao customerDao = new CustomerDaoJDBCImpl();
		    customer.setCustomerAccount(customer.getCustomerAccount()-cart.getTotalAmount());
		    customerDao.updateCustomer(customer);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
