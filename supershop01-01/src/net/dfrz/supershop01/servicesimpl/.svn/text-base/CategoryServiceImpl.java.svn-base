/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import java.util.List;

import net.dfrz.supershop01.dao.CategoryDao;
import net.dfrz.supershop01.dao.DaoFactory;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.services.CategoryService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.TransactionManager;

/**
 * Project: supershop01-02 
 * ClassName:CategoryServiceImpl 
 * Module ID: 4.6
 * Comments: 在业务层为类别类对象提供数据查询,GategoryService的实现类 
 * JDK :jdk1.6.0_10
 * Create Date： 2013-2-9
 * @see net.dfrz.supershop01.dao.CategoryDao
 * @see net.dfrz.supershop01.dao.DaoFactory
 * @see net.dfrz.supershop01.domain.Category
 * @see net.dfrz.supershop01.services.CategoryService
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see net.dfrz.supershop01.utils.TransactionManager
 * @see #getCtgById(int)
 * @see #loadAll()
 * @author J1205-YouHQ and J1205-YDP
 * @version Version 359
 */
public class CategoryServiceImpl implements CategoryService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CategoryService#getCategoryById(int)
	 */
	public Category getCtgById(int ctgId) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getTranManager();

		Category ctg = null;

		try {
			manager.beginTransaction();

			CategoryDao ctgDao = (CategoryDao) DaoFactory.getDao("CategoryDao");

			ctg = ctgDao.getCtgById(ctgId);

			manager.commitAndClose();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			manager.rollbackAndClose();
		}
		return ctg;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CategoryService#loadAll()
	 */
	public List<Category> loadAll() {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getTranManager();

		CategoryDao ctgDao = (CategoryDao) DaoFactory.getDao("CategoryDao");

		List<Category> ctgList = null;

		try {
			manager.beginTransaction();

			ctgList = ctgDao.loadAll();

			manager.commitAndClose();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			manager.rollbackAndClose();
		}

		return ctgList;
	}
}