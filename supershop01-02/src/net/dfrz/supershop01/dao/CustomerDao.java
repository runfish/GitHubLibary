/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.Customer;

/**                
 * Project: supershop01-02
 * ClassName: CustomerDao                                                        
 * Module ID: 4.6  
 * Comments: 在数据层实现用户信息的添加、获取、与修改
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Customer
 * @see #getCustomerByName(String)
 * @see #updateCustomer(Customer)
 * @see #loadPageCustomer(int, int)
 * @see #countCustomer()
 * @author J1205-YDP                                             
 * @version Version 10 
 */
public interface CustomerDao {
	
	/**
	 * 根据用户名获取用户对象返回
	 * @param name -要获取的用户对象的用户名
	 * @throws net.dfrz.supershop01.exception.DataAccessException 
	 * @return Customer
	 */
	Customer getCustomerByName(String name);
	/**
	 * 修改用户的基本信息
	 * @param customer -要修改的用户对象
	 * @throws net.dfrz.supershop01.exception.DataAccessException 
	 */
	void updateCustomer(Customer customer);
	/**
	 * 获取所有的用户信息，并实现分页效果
	 * @param beginIndex -当前页面的起始记录编号
	 * @param endIndex -当前页面的结束记录的编号
	 * @throws net.dfrz.supershop01.exception.DataAccessException 
	 * @return List<Customer>
	 */
	List<Customer> loadPageCustomer(int beginIndex,int endIndex);
	/**
	 * 统计数据库中的用户的总个数
	 * @throws net.dfrz.supershop01.exception.DataAccessException 
	 * @return long
	 */
	long countCustomer();
}
