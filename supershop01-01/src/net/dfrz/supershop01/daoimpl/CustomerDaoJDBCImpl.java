/**
 * 
 */
package net.dfrz.supershop01.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.dfrz.supershop01.dao.CustomerDao;
import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.utils.DBUtils;

/**                
 * Project: supershop01-01
 * ClassName: CustomerDaoJDBCImpl                                                        
 * Module ID: 4.6  
 * Comments: 在数据层实现用户信息的添加、获取、与修改的实现类  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see net.dfrz.supershop01.dao.CustomerDao
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see #ADD_CUSTOMER
 * @see #GET_CUS_BYNAME
 * @see #UPDATE_CUSTOMER
 * @see #add(Customer)
 * @see #getCustomerByName(String)
 * @see #updateCustomer(Customer)
 * @author J1205-YDP                                                     
 * @version Version 10 
 */
public class CustomerDaoJDBCImpl implements CustomerDao {
	/**
	 * 增加用户信息的SQL语句
	 */
	private static final String ADD_CUSTOMER = "insert into customer values(seq_customer.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 * 根据用户名获取用户信息的SQL语句
	 */
	private static final String GET_CUS_BYNAME = "select * from customer where customer_name =?";
	/**
	 * 修改用户信息的SQL语句
	 */
	private static final String UPDATE_CUSTOMER = "update customer set customer_id=?,customer_password=?,customer_real_name=?,"
			+ "customer_birthday=?,customer_mail=?,customer_tel=?,customer_address=?,customer_postcode=?,"
			+ "customer_freeze=?,customer_member=?,customer_score=?, customer_account=? where customer_name=?";

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CustomerDao#add(net.dfrz.supershop01.domain.Customer)
	 */

	public void add(Customer customer) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(ADD_CUSTOMER);
			pstmt.setString(1, customer.getCustomerName());
			pstmt.setString(2, customer.getCustomerPassword());
			pstmt.setString(3, "暂无");
			pstmt.setString(4, "暂无");
			pstmt.setString(5, "暂无");
			pstmt.setString(6, "暂无");
			pstmt.setString(7, "暂无");
			pstmt.setString(8, "暂无");
			pstmt.setInt(9, customer.getIsFreeze());
			pstmt.setInt(10, 0);
			pstmt.setDouble(11, 0.00);
			pstmt.setDouble(12, customer.getCustomerAccount());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String detailMsg = null;
			if (e.getMessage().indexOf("ORA-00001") != -1)
				detailMsg = "已存在相同的用户名!";
			throw new DataAccessException("用户信息增加失败," + detailMsg);

		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CustomerDao#getCustomerByName(java.lang.String)
	 */

	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Customer customer = null;

		try {
			pstmt = conn.prepareStatement(GET_CUS_BYNAME);
			pstmt.setString(1, name);

			rset = pstmt.executeQuery();

			while (rset.next()) {

				customer = new Customer();
				customer.setCustomerId(String.valueOf(rset.getInt("customer_id")));
				customer.setCustomerName(rset.getString("customer_name"));
				customer.setCustomerPassword(rset.getString("customer_password"));
				customer.setCustomerBirthday(rset.getString("customer_birthday"));
				customer.setCustomerAddress(rset.getString("customer_address"));
				customer.setCustomerMail(rset.getString("customer_mail"));
				customer.setCustomerRealname(rset.getString("customer_real_name"));
				customer.setCustomerPostCode(rset.getString("customer_postcode"));
				customer.setCustomerTel(rset.getString("customer_tel"));
				customer.setIsFreeze(rset.getInt("customer_freeze"));
				customer.setIsMember(rset.getInt("customer_member"));
				customer.setCustomerScore(rset.getDouble("customer_score"));
				customer.setCustomerAccount(rset.getDouble("customer_account"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("用户信息提取失败");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}

		return customer;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CustomerDao#updateCustomer(net.dfrz.supershop01.domain.Customer)
	 */

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(UPDATE_CUSTOMER);
			pstmt.setString(1, customer.getCustomerId());
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
			pstmt.setDouble(12, customer.getCustomerAccount());
			pstmt.setString(13, customer.getCustomerName());
		

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String detailMsg = null;
			if (e.getMessage().indexOf("ORA-00001") != -1)
				detailMsg = "商品名称出现了雷同!";
			throw new DataAccessException("用户信息修改失败," + detailMsg);

		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
	}
}
