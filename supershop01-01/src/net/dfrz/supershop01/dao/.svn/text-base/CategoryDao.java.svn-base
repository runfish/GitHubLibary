/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.Category;

/**
 * Project: supershop01-01 ClassName: CategoryDao Module ID: 4.6 Comments:
 * 在数据层为商品类別提供查询等功能 JDK :jdk1.6.0_10 Create Date： 2013-1-6
 * 
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Category
 * @see #getCtgById(int)
 * @see #loadAll()
 * @author J1205-YHQ and J1205-YDP
 * @version Version 5
 */
public interface CategoryDao {

	/**
	 * 根据大类的ID号获取大类别的信息
	 * 
	 * @param ctgId
	 * @exception net.dfrz.supershop01.exception.DataAccessException -读取数据库数据发生错误时抛出异常
	 * @return Category
	 */

	Category getCtgById(int ctgId);

	/**
	 * 获取所有大类别的信息
	 * 
	 * @exception net.dfrz.supershop01.exception.DataAccessException -读取数据库数据发生错误时抛出异常
	 * @return List<Category>
	 */
	List<Category> loadAll();
}
