/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
/**                
 * Project: supershop01-01
 * ClassName: DealDao                                                        
 * Module ID: 4.6  
 * Comments: �����ݲ�Ϊ����������ṩ����ɾ�����޸ġ����ҵĹ���  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-8
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Deal
 * @see net.dfrz.supershop01.servicesimpl.DealQuryHelper
 * @see #add(Deal)
 * @see #update(Deal)
 * @see #delete(Deal)
 * @see #getDealById(Integer)
 * @see #loadPage(int, int, DealQuryHelper)
 * @see #countDeal(DealQuryHelper)
 * @see #loadAll()
 * @see #getMaxDealId(DealQuryHelper)
 * @author J1205-HongHG                                                      
 * @version Version 117      
 */
public interface DealDao {

	/**
	 * ���Ӷ�������
	 * @param deal -�����Ķ�������
	 * @throws net.dfrz.supershop01.exception.DataAccessException -���������󲻴���ʱ�׳��쳣
	 */
	void add(Deal deal);
	/**
	 * ����������޸�
	 * @param deal -��Ҫ�޸ĵĶ�������
	 * @throws net.dfrz.supershop01.exception.DataAccessException -���������󲻴���ʱ�׳��쳣
	 */
	void update(Deal deal);
	/**
	 * ���������ɾ��
	 * @param deal -Ҫɾ���Ķ�������
	 * @throws net.dfrz.supershop01.exception.DataAccessException -���������󲻴���ʱ�׳��쳣
	 */
	void delete(Deal deal);
	/**
	 * ���ݶ�������ı�Ż�ȡ��Ӧ�Ķ�������
	 * @param dealId -���ҵĶ����ı��
	 * @throws net.dfrz.supershop01.exception.DataAccessException -���������󲻴���ʱ�׳��쳣
	 * @return deal
	 */
	Deal getDealById(Integer dealId);
	/**
	 * ������������ķ�ҳ��ʾ
	 * @param startIndex   -ҳ�濪ʼ�ļ�¼��ʼλ��
	 * @param endIndex   -ҳ����������һ����¼��λ��
	 * @param helper -��Ʒ������ϲ�ѯ������װ�İ�������
	 * @throws net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @return List<Deal>  -������������
	 */
	List<Deal> loadPage(int startIndex,int endIndex,DealQuryHelper helper);
	/**
	 * ͳ�����ݿ⼯�ж���������
	 * @param helper -��Ʒ������ϲ�ѯ������װ�İ�������
	 * @throws net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @return int
	 */
	int countDeal(DealQuryHelper helper);
	/**
	 * ��ȡȫ������Ʒ����
	 * @return List<Deal>
	 * @throws net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 */
	List<Deal>loadAll();
	/**
	 * ��ȡ���������Ķ������
	 * @param helper -��Ʒ������ϲ�ѯ������װ�İ�������
	 * @throws net.dfrz.supershop01.exception.DataAccessException ��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @return int
	 */
	int getMaxDealId(DealQuryHelper helper);
}
