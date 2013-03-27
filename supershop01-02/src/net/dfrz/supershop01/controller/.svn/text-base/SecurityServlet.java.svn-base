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
import net.dfrz.supershop01.domain.Administrator;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.services.AdministratorService;
import net.dfrz.supershop01.servicesimpl.AdministratorServiceImpl;
/**                
 * Project: supershop01-02
 * ClassName: DataAccessException                                                          
 * Comments: 各种管理员操作登入、退出等  
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
 * @see org.apache.log4j.Logger
 * @see net.dfrz.supershop01.domain.Administrator
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.exception.DataAccessException
 * @see net.dfrz.supershop01.services.AdministratorService
 * @see net.dfrz.supershop01.servicesimpl.AdministratorServiceImpl
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
		String userName=request.getParameter("username");
		if("gotoLogin".equals(act)){
			/**
			 * 存放用户名的客户端cookie名称
			 */
			String cookieName="userName";
			Cookie[]cookies=request.getCookies();
			if(cookies!=null)
			{
				for(Cookie c:cookies)
				{
					if(c.getName().equals(cookieName))
					{
						request.setAttribute("username", c.getValue());
						break;
					}
				}
			}
			request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
		}
		else if("login".equals(act)){
       
			/**
			 * 获取管理员信息
			 */
			 
			
			String userPwd=request.getParameter("userpwd");
			String imgCode=request.getParameter("imgcode");
			Integer isAdmin=Integer.parseInt(request.getParameter("isadmin"));
			String checkCode=(String)request.getSession().getAttribute("checkcode");
			/**
			 * 将最近一周客户端最后一个登入的管理员帐号保存至客户端Cookie
			 */
			Cookie[]cookies=request.getCookies();
			Boolean isSaved=false;
			if(cookies!=null)
			{
				for(Cookie c:cookies)
				{
					String user = URLDecoder.decode(c.getName(), "utf-8");
					if(c.getName().equals(userName))
					{
						isSaved=true;
						break;
					}
				}
			}
			if(!isSaved)
			{
				userName = URLEncoder.encode(userName, "utf-8");
				Cookie userNameCookie=new Cookie("userName",userName);
				userNameCookie.setMaxAge(7*24*60*60);
				response.addCookie(userNameCookie);
			}
			/**
			 * 管理员对象
			 */
			Administrator admin=null;  
			try 
			{
				/**
			     *管理员登入前的相关信息校验
			     */
				if(imgCode.equalsIgnoreCase(checkCode))
				{
					AdministratorService adminService=new AdministratorServiceImpl();
					userName = URLDecoder.decode(userName, "utf-8");
					admin=adminService.getAdministratorByName(userName);
					boolean isFreeze =admin.getIsFreeze();
					if(!admin.getAdministratorPassword().equals(userPwd))
					{
						LOGGER.error("帐号或者密码不正确请重新输入!");
						throw new DataAccessException("帐号或者密码不正确请重新输入!");
					}
					
				    if(!admin.getIsSuperAdministrator())  
					{
						if(isAdmin==1)
						{
							LOGGER.error("该用户不是超级管理员请重新选择登入方式!");
						    throw new DataAccessException("该用户不是超级管理员请重新选择登入方式!");
					
						}
					}
				    if(admin.getIsSuperAdministrator())
					{
						if(isAdmin==0)
						{
							LOGGER.error("该用户不是普通管理员请重新选择登入方式!");
						    throw new DataAccessException("该用户不是普通管理员请重新选择登入方式!");
						}
					} 
				    /**
					 * 如果该管理员已经被冻结直接抛出异常
					 */
				   if(isFreeze){
					    LOGGER.error("该用户的权限已被冻结,请联系超级管理员!");
						throw new DataAccessException("该用户的权限已被冻结,请联系超级管理员");
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
				request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
				return;
			}
			request.getSession().setAttribute("admin",admin);
			request.getSession().setAttribute("isadmin", isAdmin);
			
			request.getRequestDispatcher("/jsps/main/main_super.jsp").forward(request, response);
			LOGGER.info(userName+"已经进入系统，登入主界面！");
		}
		else if("getSystemDate".equals(act))
		{
			/**
			 * 为用户界面获取当前的服务器时间，以达到时间的同步
			 */
			Date date=new Date();
			String timeString=(date.getYear()+1900)+":"+(date.getMonth()+1)+":"+date.getDate()+":"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
			PrintWriter pw=response.getWriter();
			pw.write(timeString);
			pw.flush();
			pw.close();
		}
		else if("logOut".equals(act)){
			/**
			 * 管理员退出当前商城首页的相关处理
			 */
			request.getSession().removeAttribute("admin");
			request.getSession().removeAttribute("isadmin");
			request.getSession().invalidate();
			response.sendRedirect("/shop02/action/securityMgr?act=gotoLogin");
			LOGGER.info(userName+"退出当前商城首页！");
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
