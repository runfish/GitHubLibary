/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;


/**
 * Project: supershop01-02 
 * ClassName: CategoryDao 
 * Module ID: 4.6 
 * Comments:�����ݲ�Ϊ������ṩ��ɾ�Ĳ鹦�� 
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-6
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Category;
 * @see net.dfrz.supershop01.domain.SmallCategory;
 * @see net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;
 * @see #addSmallCategory(SmallCategory)
 * @see #countSmallCategory()
 * @see #deleteSmallCategory(int)
 * @see #ListOraderItem()
 * @see #getOne(int)
 * @see #getSubCtg(int)
 * @see #loadPage(int, int)
 * @see #updateSmallCategory(SmallCategory)
 * @Author J1205-YouHQ and J1205-HHG and J1205-YDP
 * @version Version 5
 */
public interface SmallCategoryDao {
	/**
	 * ��ʾ����
	 * @return
	 */
	List<SmallCategory> ListOraderItem();
	/**
	 * ����С�����Ϣ
	 * @param samllcategory
	 */
    void addSmallCategory(SmallCategory samllcategory);
    /**
     * ����С�����Ϣ
     * @param samllcategory
     */
    void updateSmallCategory(SmallCategory samllcategory);
    /**
     * ��ȡһ��С���
     * @param id
     * @return
     */
    SmallCategory getOne(int id);
    /**
     * ɾ��С�����Ϣ
     * @param id
     */
    void deleteSmallCategory(int id);
    /**
     * ��ʾ��ҳ���С�����Ϣ
     * @param beginIndex
     * @param endIndex
     * @return
     */
    List<SmallCategory>loadPage(int beginIndex, int endIndex);
    /**
     * ���ݲ�ѯ������ȡС��������
     * @return
     */
    int countSmallCategory();
    /**
     * ���ݴ����ID��ȡС��𼯺�
     * @param bigCtgId
     * @return
     */
    List<SmallCategory> getSubCtg(int bigCtgId);
}
