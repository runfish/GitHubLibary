/**
 * 
 */
package net.dfrz.supershop01.services;

import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.utils.Page;

/**                
 * Project: supershop01-02
 * ClassName: CustomerService                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为用户类对象提供数据添加，修改、查找的功能
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.utils.Page
 * @see #getCustomerByName(String)
 * @see #modifyCustomer(Customer)
 * @see #loadPageCustomer(Page)
 * @author J1205-YDP                                                     
 * @version Version 10 
 */
public interface CustomerService {
	/**
	 * 根据用户名获取用户对象
	 * @param name -要查找的用户对象的用户名
	 * @return Customer
	 */
	Customer getCustomerByName(String name);
	/**
	 * 修改修改用户对象信息
	 * @param customer -要修改的用户对象
	 */
	void modifyCustomer(Customer customer);
	/**
	 * 获取所有的用户对象，并实现分页效果
	 * @param page -分页的页面对象
	 * @return Page
	 */
	Page loadPageCustomer(Page page);
}
