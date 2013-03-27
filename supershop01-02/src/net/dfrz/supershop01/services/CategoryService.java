/**
 * 
 */
package net.dfrz.supershop01.services;

import java.util.List;

import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;
import net.dfrz.supershop01.utils.Page;

/**
 * Project: supershop01-02 
 * ClassName: CategoryService 
 * Module ID: 4.6 
 * Comments:��ҵ���Ϊ�û�������ṩ������ӣ��޸ġ����ҵĹ��� 
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-9
 * @see net.dfrz.supershop01.domain.Category;
 * @see net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;
 * @see net.dfrz.supershop01.utils.Page;
 * @see #addCtg(Category)
 * @see #deleteCtg(int)
 * @see #getCtgById(int)
 * @see #loadAll()
 * @see #loadPageAll(CategoryQueryHelper, Page)
 * @see #updateCtg(Category)
 * @author J1205-YouHQ
 * @version Version 10
 */
public interface CategoryService {
	/**
	 * �ڷ����������Ʒ�������Ϣ
	 * @param ctg
	 */
	void addCtg(Category ctg);
	/**
	 * ������Ʒ�����IDɾ����Ʒ�������Ϣ
	 * @param ctgId
	 */
	void deleteCtg(int ctgId);
	/**
	 * ������Ʒ������ID��ȡ��Ʒ�������Ϣ
	 * @param ctgId
	 * @return Category
	 */
	Category getCtgById(int ctgId);
	/**
	 * ������Ʒ�������Ϣ
	 * @param ctg
	 */
	void updateCtg(Category ctg);
	/**
	 * ��ȡ������Ʒ�������Ϣ
	 * @return
	 */
	List<Category> loadAll();
	/**
	 * ���ݲ�ѯ������÷�ҳ�����Ʒ�������Ϣ����
	 * @param page
	 * @param helper
	 * @return	Page
	 */
	Page loadPageAll(CategoryQueryHelper helper, Page page);
}
