package net.dfrz.supershop01.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.services.CustomerService;
import net.dfrz.supershop01.servicesimpl.CustomerServiceImpl;
/**                
 * Project: supershop01-01
 * ClassName: VersionInfo                                                        
 * Module ID: 4.6  
 * Comments: CustomerServlet  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-2-26
 * @see java.io.IOException
 * @see javax.servlet.ServletException
 * @see javax.servlet.http.HttpServlet
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see net.dfrz.supershop01.services.CustomerService
 * @see net.dfrz.supershop01.servicesimpl.CustomerServiceImpl
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @author J1205-supershop01                                                      
 * @version Version 292 
 */
public class CustomerServlet extends HttpServlet {
	private static final Logger LOGGER=Logger.getLogger(CustomerServlet.class);
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
		
		if(act.equals("add"))
		{
			/**
			 * 获新增的部分用户信息
			 */
			String customerName=request.getParameter("customername");
			String customerPwd=request.getParameter("customerpwd");
			String customerPwd2=request.getParameter("customerpwd2");
			String authCode=request.getParameter("authcode");
			String checkCode=(String)request.getSession().getAttribute("checkcode");
			/**
			 * 封装用户信息
			 */
			Customer customer=new Customer();
			customer.setCustomerName(customerName);
			customer.setCustomerPassword(customerPwd);
			customer.setIsFreeze(0);
			customer.setCustomerAccount(0);
			
			try 
			{
				/**
				 * 验证用户输入的验证码以及确认密码是否正确，正确执行添加操作，否则抛出相关的异常
				 */
				if(authCode.equalsIgnoreCase(checkCode))
				{
					LOGGER.info("验证码输入正确！");
					if(customerPwd.equals(customerPwd2))
					{
						LOGGER.info("用户密码输入正确！");
						CustomerService customerService=new CustomerServiceImpl();
						customerService.create(customer);
						customer = customerService.getCustomerByName(customer.getCustomerName());
					}
					else
					{
						LOGGER.error("两次密码输入不相同，请重新输入！");
						throw new DataAccessException("两次密码输入不相同，请重新输入！");
					}
				}
				else
				{
					LOGGER.error("验证码信息错误，请重新输入！");
					throw new DataAccessException("验证码信息错误，请重新输入！");
				}
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				LOGGER.info("进入用户增加页面！");
				request.getRequestDispatcher("/jsps/customer/add_customer.jsp").forward(request, response);
				return;
			}
			/**
			 * 将当前用户的最新信息保存到Session空间中
			 */
			request.getSession().setAttribute("customer", customer);
			request.getRequestDispatcher("/index.jsp").forward(request, response);	
		}
		else if(act.equals("require"))
		{
			/**
			 * 用户查看用户信息时，为用户获取当前用户的最新信息，返回用户界面
			 */
			Customer customer = (Customer)request.getSession().getAttribute("customer");
			
			request.setAttribute("customer", customer);
			
			request.getRequestDispatcher("/jsps/customer/customer_detail.jsp").forward(request, response);
		}
		else if(act.equals("update"))
		{
			/**
			 * 获取用户新信息
			 */
			String customerName = request.getParameter("customer_name");
			String customerRealname = request.getParameter("real_name");
			String birthday = request.getParameter("birthday");
			String homeAddress = request.getParameter("home_address");
			String postCode = request.getParameter("post_code");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("email");
			String oldPwd = request.getParameter("old_pwd");
			String newPwd1 = request.getParameter("new_pwd1");
			Double account = Double.parseDouble(request.getParameter("customer_account"));
			/**
			 * 从Session中获取当前用户对象，并对其进行重新封装以及保存操作
			 * 修改用户数据时如果获得的参数为null则表示没有修改此项内容
			 */
			Customer customer = (Customer)request.getSession().getAttribute("customer");
			
			if(oldPwd==null && account==0)
			{
				customer.setCustomerName(customerName);
			
				customer.setCustomerRealname(customerRealname);
			
				customer.setCustomerBirthday(birthday);
			
				customer.setCustomerAddress(homeAddress);
			
				customer.setCustomerPostCode(postCode);
			
				customer.setCustomerTel(telephone);
			
				customer.setCustomerMail(email);
				
			}
			else if(account!=null && account!=0){
				double oldAccount = customer.getCustomerAccount();
				customer.setCustomerAccount(oldAccount+account);
				
			}
			else
			{
				customer.setCustomerPassword(newPwd1);
			}
			/**
			 * 保存用户数据到数据库中
			 */
			try 
			{
				CustomerService customerService = new CustomerServiceImpl();
				customerService.modifyCustomer(customer);
				
				if(oldPwd!=null&&oldPwd.length()>0)
				{
					/**
					 * 更新Session空间中的用户信息
					 */
					request.getSession().setAttribute("customer", customer);
					throw new ApplicationException("用户密码修改成功,要好好记住你密码哈，暂时未开放找回密码的功能!!</*^*\\>!!!!!!!");
				}
				
				if(account!=null&&account>0){
					request.getSession().setAttribute("customer", customer);
					throw new ApplicationException("充值成功...可以开始您的网购咯！");
				}
			} 
			catch (ApplicationException e)
			{
				// TODO: handle exception
				e.printStackTrace();	
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(request, response);
				return;
		    }
			/**
			 * 更新Session空间中的用户信息
			 */
			request.getSession().setAttribute("customer", customer);
			request.getRequestDispatcher("/action/customerMgr?act=require").forward(request, response);
		}
		else if(act.equals("gomember"))
		{	
			try 
			{
				/**
				 * 用户进入会员中心时，为用户获取当前用户的最新信息，返回界面,如果用户为null，抛出相应的异常
				 */
				Customer customer = (Customer)request.getSession().getAttribute("customer");
				
				if(customer==null)
				{
					LOGGER.error("对不起，您还没有登入，无法登入会员中心，请先登入谢谢!");
					throw new ApplicationException("对不起，您还没有登入，无法登入会员中心，请先登入谢谢!");
				}
				
				request.setAttribute("customer", customer);
				/**
				 * 进入会员中心前，先进行一次判断当前用户是否为会员，如果是进入会员中心，否则抛出相应的异常
				 */
				if(customer.getIsMember()==0)
				{
					LOGGER.error("对不起你还不是会员!");
					throw new ApplicationException("对不起你还不是会员，请继续加油哈！*/^_^\\*");
				}
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(request, response);
				return;
			}
			
			request.getRequestDispatcher("/jsps/customer/customer_member.jsp").forward(request, response);
			LOGGER.info("进入会员中心页面！");
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
