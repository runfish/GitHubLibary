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
import net.dfrz.supershop01.dao.CategoryDao;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.utils.DBUtils;

/**
 * Project: supershop01-01
 * ClassName: CategoryDaoJDBCImpl                                                        
 * Module ID: 4.6  
 * Comments: �����ݲ�Ϊ���������ṩ���ݲ�ѯ,CategoryDao��ʵ����  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-3-1
 * @see java.sql.Connection
 * @see  java.sql.PreparedStatement
 * @see  java.sql.ResultSet
 * @see  java.sql.SQLException
 * @see  java.util.ArrayList
 * @see  java.util.List
 * @see  net.dfrz.supershop01.dao.CategoryDao
 * @see  net.dfrz.supershop01.domain.Category
 * @see  net.dfrz.supershop01.exception.DataAccessException
 * @see  net.dfrz.supershop01.utils.DBUtils
 * @see #getCtgById(int)
 * @see #loadAll()
 *@author YDP and YHQ
 *@version Version 5
 */
public class CategoryDaoJDBCImpl implements CategoryDao {

	/**
	 * ��ȡ���д������Ϣ��SQL���
	 */
	private static final String LOADALL_CTG = "select * from big_category order by b_ctg_id desc";

	/**
	 * ���ݴ�����ID��ȡ��������Ϣ��SQL���
	 * 
	 */
	private static final String LOAD_CTG_BYID = "select * from big_category where b_ctg_id=?";

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CategoryDao#getCtgById(int)
	 */
	public Category getCtgById(int ctgId) {
		// TODO Auto-generated method stub

		/**
		 * ��ȡ���ݿ�����
		 */
		Connection conn = DBUtils.getInstance().getConn();
		/**
		 * ׼�����ݿ�SQL���
		 */
		PreparedStatement pstmt = null;
		/**
		 * ���ݿ��������ڴ��еĴ�Ŷ���
		 */
		ResultSet rset = null;
		/**
		 * ��Ŵ����ݿ��л�ȡ����������Categoryʵ����
		 */
		Category ctg = null;

		try {

			pstmt = conn.prepareStatement(LOAD_CTG_BYID);

			pstmt.setInt(1, ctgId);

			System.out.print(LOAD_CTG_BYID + ctgId);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				ctg = new Category();

				ctg.setCtgId(ctgId);

				ctg.setCtgName(rset.getString("b_ctg_name"));

				ctg.setCtgStatus(rset.getString("b_ctg_status"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("���ݴ����Id��ȡ�������Ϣʧ��");
		} finally {

			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		return ctg;

	}

	public List<Category> loadAll() {
		// TODO Auto-generated method stub

		/**
		 * ��ȡ���ݿ�����
		 */
		Connection conn = DBUtils.getInstance().getConn();
		/**
		 * ׼�����ݿ�SQL���
		 */
		PreparedStatement pstmt = null;
		/**
		 * ���ݿ��������ڴ��еĴ�Ŷ���
		 */
		ResultSet rset = null;
		/**
		 * ��Ŵ����ݿ��л�ȡ���������ArrayList����
		 */
		List<Category> ctgList = null;

		try {

			pstmt = conn.prepareStatement(LOADALL_CTG);

			rset = pstmt.executeQuery();

			ctgList = new ArrayList<Category>();

			while (rset.next()) {

				Category ctg = new Category();

				ctg.setCtgId(rset.getInt("b_ctg_id"));

				ctg.setCtgName(rset.getString("b_ctg_name"));

				ctg.setCtgStatus(rset.getString("b_ctg_status"));

				ctgList.add(ctg);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("��ȡ���д������Ϣʧ��");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}

		return ctgList;
	}

}
