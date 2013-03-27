package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.CustomerService;
import net.dfrz.supershop01.servicesimpl.CustomerServiceImpl;
import net.dfrz.supershop01.utils.Page;

/**
 * Project: supershop01-02 ClassName: VersionInfo Module ID: 4.6 Comments:
 * CustomerServlet JDK :jdk1.6.0_10 Create Date£º 2013-2-26
 * 
 * @see java.io.IOException
 * @see java.net.URLDecoder
 * @see javax.servlet.ServletException
 * @see javax.servlet.http.HttpServlet
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.services.CustomerService
 * @see net.dfrz.supershop01.servicesimpl.CustomerServiceImpl
 * @see net.dfrz.supershop01.utils.Page
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @author J1205-YDP
 * @version Version 292
 */
public class CustomerServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String act = request.getParameter("act");

		if ("loadPageAll".equals(act)) {
			try {

				Integer pageNo = null;

				if (request.getParameter("pageNo") != null) {
					pageNo = Integer.parseInt(request.getParameter("pageNo"));
				}

				Page page = new Page();
				page.setPageSize(18);

				if (pageNo != null)
					page.setPageNo(pageNo);

				CustomerService customerService = new CustomerServiceImpl();

				try {
					page = customerService.loadPageCustomer(page);
					request.setAttribute("pagedCustomer", page);
					request.getRequestDispatcher(
							"/jsps/customer/customer_list.jsp").forward(
							request, response);
				} catch (ApplicationException e) {

					request.setAttribute("err", e.getMessage());
					request.getRequestDispatcher(
							"/jsps/customer/customer_list.jsp").forward(
							request, response);
				}
			} catch (ApplicationException e) {
				// TODO: handle exception
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}
		}

		else if ("update".equals(act)) {

		} else if ("freeze".equals(act)) {

			try {
				String customername = request.getParameter("customername");
				String customerName = URLDecoder.decode(customername, "utf-8");
				CustomerService customerService = new CustomerServiceImpl();
				Customer customer = new Customer();
				customer = customerService.getCustomerByName(customerName);
				int isFreeze = 1;
				customer.setIsFreeze(isFreeze);
				customerService.modifyCustomer(customer);
			} catch (ApplicationException e) {
				// TODO: handle exception
				request.setAttribute("err", e.getMessage());
				request
						.getRequestDispatcher(
								"/jsps/customer/customer_list.jsp").forward(
								request, response);
			}

			response.sendRedirect("/shop02/action/customerMgr?act=loadPageAll");

		} else if ("unfreeze".endsWith(act)) {
			try {

				String customername = request.getParameter("customername");
				String customerName = URLDecoder.decode(customername, "utf-8");
				CustomerService customerService = new CustomerServiceImpl();
				Customer customer = new Customer();
				customer = customerService.getCustomerByName(customerName);
				int isFreeze = 0;
				customer.setIsFreeze(isFreeze);
				customerService.modifyCustomer(customer);
			} catch (ApplicationException e) {
				// TODO: handle exception
				request.setAttribute("err", e.getMessage());
				request
						.getRequestDispatcher(
								"/jsps/customer/customer_list.jsp").forward(
								request, response);
			}
			response.sendRedirect("/shop02/action/customerMgr?act=loadPageAll");
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
