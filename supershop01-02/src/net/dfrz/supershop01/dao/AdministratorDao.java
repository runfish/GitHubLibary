/**
 * 
 */
package net.dfrz.supershop01.dao;

import java.util.List;
import net.dfrz.supershop01.domain.Administrator;

/**
 * Project: supershop01-02 ClassName: AdministratorDao Module ID: 4.6 Comments:
 * �����ݲ�Ϊ��Ʒ�ṩ��ɾ�Ĳ��Լ���ȡ��ƷͼƬ�ĵȹ��� JDK :jdk1.6.0_10 Create Date�� 2013-1-6
 * @see java.util.List
 * @see net.dfrz.supershop01.domain.Goods
 * @see #delete(int)
 * @see #getAdministratorById(int)
 * @see #getAdministratorByName(String)
 * @see #getMaxId()
 * @see #loadAll()
 * @see #update(Administrator)
 * @see #save(Administrator)
 * @author J1205-YDP
 * @version Version 5
 */
public interface AdministratorDao {
	/**
	 * �����ݲ���XMl�ļ�����ӹ���Ա��Ϣ
	 * 
	 * @param administrator
	 */
	void save(Administrator administrator);

	/**
	 * ���ݹ���ԱID��ȡ����Ա��Ϣ
	 * 
	 * @param administratorId
	 * @return Administrator
	 */
	Administrator getAdministratorById(int administratorId);

	/**
	 * ���ݹ���Ա���û�����ȡ����Ա����Ϣ
	 * 
	 * @param administratorName
	 * @return Administrator
	 */
	Administrator getAdministratorByName(String administratorName);

	/**
	 * ��ȡ���й���Ա����Ϣ
	 * 
	 * @return List<Administrator>
	 */
	List<Administrator> loadAll();

	/**
	 * ���¹���Ա����Ϣ
	 * 
	 * @param administrator
	 */
	void update(Administrator administrator);

	/**
	 * ���ݹ���Ա��IDɾ���˹���Ա����Ϣ��
	 * 
	 * @param adminId
	 */
	void delete(int adminId);

	/**
	 * ��ȡXMl�ļ�������ID��
	 * 
	 * @return
	 */
	int getMaxId();

}
