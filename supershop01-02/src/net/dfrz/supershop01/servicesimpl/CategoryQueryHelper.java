package net.dfrz.supershop01.servicesimpl;

/**                
 * Project: supershop01-02
 * ClassName: CategoryQuryHelper                                                        
 * Module ID: 4.6  
 * Comments: 定义商品类别组合查询的模版  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-18    
 * @see #BigCategoryId
 * @see #smallCategoryName
 * @see #getBigCategoryId()
 * @see #getSmallCategoryName()
 * @see #setBigCategoryId(Integer)
 * @see #setSmallCategoryName(String)
 * @author J1205-YouHQ                                                                                                                       
 * @version: Version 5                                        
*/
public class CategoryQueryHelper {
	
	
	private Integer BigCategoryId;
	
	private String smallCategoryName;

	public CategoryQueryHelper() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取商品大类别ID
	 * @return the bigCategoryId
	 */
	public Integer getBigCategoryId() {
		return BigCategoryId;
	}

	/**
	 * 设置商品大类别信息
	 * @param bigCategoryId the bigCategoryId to set
	 */
	public void setBigCategoryId(Integer bigCategoryId) {
		BigCategoryId = bigCategoryId;
	}

	/**
	 * 获取商品小类别信息
	 * @return the smallCategoryName
	 */
	public String getSmallCategoryName() {
		return smallCategoryName;
	}

	/**
	 * 设置商品小类别信息
	 * @param smallCategoryName the smallCategoryName to set
	 */
	public void setSmallCategoryName(String smallCategoryName) {
		this.smallCategoryName = smallCategoryName;
	}
	
	
	
	
	
	

}
