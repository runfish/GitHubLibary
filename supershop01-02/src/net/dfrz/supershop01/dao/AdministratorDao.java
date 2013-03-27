/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.Administrator;

/**
 * Project: supershop01-02 ClassName: AdministratorDao Module ID: 4.6 Comments:
 * 在数据层为商品提供增删改查以及获取商品图片的等功能 JDK :jdk1.6.0_10 Create Date： 2013-1-6
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Goods
 * @see #delete(int)
 * @see #getAdministratorById(int)
 * @see #getAdministratorByName(String)
 * @see #getMaxId()
 * @see #loadAll()
 * @see #update(Administrator)
 * @see #save(Administrator)
 * @author J1205-YDP
 * @version Version 5
 */
public interface AdministratorDao {
	/**
	 * 在数据层往XMl文件里添加管理员信息
	 * 
	 * @param administrator
	 */
	void save(Administrator administrator);

	/**
	 * 根据管理员ID获取管理员信息
	 * 
	 * @param administratorId
	 * @return Administrator
	 */
	Administrator getAdministratorById(int administratorId);

	/**
	 * 根据管理员的用户名获取管理员的信息
	 * 
	 * @param administratorName
	 * @return Administrator
	 */
	Administrator getAdministratorByName(String administratorName);

	/**
	 * 获取所有管理员的信息
	 * 
	 * @return List<Administrator>
	 */
	List<Administrator> loadAll();

	/**
	 * 更新管理员的信息
	 * 
	 * @param administrator
	 */
	void update(Administrator administrator);

	/**
	 * 根据管理员的ID删除此管理员的信息性
	 * 
	 * @param adminId
	 */
	void delete(int adminId);

	/**
	 * 获取XMl文件中最大的ID号
	 * 
	 * @return
	 */
	int getMaxId();

}
