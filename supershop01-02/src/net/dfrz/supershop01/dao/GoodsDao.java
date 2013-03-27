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
 * Comments: �����ݲ�Ϊ��Ʒ�ṩ��ɾ�Ĳ��Լ���ȡ��ƷͼƬ�ĵȹ���
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-6
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
	 * �����ݲ�������Ʒ��Ϣ
	 * @exception net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @param goods
	 */
	void add(Goods goods);

	/**
	 * �����ݲ������Ʒ��Ϣ
	 * @exception net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @param goods
	 */
	void update(Goods goods);

	/**
	 * ���ݲ�ѯ������ȡ��Ӧ����Ʒ��Ϣ����
	 * @exception net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣 
	 * @param helper
	 * @param beginIndex
	 * @param endIndex
	 * @return 	List<Goods>
	 */
	List<Goods> getScopedGoods(GoodsQueryHelper helper, int beginIndex,
			int endIndex);

	/**
	 * ������Ʒ��ID��ȡ��ƷͼƬ
	 * @exception net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @param goodsId
	 * @return 	byte[]
	 */
	byte[] getGoodsImage(Integer goodsId);

	/**
	 * ������Ʒ�Ĳ�ѯ������������ϲ�ѯ������������Ʒ����
	 * @exception net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @param helper
	 * @return	int
	 */
	int countGoods(GoodsQueryHelper helper);

	/**
	 * ������ƷIDɾ����Ʒ��Ϣ
	 * @exception net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @param goodsId
	 */
	void deleteGoodsById(Integer goodsId);

	/**
	 * ������Ʒ��id�Ż�ȡ�ض���Ʒ����Ϣ
	 * @exception net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @param goodsId
	 * @return	Goods
	 */
	Goods getGoodsById(Integer goodsId);

	/**
	 * ��ȡ������Ʒ��Ϣ����
	 * @exception net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @return	List<Goods>
	 */
	List<Goods> loadAll();
}
