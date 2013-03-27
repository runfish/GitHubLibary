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
import net.dfrz.supershop01.dao.GoodsDao;
import net.dfrz.supershop01.dao.SmallCategoryDao;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.utils.DBUtils;

/**
 * Project: supershop01-01 ClassName: SmallCategoryDaoJDBCImpl Module ID: 4.6
 * Comments: 在数据层为小类别类对象提供数据查询,SmallCategoryDao的实现类 JDK :jdk1.6.0_10 Create
 * Date： 2013-3-1
 * 
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see java.util.ArrayList
 * @see java.util.List
 * @see net.dfrz.supershop01.dao.CategoryDao
 * @see net.dfrz.supershop01.dao.GoodsDao
 * @see net.dfrz.supershop01.dao.SmallCategoryDao
 * @see net.dfrz.supershop01.domain.SmallCategory
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see# ListOraderItem()
 * @see# getOne(int)
 * @see# getSmallCtgByBigCtgId(int)
 * @author YDP and YHQ
 * @version Version 5
 */
public class SmallCategoryDaoJDBCImpl implements SmallCategoryDao {

	/**
	 * 获取所有子类别信息的SQL语句
	 */
	private final static String LOAD_ALL = "select * from small_category";

	/**
	 * 根据子类别的ID获取子类别的信息的SQL语句
	 */
	private final static String GET_ONE = "select * from small_category where s_ctg_id=?";

	/**
	 * 根据大类别的ID获取子类的所有信息的SQL语句
	 * 
	 */
	private final static String GET_SMALLCTG_BY_BIGCTGID = "select * from small_category where b_ctg_id =?";

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.gdm.dao.SmallCategoryDao#ListOraderItem()
	 */
	public List<SmallCategory> ListOraderItem() {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rest = null;
		/**
		 * 存放从数据库中获取的子类别对象存进ArrayList集合中
		 */
		List<SmallCategory> smallcategorylist = null;

		try {
			pstmt = conn.prepareStatement(LOAD_ALL);
			rest = pstmt.executeQuery();
			// 小游同志 记得要new
			smallcategorylist = new ArrayList<SmallCategory>();
			CategoryDao bigcatdao = new CategoryDaoJDBCImpl();
			GoodsDao goodsdao = new GoodsDaoJDBCImpl();
			while (rest.next()) {
				SmallCategory samllcategory = new SmallCategory();
				samllcategory.setSmallCtgId(rest.getInt("s_ctg_id"));
				samllcategory.setSmallCtgName(rest.getString("s_ctg_name"));
				samllcategory.setSmallCtgStatus(rest.getString("s_ctg_status"));
				samllcategory.setBigCategory(bigcatdao.getCtgById(rest
						.getInt("b_ctg_id")));
				smallcategorylist.add(samllcategory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("获取所有子类别信息失败");
		}
		return smallcategorylist;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.gdm.dao.SmallCategoryDao#getOne(int)
	 */
	public SmallCategory getOne(int id) {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rest = null;
		/**
		 * 存放从数据库中获取的子类别对象存进SmallCategory实例中
		 */
		SmallCategory smallCategory = null;
		CategoryDao bigcatdao = new CategoryDaoJDBCImpl();
		GoodsDao goodsdao = new GoodsDaoJDBCImpl();
		try {
			pstmt = conn.prepareStatement(GET_ONE);
			pstmt.setInt(1, id);
			rest = pstmt.executeQuery();

			while (rest.next()) {
				smallCategory = new SmallCategory();
				smallCategory.setSmallCtgId(rest.getInt("s_ctg_id"));
				smallCategory.setSmallCtgName(rest.getString("s_ctg_name"));
				smallCategory.setSmallCtgStatus(rest.getString("s_ctg_status"));
				smallCategory.setBigCategory(bigcatdao.getCtgById(rest
						.getInt("b_ctg_id")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("根据子类别的id获取子类别信息失败");
		}
		return smallCategory;
	}

	public List<SmallCategory> getSmallCtgByBigCtgId(int bigCtgId) {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rest = null;
		/**
		 * 存放从数据库中获取的子类别对象存进ArrayList集合中
		 */
		SmallCategory smallCategory = null;
		List<SmallCategory> smallCtgList = new ArrayList<SmallCategory>();
		try {
			pstmt = conn.prepareStatement(GET_SMALLCTG_BY_BIGCTGID);
			pstmt.setInt(1, bigCtgId);
			rest = pstmt.executeQuery();

			while (rest.next()) {
				smallCategory = new SmallCategory();
				smallCategory.setSmallCtgId(rest.getInt("s_ctg_id"));
				smallCategory.setSmallCtgName(rest.getString("s_ctg_name"));
				smallCategory.setSmallCtgStatus(rest.getString("s_ctg_status"));
				smallCtgList.add(smallCategory);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("根据大类别id获取子类别信息失败");
		}
		return smallCtgList;
	}
}
