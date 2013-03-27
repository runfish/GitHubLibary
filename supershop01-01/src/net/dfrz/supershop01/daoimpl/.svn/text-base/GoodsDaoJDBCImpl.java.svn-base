/**
 * 
 */
package net.dfrz.supershop01.daoimpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.dfrz.supershop01.dao.GoodsDao;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;
import net.dfrz.supershop01.utils.DBUtils;

/**
 * Project: supershop01-01 ClassName: GoodsDaoJDBCImpl Module ID: 4.6 Comments:
 * 在数据层为商品类对象提供数据查询，分页显示的功能,GoodsDao的实现类 JDK :jdk1.6.0_10 Create Date： 2013-3-1
 * 
 * @see java.io.IOException
 * @see java.io.InputStream
 * @see java.io.PrintStream
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see java.util.ArrayList
 * @see java.util.List
 * @see net.dfrz.supershop01.dao.GoodsDao
 * @see net.dfrz.supershop01.domain.Goods
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see net.dfrz.supershop01.servicesimpl.GoodsQueryHelper
 * @see net.dfrz.supershop01.utils.DBUtils;
 * @see #buildSqlByHelper(GoodsQueryHelper)
 * @see #buildSqlByHelper2(GoodsQueryHelper)
 * @see #buildSqlByHelper3(GoodsQueryHelper)
 * @see #countGoods(GoodsQueryHelper)
 * @see #countGoods(GoodsQueryHelper, int)
 * @see #countSubGoods(GoodsQueryHelper, int)
 * @see #getGoodsById(Integer)
 * @see #getGoodsImage(Integer)
 * @see #getScopedGoods(GoodsQueryHelper, int, int)
 * @see #getScopeListGoodsByBigCtgId(GoodsQueryHelper, int, int, int)
 * @see #getScopeListGoodsBySubCtgId(GoodsQueryHelper, int, int, int)
 * @see #loadAll()
 * @see #update(Goods)
 * @author J1205-YDP    
 * @version Version 5
 */
public class GoodsDaoJDBCImpl implements GoodsDao {

	/**
	 * 获取商品图片的SQL语句
	 */
	private static final String SQL_GETPIC = "select goods_image from goods where goods_id=?";

	/**
	 * 根据商品的ID获取商品详细信息的SQL语句
	 */
	private static final String GET_GOODSBYID = "select * from goods where goods_id=?";

	/**
	 * 获取所有商品的SQL语句
	 */
	private static final String LOADALL = "select * from goods order by goods_id desc";

	/**
	 * 根据商品的大类别ID获取商品的SQL语句
	 */
	private static final String GET_GOODS_BY_BIG_CTG_ID = "select * from small_category,goods where b_ctg_id=? and "
			+ "small_category.s_ctg_id = goods.goods_ctg_id";

	/**
	 * 根据商品的小类别ID获取商品的SQL语句
	 */
	private static final String GET_GOODS_BY_SUB_CTG_ID = "select * from goods where goods_ctg_id = ?";
	/**
	 * 更新商品件数的SQL语句
	 */
	private static final String UPDATE_GOODS = "update goods set goods_name=?,goods_price=?,goods_empty=?,goods_desc=?,goods_ctg_id=?,goods_qty=?,goods_admin_id=? where goods_id=?";

	public List<Goods> getScopedGoods(GoodsQueryHelper helper, int beginIndex,
			int endIndex) {

		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset = null;
		/**
		 * 存放从数据库中获取的商品对象的ArrayList数组
		 */
		List<Goods> goodsList = null;
		/**
		 * 分页查询SQL语句
		 */
		String sql = "select * from ( select rownum rn,a.* from ( "
				+ this.buildSqlByHelper(helper)
				+ " ) a where rownum<=? ) where rn>=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endIndex);
			pstmt.setInt(2, beginIndex);
			rset = pstmt.executeQuery();

			goodsList = new ArrayList<Goods>();

			while (rset.next()) {
				/**
				 * 封装商品信息的商品对象
				 */
				Goods goods = new Goods();

				goods.setGoodsId(rset.getInt("goods_id"));
				goods.setGoodsName(rset.getString("goods_name"));
				goods.setGoodsPrice(rset.getDouble("goods_price"));
				goods.setGoodsIsEmpty(rset.getInt("goods_empty"));
				goods.setGoodsDesc(rset.getString("goods_desc"));
				goods.setGoodsQty(rset.getInt("goods_qty"));
				goods.setGoodsCtgId(rset.getInt("goods_ctg_id"));
				goods.setGoodsAdminId(rset.getInt("goods_admin_id"));

				goodsList.add(goods);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("商品信息列表获取失败！如果多次出现，请联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		return goodsList;
	}

	/**
	 * 根据商品的查询条件构建根据子类别ID查询商品的SQL的语句
	 * 
	 * @param helper
	 * @return
	 */

	private String buildSqlByHelper3(GoodsQueryHelper helper) {

		String sql = GET_GOODS_BY_SUB_CTG_ID;

		if (helper.getGoodsName() != null
				&& helper.getGoodsName().trim().length() > 0) {
			sql += " and goods_name like '%" + helper.getGoodsName() + "%'";
		}
		if (helper.getGoodsCtgId() != null) {
			sql += " and goods_ctg_id=" + helper.getGoodsCtgId();
		}
		if (helper.getGoodsIsEmpty() != null
				&& helper.getGoodsIsEmpty().trim().length() > 0) {
			sql += " and goods_empty='" + helper.getGoodsIsEmpty() + "'";
		}
		if (helper.getMinGoodsPrice() != null) {

			sql += "and goods_price >=" + helper.getMinGoodsPrice();
		}
		if (helper.getMaxGoodsPrice() != null) {
			sql += "and goods_price <=" + helper.getMaxGoodsPrice();
		}
		sql += " order by goods_id";

		return sql;

	}

	/**
	 * 根据商品的查询条件构建根据商品大类别ID查询商品的SQL语句
	 * 
	 * @param helper
	 * @return
	 */
	private String buildSqlByHelper2(GoodsQueryHelper helper) {

		String sql = GET_GOODS_BY_BIG_CTG_ID;

		if (helper.getGoodsName() != null
				&& helper.getGoodsName().trim().length() > 0) {
			sql += " and goods_name like '%" + helper.getGoodsName() + "%'";
		}
		if (helper.getGoodsCtgId() != null) {
			sql += " and goods_ctg_id=" + helper.getGoodsCtgId();
		}
		if (helper.getGoodsIsEmpty() != null
				&& helper.getGoodsIsEmpty().trim().length() > 0) {
			sql += " and goods_empty='" + helper.getGoodsIsEmpty() + "'";
		}
		if (helper.getMinGoodsPrice() != null) {

			sql += "and goods_price >=" + helper.getMinGoodsPrice();
		}
		if (helper.getMaxGoodsPrice() != null) {
			sql += "and goods_price <=" + helper.getMaxGoodsPrice();
		}
		sql += " order by goods_id";

		return sql;

	}

	/**
	 * 根据商品的查询条件构建查询商品的SQL语句
	 * 
	 * @param helper
	 * @return
	 */

	private String buildSqlByHelper(GoodsQueryHelper helper) {

		String sql = "select * from goods where 1=1";

		if (helper.getGoodsName() != null
				&& helper.getGoodsName().trim().length() > 0) {
			sql += " and goods_name like '%" + helper.getGoodsName() + "%'";
		}
		if (helper.getGoodsCtgId() != null) {
			sql += " and goods_ctg_id=" + helper.getGoodsCtgId();
		}
		if (helper.getGoodsIsEmpty() != null
				&& helper.getGoodsIsEmpty().trim().length() > 0) {
			sql += " and goods_empty='" + helper.getGoodsIsEmpty() + "'";
		}
		if (helper.getMinGoodsPrice() != null) {

			sql += "and goods_price >=" + helper.getMinGoodsPrice();
		}
		if (helper.getMaxGoodsPrice() != null) {
			sql += "and goods_price <=" + helper.getMaxGoodsPrice();
		}
		sql += " order by goods_id";

		return sql;

	}

	public byte[] getGoodsImage(Integer goodsId) {
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset = null;
		/**
		 * 存放商品图片的字节数组
		 */
		byte[] goodsImage = null;

		try {

			pstmt = conn.prepareStatement(SQL_GETPIC);
			pstmt.setInt(1, goodsId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				java.sql.Blob blob = rset.getBlob("goods_image");
				if (blob != null) {
					InputStream inStream = blob.getBinaryStream();
					goodsImage = new byte[(int) blob.length()];
					inStream.read(goodsImage);
					inStream.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

			throw new DataAccessException("商品图片获取失败,如果多次出现,请及时联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		return goodsImage;
	}

	public int countGoods(GoodsQueryHelper helper) {

		String sql = this.buildSqlByHelper(helper);
		sql = sql.replace("*", "count(*) total");
		sql = sql.substring(0, sql.indexOf("order"));
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset = null;
		/**
		 * 记录符合查询条件的所有商品的总数
		 */
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
			throw new DataAccessException("商品数量统计查询失败,如果多次出现,请及时联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}

		return total;
	}

	public int countGoods(GoodsQueryHelper helper, int ctgId) {

		String sql = this.buildSqlByHelper2(helper);
		sql = sql.replace("*", "count(*) total");
		sql = sql.substring(0, sql.indexOf("order"));

		/**
		 * 获取数据库连接
		 */

		Connection conn = DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;

		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset = null;
		/**
		 * 记录符合查询条件的所有商品的总数
		 */
		Integer total = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ctgId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				total = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("商品数量统计查询失败,如果多次出现,请及时联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}

		return total;
	}

	public Goods getGoodsById(Integer goodsId) {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset = null;
		/**
		 * 封装商品信息的商品对象
		 */
		Goods goods = null;

		try {
			pstmt = conn.prepareStatement(GET_GOODSBYID);
			pstmt.setInt(1, goodsId);
			rset = pstmt.executeQuery();

			while (rset.next()) {

				goods = new Goods();
				goods.setGoodsId(goodsId);
				goods.setGoodsName(rset.getString("goods_name"));
				goods.setGoodsPrice(rset.getDouble("goods_price"));
				goods.setGoodsIsEmpty(rset.getInt("goods_empty"));
				goods.setGoodsDesc(rset.getString("goods_desc"));
				goods.setGoodsQty(rset.getInt("goods_qty"));
				goods.setGoodsCtgId(rset.getInt("goods_ctg_id"));
				goods.setGoodsAdminId(rset.getInt("goods_admin_id"));
				goods
						.setGoodsImage(this.getGoodsImage(rset
								.getInt("goods_id")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("商品信息提取失败，如果多次出现,请及时联系系统管理员。");
		} finally {

			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}

		return goods;
	}

	public List<Goods> loadAll() {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset = null;
		/**
		 * 存放从数据库中获取的商品对象的ArrayList数组
		 */
		List<Goods> goodsList = null;

		try {

			pstmt = conn.prepareStatement(LOADALL);
			rset = pstmt.executeQuery();

			goodsList = new ArrayList<Goods>();

			while (rset.next()) {
				/**
				 * 封装商品信息的商品对象
				 */
				Goods goods = new Goods();

				goods.setGoodsId(rset.getInt("goods_id"));
				goods.setGoodsName(rset.getString("goods_name"));
				goods.setGoodsPrice(rset.getDouble("goods_price"));
				goods.setGoodsIsEmpty(rset.getInt("goods_empty"));
				goods.setGoodsDesc(rset.getString("goods_desc"));
				goods.setGoodsQty(rset.getInt("goods_qty"));
				goods.setGoodsCtgId(rset.getInt("goods_ctg_id"));
				goods.setGoodsAdminId(rset.getInt("goods_admin_id"));
				goodsList.add(goods);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("获取所有商品失败！如果多次出现,请及时联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		return goodsList;
	}

	public List<Goods> getScopeListGoodsByBigCtgId(GoodsQueryHelper helper,
			int beginIndex, int endIndex, int ctgid) {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset = null;
		/**
		 * 存放从数据库中获取的商品对象的ArrayList数组
		 */
		List<Goods> goodsList = null;
		/**
		 * 分页查询SQL语句
		 */
		String sql = "select * from ( select rownum rn,a.* from ( "
				+ this.buildSqlByHelper2(helper)
				+ " ) a where rownum<=? ) where rn>=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ctgid);
			pstmt.setInt(2, endIndex);
			pstmt.setInt(3, beginIndex);
			rset = pstmt.executeQuery();

			goodsList = new ArrayList<Goods>();

			while (rset.next()) {

				/**
				 * 封装商品信息的商品对象
				 */
				Goods goods = new Goods();

				goods.setGoodsId(rset.getInt("goods_id"));
				goods.setGoodsName(rset.getString("goods_name"));
				goods.setGoodsPrice(rset.getDouble("goods_price"));
				goods.setGoodsIsEmpty(rset.getInt("goods_empty"));
				goods.setGoodsDesc(rset.getString("goods_desc"));
				goods.setGoodsQty(rset.getInt("goods_qty"));
				goods.setGoodsCtgId(rset.getInt("goods_ctg_id"));
				goods.setGoodsAdminId(rset.getInt("goods_admin_id"));

				goodsList.add(goods);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("商品信息列表获取失败！如果多次出现，请联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		return goodsList;

	}

	public List<Goods> getScopeListGoodsBySubCtgId(GoodsQueryHelper helper,
			int beginIndex, int endIndex, int subctgid) {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset = null;
		/**
		 * 存放从数据库中获取的商品对象的ArrayList数组
		 */
		List<Goods> goodsList = null;
		/**
		 * 分页查询SQL语句
		 */
		String sql = "select * from ( select rownum rn,a.* from ( "
				+ this.buildSqlByHelper3(helper)
				+ " ) a where rownum<=? ) where rn>=?";
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subctgid);
			pstmt.setInt(2, endIndex);
			pstmt.setInt(3, beginIndex);
			rset = pstmt.executeQuery();

			goodsList = new ArrayList<Goods>();

			while (rset.next()) {
				/**
				 * 封装商品信息的商品对象
				 */
				Goods goods = new Goods();

				goods.setGoodsId(rset.getInt("goods_id"));
				goods.setGoodsName(rset.getString("goods_name"));
				goods.setGoodsPrice(rset.getDouble("goods_price"));
				goods.setGoodsIsEmpty(rset.getInt("goods_empty"));
				goods.setGoodsDesc(rset.getString("goods_desc"));
				goods.setGoodsQty(rset.getInt("goods_qty"));
				goods.setGoodsCtgId(rset.getInt("goods_ctg_id"));
				goods.setGoodsAdminId(rset.getInt("goods_admin_id"));
				goodsList.add(goods);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("获取所有商品失败！如果多次出现,请及时联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		return goodsList;
	}

	public int countSubGoods(GoodsQueryHelper helper, int subCtgId) {
		// TODO Auto-generated method stub

		String sql = this.buildSqlByHelper3(helper);
		sql = sql.replace("*", "count(*) total");
		sql = sql.substring(0, sql.indexOf("order"));

		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getInstance().getConn();

		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;

		ResultSet rset = null;
		Integer total = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subCtgId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				total = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("商品数量统计查询失败,如果多次出现,请及时联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}

		return total;
	}

	public void update(Goods goods) {
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 存放从数据库中获取的商品对象的ArrayList数组
		 */
		ResultSet rset = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(UPDATE_GOODS);
			pstmt.setString(1, goods.getGoodsName());
			pstmt.setDouble(2, goods.getGoodsPrice());
			pstmt.setInt(3, goods.getGoodsIsEmpty());
			pstmt.setString(4, goods.getGoodsDesc());
			pstmt.setInt(5, goods.getGoodsCtgId());
			pstmt.setInt(6, goods.getGoodsQty());
			pstmt.setInt(7, goods.getGoodsAdminId());
			pstmt.setInt(8, goods.getGoodsId());

			pstmt.executeUpdate();
			if (goods.getGoodsImage() != null
					&& goods.getGoodsImage().length > 0) {
				pstmt = conn
						.prepareStatement("select goods_image from goods where goods_id ="
								+ goods.getGoodsId() + " for update");
				rset = pstmt.executeQuery();

				if (rset.next()) {
					oracle.sql.BLOB blob = (oracle.sql.BLOB) rset
							.getBlob("goods_image");

					PrintStream ps = new PrintStream(blob
							.getBinaryOutputStream());
					ps.write(goods.getGoodsImage());

					ps.flush();
					ps.close();

				}
			}
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DataAccessException("商品信息更新失败！如果多次出现,请及时联系系统管理员。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}

	}

}
