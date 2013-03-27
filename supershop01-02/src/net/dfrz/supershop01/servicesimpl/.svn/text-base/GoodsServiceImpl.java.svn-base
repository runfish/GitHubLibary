/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;


import java.util.List;

import net.dfrz.supershop01.dao.GoodsDao;
import net.dfrz.supershop01.daoimpl.GoodsDaoJDBCImpl;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.Page;
import net.dfrz.supershop01.utils.TransactionManager;
/**
 * Project: supershop01-02
 * ClassName: GoodsServiceImpl                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为商品类对象提供数据删除，修改，分页显示的功能,GoodsService的实现类  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.util.List
 * @see net.dfrz.supershop01.dao.GoodsDao
 * @see net.dfrz.supershop01.daoimpl.GoodsDaoJDBCImpl
 * @see net.dfrz.supershop01.domain.Goods
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.services.GoodsService
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see net.dfrz.supershop01.utils.Page
 * @see net.dfrz.supershop01.utils.TransactionManager
 * @author J1205-YDP
 * @version Version 159
 */
public class GoodsServiceImpl implements GoodsService {


	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
			manager.beginTransaction();
		    GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		    goodsDao.add(goods);
		    manager.commitAndClose();
		
		}catch(Exception e){
			e.printStackTrace();
		    manager.rollbackAndClose();	
		    throw new ApplicationException(e.getMessage());
		}
		
		
	}

	public Goods getGoodsById(int goodsId) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		Goods goods=null;
		try{
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
	    goods=goodsDao.getGoodsById(goodsId);
	    manager.commitAndClose();
		
	 }catch(Exception e){
		e.printStackTrace();
	    manager.rollbackAndClose();
	    throw new ApplicationException(e.getMessage());
	}
	 return goods;
	}


	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		goodsDao.update(goods);
	    manager.commitAndClose();
		
	    }catch(Exception e){
		e.printStackTrace();
	    manager.rollbackAndClose();	
	    throw new ApplicationException(e.getMessage());
	}
		
	}
	
	public Page loadPagedGoods(Page page, GoodsQueryHelper helper){
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
		   GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		   page.setTotalRecNum((long)goodsDao.countGoods(helper));
		   page.setPageContent(goodsDao.getScopedGoods(helper, page.getStartIndex(), page.getEndIndex()));
           manager.commitAndClose();
		}catch(Exception e){
		    e.printStackTrace();
	        manager.rollbackAndClose();	
	        throw new ApplicationException(e.getMessage());
	  }
	   return page;
	}
	
	public byte[] loadGoodsImageById(Integer goodsId){
		byte [] goodsImage = null;
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		goodsImage = goodsDao.getGoodsImage(goodsId);
		 manager.commitAndClose();
		
	   }catch(Exception e){
		  e.printStackTrace();
	      manager.rollbackAndClose();	
	      throw new ApplicationException(e.getMessage());
	}
	return goodsImage;
	}



	public void delete(Integer goodsId) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		goodsDao.deleteGoodsById(goodsId);
	    manager.commitAndClose();
		
	   }catch(Exception e){
		  e.printStackTrace();
	      manager.rollbackAndClose();
	      throw new ApplicationException(e.getMessage());
	}
		
	}


	public List<Goods> loadAll() {
		// TODO Auto-generated method stub
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		List<Goods> gooList = null;
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
		   gooList = goodsDao.loadAll();
	        manager.commitAndClose();
		
	     }catch(Exception e){
		    e.printStackTrace();
	        manager.rollbackAndClose();	
	        throw new ApplicationException(e.getMessage());
	  }
	  return gooList;
	}


}
