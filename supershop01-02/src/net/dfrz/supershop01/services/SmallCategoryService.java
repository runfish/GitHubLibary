package net.dfrz.supershop01.services;

import java.util.List;

import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;
import net.dfrz.supershop01.utils.Page;

/**
 * Project: supershop01-02 
 * ClassName: CategoryService 
 * Module ID: 4.6 
 * Comments:在业务层为用户类对象提供数据添加，修改、查找的功能 
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see net.dfrz.supershop01.domain.SmallCategory;
 * @see net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;
 * @see net.dfrz.supershop01.utils.Page;
 * @see #delBigCtg(Integer)
 * @see #deleteSmallCtg(int)
 * @see #addSmallCtg(SmallCategory)
 * @see #getSubCtg(int)
 * @see #getCtg(Integer)
 * @see #loadPage(Page)
 * @see #loadall()
 * @see #loadallByBId(Integer)
 * @see #modifyCtg(SmallCategory)
 * @author J1205-YouHQ and J1205-YDP
 * @version Version 10
 */

public interface SmallCategoryService {

	/**
	 * 在服务层增加商品大类别信息
	 * @param sctg
	 */
	void addSmallCtg(SmallCategory sctg);
	/**
	 * 根据商品大类别的ID获取商品小类别信息集合
	 * @param bId
	 * @return
	 */
	List<SmallCategory> loadallByBId(Integer bId);
	/**
	 * 获取所有商品小类别信息
	 * @return
	 */
	List<SmallCategory> loadall();
	/**
	 * 根据商品类别的ID获取商品小类别信息
	 * @param ctgId
	 * @return
	 */
    SmallCategory getCtg(Integer ctgId);
    /**
     * 修改商品小类别信息
     * @param sctg
     */
    void modifyCtg(SmallCategory sctg);
    /**
     * 删除商品大类别信息
     * @param sctg
     */
    void delBigCtg(SmallCategory sctg);
    /**
     * 删除商品小类别信息
     * @param id
     */
    void deleteSmallCtg(int id);
    /**
     * 根据查询条件获得分页后的商品小类别信息集合
     * @param page
     * @return
     */
    Page loadPage(Page page);
    /**
     * 根据商品大类别ID获取小类别
     * @param bigCtgId
     * @return
     */
    List<SmallCategory> getSubCtg(int bigCtgId);
    
    
}
