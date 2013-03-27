/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.SmallCategory;

/**                
 * Project: supershop01-01
 * ClassName: SmallCategoryDao                                                       
 * Module ID: 4.6  
 * Comments: 在数据层为商品小类別提供查询等功能
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-6
 * @see  java.util.List
 * @see  net.dfrz.supershop01.domain.SmallCategory
 * @see #ListOraderItem()
 * @see #getOne(int)
 * @see #getSmallCtgByBigCtgId(int)
 * @author J1205-YHQ and J1205-YDP                                                     
 * @version Version 5      
 */
public interface SmallCategoryDao {

	/**
	 * 获取所有商品小类别信息
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return List<SmallCategory>
	 */
	List<SmallCategory> ListOraderItem();

	/**
	 * 根据小类别的ID号获取相应小类别的信息
	 * @param id
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return SmallCategory
	 */
	SmallCategory getOne(int id);

	/**
	 * 根据大类别的ID号获取属于此大类别下的所有小类别信息
	 * @param bigCtgId
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return  List<SmallCategory> 
	 */
	List<SmallCategory> getSmallCtgByBigCtgId(int bigCtgId);
}
