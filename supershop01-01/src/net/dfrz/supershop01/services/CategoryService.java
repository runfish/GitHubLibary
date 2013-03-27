/**
 * 
 */
package net.dfrz.supershop01.services;

import java.util.List;

import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.Customer;

/**                
 * Project: supershop01-01
 * ClassName: CategoryService                                                       
 * Module ID: 4.6  
 * Comments: 在业务层为用户类对象提供数据查找的功能
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.domain.Category
 * @see #getCtgById(int)
 * @see #loadAll()
 * @author J1205-YHQ and J1205-YDP                                                     
 * @version Version 10 
 */
public interface CategoryService {
	/**
	 * 根据大类别ID获取相应的大类别信息
	 * @param ctgId
	 * @return	Category
	 */
	Category getCtgById(int ctgId);

	/**
	 * 获取所有的大类别信息
	 * @return	List<Category>
	 */
	List<Category> loadAll();
}
