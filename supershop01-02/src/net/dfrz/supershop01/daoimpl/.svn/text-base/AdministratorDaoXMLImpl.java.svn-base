/**
 * 
 */
package net.dfrz.supershop01.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import net.dfrz.supershop01.dao.AdministratorDao;
import net.dfrz.supershop01.domain.Administrator;
import net.dfrz.supershop01.utils.LoadProperties;

/**
 * Project: supershop01-02 ClassName: AdministratorDaoXMLImpl Module ID: 4.6
 * Comments: 是AdministratorDao的实现类 JDK :jdk1.6.0_10 Create Date： 2013-1-6
 * @see java.io.File
 * @see java.io.FileInputStream
 * @see java.io.FileNotFoundException
 * @see java.io.FileWriter
 * @see java.io.IOException
 * @see java.io.InputStreamReader
 * @see java.util.ArrayList
 * @see java.util.List
 * @see org.apache.log4j.Logger
 * @see org.dom4j.Document
 * @see org.dom4j.DocumentException
 * @see org.dom4j.DocumentHelper
 * @see org.dom4j.Element
 * @see org.dom4j.io.OutputFormat
 * @see org.dom4j.io.SAXReader
 * @see org.dom4j.io.XMLWriter
 * @see net.dfrz.supershop01.dao.AdministratorDao
 * @see net.dfrz.supershop01.domain.Administrator
 * @see net.dfrz.supershop01.utils.LoadProperties
 * @see #delete(int)
 * @see #getAdministratorById(int)
 * @see #getAdministratorByName(String)
 * @see #getMaxId()
 * @see #loadAll()
 * @see #update(Administrator)
 * @see #save(Administrator)
 * @see #readDoc()
 * @see #saveDoc(Document)
 * @author J1205-YDP
 * @version Version 5
 * 
 */             
public class AdministratorDaoXMLImpl implements AdministratorDao {
	/**
	 * 日志
	 */
	private static final Logger LOGGER = Logger
			.getLogger(AdministratorDaoXMLImpl.class);

	/**
	 * XML文件路径 根据配置文件写入
	 */
	private final String STORE_FILE = LoadProperties.loadProperties("filePath");

	// private static final String STORE_FILE="d:/administrator.xml";

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.dfrz.supershop01.dao.AdministratorDao#save(net.dfrz.supershop01.domain.Administrator)
	 */
	public void save(Administrator administrator) {
		// TODO Auto-generated method stub

		File file = new File(STORE_FILE);

		if (!file.exists()) {
			LOGGER.info("管理员的xml文件不存在，开始创建.....");
			Document doc = DocumentHelper.createDocument();

			Element administratorListElement = doc
					.addElement("administratorList");

			Element administratorElement = administratorListElement
					.addElement("administrator");

			administratorElement.addAttribute("administratorId", String
					.valueOf(administrator.getAdministratorId()));
			administratorElement.addAttribute("administratorName",
					administrator.getAdministratorName());
			administratorElement.addAttribute("administratorPassword",
					administrator.getAdministratorPassword());
			administratorElement.addAttribute("realName", administrator
					.getRealName());
			administratorElement.addAttribute("birthday", administrator
					.getBirthday());
			administratorElement.addAttribute("telNum", administrator
					.getTelNum());
			administratorElement.addAttribute("address", administrator
					.getAddress());
			administratorElement
					.addAttribute("email", administrator.getEmail());
			administratorElement.addAttribute("postCode", administrator
					.getPostCode());
			administratorElement.addAttribute("isSuperAdministrator", String
					.valueOf(administrator.getIsSuperAdministrator()));
			administratorElement.addAttribute("isFreeze", String
					.valueOf(administrator.getIsFreeze()));

			saveDoc(doc);
			LOGGER.info("xml文件创建成功！");

		} else {
			LOGGER.info("管理员的xml文件已经存在，开始更新.....");
			Document doc = this.readDoc();
			Element administratorListElement = doc.getRootElement();
			Element administratorElement = administratorListElement
					.addElement("administrator");

			administratorElement.addAttribute("administratorId", String
					.valueOf(administrator.getAdministratorId()));
			administratorElement.addAttribute("administratorName",
					administrator.getAdministratorName());
			administratorElement.addAttribute("administratorPassword",
					administrator.getAdministratorPassword());
			administratorElement.addAttribute("realName", administrator
					.getRealName());
			administratorElement.addAttribute("birthday", administrator
					.getBirthday());
			administratorElement.addAttribute("telNum", administrator
					.getTelNum());
			administratorElement.addAttribute("address", administrator
					.getAddress());
			administratorElement
					.addAttribute("email", administrator.getEmail());
			administratorElement.addAttribute("postCode", administrator
					.getPostCode());
			administratorElement.addAttribute("isSuperAdministrator", String
					.valueOf(administrator.getIsSuperAdministrator()));
			administratorElement.addAttribute("isFreeze", String
					.valueOf(administrator.getIsFreeze()));

			saveDoc(doc);
			LOGGER.info("xml文件更新完毕！");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.dfrz.supershop01.dao.AdministratorDao#delete(net.dfrz.supershop01.domain.Administrator)
	 */
	public void delete(int adminId) {
		// TODO Auto-generated method stub
		LOGGER.info("开始删除管理员.....");
		Document doc = this.readDoc();

		List administrators = doc
				.selectNodes("/administratorList/administrator[@administratorId='"
						+ adminId + "']");
		LOGGER.info("选中要删除的管理员的id！");
		for (int i = 0; i < administrators.size(); i++) {
			Element e = (Element) administrators.get(i);
			e.detach();
		}
		LOGGER.info("删除成功！开始保存.....");
		this.saveDoc(doc);
		LOGGER.info("保存成功！");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.dfrz.supershop01.dao.AdministratorDao#getAdministratorById(java.lang.Integer)
	 */
	public Administrator getAdministratorById(int administratorId) {
		// TODO Auto-generated method stub
		Document doc = this.readDoc();
		;
		List administrators = doc
				.selectNodes("/administratorList/administrator[@administratorId='"
						+ administratorId + "']");
		LOGGER.info("选中管理员的id！");
		Element administratorElement = (Element) administrators.get(0);

		Administrator administrator = new Administrator();
		LOGGER.info("开始设置管理员各个字段信息.....");
		administrator.setAdministratorId(Integer.parseInt(administratorElement
				.attribute("administratorId").getValue()));
		administrator.setAdministratorName(administratorElement.attribute(
				"administratorName").getValue());
		administrator.setAdministratorPassword(administratorElement.attribute(
				"administratorPassword").getValue());
		administrator.setRealName(administratorElement.attribute("realName")
				.getValue());
		administrator.setBirthday(administratorElement.attribute("birthday")
				.getValue());
		administrator.setTelNum(administratorElement.attribute("telNum")
				.getValue());
		administrator.setAddress(administratorElement.attribute("address")
				.getValue());
		administrator.setEmail(administratorElement.attribute("email")
				.getValue());
		administrator.setPostCode(administratorElement.attribute("postCode")
				.getValue());
		administrator.setSuperAdministrator(Boolean
				.parseBoolean(administratorElement.attribute(
						"isSuperAdministrator").getValue()));
		administrator.setIsFreeze(Boolean.parseBoolean(administratorElement
				.attribute("isFreeze").getValue()));

		LOGGER.info("管理员字段信息设置完毕！");
		return administrator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.dfrz.supershop01.dao.AdministratorDao#loadAll()
	 */
	public List<Administrator> loadAll() {
		// TODO Auto-generated method stub
		LOGGER.info("开始读取管理员的xml文件.....！");
		Document doc = this.readDoc();
		LOGGER.info("文件读取成功！");
		List administrators = doc.selectNodes("//administrator");
		LOGGER.info("选中管理员所有信息！");
		List<Administrator> booklist = new ArrayList<Administrator>();
		LOGGER.info("开始显示管理员所有信息.....");
		for (int i = 0; i < administrators.size(); i++) {
			Element administratorElement = (Element) administrators.get(i);
			Administrator administrator = new Administrator();
			administrator.setAdministratorId(Integer
					.parseInt(administratorElement.attribute("administratorId")
							.getValue()));
			administrator.setAdministratorName(administratorElement.attribute(
					"administratorName").getValue());
			administrator.setAdministratorPassword(administratorElement
					.attribute("administratorPassword").getValue());
			administrator.setRealName(administratorElement
					.attribute("realName").getValue());
			administrator.setBirthday(administratorElement
					.attribute("birthday").getValue());
			administrator.setTelNum(administratorElement.attribute("telNum")
					.getValue());
			administrator.setAddress(administratorElement.attribute("address")
					.getValue());
			administrator.setEmail(administratorElement.attribute("email")
					.getValue());
			administrator.setPostCode(administratorElement
					.attribute("postCode").getValue());
			administrator.setSuperAdministrator(Boolean
					.parseBoolean(administratorElement.attribute(
							"isSuperAdministrator").getValue()));
			administrator.setIsFreeze(Boolean.parseBoolean(administratorElement
					.attribute("isFreeze").getValue()));

			booklist.add(administrator);
		}
		LOGGER.info("管理员信息显示完毕！");
		return booklist;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.dfrz.supershop01.dao.AdministratorDao#update(net.dfrz.supershop01.domain.Administrator)
	 */
	public void update(Administrator administrator) {
		// TODO Auto-generated method stub
		LOGGER.info("开始读取管理员的xml文件.....");
		Document doc = this.readDoc();
		LOGGER.info("文件读取成功！");

		List administrators = doc
				.selectNodes("/administratorList/administrator[@administratorId='"
						+ administrator.getAdministratorId() + "']");
		LOGGER.info("选中管理员的id！");
		LOGGER.info("开始设置管理员的各个参数.....");
		Element administratorElement = (Element) administrators.get(0);
		administratorElement.attribute("administratorId").setValue(
				String.valueOf(administrator.getAdministratorId()));
		administratorElement.attribute("administratorName").setValue(
				administrator.getAdministratorName());
		administratorElement.attribute("administratorPassword").setValue(
				administrator.getAdministratorPassword());
		administratorElement.attribute("realName").setValue(
				administrator.getRealName());
		administratorElement.attribute("birthday").setValue(
				administrator.getBirthday());
		administratorElement.attribute("telNum").setValue(
				administrator.getTelNum());
		administratorElement.attribute("address").setValue(
				administrator.getAddress());
		administratorElement.attribute("email").setValue(
				administrator.getEmail());
		administratorElement.attribute("postCode").setValue(
				administrator.getPostCode());
		administratorElement.attribute("isSuperAdministrator").setValue(
				String.valueOf(administrator.getIsSuperAdministrator()));
		administratorElement.attribute("isFreeze").setValue(
				String.valueOf(administrator.getIsFreeze()));

		this.saveDoc(doc);
		LOGGER.info("参数设置成功！更新完毕！保存成功！");

	}

	/**
	 * 把一个内存中的document对象保存成xml文件
	 * 
	 * @param doc
	 */
	private void saveDoc(Document doc) {

		File f = new File(STORE_FILE);
		XMLWriter writer = null;

		OutputFormat of = OutputFormat.createPrettyPrint(); // 美化xml数据的格式
		// of.setEncoding("utf-8");

		try {
			writer = new XMLWriter(new FileWriter(f), of);
			writer.write(doc);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("生成xml文件发生错误！");
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.error("xml文件关闭失败！");
			}
		}
	}

	private Document readDoc() {
		// TODO Auto-generated method stub
		File f = new File(STORE_FILE);

		SAXReader reader = new SAXReader();

		Document doc = null;

		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader iReader = new InputStreamReader(fis);
			doc = reader.read(iReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("没有找到指定的xml文件！");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("xml文件读取失败！");
		}

		return doc;
	}

	public int getMaxId() {
		// TODO Auto-generated method stub
		LOGGER.info("获取超级管理员id！");
		List<Administrator> adminList = null;
		adminList = this.loadAll();

		int[] countId = new int[adminList.size()];
		int index = 0;
		for (Administrator administrator : adminList) {
			countId[index] = administrator.getAdministratorId();
			index++;
		}
		for (int i = 0; i < countId.length; i++) {
			for (int j = i + 1; j < countId.length; j++) {
				if (countId[i] < countId[j]) {
					int temp = countId[i];
					countId[i] = countId[j];
					countId[j] = temp;
				}
			}
		}

		return countId[0];
	}

	public Administrator getAdministratorByName(String administratorName) {
		// TODO Auto-generated method stub

		LOGGER.info("开始读取xml文件.....");
		Document doc = this.readDoc();
		LOGGER.info("xml文件读取成功！");

		List administrators = doc
				.selectNodes("/administratorList/administrator[@administratorName='"
						+ administratorName + "']");
		LOGGER.info("选中管理员的账号名！");
		Element administratorElement = (Element) administrators.get(0);

		Administrator administrator = new Administrator();
		LOGGER.info("开始设置管理员的各个参数.....");
		administrator.setAdministratorId(Integer.parseInt(administratorElement
				.attribute("administratorId").getValue()));
		administrator.setAdministratorName(administratorElement.attribute(
				"administratorName").getValue());
		administrator.setAdministratorPassword(administratorElement.attribute(
				"administratorPassword").getValue());
		administrator.setRealName(administratorElement.attribute("realName")
				.getValue());
		administrator.setBirthday(administratorElement.attribute("birthday")
				.getValue());
		administrator.setTelNum(administratorElement.attribute("telNum")
				.getValue());
		administrator.setAddress(administratorElement.attribute("address")
				.getValue());
		administrator.setEmail(administratorElement.attribute("email")
				.getValue());
		administrator.setPostCode(administratorElement.attribute("postCode")
				.getValue());
		administrator.setSuperAdministrator(Boolean
				.parseBoolean(administratorElement.attribute(
						"isSuperAdministrator").getValue()));
		administrator.setIsFreeze(Boolean.parseBoolean(administratorElement
				.attribute("isFreeze").getValue()));
		LOGGER.info("管理员参数设置完毕！");
		return administrator;
	}
}
