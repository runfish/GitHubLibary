package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.ShoppingCart;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.CustomerService;
import net.dfrz.supershop01.services.DealService;
import net.dfrz.supershop01.servicesimpl.CustomerServiceImpl;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.servicesimpl.DealServiceImpl;
import net.dfrz.supershop01.utils.Page;
/**                
 * Project: supershop01-01
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
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.domain.Deal
 * @see net.dfrz.supershop01.domain.ShoppingCart
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.services.CustomerService
 * @see net.dfrz.supershop01.services.DealService
 * @see net.dfrz.supershop01.servicesimpl.CustomerServiceImpl
 * @see net.dfrz.supershop01.servicesimpl.DealQuryHelper
 * @see net.dfrz.supershop01.servicesimpl.DealServiceImpl
 * @see net.dfrz.supershop01.utils.Page
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @see #doPost(HttpServletRequest, HttpServletResponse)
 * @author J1205-HongHG
 * @version 90
 */
public class DealServlet extends HttpServlet {
	private static final Logger LOGGER=Logger.getLogger(DealServlet.class);
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
		
		if("add".equals(act))
		{
			/**
			 * 获取新增订单信息
			 */
			String consigneeName=request.getParameter("consignee_name");
			String address=request.getParameter("address");
			String postCode=request.getParameter("post_code");
			String tel=request.getParameter("tel");
			String email=request.getParameter("email");
			String payPattern=request.getParameter("pay_pattern");
			String receivePattern=request.getParameter("receive_pattern");
			ShoppingCart myCart=(ShoppingCart)request.getSession().getAttribute("mycart");
			double  mycartTotalAmount = Double.parseDouble(request.getParameter("mycart_totalAmount")); 
			/**
			 * 获取当前的用户信息
			 */
			Customer customer = (Customer)request.getSession().getAttribute("customer");
			
			/**
			 * 创建下单日期
			 */
			java.util.Date date=new java.util.Date();
			String timeString=(date.getYear()+1900)+"-";
			if (date.getMonth()+1<10)
			{
				timeString+="0"+(date.getMonth()+1)+"-";
			}
			else
			{
				timeString+=(date.getMonth()+1)+"-";
			}
			if(date.getDate()<10)
			{
				timeString+="0"+date.getDate();
				System.out.println(date.getDate());
			}
			else
			{
				timeString+=date.getDate();
			}
			Date sqlDate=java.sql.Date.valueOf(timeString);
			/**
			 * 封装新增的订单信息
			 */
			Deal deal=new Deal();
			deal.setDealCustomerId(Integer.parseInt(customer.getCustomerId()));
			deal.setConsigneeInfo(consigneeName+":"+address+":"+postCode+":"+tel+":"+email);
			deal.setPayPattern(payPattern);
			deal.setReceivePattern(receivePattern);
			deal.setDealDate(sqlDate);
			deal.setDealStatus("a");
			deal.setIsAccept(0);
			
			try 
			{
				/**
				 * 对新的订单对象进行存储操作
				 */
				DealService dealService=new DealServiceImpl();
				dealService.addDeal(deal,myCart,customer);
				/**
				 * 完成订单提交后，将Session空间中的购物车信息清空
				 */
				request.getSession().removeAttribute("mycart");
				LOGGER.info("订单已提交，购物车清空！");
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("/jsps/deals/consignee_info.jsp").forward(request, response);
				LOGGER.info("进入订单信息填写界面！");
				return ;
			}
			
			response.sendRedirect("/shop01/action/dealMgr?act=loadPageDeal");
		}
		else if("loadPageDeal".equals(act))
		{
			/**
			 * 获取当前用户信息
			 */
			Customer customer=(Customer)request.getSession().getAttribute("customer");
			/**
			 * 新建Page对象，以及组合订单组合查询所需的DealQuryHelper对象
			 */
			DealQuryHelper helper=new DealQuryHelper(); 
			helper.setDealCustomerId(Integer.parseInt(customer.getCustomerId()));
		
			/**
			 * 根据用户操作所选择的查询条件的组合封装helper对象
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
			 * 进行订单查询操作，创建进行分页显示的Page对象
			 */
			Page pagedDeal=new Page();
			Integer pageNo=null;
			pagedDeal.setPageSize(8);
			
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
			LOGGER.info("进入订单信息显示界面！");
		}
		else if(act.equals("opt"))
		{
			response.setCharacterEncoding("utf-8");
			/**
			 * 获取当前用户信息
			 */
			Customer customer =(Customer)request.getSession().getAttribute("customer");
			/**
			 * 获取要确认到货的订单的订单编号、用户输入的确认密码,以及此次的操作类型
			 */
			Integer dealId = Integer.parseInt(request.getParameter("dealid"));
			String pw = request.getParameter("pw");
			String type = request.getParameter("type");
			Deal deal = null;
			try 
			{   
				/**
				 * 再一次对用户的密码进行核对，正确则继续完成此次操作，否则抛出相关的异常
				 */
				if(pw.equals(customer.getCustomerPassword()))
				{
					/**
					 * 根据type的值进行确认收货或者申请退货两种操作，accept代表确认收货，return代表申请退货
					 */
					if(type.equals("accept"))
					{
						LOGGER.info("订单确认收货中...");
						/**
						 * 判断要确认查收的订单状态，如果状态为未审核，则不能进行确认操作，抛出相应的异常
						 */
						DealService dealService = new DealServiceImpl();
						deal = dealService.getDealById(dealId);
						
						if(!deal.getDealStatus().equals("a"))
						{
							deal.setIsAccept(1);
							dealService.updateDeal(deal);
							/**
							 * 订单确认成功后，更新当前用户的最新积分，并重新保存到Session空间中
							 * 判断用户当前的用户积分，如果超过1000则将该用户升级为会员
							 */
							CustomerService customerService = new CustomerServiceImpl();
							
							customer.setCustomerScore(customer.getCustomerScore()+deal.getDealSum());
							
							if(customer.getCustomerScore()>=1000)
							{
								customer.setIsMember(1);
							}
							customerService.modifyCustomer(customer);
							request.getSession().setAttribute("customer", customer);
						}
						else
						{
							LOGGER.error("订单编号为："+dealId+"的订单信息还未通过审核，请等待审核！");
							throw new ApplicationException("订单编号为："+dealId+"的订单信息还未通过审核，请等待审核！");
						}
					}
					else if(type.equals("return"))
					{
						LOGGER.info("订单正在申请退货...");
						/**
						 * 将订单接收状态设置为2，代表该订单正在申请退货
						 */
						DealService dealService = new DealServiceImpl();
						deal = dealService.getDealById(dealId);
						deal.setIsAccept(2);
						dealService.updateDeal(deal);
					}
				}
				else
				{
					LOGGER.error("密码输入不正确请重新输入！");
					throw new ApplicationException("密码输入不正确请重新输入！");
				}
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				PrintWriter out=response.getWriter();
				out.println(e.getMessage());
				return;
			}
			PrintWriter out=response.getWriter();
			out.print("successful|");
		}  
		else if(act.equals("del"))
		{
			/**
			 * 将已经通过审核并且已经成功查收的订单的全部信息删除
			 * 通过订单编号，查找到样删除的订单对象
			 */
			Deal deal = null;
			try 
			{
				Integer dealId=Integer.parseInt(request.getParameter("dealid"));
				DealService dealService=new DealServiceImpl();
				deal = dealService.getDealById(dealId);
				
				/**
				 * 判断要删除的订单状态，如果状态为未审核，则不能进行删除操作，抛出相应的异常
				 */
				
				if(!deal.getDealStatus().equals("a"))
				{
				    dealService.deleteDeal(deal);
				}
				else
				{
					throw new ApplicationException("订单编号为："+dealId+"的订单信息还未通过审核，请等待审核！");
				}
			
			} catch (ApplicationException e)
			{
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("/action/dealMgr?act=loadPageDeal").forward(request, response);
			}
			response.sendRedirect("/shop01/action/dealMgr?act=loadPageDeal");
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
		doGet(request, response);
	}

}
