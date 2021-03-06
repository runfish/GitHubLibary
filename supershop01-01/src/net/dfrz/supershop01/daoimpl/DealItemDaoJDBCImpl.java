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
import net.dfrz.supershop01.dao.DealItemDao;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.utils.DBUtils;

/**
 * Project: supershop01-01
 * ClassName: dealDaoJDBCImpl                                                        
 * Module ID: 4.6  
 * Comments: 在数据层为订单类对象提供数据删除，修改，分页显示的功能,dealDao的实现类  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-2-1
 * @see import java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see java.util.ArrayList
 * @see java.util.List
 * @see net.dfrz.supershop01.dao.DealItemDao
 * @see  net.dfrz.supershop01.domain.DealItem
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see net.dfrz.supershop01.utils.DBUtils
 *@author J1205-HongHG
 *@version Version 5
 */
public class DealItemDaoJDBCImpl implements DealItemDao {

	private static final String ADD_ITEM="insert into deal_item values(seq_dealItem.nextval,?,?,?,?,?,?)";
	/**
	 * 订单条目SQL删除语句  
	 */
	private static final String DELETE_ITEM="delete from deal_item where item_id=?";
	/**
	 * 订单下所有订单条目SQL删除语句  
	 */
	private static final String DELETE_All_BY_DEALID="delete from deal_item where deal_id=?";
	/**
	 * 订单条目SQL更新语句     
	 */
	private static final String UPDATE_ITEM="update deal_item set item_goods_qty=?,item_goods_price=?,goods_id=?" +
			",goods_ctg_id=?,deal_id=?,admin_id=? where item_id=?";
    /**
     * 查找订单条目信息的SQL语句
     */
    private static final String SEARCHITEM_BYID="select*from deal_item where item_id=?";
    /* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealItemDao#add(net.dfrz.supershop01.domain.DealItem)
	 */
    public void add(DealItem dealItem) {
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
			pstmt=conn.prepareStatement(ADD_ITEM);
            
			pstmt.setInt(1,dealItem.getItemGoodsQty());
			pstmt.setDouble(2, dealItem.getItemGoodsPrice());
			pstmt.setInt(3, dealItem.getDealGoodsId());
			pstmt.setInt(4,dealItem.getDealGoodsCtgId());
			pstmt.setInt(5, dealItem.getDealId());
			pstmt.setInt(6, dealItem.getDealAdminId());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("增加订单条目信息失败!");
		}
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealItemDao#delete(net.dfrz.supershop01.domain.DealItem)
	 */
	public void delete(DealItem dealItem) {
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
			pstmt=conn.prepareStatement(DELETE_ITEM);
			pstmt.setInt(1, dealItem.getItemId());
			pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("订单条目信息删除失败!");
		}
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealItemDao#loadPage(java.lang.Integer,java.lang.Integer)
	 */
	public List<DealItem> loadPage(int startIndex,int endIndex,int dealId) {
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
		String sql="select * from ( select rownum rn,a.* from ( "+ this.buildSqlByHelper(dealId)+" ) a where rownum<=? ) where rn>=?";
		/**
		 * 存放从数据库中获取的订单条目对象的ArrayList数组
		 */
		ArrayList<DealItem>dealItemList=new ArrayList<DealItem>();
		/**
		 * 封装订单条目信息的订单对象
		 */
		DealItem dealItem=null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,endIndex);
			pstmt.setInt(2,startIndex);
			
			rset=pstmt.executeQuery();
			
			while(rset.next())
			{
				dealItem=new DealItem();
				dealItem.setItemId(rset.getInt("item_id"));
				dealItem.setItemGoodsQty(rset.getInt("item_goods_qty"));
				dealItem.setItemGoodsPrice(rset.getDouble("item_goods_price"));
				dealItem.setDealGoodsId(rset.getInt("goods_id"));
				dealItem.setDealGoodsCtgId(rset.getInt("goods_ctg_id"));
				dealItem.setDealId(rset.getInt("deal_id"));
				dealItem.setDealAdminId(rset.getInt("admin_id"));
				
				dealItemList.add(dealItem);
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dealItemList;
	}
 

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealItemDao#update(net.dfrz.supershop01.domain.DealItem)
	 */
	public void update(DealItem dealItem) {
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
			pstmt=conn.prepareStatement(UPDATE_ITEM);

			pstmt.setInt(1,dealItem.getItemGoodsQty());
			pstmt.setDouble(2, dealItem.getItemGoodsPrice());
			pstmt.setInt(3, dealItem.getDealGoodsId());
			pstmt.setInt(4,dealItem.getDealGoodsCtgId());
			pstmt.setInt(5, dealItem.getDealId());
			pstmt.setInt(6, dealItem.getDealAdminId());
			pstmt.setInt(7, dealItem.getItemId());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("订单信息修改失败!");
		}
	}
	
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealItemDao#countDealItem(java.lang.Integer)
	 */
	public int countDealItem(int dealId) {
			
			String sql=this.buildSqlByHelper(dealId);
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
	/**
	 * 商品订单条目信息查询的SQL语句生成器
	 * @param dealId -所要查询的订单条目信息所对应的订单编号
	 * @return String
	 */
	private String buildSqlByHelper(int dealId){
			
			String sql="select * from deal_item where 1=1";
			
			sql+=" and deal_id="+dealId;
			
			sql+=" order by item_id";
	
			return sql;
			
		}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealItemDao#getDealItemById(java.lang.Integer)
	 */
	public DealItem getDealItemById(Integer dealId) {
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
		DealItem dealItem=null;
		
		try 
		{
			pstmt=conn.prepareStatement(SEARCHITEM_BYID);
			pstmt.setInt(1, dealId);
			
			rset=pstmt.executeQuery();
			
			while(rset.next())
			{
				dealItem=new DealItem();
				dealItem.setItemId(rset.getInt("item_id"));
				dealItem.setItemGoodsQty(rset.getInt("item_goods_qty"));
				dealItem.setItemGoodsPrice(rset.getDouble("item_goods_price"));
				dealItem.setDealGoodsId(rset.getInt("goods_id"));
				dealItem.setDealGoodsCtgId(rset.getInt("goods_ctg_id"));
				dealItem.setDealId(rset.getInt("deal_id"));
				dealItem.setDealAdminId(rset.getInt("admin_id"));
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dealItem;
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealItemDao#deleteDealItemByDealId(java.lang.Integer)
	 */
	public void deleteDealItemByDealId(Integer dealId) {
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
			pstmt=conn.prepareStatement(DELETE_All_BY_DEALID);
			pstmt.setInt(1, dealId);
			pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("订单信息删除失败!");
		}
	
	}
}
