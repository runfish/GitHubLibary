/**
 * 
 */
package net.dfrz.supershop01.domain;

import java.util.List;


/**
 * Project: supershop01-02
 * ClassName: Category
 * Module ID: 3.6 
 * Comments: 定义商品类别对象的模版
 * JDK :jdk1.6.0_10
 * Create Date： 2013-1-8
 * @see #ctgId
 * @see #ctgName
 * @see #ctgRank
 * @author: J1205-YouHQ
 * @version: Version 3
 */
public class Category {
	public Category() {
		super();
	}
	public Category(Integer ctgId) {
		super();
		this.ctgId = ctgId;
	}
	/**
	 * 商品类别编号
	 */
	private Integer ctgId;
	/**
	 * 商品类别名称
	 */
	private String ctgName;
	/**
	 * 商品类别状态
	 */
	private String ctgStatus; 
	/**
	 * 子类表列表
	 */
	private List<SmallCategory> smallCategory;
	
	
	/**
	 * 获取商品类别编号
	 * @return Integer
	 */
	public Integer getCtgId() {
		return ctgId;
	}
	/**
	 * 修改商品类别编号
	 * @param ctgId
	 */
	public void setCtgId(Integer ctgId) {
		this.ctgId = ctgId;
	}
	/**
	 * 获取商品类别名称
	 * @return String
	 */
	public String getCtgName() {
		return ctgName;
	}
	/**
	 * 修改商品类别名称
	 * @param ctgName
	 */
	public void setCtgName(String ctgName) {
		this.ctgName = ctgName;
	}
	/**
	 * 获取商品类别状态
	 * @return Integer
	 */
	public String getCtgStatus() {
		return ctgStatus;
	}
	/**
	 * 修改商品类别状态
	 * @param ctgRank
	 */
	public void setCtgStatus(String ctgStatus) {
		this.ctgStatus = ctgStatus;
	}
	/**
	 * 获取子类表列表
	 * @return ctgs
	 */
	public List<SmallCategory> getSmallCategory() {
		return smallCategory;
	}
	/**
	 * 修改子类表列表
	 * @param ctgs
	 */
	public void setSmallCategory(List<SmallCategory> smallCategory) {
		this.smallCategory = smallCategory;
	}
	

	public String toString() {
		// TODO Auto-generated method stub
		return this.ctgId+":"+this.ctgName+":"+this.ctgStatus;
	}
}
