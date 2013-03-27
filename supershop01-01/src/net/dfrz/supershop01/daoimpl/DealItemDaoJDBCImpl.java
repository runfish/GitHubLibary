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
 * Comments: �����ݲ�Ϊ����������ṩ����ɾ�����޸ģ���ҳ��ʾ�Ĺ���,dealDao��ʵ����  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-2-1
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
	 * ������ĿSQLɾ�����  
	 */
	private static final String DELETE_ITEM="delete from deal_item where item_id=?";
	/**
	 * ���������ж�����ĿSQLɾ�����  
	 */
	private static final String DELETE_All_BY_DEALID="delete from deal_item where deal_id=?";
	/**
	 * ������ĿSQL�������     
	 */
	private static final String UPDATE_ITEM="update deal_item set item_goods_qty=?,item_goods_price=?,goods_id=?" +
			",goods_ctg_id=?,deal_id=?,admin_id=? where item_id=?";
    /**
     * ���Ҷ�����Ŀ��Ϣ��SQL���
     */
    private static final String SEARCHITEM_BYID="select*from deal_item where item_id=?";
    /* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealItemDao#add(net.dfrz.supershop01.domain.DealItem)
	 */
    public void add(DealItem dealItem) {
		// TODO Auto-generated method stub
    	/**
		 * ��ȡ���ݿ�����
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * ׼�����ݿ�SQL���
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
			throw new DataAccessException("���Ӷ�����Ŀ��Ϣʧ��!");
		}
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealItemDao#delete(net.dfrz.supershop01.domain.DealItem)
	 */
	public void delete(DealItem dealItem) {
		// TODO Auto-generated method stub

		/**
		 * ��ȡ���ݿ�����
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * ׼�����ݿ�SQL���
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
			throw new DataAccessException("������Ŀ��Ϣɾ��ʧ��!");
		}
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealItemDao#loadPage(java.lang.Integer,java.lang.Integer)
	 */
	public List<DealItem> loadPage(int startIndex,int endIndex,int dealId) {
		// TODO Auto-generated method stub
		/**
		 * ��ȡ���ݿ�����
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * ׼�����ݿ�SQL���
		 */
		PreparedStatement pstmt=null;
		/**
		 * ���ݿ��������ڴ��еĴ�Ŷ���
		 */
		ResultSet rset=null;
		/**
		 * ��ҳ��ѯSQL���
		 */
		String sql="select * from ( select rownum rn,a.* from ( "+ this.buildSqlByHelper(dealId)+" ) a where rownum<=? ) where rn>=?";
		/**
		 * ��Ŵ����ݿ��л�ȡ�Ķ�����Ŀ�����ArrayList����
		 */
		ArrayList<DealItem>dealItemList=new ArrayList<DealItem>();
		/**
		 * ��װ������Ŀ��Ϣ�Ķ�������
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
		 * ��ȡ���ݿ�����
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * ׼�����ݿ�SQL���
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
			throw new DataAccessException("������Ϣ�޸�ʧ��!");
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
	 * ��Ʒ������Ŀ��Ϣ��ѯ��SQL���������
	 * @param dealId -��Ҫ��ѯ�Ķ�����Ŀ��Ϣ����Ӧ�Ķ������
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
		 * ��ȡ���ݿ�����
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * ׼�����ݿ�SQL���
		 */
		PreparedStatement pstmt=null;
		/**
		 * ���ݿ��������ڴ��еĴ�Ŷ���
		 */
		ResultSet rset=null;
		/**
		 * ��װ������Ϣ�Ķ�������
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
		 * ��ȡ���ݿ�����
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * ׼�����ݿ�SQL���
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
			throw new DataAccessException("������Ϣɾ��ʧ��!");
		}
	
	}
}
