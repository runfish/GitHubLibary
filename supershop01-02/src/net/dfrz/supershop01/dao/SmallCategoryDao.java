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
 * @see #addSmallCategory(SmallCategory)
 * @see #countSmallCategory()
 * @see #deleteSmallCategory(int)
 * @see #ListOraderItem()
 * @see #getOne(int)
 * @see #getSubCtg(int)
 * @see #loadPage(int, int)
 * @see #updateSmallCategory(SmallCategory)
 * @Author J1205-YouHQ and J1205-HHG and J1205-YDP
 * @version Version 5
 */
public interface SmallCategoryDao {
	/**
	 * 显示订单
	 * @return
	 */
	List<SmallCategory> ListOraderItem();
	/**
	 * 增加小类别信息
	 * @param samllcategory
	 */
    void addSmallCategory(SmallCategory samllcategory);
    /**
     * 更新小类别信息
     * @param samllcategory
     */
    void updateSmallCategory(SmallCategory samllcategory);
    /**
     * 获取一个小类别
     * @param id
     * @return
     */
    SmallCategory getOne(int id);
    /**
     * 删除小类别信息
     * @param id
     */
    void deleteSmallCategory(int id);
    /**
     * 显示分页后的小类别信息
     * @param beginIndex
     * @param endIndex
     * @return
     */
    List<SmallCategory>loadPage(int beginIndex, int endIndex);
    /**
     * 根据查询条件获取小类别的总数
     * @return
     */
    int countSmallCategory();
    /**
     * 根据大类别ID获取小类别集合
     * @param bigCtgId
     * @return
     */
    List<SmallCategory> getSubCtg(int bigCtgId);
}
