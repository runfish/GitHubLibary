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
 * Comments:在业务层为用户类对象提供数据添加，修改、查找的功能 
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
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
	 * 在服务层增加商品大类别信息
	 * @param ctg
	 */
	void addCtg(Category ctg);
	/**
	 * 根据商品大类别ID删除商品大类别信息
	 * @param ctgId
	 */
	void deleteCtg(int ctgId);
	/**
	 * 根据商品大类别的ID获取商品大类别信息
	 * @param ctgId
	 * @return Category
	 */
	Category getCtgById(int ctgId);
	/**
	 * 更新商品大类别信息
	 * @param ctg
	 */
	void updateCtg(Category ctg);
	/**
	 * 获取所有商品大类别信息
	 * @return
	 */
	List<Category> loadAll();
	/**
	 * 根据查询条件获得分页后的商品大类别信息集合
	 * @param page
	 * @param helper
	 * @return	Page
	 */
	Page loadPageAll(CategoryQueryHelper helper, Page page);
}
