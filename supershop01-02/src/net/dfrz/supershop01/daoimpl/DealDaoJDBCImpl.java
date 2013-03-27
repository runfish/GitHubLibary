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
import net.dfrz.supershop01.dao.DealDao;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.utils.DBUtils;
/**
 * Project: supershop01-02
 * ClassName: dealDaoJDBCImpl                                                        
 * Module ID: 4.6  
 * Comments: �����ݲ�Ϊ����������ṩ����ɾ�����޸ģ����ҵĹ���,dealDao��ʵ����  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-8
 *@see java.sql.Connection
 *@see java.sql.PreparedStatement
 *@see java.sql.ResultSet
 *@see java.sql.SQLException
 *@see java.util.ArrayList
 *@see java.util.List
 *@see org.apache.log4j.Logger
 *@see net.dfrz.supershop01.dao.DealDao
 *@see net.dfrz.supershop01.domain.Deal
 *@see net.dfrz.supershop01.exception.DataAccessException
 *@see net.dfrz.supershop01.servicesimpl.DealQuryHelper
 *@see net.dfrz.supershop01.utils.DBUtils
 *@see #DELETE_DEAL
 *@see #UPDATE_DEAL
 *@see #SEARCHDEAL_BYID
 *@see #LOADALL_DEAL
 *@see #LOGGER
 *@see #delete(Deal)
 *@see #update(Deal)
 *@see #getDealById(Integer)
 *@see #countDeal(DealQuryHelper)
 *@see #loadAll()
 *@see #loadPage(int, int, DealQuryHelper)
 *@see #buildSqlByHelper(DealQuryHelper)
 *@author J1205-HongHG
 *@version Version 5
 */
public class DealDaoJDBCImpl implements DealDao {

	/**
	 * ����SQLɾ�����
	 */
	private static final String DELETE_DEAL="delete from deal where deal_id=?";
	/**
	 * ����SQL�������
	 */
	private static final String UPDATE_DEAL="update deal set deal_customer_id=?,consignee_info=?,pay_pattern=?,receive_pattern=?,item_amount=?,deal_status=?,deal_date=?,deal_exam_date=?,is_accept=?,deal_sum=? where deal_id=?";
    /**
     * ���Ҷ�����Ϣ��SQL���
     */
    private static final String SEARCHDEAL_BYID="select*from deal where deal_id=?";
    /**
	 * ��ȡȫ��������Ŀ��Ϣ��SQL���
	 */
    private static final String LOADALL_DEAL="select*from deal order by item_id";
    /**
	 * ��־
	 */
    private static final Logger LOGGER=Logger.getLogger(DealDaoJDBCImpl.class);
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#delete(net.dfrz.supershop01.domain.Deal)
	 */
	public void delete(Deal deal) {
		// TODO Auto-generated method stub

		/**
		 * ��ȡ���ݿ�����
		 */
		LOGGER.info("��ʼ�������ݿ�...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("���ݿ����ӳɹ���");
		/**
		 * ׼�����ݿ�SQL���
		 */
		PreparedStatement pstmt=null;
		
		try 
		{
			LOGGER.info("��ʼɾ������...");
			pstmt=conn.prepareStatement(DELETE_DEAL);
			pstmt.setInt(1, deal.getDealId());
			pstmt.executeUpdate();
			LOGGER.info("����ɾ���ɹ���");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("������Ϣɾ��ʧ��!");
			throw new DataAccessException("������Ϣɾ��ʧ��!");
		}
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#update(net.dfrz.supershop01.domain.Deal)
	 */
	public void update(Deal deal) {
		// TODO Auto-generated method stub
		/**
		 * ��ȡ���ݿ�����
		 */
		LOGGER.info("��ʼ�������ݿ�...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("���ݿ����ӳɹ���");
		/**
		 * ׼�����ݿ�SQL���
		 */
		PreparedStatement pstmt=null;
		try
		{  
			LOGGER.info("��ʼ���¶���...");
			pstmt=conn.prepareStatement(UPDATE_DEAL);
			LOGGER.info("��ʼ���ö�����Ϣ...");
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
			LOGGER.info("����������ϣ�");
			pstmt.executeUpdate();
			LOGGER.info("���³ɹ���");
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("������Ϣ�޸�ʧ��!");
			throw new DataAccessException("������Ϣ�޸�ʧ��!");
		}
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#getDealById(java.lang.Integer)
	 */
	public Deal getDealById(Integer dealId) {
		// TODO Auto-generated method stub
		/**
		 * ��ȡ���ݿ�����
		 */
		LOGGER.info("��ʼ�������ݿ�...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("���ݿ����ӳɹ���");
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
		Deal deal=null;
		
		try 
		{
			LOGGER.info("���ݶ���id��Ѱ������");
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
	 * @see net.dfrz.supershop01.dao.dealDao#countDeal(net.dfrz.supershop01.servicesimpl.dealQuryHelper)
	 */
	public int countDeal(DealQuryHelper helper) {
		// TODO Auto-generated method stub
		
		String sql=this.buildSqlByHelper(helper);
		sql=sql.replace("*", "count(*) total");
		sql=sql.substring(0, sql.indexOf("order"));
		LOGGER.info("��ʼ�������ݿ�...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("���ݿ����ӳɹ���");
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
		 * ��ȡ���ݿ�����
		 */
		LOGGER.info("��ʼ�������ݿ�...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("���ݿ����ӳɹ���");
		/**
		 * ׼�����ݿ�SQL���
		 */
		PreparedStatement pstmt=null;
		/**
		 * ���ݿ��������ڴ��еĴ�Ŷ���
		 */
		ResultSet rset=null;
		/**
		 * ��Ŵ����ݿ��л�ȡ�Ķ��������ArrayList����
		 */
		ArrayList<Deal>dealList=new ArrayList<Deal>();
		/**
		 * ��װ������Ϣ�Ķ�������
		 */
		Deal deal=null;
		
		try 
		{
			pstmt=conn.prepareStatement(LOADALL_DEAL);
			
			rset=pstmt.executeQuery();
			LOGGER.info("��ʾ���ж�����Ϣ��");
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
	 * @see net.dfrz.supershop01.dao.dealDao#loadPage(java.lang.Integer, java.lang.Integer)
	 */
	public List<Deal> loadPage(int startIndex, int endIndex,
			DealQuryHelper helper) {
		// TODO Auto-generated method stub
		/**
		 * ��ȡ���ݿ�����
		 */
		LOGGER.info("��ʼ�������ݿ�...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("���ݿ����ӳɹ���");
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
		String sql="select * from ( select rownum rn,a.* from ( "+ this.buildSqlByHelper(helper)+" ) a where rownum<=? ) where rn>=?";
		/**
		 * ��Ŵ����ݿ��л�ȡ�Ķ�����Ŀ�����ArrayList����
		 */
		ArrayList<Deal>dealList=new ArrayList<Deal>();
		/**
		 * ��װ������Ϣ�Ķ�������
		 */
		Deal deal=null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,endIndex);
			pstmt.setInt(2,startIndex);
			
			rset=pstmt.executeQuery();
			LOGGER.info("��ʾ���ж�����Ϣ��");
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
	 * ��Ʒ������ϲ�ѯ��SQL���������
	 * @param helper -��Ʒ������ϲ�ѯ���������ķ�װ����
	 * @return String
	 */
	private String buildSqlByHelper(DealQuryHelper helper){
			
			String sql="select * from deal where 1=1";
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
}
