package net.dfrz.supershop01.servicesimpl;


import java.util.List;
import net.dfrz.supershop01.dao.SmallCategoryDao;
import net.dfrz.supershop01.daoimpl.SmallCategoryDaoJDBCImpl;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.TransactionManager;
/**
 * Project: supershop01-01 
 * ClassName:SmallCategoryServiceImpl 
 * Module ID: 4.6
 * Comments: 在业务层为小类别类对象提供数据查询,SamllGategoryService的实现类 
 * JDK :jdk1.6.0_10
 * Create Date： 2013-2-9  
 * @see java.util.List
 * @see net.dfrz.supershop01.dao.SmallCategoryDao
 * @see net.dfrz.supershop01.daoimpl.SmallCategoryDaoJDBCImpl
 * @see net.dfrz.supershop01.domain.SmallCategory
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.services.SmallCategoryService
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see net.dfrz.supershop01.utils.TransactionManager
 * @see #getCtg(Integer)
 * @see #getSmallCtgByBigId(int)
 * @see #loadall()
 * @author J1205-YouHQ and J1205-YDP
 * @version Version 359
 */
public class SmallCategoryServiceImpl implements SmallCategoryService {

	public SmallCategory getCtg(Integer ctgId) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getTranManager();
		SmallCategory smallCategory = null;
		try {
			manager.beginTransaction();
			SmallCategoryDao smallcategorydao = new SmallCategoryDaoJDBCImpl();
			smallCategory = smallcategorydao.getOne(ctgId);
		} catch (Exception e) {
			e.printStackTrace();
			manager.rollbackAndClose();
			throw new ApplicationException(e.getMessage());
		}

		return smallCategory;

	}

	public List<SmallCategory> loadall() {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getTranManager();
		List<SmallCategory> smallList = null;
		try {

			manager.beginTransaction();
			SmallCategoryDao smallcategorydao = new SmallCategoryDaoJDBCImpl();
			smallList = smallcategorydao.ListOraderItem();

		} catch (Exception e) {
			e.printStackTrace();
			manager.rollbackAndClose();
			throw new ApplicationException(e.getMessage());
		}
		return smallList;
	}

	public List<SmallCategory> getSmallCtgByBigId(int bigCtgId) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getTranManager();
		List<SmallCategory> smalList = null;
		try {
			manager.beginTransaction();
			SmallCategoryDao smallCategoryDao = new SmallCategoryDaoJDBCImpl();
			smalList = smallCategoryDao.getSmallCtgByBigCtgId(bigCtgId);
			manager.commitAndClose();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		return smalList;
	}

}
