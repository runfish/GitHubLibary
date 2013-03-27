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
import net.dfrz.supershop01.dao.CategoryDao;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;
import net.dfrz.supershop01.utils.DBUtils;

/**
 * Project: supershop01-02 ClassName: CategoryDaoJDBCImpl Module ID: 4.6
 * Comments: ��CategoryDao��ʵ���� JDK :jdk1.6.0_10 Create Date�� 2013-1-9
 * 
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see java.util.ArrayList
 * @see java.util.List
 * @see org.apache.log4j.Logger
 * @see net.dfrz.supershop01.dao.CategoryDao
 * @see net.dfrz.supershop01.domain.Category
 * @see net.dfrz.supershop01.domain.Goods
 * @see net.dfrz.supershop01.domain.SmallCategory 
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see net.dfrz.supershop01.servicesimpl.CategoryQueryHelper
 * @see net.dfrz.supershop01.servicesimpl.GoodsQueryHelper
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see #ADD_CTG
 * @see #DELETE_CTG
 * @see #LOADALL_CTG
 * @see #UPDATE_CTG
 * @see #LOGGER
 * @see #LOAD_CTG_BYID
 * @see #add(ctg)
 * @see #countCategory(CategoryQueryHelper)
 * @see #delete(Integer)
 * @see #getCtgById(Integer)
 * @see #loadPageAll(CategoryQueryHelper, int, int)
 * @see #loadAll()
 * @see #update(ctg)
 * @see #buildSqlByHelper(CategoryQueryHelper)
 * @author J1205-YouHQ
 * @version Version 5
 */
public class CategoryDaoJDBCImpl implements CategoryDao {

	/**
	 * ��־����
	 */
	private static final Logger LOGGER = Logger
			.getLogger(CategoryDaoJDBCImpl.class);
	/**
	 * �����ݲ�������Ʒ�����Ϣ��SQL���
	 */
	private final static String ADD_CTG = "insert into big_category values(?,?,?)";
	/**
	 * �����ݲ������Ʒ����IDɾ������Ʒ��SQL���
	 */
	private static final String DELETE_CTG = "delete from big_category where b_ctg_id=?";
	/**
	 * �����ݲ��ȡ������Ʒ�����Ϣ��SQL���
	 */
	private static final String LOADALL_CTG = "select * from big_category order by b_ctg_id desc";
	/**
	 * �����ݲ������Ʒ�����Ϣ��SQl���
	 */
	private static final String UPDATE_CTG = "update big_category set "
			+ "b_ctg_name=?" + ",b_ctg_status=?" + " where b_ctg_id=?";
	/**
	 * �����ݲ��ȡ������Ʒ�����Ϣ������ID�����SQL���
	 */
	private static final String LOAD_CTG_BYID = "select * from big_category where b_ctg_id=?";

	public void add(Category ctg) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;

		try {
			LOGGER.info("��ʼ����category���󣬶�����Ϣ���£�");
			pstmt = conn.prepareStatement(ADD_CTG);
			pstmt.setInt(1, ctg.getCtgId());
			pstmt.setString(2, ctg.getCtgName());
			pstmt.setString(3, ctg.getCtgStatus());
			pstmt.executeUpdate();

			LOGGER.debug("PSTMT�����������!");
			conn.commit();
			LOGGER.info("���󱣴�ɹ���");
		} catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();
			String detailMsg = null;

			if (e.getMessage().indexOf("ORA-00001") != -1)
				detailMsg = "������Ƴ�������ͬ!";

			throw new DataAccessException("�����Ϣ����ʧ��," + detailMsg);
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.dfrz.supershop01.dao.CategoryDao#delete(net.dfrz.supershop01.domain.Category)
	 */
	public void delete(int ctgId) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;

		try {
			LOGGER.info("��ʼ����ctgIdɾ�����");
			pstmt = conn.prepareStatement(DELETE_CTG);
			pstmt.setInt(1, ctgId);
			pstmt.executeUpdate();
			LOGGER.info("ɾ�����������ϣ�");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("�����Ϣɾ��ʧ�ܣ�");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.dfrz.supershop01.dao.CategoryDao#getCtgById(int)
	 */
	public Category getCtgById(int ctgId) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Category ctg = null;

		try {

			pstmt = conn.prepareStatement(LOAD_CTG_BYID);
			pstmt.setInt(1, ctgId);

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
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		return ctg;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.dfrz.supershop01.dao.CategoryDao#update(net.dfrz.supershop01.domain.Category)
	 */
	public void update(Category ctg) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;

		try {
			LOGGER.info("��ʼ����category���󣬶�����Ϣ���£�");
			pstmt = conn.prepareStatement(UPDATE_CTG);

			pstmt.setString(1, ctg.getCtgName());
			pstmt.setString(2, ctg.getCtgStatus());
			pstmt.setInt(3, ctg.getCtgId());
			pstmt.executeUpdate();
			conn.commit();
			LOGGER.info("������ϣ�");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("�����Ϣ�޸�ʧ��!");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}

	}

	public List<Category> loadAll() {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Category> ctgList = null;

		try {
			LOGGER.info("��ʼ��ʾ���д����");
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
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}

		return ctgList;
	}

	public int countCategory(CategoryQueryHelper helper) {
		// TODO Auto-generated method stub
		String sql = this.buildSqlByHelper(helper);
		sql = sql
				.replace(
						"big_category.b_ctg_id,big_category.b_ctg_name,small_category.s_ctg_name,small_category.s_ctg_id",
						"count(*) total");

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Integer total = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				total = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}

		return total;
	}

	public List<SmallCategory> loadPageAll(CategoryQueryHelper helper,
			int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SmallCategory> categoryList = null;

		try {
			LOGGER.info("��ʼ��ʾ���еķ�ҳ������!");
			categoryList = new ArrayList<SmallCategory>();

			String sql = "select * from ( select rownum rn,a.* from ( "
					+ this.buildSqlByHelper(helper)
					+ " ) a where rownum<=? ) where rn>=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endIndex);
			pstmt.setInt(2, beginIndex);
			rset = pstmt.executeQuery();

			while (rset.next()) {

				Category category = new Category();
				SmallCategory smallCategory = new SmallCategory();

				category.setCtgId(rset.getInt("b_ctg_id"));
				category.setCtgName(rset.getString("b_ctg_name"));
				smallCategory.setBigCategory(category);
				smallCategory.setSmallCtgId(rset.getInt("s_ctg_id"));
				smallCategory.setSmallCtgName(rset.getString("s_ctg_name"));

				categoryList.add(smallCategory);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		LOGGER.info("�������ʾ��ϣ�");
		return categoryList;

	}

	private String buildSqlByHelper(CategoryQueryHelper helper) {

		String sql = "select big_category.b_ctg_id,big_category.b_ctg_name,small_category.s_ctg_name,small_category.s_ctg_id from big_category,small_category where big_category.b_ctg_id = small_category.b_ctg_id";

		if (helper.getSmallCategoryName() != null
				&& helper.getSmallCategoryName().trim().length() > 0) {
			sql += " and small_category.s_ctg_name like '%"
					+ helper.getSmallCategoryName() + "%'";
		}
		if (helper.getBigCategoryId() != null) {
			sql += " and big_category.b_ctg_id=" + helper.getBigCategoryId();
		}
		sql += " order by big_category.b_ctg_id";

		return sql;

	}

}
