/**
 * 
 */
package net.dfrz.supershop01.dao;

import net.dfrz.supershop01.daoimpl.CategoryDaoJDBCImpl;
import net.dfrz.supershop01.daoimpl.DealDaoJDBCImpl;
import net.dfrz.supershop01.daoimpl.DealItemDaoJDBCImpl;

/**                
 * Project: supershop01-02
 * ClassName: Deal                                                     
 * Module ID: 4.6  
 * Comments: 定义商品订单对象的模版  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-16
 *@see net.dfrz.supershop01.daoimpl.CategoryDaoJDBCImpl
 *@see net.dfrz.supershop01.daoimpl.DealDaoJDBCImpl
 *@see net.dfrz.supershop01.daoimpl.DealItemDaoJDBCImpl
 *@see #getDao(String)
 *@author J1205-HongHG J1205-YouHQ                                                      
 *@version Version 100 
 */
public class DaoFactory {

	/**
	 * 根据具体的实体名称返回所需的Dao的实例
	 * @param daoName -Dao对象的名称
	 * @return Object
	 */
	public static Object getDao(String daoName) {

		if ("CategoryDao".equals(daoName)) {
			return new CategoryDaoJDBCImpl();
		} else if ("DealDao".equals(daoName)) {
			return new DealDaoJDBCImpl();
		} else if ("DealItemDao".equals(daoName)) {
			return new DealItemDaoJDBCImpl();
		} else if ("GoodsDao".equals(daoName)) {
			return null;
		} else if ("AdministratorDao".equals(daoName)) {
			return null;
		} else if ("CustomerDao".equals(daoName)) {
			return null;
		}

		return null;
	}

}
