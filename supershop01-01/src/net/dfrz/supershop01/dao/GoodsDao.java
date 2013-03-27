/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;

/**                
 * Project: supershop01-01
 * ClassName: GoodsDao                                                       
 * Module ID: 4.6  
 * Comments: 在数据层为商品提供查询以及获取商品图片的等功能
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-6
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Goods
 * @see net.dfrz.supershop01.servicesimpl.GoodsQuryHelper
 * @see net.dfrz.supershop01.utils.Page
 * @see #getGoodsImage(Integer)
 * @see #countGoods(GoodsQueryHelper)
 * @see #countGoods(GoodsQueryHelper,int)
 * @see #countSubGoods(GoodsQueryHelper,int)
 * @see #getGoodsById(Integer)
 * @see #loadAll()
 * @see #getScopedGoods(GoodsQueryHelper,int, int)
 * @see #getScopeListGoodsByBigCtgId(GoodsQueryHelper,int, int,int)
 * @see #getScopeListGoodsBySubCtgId(GoodsQueryHelper,int, int,int)
 * @see #update(Goods)
 * @author J1205-YDP                                                        
 * @version Version 5      
 */
public interface GoodsDao {

	/**
	 * 根据商品的goodsId获取商品的图片
	 * @param goodsId
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return  byte[]
	 */
	byte[] getGoodsImage(Integer goodsId);

	/**
	 * 根据相应的查询条件helper查询出符合查询条件的所有商品件数
	 * @param helper
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return int
	 */
	int countGoods(GoodsQueryHelper helper);

	/**
	 *根据相应的查询条件helper以及商品所属的大类别ctgId查询出符合查询条件的所有商品件数
	 * @param helper
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @param ctgId
	 * @return int
	 */
	int countGoods(GoodsQueryHelper helper, int ctgId);

	/**
	 * 根据相应的查询条件helper以及商品所属的小类别subCtgId查询出符合查询条件的所有商品件数
	 * @param helper
	 * @param subCtgId
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return int
	 */
	int countSubGoods(GoodsQueryHelper helper, int subCtgId);

	/**
	 * 根据提供的商品goodsId获取商品的所有信息
	 * @param goodsId
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return 	Goods
	 */
	Goods getGoodsById(Integer goodsId);

	/**
	 * 获取所有商品的信息
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return List<Goods>
	 */
	List<Goods> loadAll();

	/**
	 * 根据查询条件和分页信息分页查询出符合条件的商品
	 * @param helper
	 * @param beginIndex
	 * @param endIndex
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return List<Goods>
	 */
	List<Goods> getScopedGoods(GoodsQueryHelper helper, int beginIndex,
			int endIndex);

	/**
	 * 根据查询条件和分页信息以及商品大类别ID查询出符合条件的商品
	 * @param helper
	 * @param beginIndex
	 * @param endIndex
	 * @param ctgid
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return List<Goods>
	 */
	List<Goods> getScopeListGoodsByBigCtgId(GoodsQueryHelper helper,
			int beginIndex, int endIndex, int ctgid);

	/**
	 * 根据查询条件和分页信息以及商品子类别查询出符合条件的商品
	 * @param helper
	 * @param beginIndex
	 * @param endIndex
	 * @param subctgid
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return List<Goods>
	 */
	List<Goods> getScopeListGoodsBySubCtgId(GoodsQueryHelper helper,
			int beginIndex, int endIndex, int subctgid);

	/**
	 * 根据前台商品销售情况更新数据库中商品的数量
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @param goods
	 */
	void update(Goods goods);

}
