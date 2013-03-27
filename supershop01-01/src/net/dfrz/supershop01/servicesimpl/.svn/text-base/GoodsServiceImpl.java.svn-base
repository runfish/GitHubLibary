/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import java.util.List;

import net.dfrz.supershop01.dao.GoodsDao;
import net.dfrz.supershop01.daoimpl.GoodsDaoJDBCImpl;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.Page;
import net.dfrz.supershop01.utils.TransactionManager;

/**
 * Project: supershop01-01 ClassName: GoodsService Module ID: 4.6 Comments:
 * 在业务层为商品类对象提供数据查询，更新，分页显示的功能 JDK :jdk1.6.0_10 Create Date： 2013-3-1
 * 
 * @see net.dfrz.supershop01.domain.Goods
 * @see java.util.List
 * @see net.dfrz.supershop01.servicesimpl.GoodsQueryHelper
 * @see net.dfrz.supershop01.utils.Page
 * @author J1205-YDP
 * @version Version 5
 */
public class GoodsServiceImpl implements GoodsService {

	public Goods getGoodsById(int goodsId) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		Goods goods = null;
		try {
			manager.beginTransaction();
			GoodsDao goodsDao = new GoodsDaoJDBCImpl();
			goods = goodsDao.getGoodsById(goodsId);
			manager.commitAndClose();

		} catch (Exception e) {
			e.printStackTrace();
			manager.rollbackAndClose();
			throw new ApplicationException(e.getMessage());
		}
		return goods;
	}

	public Page loadPagedGoods(Page page, GoodsQueryHelper helper) {
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try {
			manager.beginTransaction();
			GoodsDao goodsDao = new GoodsDaoJDBCImpl();
			page.setTotalRecNum((long) goodsDao.countGoods(helper));
			page.setPageContent(goodsDao.getScopedGoods(helper, page
					.getStartIndex(), page.getEndIndex()));
			manager.commitAndClose();
		} catch (Exception e) {
			e.printStackTrace();
			manager.rollbackAndClose();
			throw new ApplicationException(e.getMessage());
		}
		return page;
	}

	public byte[] loadGoodsImageById(Integer goodsId) {
		byte[] goodsImage = null;
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try {

			manager.beginTransaction();
			GoodsDao goodsDao = new GoodsDaoJDBCImpl();
			goodsImage = goodsDao.getGoodsImage(goodsId);
			manager.commitAndClose();

		} catch (Exception e) {
			e.printStackTrace();
			manager.rollbackAndClose();
			throw new ApplicationException(e.getMessage());
		}
		return goodsImage;
	}

	public List<Goods> loadAll() {
		// TODO Auto-generated method stub
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		List<Goods> gooList = null;
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try {
			manager.beginTransaction();
			gooList = goodsDao.loadAll();
			manager.commitAndClose();

		} catch (Exception e) {
			e.printStackTrace();
			manager.rollbackAndClose();
			throw new ApplicationException(e.getMessage());
		}
		return gooList;
	}

	public Page getGoodsByBigCtgId(Page page, GoodsQueryHelper helper, int ctgId) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();

		try {
			manager.beginTransaction();
			GoodsDao goodsDao = new GoodsDaoJDBCImpl();
			page.setTotalRecNum((long) goodsDao.countGoods(helper, ctgId));
			page.setPageContent(goodsDao.getScopeListGoodsByBigCtgId(helper,
					page.getStartIndex(), page.getEndIndex(), ctgId));
			manager.commitAndClose();

		} catch (Exception e) {
			e.printStackTrace();
			manager.rollbackAndClose();
			throw new ApplicationException(e.getMessage());
		}
		return page;

	}

	public Page getGoodsBySubCtgId(Page page, GoodsQueryHelper helper,
			int subCtgId) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();

		try {
			manager.beginTransaction();
			GoodsDao goodsDao = new GoodsDaoJDBCImpl();
			page
					.setTotalRecNum((long) goodsDao.countSubGoods(helper,
							subCtgId));
			page.setPageContent(goodsDao.getScopeListGoodsBySubCtgId(helper,
					page.getStartIndex(), page.getEndIndex(), subCtgId));
			manager.commitAndClose();

		} catch (Exception e) {
			e.printStackTrace();
			manager.rollbackAndClose();
			throw new ApplicationException(e.getMessage());
		}
		return page;
	}

}
