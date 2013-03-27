package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.DealService;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.servicesimpl.DealServiceImpl;
import net.dfrz.supershop01.utils.Page;
/**                
 * Project: supershop01-02
 * ClassName: DealServlet                                                          
 * Comments: 订单处理表现层  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-16
 * @see java.io.IOException
 * @see java.io.PrintWriter
 * @see java.sql.Date
 * @see javax.servlet.ServletException
 * @see javax.servlet.http.HttpServlet
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @see net.dfrz.supershop01.domain.Deal
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.services.DealService
 * @see net.dfrz.supershop01.servicesimpl.DealQuryHelper
 * @see net.dfrz.supershop01.servicesimpl.DealServiceImpl
 * @see net.dfrz.supershop01.utils.Page
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @see #doPost(HttpServletRequest, HttpServletResponse)
 * @author J1205-HongHG
 * @version 90
 */
public class DealServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DealServlet() {
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
		
		if("loadPageDeal".equals(act))
		{
			/**
			 * 创建一个的组合查询的帮助对象
			 */
			
			DealQuryHelper helper=new DealQuryHelper(); 
			
			/**
			 * 根据用户的具体查询条件，封装组合查询的帮助对象
			 */
			
			if(request.getParameter("qurydealid")!=null&&request.getParameter("qurydealid").length()>0)
			{
				helper.setDealId(Integer.parseInt(request.getParameter("qurydealid")));
			}
			if(request.getParameter("qurydealstatus")!=null)
			{
				helper.setDealStatus(request.getParameter("qurydealstatus"));
			}
			if(request.getParameter("qurydealdate")!=null)
			{
				helper.setDealDate(request.getParameter("qurydealdate"));
			}
			if(request.getParameter("quryisaccept")!=null)
			{
				helper.setIsAccept(Integer.parseInt(request.getParameter("quryisaccept")));
			}
			/**
			 * 创建一个新的页面对象，并赋初值
			 */
			Integer pageNo=null;
			Page pagedDeal=new Page();
			pagedDeal.setPageSize(18);
			
			if(request.getParameter("pageno")!=null)
			{
				pageNo=Integer.parseInt(request.getParameter("pageno"));
			}
			
			if(pageNo!=null)pagedDeal.setPageNo(pageNo);
			/**
			 * 获取符合条件的所有商品订单信息
			 */
			try
			{	
				DealService dealService=new DealServiceImpl();
				pagedDeal=dealService.loadPage(pagedDeal, helper);
			}
			catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			}
			
			request.setAttribute("pagedDeal", pagedDeal);
			
			request.getRequestDispatcher("/jsps/deals/deals_list.jsp").forward(request, response);
		}
		else if(act.equals("del")) 
		{
			/**
			 * 将已经通过审核并且已经成功查收的订单的全部信息删除
			 * 获取要删除的订单编号
			 */
			Integer dealId=Integer.parseInt(request.getParameter("dealid"));
			/**
			 * 执行删除操作
			 */
			try 
			{
				DealService dealService=new DealServiceImpl();
				dealService.deleteDeal(dealService.getDealById(dealId));
				request.setAttribute("error","订单编号为："+dealId+"的订单信息已经成功删除！");
			
			} catch (ApplicationException e)
			{
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			}
			response.sendRedirect("/shop02/action/dealMgr?act=loadPageDeal");
		}
		else if(act.equals("update"))
		{
			request.setCharacterEncoding("utf-8");
			/**
			 * 获取订单修改的属性的类型
			 */
			String type=request.getParameter("type");
			/**
			 * 下拉列表选中的值以及订单条目编号
			 */
			String Value=request.getParameter("selectedvalue");
			String selectedValue=new String(Value.getBytes("iso-8859-1"),"utf-8");
			Integer dealId=Integer.parseInt(request.getParameter("dealid"));
			response.setCharacterEncoding("utf-8");
			try 
			{
				/**
				 * 获取要修改的商品订单对象
				 */
				DealService dealService=new DealServiceImpl();
				Deal deal=dealService.getDealById(dealId);
				/**
				 * 根据type的值确定此次操作的类型，对订单对象进行修改
				 */
			    if(type.equals("payPattern"))
			    {
			    	deal.setPayPattern(selectedValue);
			    }
			    else if(type.equals("receivePattern"))
			    {
			    	deal.setReceivePattern(selectedValue);
			    }
			    else if(type.equals("consigneeInfo"))
			    {
			    	deal.setConsigneeInfo(selectedValue);
			    }
			    else if(type.equals("dealExam"))
			    {
			    	String date=request.getParameter("date");
			    	Date sqlDate=java.sql.Date.valueOf(date);
			    	deal.setDealExamDate(sqlDate);
					deal.setDealStatus(selectedValue);
				}
			    dealService.updateDeal(deal);
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				PrintWriter pw=response.getWriter();
				pw.write("error|"+e.getMessage());
				pw.flush();
				pw.close();
			} 
			
			PrintWriter pw=response.getWriter();
			pw.write("input|"+selectedValue.toString());
			pw.flush();
			pw.close();
		}
		else if(act.equals("getDealInfo"))
		{
			response.setCharacterEncoding("utf-8");
			/**
			 * 获取要展示的信息类型（收货人信息、订单信息）
			 */
			String type=request.getParameter("type");
			/**
			 * 获得需要显示详细信息的订单编号
			 */
			Integer dealId=Integer.parseInt(request.getParameter("dealid"));
			/**
			 * 存放信息的数据缓冲区
			 */
			StringBuffer buffer=new StringBuffer();
			
			try 
			{
				/**
				 * 获取要显示的订单详细信息的对象
				 */
				Deal deal=null;	
				DealService dealService=new DealServiceImpl();
				deal=dealService.getDealById(dealId);
				
				String[]dealInfo=null;
				dealInfo=deal.toString().split(":");
				
				if(type.equals("part"))
				{
					buffer.append("input|");
					buffer.append(dealInfo[0]+":");
					buffer.append(dealInfo[1]+":");
					buffer.append(dealInfo[2]+":");
					buffer.append(dealInfo[3]+":");
					buffer.append(dealInfo[4]);
				}
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				PrintWriter pw=response.getWriter();
				pw.write("error|"+e.getMessage());
				pw.flush();
				pw.close();
			}
			
			PrintWriter pw=response.getWriter();
			pw.write(buffer.toString());
			pw.flush();
			pw.close();
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
