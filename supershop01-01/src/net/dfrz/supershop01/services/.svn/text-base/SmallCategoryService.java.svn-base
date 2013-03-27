package net.dfrz.supershop01.services;

import java.util.List;
import net.dfrz.supershop01.domain.SmallCategory;

/**                
 * Project: supershop01-01
 * ClassName: SmallCategoryService                                                      
 * Module ID: 4.6  
 * Comments: 在数据层为商品小类別提供查询等功能
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-6
 * @see  java.util.List
 * @see  net.dfrz.supershop01.domain.SmallCategory
 * @see #loadall()
 * @see #getCtg(Integer)
 * @see #getSmallCtgByBigId(int)
 * @author J1205-YHQ and J1205-YDP                                                     
 * @version Version 5      
 */

public interface SmallCategoryService {

	/**
	 *在服务层获取所有小类别信息
	 * @return	List<SmallCategory>
	 */
	List<SmallCategory> loadall();

	/**
	 * 在服务层根据小类别的ID获取相应小类别的信息
	 * @param ctgId
	 * @return	SmallCategory 
	 */
	SmallCategory getCtg(Integer ctgId);

	/**
	 * 在服务层根据大类别的ID获取相应小类别信息的集合
	 * @param bigCtgId
	 * @return	List<SmallCategory>
	 */
	List<SmallCategory> getSmallCtgByBigId(int bigCtgId);

}
