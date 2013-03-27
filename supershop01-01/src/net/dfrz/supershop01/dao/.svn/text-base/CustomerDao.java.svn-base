/**
 * 
 */
package net.dfrz.supershop01.dao;

import net.dfrz.supershop01.domain.Customer;

/**
 * Project: supershop01-01 ClassName: CustomerDao Module ID: 4.6 Comments:
 * 在数据层实现用户信息的添加、获取、与修改 JDK :jdk1.6.0_10 Create Date： 2013-1-9
 * 
 * @see net.dfrz.supershop01.domain.Customer
 * @see #add(Customer)
 * @see #getCustomerByName(String)
 * @see #updateCustomer(Customer)
 * @author J1205-YDP    
 * @version Version 10
 */
public interface CustomerDao {
	/**
	 * 增加新的用户信息
	 * 
	 * @param customer -新增的用户信息
	 * @throws net.dfrz.supershop01.exception.DataAccessException -增加用户失败
	 */
	void add(Customer customer);

	/**
	 * 根据用户名获取用户对象返回
	 * 
	 * @param name -要获取的用户对象的用户名
	 * @throws net.dfrz.supershop01.exception.DataAccessException -获取用户名失败
	 * @return Customer
	 */
	Customer getCustomerByName(String name);

	/**
	 * 修改用户的基本信息
	 * 
	 * @param customer -要修改的用户对象
	 * @throws net.dfrz.supershop01.exception.DataAccessException -修改用户信息失败
	 */
	void updateCustomer(Customer customer);
}
