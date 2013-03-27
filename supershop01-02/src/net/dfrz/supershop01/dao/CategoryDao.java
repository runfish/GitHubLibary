/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;

import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;


/**
 * Project: supershop01-02 
 * ClassName: CategoryDao 
 * Module ID: 4.6 
 * Comments:在数据层为大类别提供增删改查功能 
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-6
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Category;
 * @see net.dfrz.supershop01.domain.SmallCategory;
 * @see net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;
 * @see #add(Category)
 * @see #countCategory(CategoryQueryHelper)
 * @see #delete(int)
 * @see #getCtgById(int)
 * @see #loadAll()
 * @see #loadPageAll(CategoryQueryHelper, int, int)
 * @see #update(Category)
 * @Author J1205-YHQ and J1205-HHG and J1205-YDP
 * @version Version 5
 */
public interface CategoryDao {

	/**
	 * 增加大类别信息
	 * 
	 * @param ctg
	 */
	void add(Category ctg);

	/**
	 * 根据大类别ID删除类别信息
	 * 
	 * @param ctgId
	 */
	void delete(int ctgId);

	/**
	 * 根据大类别ID 获取此大类别的所有信息
	 * 
	 * @param ctgId
	 * @return
	 */
	Category getCtgById(int ctgId);

	/**
	 * 更新类别信息
	 * 
	 * @param ctg
	 */
	void update(Category ctg);

	/**
	 * 获取所有类别信息
	 * 
	 * @return List<Category>
	 */
	List<Category> loadAll();

	/**
	 * 根据查询条件获取分页的小类别信息
	 * 
	 * @param helper
	 * @param beginIndex
	 * @param endIndex
	 * @return List<SmallCategory>
	 */
	List<SmallCategory> loadPageAll(CategoryQueryHelper helper, int beginIndex,
			int endIndex);

	
	/**
	 * 根据查询条件获取类别的总数
	 * 
	 * @param helper
	 * @return int
	 */
	int countCategory(CategoryQueryHelper helper);

}
