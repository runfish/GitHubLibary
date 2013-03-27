/**
 * 
 */
package net.dfrz.supershop01.domain;

import java.util.List;

/**
 * Project: supershop01-02
 * ClassName: SamllCategory 
 * Module ID: 3.6 Comments:
 * 定义商品小类别对象的模版 
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-2-8
 * @see #smallCtgId
 * @see #smallCtgName
 * @see #smallCtgStatus
 * @see #bigCategory
 * @see #goodsList
 * @see #getBigCategory()
 * @see #getGoodsList()
 * @see #getSmallCtgId()
 * @see #getSmallCtgName()
 * @see #getSmallCtgStatus()
 * @see #setBigCategory(Category)
 * @see #setGoodsList(List)
 * @see #setSmallCtgId(int)
 * @see #setSmallCtgStatus(String)
 * @author J1205-YouHQ
 * @version Version 3
 */
public class SmallCategory {
	private int smallCtgId;
	private String smallCtgName;
	private String smallCtgStatus;
	private Category bigCategory;
	private List<Goods> goodsList;

	public int getSmallCtgId() {
		return smallCtgId;
	}

	public void setSmallCtgId(int smallCtgId) {
		this.smallCtgId = smallCtgId;
	}

	public String getSmallCtgName() {
		return smallCtgName;
	}

	public void setSmallCtgName(String smallCtgName) {
		this.smallCtgName = smallCtgName;
	}

	public String getSmallCtgStatus() {
		return smallCtgStatus;
	}

	public void setSmallCtgStatus(String smallCtgStatus) {
		this.smallCtgStatus = smallCtgStatus;
	}

	public Category getBigCategory() {
		return bigCategory;
	}

	public void setBigCategory(Category bigCategory) {
		this.bigCategory = bigCategory;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return this.smallCtgName + ":" + this.bigCategory.getCtgName();
	}

}
