/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;

/**                
 * Project: supershop01-02
 * ClassName: GoodsDao                                                       
 * Module ID: 4.6  
 * Comments: 在数据层为商品提供增删改查以及获取商品图片的等功能
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-6
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Goods
 * @see net.dfrz.supershop01.servicesimpl.GoodsQuryHelper
 * @see #add(Goods)
 * @see #countGoods(GoodsQueryHelper)
 * @see #deleteGoodsById(Integer)
 * @see #getGoodsById(Integer)
 * @see #getGoodsImage(Integer)
 * @see #getScopedGoods(GoodsQueryHelper, int, int)
 * @see #loadAll()
 * @see #update(Goods)
 * @author J1205-YDP                                                     
 * @version Version 5      
 */
public interface GoodsDao {
	/**
	 * 在数据层增加商品信息
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @param goods
	 */
	void add(Goods goods);

	/**
	 * 在数据层更新商品信息
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @param goods
	 */
	void update(Goods goods);

	/**
	 * 根据查询条件获取相应的商品信息集合
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常 
	 * @param helper
	 * @param beginIndex
	 * @param endIndex
	 * @return 	List<Goods>
	 */
	List<Goods> getScopedGoods(GoodsQueryHelper helper, int beginIndex,
			int endIndex);

	/**
	 * 根据商品的ID获取商品图片
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @param goodsId
	 * @return 	byte[]
	 */
	byte[] getGoodsImage(Integer goodsId);

	/**
	 * 根据商品的查询条件获得所符合查询条件的所有商品件数
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @param helper
	 * @return	int
	 */
	int countGoods(GoodsQueryHelper helper);

	/**
	 * 根据商品ID删除商品信息
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @param goodsId
	 */
	void deleteGoodsById(Integer goodsId);

	/**
	 * 根据商品的id号获取特定商品的信息
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @param goodsId
	 * @return	Goods
	 */
	Goods getGoodsById(Integer goodsId);

	/**
	 * 获取所有商品信息集合
	 * @exception net.dfrz.supershop01.exception.DataAccessException 读取数据库数据发生错误时抛出异常
	 * @return	List<Goods>
	 */
	List<Goods> loadAll();
}
