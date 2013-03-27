package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
 * ClassName: DataAccessException                                                          
 * Comments: 各种用户操作登入、退出等  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-25
 * @see java.io.IOException
 * @see java.io.PrintWriter
 * @see java.net.URLDecoder
 * @see java.net.URLEncoder
 * @see java.util.Date
 * @see javax.servlet.ServletException
 * @see javax.servlet.http.Cookie
 * @see javax.servlet.http.HttpServlet
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see net.dfrz.supershop01.services.CustomerService
 * @see net.dfrz.supershop01.servicesimpl.CustomerServiceImpl
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @see #doPost(HttpServletRequest, HttpServletResponse)
 * @author J1205-HongHG
 * @version 125
 */
public class SecurityServlet extends HttpServlet {

	private static final Logger LOGGER=Logger.getLogger(SecurityServlet.class);
	/**
	 * Constructor of the object.
	 */
	public SecurityServlet() {
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
		
		if("gotoLogin".equals(act)){
			/**
			 * 存放用户名的客户端cookie名称
			 */
			String cookieName="loginName";
			Cookie[]cookies=request.getCookies();
			if(cookies!=null)
			{
				for(Cookie c:cookies)
				{
					if(c.getName().equals(cookieName))
					{
						request.setAttribute("loginname", c.getValue());
						break;
					}
				}
			}
			request.getRequestDispatcher("/jsps/login/login.jsp").forward(request, response);
		
		}
		else if("login".equals(act)){
       
			/**
			 * 获取用户信息
			 */
			 
			String loginName=request.getParameter("loginname");
			String loginPwd=request.getParameter("loginpwd");
			String authCode=request.getParameter("authcode");
			String checkCode=(String)request.getSession().getAttribute("checkcode");
			/**
			 * 将最近一周客户端最后一个登入的用户帐号保存至客户端Cookie
			 */
			Cookie[]cookies=request.getCookies();
			Boolean isSaved=false;
			if(cookies!=null)
			{
				for(Cookie c:cookies)
				{
					String user = URLDecoder.decode(c.getName(), "utf-8");
					if(c.getName().equals(loginName))
					{
						isSaved=true;
						break;
					}
				}
			}
			if(!isSaved)
			{
				loginName = URLEncoder.encode(loginName, "utf-8");
				Cookie userNameCookie=new Cookie("userName",loginName);
				userNameCookie.setMaxAge(7*24*60*60);
				response.addCookie(userNameCookie);
			}
			/**
			 * 用户对象
			 */
			Customer customer=null;  
			try 
			{   /**
			     *用户登入前的相关信息校验
			     */
				if(authCode.equalsIgnoreCase(checkCode))
				{
					CustomerService customerService=new CustomerServiceImpl();
					loginName = URLDecoder.decode(loginName, "utf-8");
					customer=customerService.getCustomerByName(loginName);
					/**
					 * 当用户查询为空，该用户对象不存在，抛出相应异常
					 */
					if(customer==null)
					{
						throw new ApplicationException("对不起，用户名不存在，请重新输入！");
					}
					
					int isFreeze =customer.getIsFreeze();
					/**
					 * 如果该用户已经被冻结直接抛出异常
					 */
					if(isFreeze==1)
					{
						LOGGER.error(loginName+"对不起该用户已经被冻结，暂时无法使用!");
						throw new DataAccessException("对不起该用户已经被冻结，暂时无法使用!");
					}
					if(!customer.getCustomerPassword().equals(loginPwd))
					{
						LOGGER.error("帐号或者密码不正确请重新输入!");
						throw new DataAccessException("帐号或者密码不正确请重新输入!");
					}
				}
				else
				{
					LOGGER.error("验证码信息错误，请重新输入！");
					throw new DataAccessException("验证码信息错误，请重新输入！");
				}
				
			} catch (ApplicationException e)
			{
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				LOGGER.info(loginName+"已经进入商城首页！");
				request.getRequestDispatcher("/jsps/login/login.jsp").forward(request, response);
				return;
			}
			request.getSession().setAttribute("customer",customer);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if("logOut".equals(act)){
			/**
			 * 用户退出当前商城首页的相关处理
			 */
			String loginName=request.getParameter("loginname");
			request.getSession().removeAttribute("customer");
			request.getSession().removeAttribute("cart");
			//request.getSession().invalidate();
			response.sendRedirect("/shop01/index.jsp");
			LOGGER.info(loginName+"退出当前商城首页！");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
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
