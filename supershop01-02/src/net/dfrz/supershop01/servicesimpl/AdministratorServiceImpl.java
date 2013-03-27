/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import java.util.List;
import net.dfrz.supershop01.dao.AdministratorDao;
import net.dfrz.supershop01.daoimpl.AdministratorDaoXMLImpl;
import net.dfrz.supershop01.domain.Administrator;
import net.dfrz.supershop01.exception.ServiceRunTimeException;
import net.dfrz.supershop01.services.AdministratorService;

/**                
 * Project: supershop01-02
 * ClassName: AdministratorServiceImpl                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为管理员类对象提供数据添加、删除，修改，显示的功能的实现类
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.util.List
 * @see net.dfrz.supershop01.dao.AdministratorDao
 * @see net.dfrz.supershop01.daoimpl.AdministratorDaoXMLImpl
 * @see net.dfrz.supershop01.domain.Administrator
 * @see net.dfrz.supershop01.exception.ServiceRunTimeException
 * @see net.dfrz.supershop01.services.AdministratorService
 * @see #save(Administrator)
 * @see #getAdministratorById(int)
 * @see #getAdministratorByName(String)
 * @see #loadAll()
 * @see #update(Administrator)
 * @see #delete(int)
 * @author J1205-YDP                                                       
 * @version Version 10 
 */
public class AdministratorServiceImpl implements AdministratorService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#delete(java.lang.Integer)
	 */
	public void delete(int adminId) {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		administratorDao.delete(adminId);

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#getAdministratorById(java.lang.Integer)
	 */
	public Administrator getAdministratorById(int administratorId) {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		
		Administrator administrator = administratorDao.getAdministratorById(administratorId);
		if(administrator==null)
		{
			throw new ServiceRunTimeException("该管理员用户不存在，请重新输入!");
		}
		
		return administrator;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#loadAll()
	 */
	public List<Administrator> loadAll() {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		
		List<Administrator> administratorList = administratorDao.loadAll();
		
		return administratorList;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#save(net.dfrz.supershop01.domain.Administrator)
	 */

	public void save(Administrator administrator) {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		
		administratorDao.save(administrator);

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#update(net.dfrz.supershop01.domain.Administrator)
	 */
	public void update(Administrator administrator) {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		administratorDao.update(administrator);

	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#getMax()
	 */
	public int getMax() {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		return administratorDao.getMaxId();
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#getAdministratorByName(java.lang.String)
	 */
	public Administrator getAdministratorByName(String administratorName) {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		return administratorDao.getAdministratorByName(administratorName);
	}
}
