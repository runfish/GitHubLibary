/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import javax.xml.rpc.ServiceException;

import net.dfrz.supershop01.dao.CustomerDao;
import net.dfrz.supershop01.daoimpl.CustomerDaoJDBCImpl;
import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.services.CustomerService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.TransactionManager;

/**                
 * Project: supershop01-01
 * ClassName: CustomerServiceImpl                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为用户类对象提供数据添加，修改、查找的功能的实现类
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see net.dfrz.supershop01.dao.CustomerDao
 * @see net.dfrz.supershop01.daoimpl.CustomerDaoJDBCImpl
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.services.CustomerService
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see net.dfrz.supershop01.utils.TransactionManager
 * @see #create(Customer)
 * @see #getCustomerByName(String)
 * @see #modifyCustomer(Customer)
 * @author J1205-YDP                                                 
 * @version Version 10 
 */
public class CustomerServiceImpl implements CustomerService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CustomerService#create(net.dfrz.supershop01.domain.Customer)
	 */

	public void create(Customer customer) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		CustomerDao customerDao = new CustomerDaoJDBCImpl();
		try {
			manager.beginTransaction();
			customerDao.add(customer);
			manager.commitAndClose();

		} catch (Exception e) {
			e.printStackTrace();
			manager.rollbackAndClose();
		}

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CustomerService#getCustomerByName(java.lang.String)
	 */

	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		CustomerDao customerDao = new CustomerDaoJDBCImpl();
		Customer customer = null;
		try {
			manager.beginTransaction();
			customer = customerDao.getCustomerByName(name);
			if(customer==null)
			{  
			   throw new ServiceException("对不起，用户名不存在，请重新输入！");
			}
			manager.commitAndClose();

		} catch (Exception e) {
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		return customer;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CustomerService#modifyCustomer(net.dfrz.supershop01.domain.Customer)
	 */

	public void modifyCustomer(Customer customer) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		CustomerDao customerDao = new CustomerDaoJDBCImpl();
		try {
			manager.beginTransaction();
			customerDao.updateCustomer(customer);
			manager.commitAndClose();

		} catch (Exception e) {
			e.printStackTrace();
			manager.rollbackAndClose();
		}

	}

}
