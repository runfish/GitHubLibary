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
 * Comments: ���ֹ���Ա�������롢�˳���  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-25
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
			 * ����û����Ŀͻ���cookie����
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
			 * ��ȡ����Ա��Ϣ
			 */
			 
			
			String userPwd=request.getParameter("userpwd");
			String imgCode=request.getParameter("imgcode");
			Integer isAdmin=Integer.parseInt(request.getParameter("isadmin"));
			String checkCode=(String)request.getSession().getAttribute("checkcode");
			/**
			 * �����һ�ܿͻ������һ������Ĺ���Ա�ʺű������ͻ���Cookie
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
			 * ����Ա����
			 */
			Administrator admin=null;  
			try 
			{
				/**
			     *����Ա����ǰ�������ϢУ��
			     */
				if(imgCode.equalsIgnoreCase(checkCode))
				{
					AdministratorService adminService=new AdministratorServiceImpl();
					userName = URLDecoder.decode(userName, "utf-8");
					admin=adminService.getAdministratorByName(userName);
					boolean isFreeze =admin.getIsFreeze();
					if(!admin.getAdministratorPassword().equals(userPwd))
					{
						LOGGER.error("�ʺŻ������벻��ȷ����������!");
						throw new DataAccessException("�ʺŻ������벻��ȷ����������!");
					}
					
				    if(!admin.getIsSuperAdministrator())  
					{
						if(isAdmin==1)
						{
							LOGGER.error("���û����ǳ�������Ա������ѡ����뷽ʽ!");
						    throw new DataAccessException("���û����ǳ�������Ա������ѡ����뷽ʽ!");
					
						}
					}
				    if(admin.getIsSuperAdministrator())
					{
						if(isAdmin==0)
						{
							LOGGER.error("���û�������ͨ����Ա������ѡ����뷽ʽ!");
						    throw new DataAccessException("���û�������ͨ����Ա������ѡ����뷽ʽ!");
						}
					} 
				    /**
					 * ����ù���Ա�Ѿ�������ֱ���׳��쳣
					 */
				   if(isFreeze){
					    LOGGER.error("���û���Ȩ���ѱ�����,����ϵ��������Ա!");
						throw new DataAccessException("���û���Ȩ���ѱ�����,����ϵ��������Ա");
					}
				}
				else
				{
					LOGGER.error("��֤����Ϣ�������������룡");
					throw new DataAccessException("��֤����Ϣ�������������룡");
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
			LOGGER.info(userName+"�Ѿ�����ϵͳ�����������棡");
		}
		else if("getSystemDate".equals(act))
		{
			/**
			 * Ϊ�û������ȡ��ǰ�ķ�����ʱ�䣬�Դﵽʱ���ͬ��
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
			 * ����Ա�˳���ǰ�̳���ҳ����ش���
			 */
			request.getSession().removeAttribute("admin");
			request.getSession().removeAttribute("isadmin");
			request.getSession().invalidate();
			response.sendRedirect("/shop02/action/securityMgr?act=gotoLogin");
			LOGGER.info(userName+"�˳���ǰ�̳���ҳ��");
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
