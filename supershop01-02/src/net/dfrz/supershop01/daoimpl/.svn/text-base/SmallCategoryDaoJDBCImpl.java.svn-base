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
import net.dfrz.supershop01.dao.DaoFactory;
import net.dfrz.supershop01.dao.GoodsDao;
import net.dfrz.supershop01.dao.SmallCategoryDao;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;
import net.dfrz.supershop01.utils.DBUtils;


/**
 * Project: supershop01-02 
 * ClassName: SmallCategoryDaoJDBCImpl 
 * Module ID: 4.6
 * Comments: 是SmallCategoryDao的实现类 
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see java.util.ArrayList
 * @see java.util.List
 * @see org.apache.log4j.Logger
 * @see net.dfrz.supershop01.dao.CategoryDao
 * @see net.dfrz.supershop01.dao.DaoFactory
 * @see net.dfrz.supershop01.dao.GoodsDao
 * @see net.dfrz.supershop01.dao.SmallCategoryDao
 * @see net.dfrz.supershop01.domain.Category
 * @see net.dfrz.supershop01.domain.SmallCategory
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see net.dfrz.supershop01.servicesimpl.CategoryQueryHelper
 * @see net.dfrz.supershop01.utils.DBUtils
 * @see #LOGGER
 * @see #LOAD_ALL
 * @see #ADD
 * @see #UPDATE
 * @see #DELETE
 * @see #GET_ONE
 * @see #GET_SUBCTG_ID
 * @see #addSmallCategory(SmallCategory)
 * @see #getOne(int)
 * @see #getSubCtg(int)
 * @see #ListOraderItem()
 * @see #loadPage(int, int)
 * @see #deleteSmallCategory(int)
 * @see #updateSmallCategory(SmallCategory)
 * @see #countSmallCategory()
 * @see #buildSqlByHelper()
 * @author J1205-YouHQ
 * @version Version 5
 */
public class SmallCategoryDaoJDBCImpl implements SmallCategoryDao {
	/**
	 * 日志常量
	 */
	 private static final Logger LOGGER=Logger.getLogger(SmallCategoryDaoJDBCImpl.class);
	 /**
	  * 在数据层增加商品小类别信息的SQL语句
	  */	 
	 private final static String ADD="insert into small_category values(seq_small_ctgid.nextval,?,?,?)";
	 /**
	  * 在数据层获取所有商品小类别信息的SQL语句
	  */
	 private final static String LOAD_ALL="select * from small_category";
	 /**
	 * 在数据层更新商品小类别信息的SQl语句
	 */    
	 private final static String UPDATE="update small_category set "+
                                        "s_ctg_name=?"+
                                        ",s_ctg_status=?"+
                                        ",b_ctg_id=?"+
                                        "where s_ctg_id=?";
	 /**
	  * 在数据层根据商品小类别的ID删除此商品的SQL语句
      */
	 private final static String DELETE="delete from small_category where s_ctg_id=?";
     /**
      * 在数据层根据ID获取一个小类别
      */
	 private final static String GET_ONE="select * from small_category where s_ctg_id=?";
	 /**
	  * 在数据层根据ID获取小类别的子类别
	  */
	 private final static String GET_SUBCTG_ID = "select * from small_category where b_ctg_id=?";
     
     /* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#ListOraderItem()
	 */
	public List<SmallCategory> ListOraderItem() {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		List<SmallCategory> smallcategorylist=null;
		
		try {
			pstmt=conn.prepareStatement(LOAD_ALL);
			rest=pstmt.executeQuery();
			smallcategorylist = new ArrayList<SmallCategory>();
			CategoryDao bigcatdao=new CategoryDaoJDBCImpl();
			GoodsDao goodsdao=new GoodsDaoJDBCImpl();
			LOGGER.info("开始显示所有商品小类别...");	
			while(rest.next())
			{
				SmallCategory samllcategory=new SmallCategory();
				samllcategory.setSmallCtgId(rest.getInt("s_ctg_id"));
				samllcategory.setSmallCtgName(rest.getString("s_ctg_name"));
				samllcategory.setSmallCtgStatus(rest.getString("s_ctg_status"));
				samllcategory.setBigCategory(bigcatdao.getCtgById(rest.getInt("b_ctg_id")));
				smallcategorylist.add(samllcategory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("小类别显示失败！");	
		}
		LOGGER.info("小类别显示成功！");	
		return smallcategorylist;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#addSmallCategory(net.gdm.demo.SmallCategory)
	 */
	public void addSmallCategory(SmallCategory smallcategory) {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		PreparedStatement pstmt=null;

		try {
			LOGGER.info("开始保存小类别对象，对象信息如下："); 
			pstmt=conn.prepareStatement(ADD);
			
			pstmt.setString(1, smallcategory.getSmallCtgName());
			pstmt.setString(2, smallcategory.getSmallCtgStatus());
			pstmt.setInt(3, smallcategory.getBigCategory().getCtgId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String detail = null;
			if(e.getMessage().indexOf("ORA-00001")!=-1) 
			{
				 detail = "已存在该类别，请重新确认后在添加!";
				 LOGGER.error("已存在该类别，请重新确认后在添加!");	
			}
			LOGGER.error("商品小类别增加失败!");
			throw new DataAccessException("商品小类别增加失败"+detail);
			
		}
		LOGGER.info("商品小类别增加成功！"); 
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#deleteSmallCategory(int)
	 */
	public void deleteSmallCategory(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		PreparedStatement pstmt=null;
		
		try {
			LOGGER.info("开始删除小类别信息...");	
			pstmt=conn.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			LOGGER.info("商品小类别删除成功！");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("小类别删除失败！");	
		}
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#getOne(int)
	 */
	public SmallCategory getOne(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		SmallCategory smallCategory=null;
		CategoryDao bigcatdao=new CategoryDaoJDBCImpl();
		GoodsDao goodsdao=new GoodsDaoJDBCImpl();
		try {
			LOGGER.info("开始获取小类别...");	
			pstmt=conn.prepareStatement(GET_ONE);
			pstmt.setInt(1, id);
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				smallCategory=new SmallCategory();
				smallCategory.setSmallCtgId(rest.getInt("s_ctg_id"));
				smallCategory.setSmallCtgName(rest.getString("s_ctg_name"));
				smallCategory.setSmallCtgStatus(rest.getString("s_ctg_status"));
				smallCategory.setBigCategory(bigcatdao.getCtgById(rest.getInt("b_ctg_id")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info("小类别获取失败！");	
		}
		LOGGER.info("小类别获取成功！");	
		return smallCategory;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#updateSmallCategory(net.gdm.demo.SmallCategory)
	 */
	public void updateSmallCategory(SmallCategory smallcategory) {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		PreparedStatement pstmt=null;

		try {
			LOGGER.info("开始更新商品小类别...");	
			pstmt=conn.prepareStatement(UPDATE);
			pstmt.setString(1, smallcategory.getSmallCtgName());
			pstmt.setString(2, smallcategory.getSmallCtgStatus());
			pstmt.setInt(3, smallcategory.getBigCategory().getCtgId());
			pstmt.setInt(4, smallcategory.getSmallCtgId());
			pstmt.executeUpdate();
			LOGGER.info("商品小类别修改成功！");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("商品类别修改失败");	
			throw new DataAccessException("商品类别修改失败");
		}
		
	}
	public int countSmallCategory()
	{
		String sql=this.buildSqlByHelper();
		sql=sql.replace("*", "count(*) total");
		
		LOGGER.info("开始连接数据库...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
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
	public List<SmallCategory>loadPage(int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		LOGGER.info("开始连接数据库...");		
		Connection conn = DBUtils.getConn();
		LOGGER.info("数据库连接成功！");
		PreparedStatement pstmt=null; 
		ResultSet rset=null;
		List<SmallCategory> smallCtgList=null;
		CategoryDao categoryDao=(CategoryDao)DaoFactory.getDao("CategoryDao");
		
		try {
			
			smallCtgList=new ArrayList<SmallCategory>();
			
			String sql="select * from ( select rownum rn,a.* from ( "+ this.buildSqlByHelper()+" ) a where rownum<=? ) where rn>=?";
			pstmt=conn.prepareStatement(sql);	
			pstmt.setInt(1, endIndex);
			pstmt.setInt(2, beginIndex);
			rset=pstmt.executeQuery();
			LOGGER.info("开始显示分页后所有小类别信息...");	
			while(rset.next()){
				
			  SmallCategory smallcategory=new SmallCategory();
			   
			  smallcategory.setSmallCtgId(rset.getInt("s_ctg_id"));
			  smallcategory.setSmallCtgName(rset.getString("s_ctg_name"));
			  smallcategory.setSmallCtgStatus(rset.getString("s_ctg_status"));
			  Category category=new Category();
			  category.setCtgId(rset.getInt("b_ctg_id"));
			  category=categoryDao.getCtgById(category.getCtgId());
			  
			  smallcategory.setBigCategory(category);
		       
		      smallCtgList.add(smallcategory);
			   
			}
			LOGGER.info("小类别信息显示成功！");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("小类别信息显示失败！");	
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		
		return smallCtgList;
	}
    private String buildSqlByHelper(){
  		
  		String sql="select * from small_category where 1=1";
  		
  		return sql;
  		
  	}


	public List<SmallCategory> getSubCtg(int bigCtgId) {
		// TODO Auto-generated method stub
		Connection conn =DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet rest = null;
		List<SmallCategory> smalList = new ArrayList<SmallCategory>();
		
		try {
			pstmt = conn.prepareStatement(GET_SUBCTG_ID);
			pstmt.setInt(1, bigCtgId);
			rest = pstmt.executeQuery();
			
			while(rest.next()){
				SmallCategory smallCategory = new SmallCategory();
				smallCategory.setSmallCtgId(Integer.parseInt(rest.getString("s_ctg_id")));
				smallCategory.setSmallCtgName(rest.getString("s_ctg_name"));
				smalList.add(smallCategory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return smalList;
	}
}
