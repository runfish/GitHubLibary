/**
 * 
 */
package net.dfrz.supershop01.utils;

import java.util.Collection;

/**                
 * Project: supershop01-01
 * ClassName: Page                                                        
 * Module ID: 4.6  
 * Comments: 分页显示类  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see java.util.Collection
 * @see #pageNo
 * @see #pageSize
 * @see #nextPage
 * @see #prePage
 * @see #totalRecNum
 * @see #totalPageNum
 * @see #pageContent
 * @see #startIndex
 * @see #endIndex
 * @see #Page()
 * @see #getPageNo()
 * @see #getPageSize()
 * @see #getNextPage()
 * @see #getPrePage()
 * @see #getTotalRecNum()
 * @see #getTotalPageNum()
 * @see #getPageContent()
 * @see #getStartIndex()
 * @see #getEndIndex()
 * @see #setPageNo(Integer)
 * @see #setPageSize(Integer)
 * @see #setTotalRecNum(Long)
 * @see #setPageContent(Collection)
 * @author J1205-supershop01                                                      
 * @version Version 10 
 */
public class Page {
	/**
	 * 当前页号
	 */
    private Integer pageNo;    
    /**
     * 每页记录条数
     */
    private Integer pageSize;  
    /**
     * 是否有下一页
     */
    private Boolean nextPage;  
    /**
     * 是否有上一页
     */
    private Boolean prePage;   
    /**
     * 总共有多少条记录
     */
    private Long totalRecNum;  
    /**
     * 总共多少页
     */
    private Integer totalPageNum;
    /**
     * 该页的数据(记录明细)
     */
    private Collection pageContent; 
    /**
     * 记录开始位置
     */
    private Integer startIndex; 
    /**
     * 记录结束位置
     */
    private Integer endIndex;   
    /**
     * 构造函数
     */   
	public Page() {
		super();
        pageNo=1;
        pageSize=9;
	}
	/**
	 * 获取当前的页面号数
	 * @return Integer
	 */
	public Integer getPageNo() {
		return pageNo;
	}
	/**
	 * 设置当前的页面号数
	 * @param pageNo -当前的页面号数
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * 设置页面的记录容量
	 * @return Integer
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * 修改页面的记录容量大小
	 * @param pageSize -当前的页面的容量大小
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 查看是否还有下一页
	 * @return Boolean
	 */
	public Boolean getNextPage() {
		return pageNo<getTotalPageNum()?true:false;
	}
    /**
     * 查看是否有前一页
     * @return Boolean
     */
	public Boolean getPrePage() {
		return pageNo>1?true:false;
	}
    /**
     * 获取当前的记录的总数
     * @return Long
     */
	public Long getTotalRecNum() {
		return totalRecNum;
	}
	/**
	 * 设置记录的总数
	 * @param totalRecNum -当前的记录总数
	 */
	public void setTotalRecNum(Long totalRecNum) {
		this.totalRecNum = totalRecNum;
	}
	/**
	 * 查看当前的页面总数
	 * @return Integer
	 */
	public Integer getTotalPageNum() {
		//13%5=3  13/5+1=3
		return totalRecNum%pageSize>0?(int)(totalRecNum/pageSize+1):(int)(totalRecNum/pageSize);
	}
    /**
     * 获取页面中的记录数组
     * @return Collection
     */
	public Collection getPageContent() {
		return pageContent;
	}
	/**
	 * 修改页面中的记录数组
	 * @param pageContent -页面对象中存放的记录数组
	 */
	public void setPageContent(Collection pageContent) {
		this.pageContent = pageContent;
	}
    /**
     * 获取当前页面的起始位置的编号
     * @return int
     */
	public int getStartIndex()
	{
		return pageSize*(pageNo-1)+1;  // size:10 pageno:3   21
	}
    /**
     * 获取当前页面的结束位置的编号
     * @return int
     */
	public int getEndIndex()
	{
		return (pageSize*pageNo>this.totalRecNum)? (int)(this.totalRecNum.longValue()):(pageSize*pageNo);
	}
    
}
