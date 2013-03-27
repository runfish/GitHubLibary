/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.Category;

/**
 * Project: supershop01-01 ClassName: CategoryDao Module ID: 4.6 Comments:
 * �����ݲ�Ϊ��Ʒ���e�ṩ��ѯ�ȹ��� JDK :jdk1.6.0_10 Create Date�� 2013-1-6
 * 
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Category
 * @see #getCtgById(int)
 * @see #loadAll()
 * @author J1205-YHQ and J1205-YDP
 * @version Version 5
 */
public interface CategoryDao {

	/**
	 * ���ݴ����ID�Ż�ȡ��������Ϣ
	 * 
	 * @param ctgId
	 * @exception net.dfrz.supershop01.exception.DataAccessException -��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @return Category
	 */

	Category getCtgById(int ctgId);

	/**
	 * ��ȡ���д�������Ϣ
	 * 
	 * @exception net.dfrz.supershop01.exception.DataAccessException -��ȡ���ݿ����ݷ�������ʱ�׳��쳣
	 * @return List<Category>
	 */
	List<Category> loadAll();
}
