/**
 * 
 */
package net.dfrz.supershop01.dao;

import net.dfrz.supershop01.daoimpl.AdministratorDaoXMLImpl;
import net.dfrz.supershop01.daoimpl.CategoryDaoJDBCImpl;
import net.dfrz.supershop01.daoimpl.DealDaoJDBCImpl;
import net.dfrz.supershop01.daoimpl.DealItemDaoJDBCImpl;
import net.dfrz.supershop01.daoimpl.GoodsDaoJDBCImpl;
import net.dfrz.supershop01.daoimpl.SmallCategoryDaoJDBCImpl;

/**
 * @author ctd
 *
 */
public class DaoFactory {
	
	
	public static Object getDao(String daoName){
		if("CategoryDao".equals(daoName))
		{
			return new CategoryDaoJDBCImpl();
		}
		else if("SmallCategoryDao".equals(daoName))
		{
			return new SmallCategoryDaoJDBCImpl();
		}
		else if("DealDao".equals(daoName))
		{
			return new DealDaoJDBCImpl();
		}
		else if("DealItemDao".equals(daoName))
		{
			return new DealItemDaoJDBCImpl();
		}
		else if("GoodsDao".equals(daoName))
		{
			return new GoodsDaoJDBCImpl();
		}
		else if("AdministratorDao".equals(daoName))
		{
			return new AdministratorDaoXMLImpl();
		}
		else if("CustomerDao".equals(daoName))
		{
			return null;
		}
		
		return null;
	}

}
