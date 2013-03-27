package net.dfrz.supershop01.services;

import java.util.List;

import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;
import net.dfrz.supershop01.utils.Page;
/**                
 * Project: supershop01-02
 * ClassName: GoodsService                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为用户类对象提供数据添加，修改、查找的功能
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see net.dfrz.supershop01.domain.Customer;
 * @see net.dfrz.supershop01.domain.Goods;
 * @see net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;
 * @see net.dfrz.supershop01.utils.Page;
 * @see #addGoods(Goods)
 * @see #delete(Integer)
 * @see #getGoodsById(int)
 * @see #loadAll()
 * @see #loadGoodsImageById(Integer)
 * @see #loadPagedGoods(Page, GoodsQueryHelper)
 * @see #updateGoods(Goods)
 * @author J1205-YDP                                                     
 * @version Version 10 
 */
public interface GoodsService {
	/**
	 * 在服务层增加商品信息
	 * @param goods
	 */
	void addGoods(Goods goods);
	
	/**
	 * 根据商品的ID获取商品信息
	 * @param goodsId
	 * @return Goods
	 */
	Goods getGoodsById(int goodsId);
	
	/**
	 * 更新商品信息
	 * @param goods
	 */
	void updateGoods(Goods goods);
	/**
	 * 根据查询条件获得分页后的商品信息集合
	 * @param page
	 * @param helper
	 * @return	Page
	 */
	Page loadPagedGoods(Page page, GoodsQueryHelper helper);
	/**
	 * 根据商品的ID获取商品的图片
	 * @param goodsId
	 * @return	byte[] 
	 */
	byte[] loadGoodsImageById(Integer goodsId);
	/**
	 * 根据商品ID删除商品信息
	 * @param goodsId
	 */
	void delete(Integer goodsId);
	/**
	 * 获取所有商品信息
	 * @return
	 */
	List<Goods> loadAll();
	

}
