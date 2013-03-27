package net.dfrz.supershop01.services;

import java.util.List;

import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;
import net.dfrz.supershop01.utils.Page;

/**
 * Project: supershop01-01 ClassName: GoodsService Module ID: 4.6 Comments:
 * 在业务层为商品类对象提供数据查询，更新，分页显示的功能 JDK :jdk1.6.0_10 Create Date： 2013-3-1
 * 
 * @see net.dfrz.supershop01.domain.Goods
 * @see java.util.List
 * @see net.dfrz.supershop01.servicesimpl.GoodsQueryHelper
 * @see net.dfrz.supershop01.utils.Page
 * @see #getGoodsById(int)
 * @see #loadGoodsImageById(Integer)
 * @see #loadAll()
 * @see #loadPagedGoods(Page,GoodsQueryHelper)
 * @see #getGoodsByBigCtgId(Page, GoodsQueryHelper, int)
 * @see #getGoodsBySubCtgId(Page, GoodsQueryHelper, int)
 * @author J1205-YDP
 * @version Version 5
 */
public interface GoodsService {

	/**
	 * 根据商品ID获取单个商品信息
	 * 
	 * @param goodsId
	 * @return Goods
	 */
	Goods getGoodsById(int goodsId);

	/**
	 * 根据商品ID获取单个商品的商品图片
	 * 
	 * @param goodsId
	 * @return 	byte[]
	 */
	byte[] loadGoodsImageById(Integer goodsId);

	/**
	 * 获取所有商品的信息
	 * 
	 * @return	List<Goods>
	 */
	List<Goods> loadAll();

	/**
	 * 根据商品的查询条件获取分页的商品信息
	 * 
	 * @param page
	 * @param helper
	 * @return Page
	 */
	Page loadPagedGoods(Page page, GoodsQueryHelper helper);

	/**
	 * 根据商品的查询条件以及商品大类别ID 获取商品分页的商品信息
	 * 
	 * @param page
	 * @param helper
	 * @param ctgId
	 * @return 	Page
	 */
	Page getGoodsByBigCtgId(Page page, GoodsQueryHelper helper, int ctgId);

	/**
	 * 根据商品的查询条件以及商品小类别ID 获取商品分页的商品信息
	 * 
	 * @param page
	 * @param helper
	 * @param subCtgId
	 * @return Page 
	 */
	Page getGoodsBySubCtgId(Page page, GoodsQueryHelper helper, int subCtgId);
}
