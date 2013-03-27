/**
 * 
 */
package net.dfrz.supershop01.services;

import java.util.List;
import net.dfrz.supershop01.domain.Administrator;

/**                
 * Project: supershop01-02
 * ClassName:AdministratorService                                                      
 * Module ID: 4.6  
 * Comments: 在业务层为管理员类对象提供数据添加、删除，修改，显示的功能  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Administrator
 * @see #save(Administrator)
 * @see #getAdministratorById(int)
 * @see #getAdministratorByName(String)
 * @see #loadAll()
 * @see #update(Administrator)
 * @see #delete(int)
 * @author J1205-YDP                                                    
 * @version Version 10 
 */
public interface AdministratorService {
	/**
	 * 保存管理员信息
	 * @param administrator -新增的管理员信息
	 */
	 void save(Administrator administrator);
	 /**
	  * 根据管理员编号获取要查找的管理员对象
	  * @param administratorId -要查找的管理员编号
	  * @return Administrator
	  */
	 Administrator getAdministratorById(int administratorId);
	 /**
	  * 根据管理员帐号获取要查找的管理员对象
	  * @param administratorId -要查找的管理员帐号
	  * @return Administrator 
	  */
	 Administrator getAdministratorByName(String administratorName);
	 /**
	  * 批量显示管理员的信息
	  * @return List<Administrator>
	  */
	 List<Administrator> loadAll();
	 /**
	  * 更新管理员信息
	  * @param administrator -要更新的管理员对象
	  */
	 void update (Administrator administrator);
	 /**
	  * 根据管理员编号删除指定的管理员对象
	  * @param adminId -要删除的管理员编号
	  */
	 void delete(int adminId);
	 /**
	  * 获取所有管理员中编号最大的管理员编号
	  * @return int
	  */
	 int getMax();
}
