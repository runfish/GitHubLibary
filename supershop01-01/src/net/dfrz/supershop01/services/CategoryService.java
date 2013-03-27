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
 * Comments: ��ҵ���Ϊ�û�������ṩ���ݲ��ҵĹ���
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-9
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.domain.Category
 * @see #getCtgById(int)
 * @see #loadAll()
 * @author J1205-YHQ and J1205-YDP                                                     
 * @version Version 10 
 */
public interface CategoryService {
	/**
	 * ���ݴ����ID��ȡ��Ӧ�Ĵ������Ϣ
	 * @param ctgId
	 * @return	Category
	 */
	Category getCtgById(int ctgId);

	/**
	 * ��ȡ���еĴ������Ϣ
	 * @return	List<Category>
	 */
	List<Category> loadAll();
}
