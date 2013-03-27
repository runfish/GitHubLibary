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
import java.sql.SQLXML;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import net.dfrz.supershop01.dao.GoodsDao;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;
import net.dfrz.supershop01.utils.DBUtils;

/**
 * Project: supershop01-02 ClassName: GoodsDaoJDBCImpl Module ID: 4.6 Comments:
 * 是GoodsDao的实现类 JDK :jdk1.6.0_10 Create Date： 2013-1-6
 * 
 * @see java.util.List
 * @see java.io.IOException
 * @see java.io.InputStream
 * @see java.io.PrintStream
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see java.util.ArrayList
 * @see org.apache.log4j.Logger
 * @see net.dfrz.supershop01.dao.GoodsDao
 * @see net.dfrz.supershop01.domain.Goods
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see net.dfrz.supershop01.servicesimpl.GoodsQueryHelper
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see #ADD_GOODS
 * @see #DELETE_GOODSBYID
 * @see #GET_GOODSBYID
 * @see #LOADALL
 * @see #LOGGER
 * @see #SQL_GETPIC
 * @see #add(Goods)
 * @see #countGoods(GoodsQueryHelper)
 * @see #deleteGoodsById(Integer)
 * @see #getGoodsById(Integer)
 * @see #getGoodsImage(Integer)
 * @see #getScopedGoods(GoodsQueryHelper, int, int)
 * @see #loadAll()
 * @see #update(Goods)
 * @see #buildSqlByHelper(GoodsQueryHelper)
 * @author J1205-YDP
 * @version Version 5
 */
public class GoodsDaoJDBCImpl implements GoodsDao {
	/**
	 * 日志常量
	 */
	private static final Logger LOGGER = Logger
			.getLogger(GoodsDaoJDBCImpl.class);
	/**
	 * 在数据层增加商品信息的SQL语句
	 */
	private final static String ADD_GOODS = "insert into goods values(seq_goods.nextval,?,?,?,?,?,?,?,Empty_BLOB())";
	/**
	 * 在数据层获取商品图片的SQL语句
	 */
	private static final String SQL_GETPIC = "select goods_image from goods where goods_id=?";
	/**
	 * 在数据层根据商品ID获取商品信息的SQL语句
	 */
	private static final String GET_GOODSBYID = "select * from goods where goods_id=?";
	/**
	 * 在数据层更新商品信息的SQl语句
	 */
	private static final String UPDATE_GOODS = "update goods set goods_name=?,goods_price=?,goods_empty=?,goods_desc=?,goods_ctg_id=?,goods_qty=?,goods_admin_id=? where goods_id=?";
	/**
	 * 在数据层获取所有商品信息的SQL语句
	 */
	private static final String LOADALL = "select * from goods order by goods_id desc";
	/**
	 * 在数据层根据商品的ID删除此商品的SQL语句
	 */
	private static final String DELETE_GOODSBYID = "delete from goods where goods_id=?";

	public void add(Goods goods) {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		/**
		 * 准备SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存的存放对象
		 */
		ResultSet rset = null;
		try {

			conn.setAutoCommit(false);
			LOGGER.info("开始增加商品...");
			pstmt = conn.prepareStatement(ADD_GOODS);
			pstmt.setString(1, goods.getGoodsName());
			pstmt.setDouble(2, goods.getGoodsPrice());
			pstmt.setInt(3, goods.getGoodsIsEmpty());
			pstmt.setString(4, goods.getGoodsDesc());
			pstmt.setInt(5, goods.getGoodsCtgId());
			pstmt.setInt(6, goods.getGoodsQty());
			pstmt.setInt(7, goods.getGoodsAdminId());

			pstmt.executeUpdate();
			LOGGER.info("开始增加商品图片...");
			/**
			 * 开始准备增加商品图片的SQL语句
			 */
			pstmt = conn
					.prepareStatement("select goods_image from goods where goods_id =( select max(goods_id) from goods) for update");
			rset = pstmt.executeQuery();

			if (rset.next()) {
				oracle.sql.BLOB blob = (oracle.sql.BLOB) rset
						.getBlob("goods_image");

				PrintStream ps = new PrintStream(blob.getBinaryOutputStream());
				ps.write(goods.getGoodsImage());

				ps.flush();
				ps.close();

			}
			conn.commit();
			LOGGER.info("商品增加成功！");

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
			if (e.getMessage().indexOf("ORA-00001") != -1) {
				detailMsg = "商品名称出现了雷同!";
				LOGGER.error("商品名称出现了雷同!");
			}
			LOGGER.error("商品信息增加失败!");
			throw new DataAccessException("商品信息增加失败," + detailMsg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}

	}

	public List<Goods> getScopedGoods(GoodsQueryHelper helper, int beginIndex,
			int endIndex) {

		LOGGER.info("开始连接数据库...");
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		/**
		 * 准备SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存的存放对象
		 */
		ResultSet rset = null;
		List<Goods> goodsList = null;

		String sql = "select * from ( select rownum rn,a.* from ( "
				+ this.buildSqlByHelper(helper)
				+ " ) a where rownum<=? ) where rn>=?";

		System.out.println(sql);

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endIndex);
			pstmt.setInt(2, beginIndex);
			rset = pstmt.executeQuery();

			goodsList = new ArrayList<Goods>();

			LOGGER.info("开始显示商品信息...");
			while (rset.next()) {
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
			LOGGER.info("商品信息显示完毕！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("商品信息列表获取失败！如果多次出现，请联系系统管理员!");
			throw new DataAccessException("商品信息列表获取失败！如果多次出现，请联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		return goodsList;
	}

	/**
	 * 构建查询商品信息的Sql语句
	 * @param helper
	 * @return String 
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
		else if(helper.getGoodsCtgs()!=null)
		{
			sql += " and goods_ctg_id=any(" ;
			for(SmallCategory sCtg:helper.getGoodsCtgs())
			{
				sql += ""+sCtg.getSmallCtgId()+",";
			}
			sql = sql.substring(0, sql.length()-1);
			sql += ")";
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

		LOGGER.info("开始连接数据库...");
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		/**
		 * 准备SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存的存放对象
		 */
		ResultSet rset = null;
		
		/**
		 * 存放商品图片的字节数组
		 */
		byte[] goodsImage = null;

		try {
			LOGGER.info("开始获取数据库中的商品图片...");
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
			LOGGER.error("商品图片获取失败,如果多次出现,请及时联系系统管理员!");
			throw new DataAccessException("商品图片获取失败,如果多次出现,请及时联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		LOGGER.info("商品图片获取成功！");
		return goodsImage;
	}

	public int countGoods(GoodsQueryHelper helper) {

		String sql = this.buildSqlByHelper(helper);
		sql = sql.replace("*", "count(*) total");
		sql = sql.substring(0, sql.indexOf("order"));

		LOGGER.info("开始连接数据库...");
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		/**
		 * 准备SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存的存放对象
		 */
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
			LOGGER.error("商品数量统计查询失败,如果多次出现,请及时联系系统管理员!");
			throw new DataAccessException("商品数量统计查询失败,如果多次出现,请及时联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}

		return total;
	}

	public void deleteGoodsById(Integer goodsId) {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		/**
		 * 准备SQL语句
		 */
		PreparedStatement pstmt = null;

		try {
			LOGGER.info("开始删除商品...");
			pstmt = conn.prepareStatement(DELETE_GOODSBYID);
			pstmt.setInt(1, goodsId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("商品信息删除失败！如果多次出现,请及时联系系统管理员!");
			throw new DataAccessException("商品信息删除失败！如果多次出现,请及时联系系统管理员。");
			// TODO Auto-generated catch bloc
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
		LOGGER.info("商品删除成功！");

	}

	public Goods getGoodsById(Integer goodsId) {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		/**
		 * 准备SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存的存放对象
		 */
		ResultSet rset = null;
		/**
		 * 封装Goods对象
		 */
		Goods goods = null;

		try {
			LOGGER.info("开始获取数据库中的商品信息...");
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
			LOGGER.error("商品信息提取失败！如果多次出现,请及时联系系统管理员!");
			throw new DataAccessException("商品信息提取失败，如果多次出现,请及时联系系统管理员。");
		} finally {

			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		LOGGER.info("商品信息获取成功！");
		return goods;
	}

	public void update(Goods goods) {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		/**
		 * 准备SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存的存放对象
		 */
		ResultSet rset = null;
		try {
			conn.setAutoCommit(false);
			LOGGER.info("开始更新商品信息...");
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
			LOGGER.info("开始更新商品图片信息...");
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
			LOGGER.info("商品图片信息更新完毕！");
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
			LOGGER.error("商品信息更新失败！如果多次出现,请及时联系系统管理员!");
			throw new DataAccessException("商品信息更新失败！如果多次出现,请及时联系系统管理员。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
		LOGGER.info("商品信息更新完毕！");
	}

	public List<Goods> loadAll() {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");
		/**
		 * 获取数据库连接
		 */
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		/**
		 * 准备SQL语句
		 */
		PreparedStatement pstmt = null;
		/**
		 * 数据库数据在内存的存放对象
		 */
		ResultSet rset = null;
		
		/**
		 * 把从数据库中获取的所有数据封装到存放Goods的ArrayList的对象中
		 */
		List<Goods> goodsList = null;

		try {

			pstmt = conn.prepareStatement(LOADALL);
			rset = pstmt.executeQuery();

			goodsList = new ArrayList<Goods>();

			LOGGER.info("开始显示所有商品...");
			while (rset.next()) {
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
			LOGGER.error("获取所有商品失败！如果多次出现,请及时联系系统管理员");
			throw new DataAccessException("获取所有商品失败！如果多次出现,请及时联系系统管理员。");
		} finally {
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		LOGGER.info("所有商品显示成功！");
		return goodsList;
	}

}
