/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;


import net.dfrz.supershop01.dao.CustomerDao;
import net.dfrz.supershop01.daoimpl.CustomerDaoJDBCImpl;
import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.services.CustomerService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.Page;
import net.dfrz.supershop01.utils.TransactionManager;

/**                
 * Project: supershop01-02
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
 * @see net.dfrz.supershop01.utils.Page
 * @see net.dfrz.supershop01.utils.TransactionManager
 * @see #getCustomerByName(String)
 * @see #modifyCustomer(Customer)
 * @see #loadPageCustomer(Page)
 * @author J1205-YDP                                                       
 * @version Version 10 
 */
public class CustomerServiceImpl implements CustomerService {


	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CustomerService#getCustomerByName(java.lang.String)
	 */
	
	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		CustomerDao customerDao = new CustomerDaoJDBCImpl();
		Customer customer = null;
		try{
			 manager.beginTransaction();
			 customer = customerDao.getCustomerByName(name);
			 manager.commitAndClose();
				
		}catch(Exception e){
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
		try{
			 manager.beginTransaction();
			 customerDao.updateCustomer(customer);
			 manager.commitAndClose();
				
		}catch(Exception e){
			e.printStackTrace();
		  manager.rollbackAndClose();	
		}

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CustomerService#loadPageCustomer(net.dfrz.supershop01.utils.Page)
	 */
	public Page loadPageCustomer(Page page) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		CustomerDao customerDao = new CustomerDaoJDBCImpl();
		
		try{
			 manager.beginTransaction();
			 
			 page.setTotalRecNum(customerDao.countCustomer());
			 page.setPageContent(customerDao.loadPageCustomer(page.getStartIndex(), page.getEndIndex()));
			 
			 manager.commitAndClose();
				
		}catch(Exception e){
			e.printStackTrace();
		  manager.rollbackAndClose();	
		}
		return page;
	}

}
