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
 * ��ҵ���Ϊ��Ʒ������ṩ���ݲ�ѯ�����£���ҳ��ʾ�Ĺ��� JDK :jdk1.6.0_10 Create Date�� 2013-3-1
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
	 * ������ƷID��ȡ������Ʒ��Ϣ
	 * 
	 * @param goodsId
	 * @return Goods
	 */
	Goods getGoodsById(int goodsId);

	/**
	 * ������ƷID��ȡ������Ʒ����ƷͼƬ
	 * 
	 * @param goodsId
	 * @return 	byte[]
	 */
	byte[] loadGoodsImageById(Integer goodsId);

	/**
	 * ��ȡ������Ʒ����Ϣ
	 * 
	 * @return	List<Goods>
	 */
	List<Goods> loadAll();

	/**
	 * ������Ʒ�Ĳ�ѯ������ȡ��ҳ����Ʒ��Ϣ
	 * 
	 * @param page
	 * @param helper
	 * @return Page
	 */
	Page loadPagedGoods(Page page, GoodsQueryHelper helper);

	/**
	 * ������Ʒ�Ĳ�ѯ�����Լ���Ʒ�����ID ��ȡ��Ʒ��ҳ����Ʒ��Ϣ
	 * 
	 * @param page
	 * @param helper
	 * @param ctgId
	 * @return 	Page
	 */
	Page getGoodsByBigCtgId(Page page, GoodsQueryHelper helper, int ctgId);

	/**
	 * ������Ʒ�Ĳ�ѯ�����Լ���ƷС���ID ��ȡ��Ʒ��ҳ����Ʒ��Ϣ
	 * 
	 * @param page
	 * @param helper
	 * @param subCtgId
	 * @return Page 
	 */
	Page getGoodsBySubCtgId(Page page, GoodsQueryHelper helper, int subCtgId);
}