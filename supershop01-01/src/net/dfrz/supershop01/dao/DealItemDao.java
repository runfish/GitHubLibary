/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.DealItem;

/**                
 * Project: supershop01-01
 * ClassName: DealItemDao                                                        
 * Module ID: 4.6  
 * Comments: �����ݲ�Ϊ������Ŀ������ṩ����ɾ�����޸ġ���ҳ��ʾ�Ĺ���  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-8
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.DealItem
 * @see #add(DealItem)
 * @see #update(DealItem)
 * @see #delete(DealItem)
 * @see #getDealItemById(Integer)
 * @see #loadPage(int,int,DealQuryHelper)
 * @see #countDealItem(DealQuryHelper)
 * @see #deleteDealItemByDealId(Integer)
 * @author J1205-HongHG                                                      
 * @version Version 5      
 */
public interface DealItemDao {

	/**
	 * ���Ӷ�����Ŀ����
	 * @param dealItem -������Ŀ����
	 * @throws net.dfrz.supershop01.exception.DataAccessException -���������󲻴���ʱ�׳��쳣
	 */
	void add(DealItem dealItem);
	/**
	 * ������Ŀ������޸�
	 * @param dealItem -������Ŀ����
	 * @throws net.dfrz.supershop01.exception.DataAccessException -���������󲻴���ʱ�׳��쳣
	 */
	void update(DealItem dealItem);
	/**
	 * ������Ŀ�����ɾ��
	 * @param dealItem -������Ŀ����
	 * @throws net.dfrz.supershop01.exception.DataAccessException -���������󲻴���ʱ�׳��쳣
	 */
	void delete(DealItem dealItem);
	/**
	 * ���ݶ�����Ŀ����ı�Ż�ȡ��Ӧ�Ķ�����Ŀ����
	 * @param itemId -���ҵĶ�����Ŀ�ı��
	 * @throws net.dfrz.supershop01.exception.DataAccessException -���������󲻴���ʱ�׳��쳣
	 * @return DealItem
	 */
	DealItem getDealItemById(Integer itemId);
	/**
	 * ������������ķ�ҳ��ʾ
	 * @param startIndex   -ҳ�濪ʼ�ļ�¼��ʼλ��
	 * @param endIndex   -ҳ����������һ����¼��λ��
	 * @param dealId -��Ʒ������Ŀ��ϲ�ѯ������װ�İ�������
	 * @throws net.dfrz.supershop01.exception.DataAccessException -���������󲻴���ʱ�׳��쳣
	 * @return List<DealItem>  
	 */
	List<DealItem> loadPage(int startIndex,int endIndex,int dealId);
	/**
	 * ͳ�����ݿ⼯�ж���������
	 * @param dealId -��Ʒ������ϲ�ѯ������װ�İ�������
	 * @throws net.dfrz.supershop01.exception.DataAccessException -���������󲻴���ʱ�׳��쳣
	 * @return dealId
	 */
	int countDealItem(int dealId);
	/**
	 * ɾ��ָ����������µ����ж�����Ŀ
	 * @param dealId -�������
	 * @throws net.dfrz.supershop01.exception.DataAccessException -���������󲻴���ʱ�׳��쳣
	 */
	void deleteDealItemByDealId(Integer dealId);
}