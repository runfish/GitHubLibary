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
 * Comments: �����������ֲ�  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-16
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
			 * ��ȡ����������Ϣ
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
			 * ��ȡ��ǰ���û���Ϣ
			 */
			Customer customer = (Customer)request.getSession().getAttribute("customer");
			
			/**
			 * �����µ�����
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
			 * ��װ�����Ķ�����Ϣ
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
				 * ���µĶ���������д洢����
				 */
				DealService dealService=new DealServiceImpl();
				dealService.addDeal(deal,myCart,customer);
				/**
				 * ��ɶ����ύ�󣬽�Session�ռ��еĹ��ﳵ��Ϣ���
				 */
				request.getSession().removeAttribute("mycart");
				LOGGER.info("�������ύ�����ﳵ��գ�");
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("/jsps/deals/consignee_info.jsp").forward(request, response);
				LOGGER.info("���붩����Ϣ��д���棡");
				return ;
			}
			
			response.sendRedirect("/shop01/action/dealMgr?act=loadPageDeal");
		}
		else if("loadPageDeal".equals(act))
		{
			/**
			 * ��ȡ��ǰ�û���Ϣ
			 */
			Customer customer=(Customer)request.getSession().getAttribute("customer");
			/**
			 * �½�Page�����Լ���϶�����ϲ�ѯ�����DealQuryHelper����
			 */
			DealQuryHelper helper=new DealQuryHelper(); 
			helper.setDealCustomerId(Integer.parseInt(customer.getCustomerId()));
		
			/**
			 * �����û�������ѡ��Ĳ�ѯ��������Ϸ�װhelper����
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
			 * ���ж�����ѯ�������������з�ҳ��ʾ��Page����
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
			 * ��ȡ����������������Ʒ������Ϣ
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
			LOGGER.info("���붩����Ϣ��ʾ���棡");
		}
		else if(act.equals("opt"))
		{
			response.setCharacterEncoding("utf-8");
			/**
			 * ��ȡ��ǰ�û���Ϣ
			 */
			Customer customer =(Customer)request.getSession().getAttribute("customer");
			/**
			 * ��ȡҪȷ�ϵ����Ķ����Ķ�����š��û������ȷ������,�Լ��˴εĲ�������
			 */
			Integer dealId = Integer.parseInt(request.getParameter("dealid"));
			String pw = request.getParameter("pw");
			String type = request.getParameter("type");
			Deal deal = null;
			try 
			{   
				/**
				 * ��һ�ζ��û���������к˶ԣ���ȷ�������ɴ˴β����������׳���ص��쳣
				 */
				if(pw.equals(customer.getCustomerPassword()))
				{
					/**
					 * ����type��ֵ����ȷ���ջ����������˻����ֲ�����accept����ȷ���ջ���return���������˻�
					 */
					if(type.equals("accept"))
					{
						LOGGER.info("����ȷ���ջ���...");
						/**
						 * �ж�Ҫȷ�ϲ��յĶ���״̬�����״̬Ϊδ��ˣ����ܽ���ȷ�ϲ������׳���Ӧ���쳣
						 */
						DealService dealService = new DealServiceImpl();
						deal = dealService.getDealById(dealId);
						
						if(!deal.getDealStatus().equals("a"))
						{
							deal.setIsAccept(1);
							dealService.updateDeal(deal);
							/**
							 * ����ȷ�ϳɹ��󣬸��µ�ǰ�û������»��֣������±��浽Session�ռ���
							 * �ж��û���ǰ���û����֣��������1000�򽫸��û�����Ϊ��Ա
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
							LOGGER.error("�������Ϊ��"+dealId+"�Ķ�����Ϣ��δͨ����ˣ���ȴ���ˣ�");
							throw new ApplicationException("�������Ϊ��"+dealId+"�Ķ�����Ϣ��δͨ����ˣ���ȴ���ˣ�");
						}
					}
					else if(type.equals("return"))
					{
						LOGGER.info("�������������˻�...");
						/**
						 * ����������״̬����Ϊ2�������ö������������˻�
						 */
						DealService dealService = new DealServiceImpl();
						deal = dealService.getDealById(dealId);
						deal.setIsAccept(2);
						dealService.updateDeal(deal);
					}
				}
				else
				{
					LOGGER.error("�������벻��ȷ���������룡");
					throw new ApplicationException("�������벻��ȷ���������룡");
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
			 * ���Ѿ�ͨ����˲����Ѿ��ɹ����յĶ�����ȫ����Ϣɾ��
			 * ͨ��������ţ����ҵ���ɾ���Ķ�������
			 */
			Deal deal = null;
			try 
			{
				Integer dealId=Integer.parseInt(request.getParameter("dealid"));
				DealService dealService=new DealServiceImpl();
				deal = dealService.getDealById(dealId);
				
				/**
				 * �ж�Ҫɾ���Ķ���״̬�����״̬Ϊδ��ˣ����ܽ���ɾ���������׳���Ӧ���쳣
				 */
				
				if(!deal.getDealStatus().equals("a"))
				{
				    dealService.deleteDeal(deal);
				}
				else
				{
					throw new ApplicationException("�������Ϊ��"+dealId+"�Ķ�����Ϣ��δͨ����ˣ���ȴ���ˣ�");
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