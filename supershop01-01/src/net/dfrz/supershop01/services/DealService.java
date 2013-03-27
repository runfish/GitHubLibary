/**
 * 
 */
package net.dfrz.supershop01.services;

import java.util.List;

import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.ShoppingCart;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.utils.Page;
/**                
 * Project: supershop01-01
 * ClassName: DealService                                                        
 * Module ID: 4.6  
 * Comments: ��ҵ���Ϊ����������ṩ����ɾ�����޸ġ����ҵĹ���  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-9
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.domain.Deal
 * @see net.dfrz.supershop01.domain.ShoppingCart
 * @see net.dfrz.supershop01.servicesimpl.DealQuryHelper
 * @see net.dfrz.supershop01.utils.Page
 * @see #addDeal(Deal)
 * @see #updateDeal(Deal)
 * @see #deleteDeal(Deal)
 * @see #getDealById(Integer)
 * @see #loadPage(Page, DealQuryHelper)
 * @see #loadAll()
 * @see #changeCartItemToDeal(Deal,ShoppingCart)
 * @author J1205-HongHG                                                      
 * @version Version 150 
 */
public interface DealService {
	/**
	 * ���Ӷ����������ݿ�
	 * @param deal -������������
	 * @param cart -��ǰ���ﳵ����
	 * @param customer -��ǰ���û�����
	 */
	void addDeal(Deal deal,ShoppingCart cart,Customer customer);
	/**
	 * ����������޸�
	 * @param deal -Ҫ�޸ĵĶ�������
	 */
	void updateDeal(Deal deal);
	/**
	 * ���������ɾ��
	 * @param deal -Ҫɾ���Ķ�������
	 */
	void deleteDeal(Deal deal);
	/**
	 * ���ݶ�����Ż�ȡ��Ӧ�Ķ�����Ϣ
	 * @param dealId -��ѯ�Ķ����Ķ������
	 */
	Deal getDealById(Integer dealId);
	/**
	 * ������ʾ��������ķ�ҳ����
	 * @param pagedDeal   -ҳ�����
	 * @param helper -��Ʒ������ϲ�ѯ������װ�İ�������
	 * @return Page  
	 */
	Page loadPage(Page pagedDeal,DealQuryHelper helper);
	/**
	 * ��ȡ���е���Ʒ������Ϣ
	 * @return List<Deal>
	 */
	List<Deal>loadAll();
	/**
	 * �����ﳵ�е���Ʒ��Ϣת���ɶ�����Ϣ
	 * @param cart -��ǰ���ﳵ����
	 *@param deal -�����Ķ�������
	 */
	void changeCartItemToDeal(Deal deal ,ShoppingCart cart,Customer customer);
}
