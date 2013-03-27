package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.DealItemService;
import net.dfrz.supershop01.services.DealService;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.servicesimpl.DealItemServiceImpl;
import net.dfrz.supershop01.servicesimpl.DealServiceImpl;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;
import net.dfrz.supershop01.utils.Page;
/**                
 * Project: supershop01-01
 * ClassName: DealItemServlet                                                        
 * Module ID: 4.6  
 * Comments: 订单条目管理表现层 
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-2-6
 *@see java.io.IOException
 *@see java.io.PrintWriter
 *@see java.util.List
 *@see javax.servlet.ServletException
 *@see javax.servlet.http.HttpServlet
 *@see javax.servlet.http.HttpServletRequest
 *@see javax.servlet.http.HttpServletResponse
 *@see net.dfrz.supershop01.domain.Category
 *@see  net.dfrz.supershop01.domain.Deal
 *@see net.dfrz.supershop01.domain.DealItem
 *@see  net.dfrz.supershop01.domain.Goods
 *@see  net.dfrz.supershop01.domain.SmallCategory
 *@see net.dfrz.supershop01.exception.ApplicationException
 *@see  net.dfrz.supershop01.services.DealItemService
 *@see  net.dfrz.supershop01.services.DealService
 *@see  net.dfrz.supershop01.services.GoodsService
 *@see  net.dfrz.supershop01.services.SmallCategoryService
 *@see  net.dfrz.supershop01.servicesimpl.DealItemServiceImpl
 *@see net.dfrz.supershop01.servicesimpl.DealServiceImpl
 *@see  net.dfrz.supershop01.servicesimpl.GoodsServiceImpl
 *@see  net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl
 *@see net.dfrz.supershop01.utils.Page
 *@see #doPost(HttpServletRequest, HttpServletResponse)
 *@see #doGet(HttpServletRequest, HttpServletResponse)
 * @author J1205-HongHG                                                      
 * @version Version 150 
 */
public class DealItemServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	
	public DealItemServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String act=request.getParameter("act");
		/**
		 * 获取要查询的订单的所有订单条目的信息以及其他详细信息，封装成HTML页面返回用户界面
		 */
		if("loadPageDealItem".equals(act))
		{
			/**
			 * 获取要查询详细信息的订单编号
			 */
			Integer dealId=Integer.parseInt(request.getParameter("dealid"));
			request.getSession(false).setAttribute("dealId", dealId);
			
			try 
			{
				/**
				 * 从数据库获取相关的订单信息进行封装
				 */
				
				
				/**
				 * 创建html页面，以便显示订单的详细信息
				 */
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				/**
				 * 获取要查看详细信息的订单对象
				 */
				DealService dealService=new DealServiceImpl();
				Deal deal=dealService.getDealById(dealId);
				
				out.print("<div>");
				out.print("<div style=\"border:1px solid gray;background:#eae7d7\">");
				out.print("订单基本信息");
				out.print("</div>");
				out.print("<div>");
				out.print("收货人名:"+deal.getConsigneeInfo().split(":")[0]);
				out.print("</div>");
				out.print("<div>");
				out.print("收货地址："+deal.getConsigneeInfo().split(":")[1]);
				out.print("</div>");
				out.print("<div>");
				out.print("邮政编码："+deal.getConsigneeInfo().split(":")[2]);
				out.print("</div>");
				out.print("<div>");
				out.print("联系方式："+deal.getConsigneeInfo().split(":")[3]);
				out.print("</div>");
				out.print("<div>");
				out.print("电子邮箱："+deal.getConsigneeInfo().split(":")[4]);
				out.print("</div>");
				out.print("<hr>");
				if(deal.getPayPattern().equals("b"))
				{
					out.print("<div>");
					out.print("付款方式：账户支付");
					out.print("</div>");
				}
				else if(deal.getPayPattern().equals("c"))
				{
					out.print("<div>");
					out.print("付款方式：网银支付");
					out.print("</div>");
				}
				if(deal.getReceivePattern().equals("b"))
				{
					out.print("<div>");
					out.print("收货方式：平邮");
					out.print("</div>");
				}
				if(deal.getReceivePattern().equals("c"))
				{
					out.print("<div>");
					out.print("收货方式：快递");
					out.print("</div>");
				}
				if(deal.getReceivePattern().equals("d"))
				{
					out.print("<div>");
					out.print("收货方式：ESM");
					out.print("</div>");
				}
				out.print("<hr>");
				out.print("<div>");
				out.print("下单时间："+deal.getDealDate());
				out.print("</div>");
				if(deal.getDealStatus().equals("a"))
				{
					out.print("<div>");
					out.print("订单状态：未发货");
					out.print("</div>");
				}
				if(deal.getDealStatus().equals("b"))
				{
					out.print("<div>");
					out.print("订单状态：已发货");
					out.print("</div>");
				}
				if(deal.getDealStatus().equals("c"))
				{
					out.print("<div>");
					out.print("订单状态：已退货");
					out.print("</div>");
				}
				if(deal.getDealExamDate()!=null)
				{
					out.print("<div>");
					out.print("审核时间："+deal.getDealExamDate());
					out.print("</div>");
				}
				else
				{
					out.print("<div>");
					out.print("审核时间：------");
					out.print("</div>");
				}
				/**
				 * 获取订单详细信息所需的订单条目信息
				 * 为被查询的订单下的所有订单条目重新编写订单条目编号itemId
				 */
				Page pagedDealItem=new Page();
				pagedDealItem.setPageSize(50);
				DealItemService dealItemService=new DealItemServiceImpl();
				pagedDealItem=dealItemService.loadPage(pagedDealItem, dealId);
				List<DealItem>dealItemList=(List<DealItem>)pagedDealItem.getPageContent();
			    Integer itemId  =  new Integer(1);
				
				out.print("<div style=\"border:1px solid gray;background:#eae7d7\">");
				out.print("订单条目信息");
				out.print("</div>");
				out.print("<div>");
				out.println("<table id=\"listtable\" cellpadding=\"0\" cellspacing=\"0\">");
				out.println("<tr>");
				out.print("<th>");
				out.print("条目编号");
				out.print("</th>");
				out.print("<th>");
				out.print("商品名称");
				out.print("</th>");
				out.print("<th>");
				out.print("商品类型");
				out.print("</th>");
				out.print("<th>");
				out.print("商品单价");
				out.print("</th>");
				out.print("<th>");
				out.print("商品数量");
				out.print("</th>");
				out.print("<th>");
				out.print("商品总额");
				out.print("</th>");
				out.println("</tr>");
				for(DealItem item:dealItemList)
				{
					out.println("<tr>");
					out.print("<td>");
					out.print(itemId++);
					out.print("</td>");
					out.print("<td>");
					/**
					 * 获取订单详细信息所需的商品信息
					 */
					GoodsService goodsService=new GoodsServiceImpl();
					Goods goods=goodsService.getGoodsById(item.getDealGoodsId());
					out.print("<a href='/shop01/action/goodsMgr?act=getgoodsdetail&bigctgid=index&goodsid="+goods.getGoodsId()+"'" +
							 "target='_blank' title='点击查看商品详细信息'>" +
							goods.getGoodsName()+"</a>");
					out.print("</td>");
					out.print("<td>");
					/**
					 * 获取订单详细信息所需的商品类别信息
					 */
					SmallCategoryService smallCategoryService=new SmallCategoryServiceImpl();
					SmallCategory smallCategory=smallCategoryService.getCtg(item.getDealGoodsCtgId());
					Category category=smallCategory.getBigCategory();
					out.print(category.getCtgName()+"->"+smallCategory.getSmallCtgName());
					out.print("</td>");
					out.print("<td>");
					out.print(item.getItemGoodsPrice());
					out.print("</td>");
					out.print("<td>");
					out.print(item.getItemGoodsQty());
					out.print("</td>");
					out.print("<td>");
					out.print(item.getItemGoodsPrice()*item.getItemGoodsQty());
					out.print("</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.print("</div>");
				out.print("<div>");
				out.print("<input type=\"button\" value=\"返回\" title=\"点击返回订单列表\" onclick=\"cleanChild(this)\" style=\"width:80px;\" />");
				out.print("</div>");
				out.print("</div>");
				
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
