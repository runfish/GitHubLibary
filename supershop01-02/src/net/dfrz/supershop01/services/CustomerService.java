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
 * Comments: ��ҵ���Ϊ�û�������ṩ������ӣ��޸ġ����ҵĹ���
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-9
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
	 * �����û�����ȡ�û�����
	 * @param name -Ҫ���ҵ��û�������û���
	 * @return Customer
	 */
	Customer getCustomerByName(String name);
	/**
	 * �޸��޸��û�������Ϣ
	 * @param customer -Ҫ�޸ĵ��û�����
	 */
	void modifyCustomer(Customer customer);
	/**
	 * ��ȡ���е��û����󣬲�ʵ�ַ�ҳЧ��
	 * @param page -��ҳ��ҳ�����
	 * @return Page
	 */
	Page loadPageCustomer(Page page);
}
