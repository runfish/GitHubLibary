package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.CategoryService;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.servicesimpl.CategoryServiceImpl;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.utils.Page;

/**
 * Project: supershop01-01 ClassName: IndexServlet Module ID: 4.6 Comments:
 * 商城首页管理表现层 JDK :jdk1.6.0_10 Create Date： 2013-2-28
 * 
 * @see java.io.IOException
 * @see java.io.PrintWriter
 * @see java.util.ArrayList
 * @see java.util.List
 * @see javax.servlet.ServletException
 * @see javax.servlet.http.HttpServlet
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * 
 * @see net.dfrz.supershop01.domain.Category
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.services.CategoryService
 * @see net.dfrz.supershop01.services.GoodsService
 * @see net.dfrz.supershop01.servicesimpl.CategoryServiceImpl
 * @see net.dfrz.supershop01.servicesimpl.GoodsQueryHelper
 * @see net.dfrz.supershop01.servicesimpl.GoodsServiceImpl
 * @see net.dfrz.supershop01.utils.Page
 * @see #doPost(HttpServletRequest, HttpServletResponse)
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @author J1205-YDP    
 * @version Version 350
 */

public class IndexServlet extends HttpServlet {
	private static final Logger LOGGER=Logger.getLogger(IndexServlet.class);
	public IndexServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Page page = new Page();
			CategoryService categoryService = new CategoryServiceImpl();
			GoodsQueryHelper helper = new GoodsQueryHelper();
			GoodsService goodService = new GoodsServiceImpl();
			List<Category> ctgList = categoryService.loadAll();
			try {
				page = goodService.loadPagedGoods(page, helper);
				request.setAttribute("ctglist", ctgList);
				request.setAttribute("pagedGoods", page);
				request.getRequestDispatcher("/jsps/main/menu.jsp").forward(
						request, response);
				LOGGER.info("进入商城首页！");
			} catch (ApplicationException e) {
				request.setAttribute("err", e.getMessage());
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}
		} catch (ApplicationException e) {
			// TODO: handle exception
			request.getRequestDispatcher("/jsps/error/error.jsp").forward(
					request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
