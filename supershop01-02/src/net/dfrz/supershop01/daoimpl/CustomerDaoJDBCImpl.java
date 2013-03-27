/**
 * 
 */
package net.dfrz.supershop01.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import net.dfrz.supershop01.dao.CustomerDao;
import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.utils.DBUtils;

/**                
 * Project: supershop01-02
 * ClassName: CustomerDaoJDBCImpl                                                        
 * Module ID: 4.6  
 * Comments: 在数据层实现用户信息的添加、获取、与修改的实现类  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see java.util.ArrayList
 * @see java.util.List
 * @see org.apache.log4j.Logger
 * @see net.dfrz.supershop01.dao.CustomerDao
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see #GET_CUS_BYNAME
 * @see #UPDATE_CUSTOMER
 * @see #LOGGER
 * @see #getCustomerByName(String)
 * @see #updateCustomer(Customer)
 * @see #loadPageCustomer(int, int)
 * @see #countCustomer()
 * @see #buildSqlByHelper()
 * @author J1205-YDP                                                 
 * @version Version 10 
 */
public class CustomerDaoJDBCImpl implements CustomerDao {
	private static final Logger LOGGER=Logger.getLogger(CustomerDaoJDBCImpl.class);
	private static final String GET_CUS_BYNAME = "select * from customer where customer_name =?";
	
	private static final String UPDATE_CUSTOMER = "update customer set customer_id=?,customer_password=?,customer_real_name=?," +
			                                      "customer_birthday=?,customer_mail=?,customer_tel=?,customer_address=?,customer_postcode=?," +
			                                      "customer_freeze=?,customer_member=?,customer_score=? where customer_name=?";

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CustomerDao#getCustomerByName(java.lang.String)
	 */

	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Customer customer = new Customer();
		
		try {
			LOGGER.info("通过用户名获取用户！");
			pstmt = conn.prepareStatement(GET_CUS_BYNAME);
			pstmt.setString(1, name);
			
			rset = pstmt.executeQuery();
			LOGGER.info("开始设置用户各参数...");
			while(rset.next()){
				
				customer.setCustomerId(String.valueOf(rset.getInt("customer_id")));
				customer.setCustomerName(rset.getString("customer_name"));
				customer.setCustomerPassword(rset.getString("customer_password"));
				customer.setCustomerBirthday(rset.getString("customer_birthday"));
				customer.setCustomerAddress(rset.getString("customer_address"));
				customer.setCustomerMail(rset.getString("customer_mail"));
				customer.setCustomerRealname(rset.getString("customer_real_name"));
				customer.setCustomerPostCode(rset.getString("customer_postcode"));
				customer.setCustomerTel(rset.getString("customer_tel"));
				customer.setIsFreeze(Integer.parseInt((rset.getString("customer_freeze"))));
				customer.setIsMember(rset.getInt("customer_member"));
				customer.setCustomerScore(rset.getDouble("customer_score"));
				customer.setCustomerAccount(rset.getDouble("customer_account"));
			}
			LOGGER.info("用户参数设置完毕！");			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("用户信息提取失败！");
			throw new DataAccessException("用户信息提取失败");

		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		
		return customer;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CustomerDao#updateCustomer(net.dfrz.supershop01.domain.Customer)
	 */

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		PreparedStatement pstmt = null;
		LOGGER.info("开始设置用户各参数...");
		try {
			
			pstmt = conn.prepareStatement(UPDATE_CUSTOMER);
			pstmt.setInt(1, Integer.parseInt(customer.getCustomerId()));
			pstmt.setString(2, customer.getCustomerPassword());
			pstmt.setString(3, customer.getCustomerRealname());
			pstmt.setString(4, customer.getCustomerBirthday());
			pstmt.setString(5, customer.getCustomerMail());
			pstmt.setString(6, customer.getCustomerTel());
			pstmt.setString(7, customer.getCustomerAddress());
			pstmt.setString(8, customer.getCustomerPostCode());
			pstmt.setInt(9, customer.getIsFreeze());
			pstmt.setInt(10, customer.getIsMember());
			pstmt.setDouble(11, customer.getCustomerScore());
			pstmt.setString(12, customer.getCustomerName());
			
			
			pstmt.executeUpdate();
			LOGGER.info("用户信息更新完毕！");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			LOGGER.error("用户信息修改失败！");
			throw new DataAccessException("用户信息修改失败,");
			
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
		
		
		
		

	}

	
	public List<Customer> loadPageCustomer(int beginIndex, int endIndex) {
		LOGGER.info("开始连接数据库...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		PreparedStatement pstmt=null; 
		ResultSet rset=null;
		List<Customer> customerList=null;
		
		try {
			
			customerList=new ArrayList<Customer>();
			
			String sql="select * from ( select rownum rn,a.* from ( "+ this.buildSqlByHelper()+" ) a where rownum<=? ) where rn>=?";
			pstmt=conn.prepareStatement(sql);	
			pstmt.setInt(1, endIndex);
			pstmt.setInt(2, beginIndex);
			rset=pstmt.executeQuery();
			LOGGER.info("开始设置用户各参数...");
			while(rset.next()){
				Customer customer = new Customer();
				
				
				customer.setCustomerId(String.valueOf(rset.getInt("customer_id")));
				customer.setCustomerName(rset.getString("customer_name"));
				customer.setCustomerPassword(rset.getString("customer_password"));
				customer.setCustomerBirthday(rset.getString("customer_birthday"));
				customer.setCustomerAddress(rset.getString("customer_address"));
				customer.setCustomerMail(rset.getString("customer_mail"));
				customer.setCustomerRealname(rset.getString("customer_real_name"));
				customer.setCustomerPostCode(rset.getString("customer_postcode"));
				customer.setCustomerTel(rset.getString("customer_tel"));
				customer.setIsFreeze(Integer.parseInt(rset.getString("customer_freeze")));
				customer.setIsMember(rset.getInt("customer_member"));
				customer.setCustomerScore(rset.getDouble("customer_score"));
				customer.setCustomerAccount(rset.getDouble("customer_account"));
				
				
				
				customerList.add(customer);
			   
			}
			LOGGER.info("用户各参数设置完毕！");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("数据提取失败！");
			throw new DataAccessException("数据提取失败");
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		
		return customerList;
	}
	
	
    private String buildSqlByHelper(){
  		
  		String sql="select * from customer where 1=1";
  		
  		return sql;
  		
  	}


	public long countCustomer() {
		// TODO Auto-generated method stub
			String sql=this.buildSqlByHelper();
			sql=sql.replace("*", "count(*) total");			
			LOGGER.info("开始连接数据库...");		
			Connection conn = DBUtils.getConn();
			LOGGER.info("数据库连接成功！");
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			Integer total=null;
			
			try{
			   pstmt=conn.prepareStatement(sql);
			   rset=pstmt.executeQuery();
			   
			   if(rset.next()){
				  total=rset.getInt("total"); 
			   }
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.error("获取用户总数失败！");
				throw new DataAccessException("获取用户总数失败");
			}finally{
				DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
			}	
			
			return total;
	}

}
