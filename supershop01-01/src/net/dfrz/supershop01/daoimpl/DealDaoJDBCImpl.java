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
import net.dfrz.supershop01.dao.DealDao;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.utils.DBUtils;
/**
 * Project: supershop01-01
 * ClassName: dealDaoJDBCImpl                                                        
 * Module ID: 4.6  
 * Comments: 在数据层为订单类对象提供数据删除，修改，查找的功能,dealDao的实现类  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-8
 *@see java.sql.Connection
 *@see java.sql.PreparedStatement
 *@see java.sql.ResultSet
 *@see java.sql.SQLException
 *@see java.util.ArrayList
 *@see java.util.List
 *@see net.dfrz.supershop01.dao.DealDao
 *@see net.dfrz.supershop01.domain.Deal
 *@see net.dfrz.supershop01.exception.DataAccessException
 *@see net.dfrz.supershop01.servicesimpl.DealQuryHelper
 *@see net.dfrz.supershop01.utils.DBUtils
 *@see #ADD_DEAL
 *@see #update(Deal)
 *@see #DELETE_DEAL
 *@see #SEARCHDEAL_BYID
 *@see #LOADALL_DEAL
 *@see #add(Deal)
 *@see #delete(Deal)
 *@see #update(Deal)
 *@see #getDealById(Integer)
 *@see #getMaxDealId(DealQuryHelper)
 *@see #loadAll()
 *@see #loadPage(int, int, DealQuryHelper)
 *@author J1205-HongHG
 *@version Version 5
 */
public class DealDaoJDBCImpl implements DealDao {

	private static final String ADD_DEAL="insert into deal values(?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 * 订单SQL删除语句
	 */
	private static final String DELETE_DEAL="delete from deal where deal_id=?";
	/**
	 * 订单SQL更新语句
	 */
	private static final String UPDATE_DEAL="update deal set deal_customer_id=?,consignee_info=?,pay_pattern=?,receive_pattern=?,item_amount=?,deal_status=?,deal_date=?,deal_exam_date=?,is_accept=?,deal_sum=? where deal_id=?";
    /**
     * 查找订单信息的SQL语句
     */
    private static final String SEARCHDEAL_BYID="select*from deal where deal_id=?";
    /**
	 * 获取全部订单条目信息的SQL语句
	 */
    private static final String LOADALL_DEAL="select*from deal order by item_id";
    /* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#add(net.dfrz.supershop01.domain.Deal)
	 */
    public void add(Deal deal) {
		// TODO Auto-generated method stub
    	/**
		 * 获取数据库连接
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt=null;
		try
		{  
			pstmt=conn.prepareStatement(ADD_DEAL);
		   
			pstmt.setInt(1, deal.getDealId());
			pstmt.setInt(2, deal.getDealCustomerId());
			pstmt.setString(3,deal.getConsigneeInfo());
			pstmt.setString(4, deal.getPayPattern());
			pstmt.setString(5, deal.getReceivePattern());
			pstmt.setInt(6, 0);
			pstmt.setString(7, deal.getDealStatus());
			pstmt.setDate(8, deal.getDealDate());
			pstmt.setDate(9, deal.getDealExamDate());
			pstmt.setInt(10, deal.getIsAccept());
			pstmt.setDouble(11, 0.00);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("增加订单信息失败!");
		}
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#delete(net.dfrz.supershop01.domain.Deal)
	 */
	public void delete(Deal deal) {
		// TODO Auto-generated method stub

		/**
		 * 获取数据库连接
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt=null;
		
		try 
		{
			pstmt=conn.prepareStatement(DELETE_DEAL);
			pstmt.setInt(1, deal.getDealId());
			pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("订单信息删除失败!");
		}
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#update(net.dfrz.supershop01.domain.Deal)
	 */
	public void update(Deal deal) {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt=null;
		try
		{  
			pstmt=conn.prepareStatement(UPDATE_DEAL);
		   
			pstmt.setInt(1, deal.getDealCustomerId());
			pstmt.setString(2,deal.getConsigneeInfo());
			pstmt.setString(3, deal.getPayPattern());
			pstmt.setString(4, deal.getReceivePattern());
			pstmt.setInt(5, deal.getItemAmount());
			pstmt.setString(6, deal.getDealStatus());
			pstmt.setDate(7, deal.getDealDate());
			pstmt.setDate(8, deal.getDealExamDate());
			pstmt.setInt(9, deal.getIsAccept());
			pstmt.setDouble(10, deal.getDealSum());
			pstmt.setInt(11, deal.getDealId());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("订单信息修改失败!");
		}
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#getDealById(java.lang.Integer)
	 */
	public Deal getDealById(Integer dealId) {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt=null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset=null;
		/**
		 * 封装订单信息的订单对象
		 */
		Deal deal=null;
		
		try 
		{
			pstmt=conn.prepareStatement(SEARCHDEAL_BYID);
			pstmt.setInt(1, dealId);
			
			rset=pstmt.executeQuery();
			
			while(rset.next())
			{
				deal=new Deal();
				deal.setDealId(rset.getInt("deal_id"));
				deal.setDealCustomerId(rset.getInt("deal_customer_id"));
				deal.setConsigneeInfo(rset.getString("consignee_info"));
				deal.setPayPattern(rset.getString("pay_pattern"));
				deal.setReceivePattern(rset.getString("receive_pattern"));
				deal.setItemAmount(rset.getInt("item_amount"));
				deal.setDealStatus(rset.getString("deal_status"));
				deal.setDealDate(rset.getDate("deal_date"));
				deal.setDealExamDate(rset.getDate("deal_exam_date"));
				deal.setIsAccept(rset.getInt("is_accept"));
				deal.setDealSum(rset.getDouble("deal_sum"));
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deal;
	}
	 /* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#countDeal(net.dfrz.supershop01.servicesimpl.DealQuryHelper)
	 */
	public int countDeal(DealQuryHelper helper) {
		// TODO Auto-generated method stub
		
		String sql=this.buildSqlByHelper(helper);
		sql=sql.replace("*", "count(*) total");
		sql=sql.substring(0, sql.indexOf("order"));
		Connection conn=DBUtils.getInstance().getConn();
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
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}	
		
		return total;
	}
	 /* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#loadAll()
	 */
	public List<Deal> loadAll() {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt=null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset=null;
		/**
		 * 存放从数据库中获取的订单对象的ArrayList数组
		 */
		ArrayList<Deal>dealList=new ArrayList<Deal>();
		/**
		 * 封装订单信息的订单对象
		 */
		Deal deal=null;
		
		try 
		{
			pstmt=conn.prepareStatement(LOADALL_DEAL);
			
			rset=pstmt.executeQuery();
			
			while(rset.next())
			{
				deal=new Deal();
				deal.setDealId(rset.getInt("deal_id"));
				deal.setDealCustomerId(rset.getInt("deal_customer_id"));
				deal.setConsigneeInfo(rset.getString("consignee_info"));
				deal.setPayPattern(rset.getString("pay_pattern"));
				deal.setReceivePattern(rset.getString("receive_pattern"));
				deal.setItemAmount(rset.getInt("item_amount"));
				deal.setDealStatus(rset.getString("deal_status"));
				deal.setDealDate(rset.getDate("deal_date"));
				deal.setDealExamDate(rset.getDate("deal_exam_date"));
				deal.setIsAccept(rset.getInt("is_accept"));
				deal.setDealSum(rset.getDouble("deal_sum"));
				
				dealList.add(deal);
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dealList;
	}
	 /* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#loadPage(java.lang.Integer ,java.lang.Integer ,net.dfrz.supershop01.servicesimpl.DealQuryHelper)
	 */
	public List<Deal> loadPage(int startIndex, int endIndex,
			DealQuryHelper helper) {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt=null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset=null;
		/**
		 * 分页查询SQL语句
		 */
		String sql="select * from ( select rownum rn,a.* from ( "+ this.buildSqlByHelper(helper)+" ) a where rownum<=? ) where rn>=?";
		/**
		 * 存放从数据库中获取的订单条目对象的ArrayList数组
		 */
		ArrayList<Deal>dealList=new ArrayList<Deal>();
		/**
		 * 封装订单信息的订单对象
		 */
		Deal deal=null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,endIndex);
			pstmt.setInt(2,startIndex);
			
			rset=pstmt.executeQuery();
			
			while(rset.next())
			{
				deal=new Deal();
				deal.setDealId(rset.getInt("deal_id"));
				deal.setDealCustomerId(rset.getInt("deal_customer_id"));
				deal.setConsigneeInfo(rset.getString("consignee_info"));
				deal.setPayPattern(rset.getString("pay_pattern"));
				deal.setReceivePattern(rset.getString("receive_pattern"));
				deal.setItemAmount(rset.getInt("item_amount"));
				deal.setDealStatus(rset.getString("deal_status"));
				deal.setDealDate(rset.getDate("deal_date"));
				deal.setDealExamDate(rset.getDate("deal_exam_date"));
				deal.setIsAccept(rset.getInt("is_accept"));
				deal.setDealSum(rset.getDouble("deal_sum"));
				dealList.add(deal);
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dealList;
	}
	/**
	 * 商品订单组合查询的SQL语句生成器
	 * @param helper -商品订单组合查询语句的条件的封装对象
	 * @return String
	 */
	private String buildSqlByHelper(DealQuryHelper helper){
			
			String sql="select * from deal where 1=1";
			
			if(helper.getDealCustomerId()!=null)
			{
				sql+=" and deal_customer_id="+helper.getDealCustomerId();
			}
			if(helper.getDealId()!=null)
			{
				sql+=" and deal_id="+helper.getDealId();
			}
			if(helper.getDealStatus()!=null&&helper.getDealStatus().length()>0)
			{
				sql+=" and deal_status='"+helper.getDealStatus()+"'";
			}
			if(helper.getDealDate()!=null&&helper.getDealDate().length()>0)
			{
				sql+=" and deal_date>=to_date('"+helper.getDealDate()+"','yyyy-mm-dd')";
			}
			if(helper.getIsAccept()!=null&&helper.getIsAccept()!=-1)
			{
				sql+=" and is_accept="+helper.getIsAccept();
			}

			sql+=" order by deal_id";
	
			return sql;
		}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#getMaxDealId(net.dfrz.supershop01.servicesimpl.DealQuryHelper)
	 */
	public int getMaxDealId(DealQuryHelper helper) {
		// TODO Auto-generated method stub
		String sql=this.buildSqlByHelper(helper);
		sql=sql.replace("*", "max(deal_id) maxid");
		sql=sql.substring(0, sql.indexOf("order"));
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Integer maxId=0;
		
		try{
		   pstmt=conn.prepareStatement(sql);
		   rset=pstmt.executeQuery();
		   
		   if(rset.next()){
			   
			  maxId=rset.getInt("maxid"); 
		   }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}	
		
		return maxId;
	}
}
