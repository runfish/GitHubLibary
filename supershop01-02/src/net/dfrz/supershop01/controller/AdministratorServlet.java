package net.dfrz.supershop01.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dfrz.supershop01.domain.Administrator;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.AdministratorService;
import net.dfrz.supershop01.servicesimpl.AdministratorServiceImpl;

/**
 * Project: supershop01-02 ClassName: AdministratorServlet Comments: 管理员处理表现层
 * JDK :jdk1.6.0_10 Create Date： 2013-1-16
 * @see java.io.IOException
 * @see javax.servlet.ServletException
 * @see javax.servlet.http.HttpServlet
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @see net.dfrz.supershop01.domain.Administrator
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.services.AdministratorService
 * @see net.dfrz.supershop01.servicesimpl.AdministratorServiceImpl
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @see #doPost(HttpServletRequest, HttpServletResponse)
 * @author J1205-YDP
 * @version 380
 */
public class AdministratorServlet extends HttpServlet {

	public AdministratorServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String act = request.getParameter("act");

		if ("input".equals(act)) {

			request.getRequestDispatcher(
					"/jsps/administrator/add_administrator.jsp").forward(
					request, response);
		} else if ("create".equals(act)) {
			/**
			 * 获取新增普通管理员的信息
			 */
			String administratorName = request
					.getParameter("administratorname");
			String administratorPassword = request
					.getParameter("administratorpassword");
			String realName = request.getParameter("administratorrealname");
			String birthday = request.getParameter("administratorbirthday");
			String telNum = request.getParameter("administratortelnum");
			String address = request.getParameter("administratoraddress");
			String email = request.getParameter("administratoremail");
			String postCode = request.getParameter("administratorpostcode");
			Boolean isSuperAdministrator = false;
			if (isSuperAdministrator.equals(true)) {
				isSuperAdministrator = true;
			}
			Boolean isFreeze = false;
			/**
			 * 普通管理员对象封装
			 */
			Administrator administrator = new Administrator();

			administrator.setAdministratorName(administratorName);
			administrator.setAdministratorPassword(administratorPassword);
			administrator.setRealName(realName);
			administrator.setBirthday(birthday);
			administrator.setTelNum(telNum);
			administrator.setAddress(address);
			administrator.setEmail(email);
			administrator.setPostCode(postCode);
			administrator.setSuperAdministrator(isSuperAdministrator);
			administrator.setIsFreeze(isFreeze);

			AdministratorService administratorService = new AdministratorServiceImpl();
			administrator.setAdministratorId(administratorService.getMax() + 1);
			administratorService.save(administrator);

			response.sendRedirect("/shop02/action/adminMgr?act=loadall");
		}

		else if ("loadall".equals(act)) {
			/**
			 * 读取显示所有普通管理员信息
			 */
			AdministratorService service = new AdministratorServiceImpl();
			request.setAttribute("administratorList", service.loadAll());

			request.getRequestDispatcher(
					"/jsps/administrator/list_administrator.jsp").forward(
					request, response);
		}
		/**
		 * 普通管理员信息修改
		 */
		else if (act.equals("forUpdate")) {
			int administratorId = Integer.parseInt(request
					.getParameter("administratorid"));

			AdministratorService service = new AdministratorServiceImpl();

			request.setAttribute("administrator", service
					.getAdministratorById(administratorId));

			request.getRequestDispatcher(
					"/jsps/administrator/update_administrator.jsp").forward(
					request, response);
		}

		else if ("update".equals(act)) {

			int administratorId = Integer.parseInt(request
					.getParameter("administratorid"));
			String administratorName = request
					.getParameter("administratorname");
			String administratorPassword = request
					.getParameter("administratorpassword");
			String realName = request.getParameter("administratorrealname");
			String birthday = request.getParameter("administratorbirthday");
			String telNum = request.getParameter("administratortelnum");
			String address = request.getParameter("administratoraddress");
			String email = request.getParameter("administratoremail");
			String postCode = request.getParameter("administratorpostcode");
			String isSuperAdmin = request.getParameter("superadminid");
			Boolean isSuperAdministrator = false;
			if (isSuperAdministrator.equals(true)) {
				isSuperAdministrator = true;
			}

			AdministratorService administratorService = new AdministratorServiceImpl();
			Administrator administrator = new Administrator();
			administrator.setAdministratorId(administratorId);
			administrator.setAdministratorName(administratorName);
			administrator.setAdministratorPassword(administratorPassword);
			administrator.setRealName(realName);
			administrator.setBirthday(birthday);
			administrator.setTelNum(telNum);
			administrator.setAddress(address);
			administrator.setEmail(email);
			administrator.setPostCode(postCode);
			administrator.setSuperAdministrator(isSuperAdministrator);

			administratorService.update(administrator);
			response.sendRedirect("/shop02/action/adminMgr?act=loadall");
		}
		/**
		 * 普通管理员信息删除
		 */
		else if ("delete".equals(act)) {
			int administratorId = Integer.parseInt(request
					.getParameter("administratorid"));

			AdministratorService service = new AdministratorServiceImpl();

			service.delete(administratorId);
			response.sendRedirect("/shop02/action/adminMgr?act=loadall");
		}

		else if ("freeze".equals(act)) {
			try {
				int administratorId = Integer.parseInt(request
						.getParameter("administratorid"));
				AdministratorService administratorService = new AdministratorServiceImpl();
				Administrator administrator = administratorService
						.getAdministratorById(administratorId);
				administrator.setIsFreeze(true);
				administratorService.update(administrator);
			} catch (ApplicationException e) {
				String detail = "管理员冻结权限失败";
				request.setAttribute("err", e.getMessage() + detail);
				request.getRequestDispatcher(
						"/jsps/administrator/list_administrator.jsp").forward(
						request, response);

				// TODO: handle exception
			}

			response.sendRedirect("/shop02/action/adminMgr?act=loadall");
		}
		/**
		 * 普通管理员权限冻结
		 */
		else if ("unfreeze".equals(act)) {
			try {
				int administratorId = Integer.parseInt(request
						.getParameter("administratorid"));
				AdministratorService administratorService = new AdministratorServiceImpl();
				Administrator administrator = administratorService
						.getAdministratorById(administratorId);
				administrator.setIsFreeze(false);
				administratorService.update(administrator);
			} catch (ApplicationException e) {
				String detail = "管理员权限释放失败";
				request.setAttribute("err", e.getMessage() + detail);
				request.getRequestDispatcher(
						"/jsps/administrator/list_administrator.jsp").forward(
						request, response);

				// TODO: handle exception
			}

			response.sendRedirect("/shop02/action/adminMgr?act=loadall");
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
