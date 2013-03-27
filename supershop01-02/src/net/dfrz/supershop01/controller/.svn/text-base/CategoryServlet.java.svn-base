package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.CategoryService;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;
import net.dfrz.supershop01.servicesimpl.CategoryServiceImpl;
import net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;
import net.dfrz.supershop01.utils.Page;

/**
 * Project: supershop01-02 
 * ClassName: CategoryServlet 
 * Comments: 商品类别处理表现层 
 * JDK:jdk1.6.0_10 
 * Create Date： 2013-1-16 
 * @see java.io.IOException;
 * @see java.util.List; 
 * @see javax.servlet.ServletException; 
 * @see javax.servlet.http.HttpServlet;
 * @see javax.servlet.http.HttpServletRequest;
 * @see javax.servlet.http.HttpServletResponse;
 * @see org.apache.commons.lang3.StringUtils; 
 * @see org.apache.log4j.Logger; 
 * @see net.dfrz.supershop01.domain.Category;
 * @see net.dfrz.supershop01.domain.SmallCategory;
 * @see net.dfrz.supershop01.exception.ApplicationException;
 * @see net.dfrz.supershop01.services.CategoryService; import
 * @see net.dfrz.supershop01.services.SmallCategoryService;
 * @see net.dfrz.supershop01.servicesimpl.CategoryQueryHelper;
 * @see net.dfrz.supershop01.servicesimpl.CategoryServiceImpl;
 * @see net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;
 * @see net.dfrz.supershop01.utils.Page;
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @see #doPost(HttpServletRequest, HttpServletResponse)
 * @author J1205-YouHQ
 * @version Version 5
 */

public class CategoryServlet extends HttpServlet {
	private static final Logger LOGGER = Logger
			.getLogger(CategoryServlet.class);

	/**
	 * Constructor of the object.
	 */
	public CategoryServlet() {
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

		String act = null;

		act = request.getParameter("act").trim();
		if (act.equals("input")) {

			List<Category> bigCtgList = null;
			try {
				CategoryService categoryService = new CategoryServiceImpl();
				bigCtgList = categoryService.loadAll();

			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			request.setAttribute("bigctglist", bigCtgList);
			request.getRequestDispatcher("/jsps/category/input_ctg.jsp")
					.forward(request, response);
			LOGGER.info("进入商品类别增加页面！");
		} else if ("create".equals(act)) {

			String smallCtgName = request.getParameter("smallctgname");
			String goodsBigCtgId = request.getParameter("goodsbigctgid");
			Category bigCategory = new Category();
			bigCategory.setCtgId(Integer.parseInt(goodsBigCtgId));
			bigCategory.setCtgStatus("1");

			SmallCategory smallCategory = new SmallCategory();
			smallCategory.setBigCategory(bigCategory);
			smallCategory.setSmallCtgName(smallCtgName);
			smallCategory.setSmallCtgStatus("1");

			SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();
			try {

				smallCategoryService.addSmallCtg(smallCategory);
				response
						.sendRedirect("/shop02/action/categoryMgr?act=loadPageAll");

			} catch (ApplicationException e) {
				CategoryService categoryService = new CategoryServiceImpl();

				request.setAttribute("err", e.getMessage());
				request.getRequestDispatcher("/action/categoryMgr?act=input")
						.forward(request, response);
			}
		} else if ("loadall".equals(act)) {

			Integer pageNo = null;

			CategoryQueryHelper helper = new CategoryQueryHelper();

			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			}

			Page page = new Page();
			page.setPageSize(20);
			if (pageNo != null)
				page.setPageNo(pageNo);

			CategoryService categoryService = new CategoryServiceImpl();
			List<Category> categoryList = categoryService.loadAll();
			page = categoryService.loadPageAll(helper, page);

			request.setAttribute("biglist", categoryList);
			request.setAttribute("pagedCategory", page);

			request.getRequestDispatcher("/jsps/category/list_ctg.jsp")
					.forward(request, response);
		} else if (act.equals("loadPageAll")) {

			Integer pageNo = null;

			CategoryQueryHelper helper = new CategoryQueryHelper();

			if (StringUtils.isNotEmpty(request.getParameter("qurysctgname"))) {
				helper.setSmallCategoryName(request
						.getParameter("qurysctgname"));
			}
			if (StringUtils.isNotEmpty(request.getParameter("qurybigctgid"))) {
				helper.setBigCategoryId(Integer.parseInt(request
						.getParameter("qurybigctgid")));
			}
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			}

			Page page = new Page();
			page.setPageSize(18);
			if (pageNo != null)
				page.setPageNo(pageNo);
			List<Category> categoryList = null;
			try {
				CategoryService categoryService = new CategoryServiceImpl();
				categoryList = categoryService.loadAll();
				page = categoryService.loadPageAll(helper, page);

			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			request.setAttribute("biglist", categoryList);
			request.setAttribute("pagedCategory", page);

			request.getRequestDispatcher("/jsps/category/list_ctg.jsp")
					.forward(request, response);
			LOGGER.info("显示分页后所有商品类别！");
		} else if (act.equals("delete")) {

			int smallCtgId = Integer.parseInt(request
					.getParameter("smallctgid"));
			SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();
			try {
				smallCategoryService.deleteSmallCtg(smallCtgId);
			} catch (ApplicationException e) {
				// TODO: handle exception
				request.setAttribute("err", e.getMessage());
				request.getRequestDispatcher("/jsps/ctaegory/list_ctg.jsp")
						.forward(request, response);
				return;
			}
			response.sendRedirect("/shop02/action/categoryMgr?act=loadPageAll");
		} else if (act.equals("forUpdate")) {
			int smallCtgId = Integer.parseInt(request
					.getParameter("smallctgid"));
			List<Category> bigCtgList = null;
			SmallCategory smallCategory = null;

			try {
				SmallCategoryService ctgService = new SmallCategoryServiceImpl();
				CategoryService categoryService = new CategoryServiceImpl();
				bigCtgList = categoryService.loadAll();
				smallCategory = ctgService.getCtg(smallCtgId);
				request.setAttribute("smallcategory", smallCategory);
				request.setAttribute("bigctglist", bigCtgList);
				request.getRequestDispatcher("/jsps/category/update_ctg.jsp")
						.forward(request, response);
				LOGGER.info("进入商品类别更新界面！");
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} else if ("update".equals(act)) {

			int smallCtgId = Integer.parseInt(request
					.getParameter("goodssmallctgid"));
			int bigCtgId = Integer.parseInt(request
					.getParameter("goodsbigctgid"));
			;

			String smallCtgName = request.getParameter("smallctgname");

			try {
				SmallCategoryService samllCtgService = new SmallCategoryServiceImpl();
				SmallCategory sctg = samllCtgService.getCtg(smallCtgId);
				sctg.setSmallCtgId(smallCtgId);
				sctg.setSmallCtgName(smallCtgName);
				sctg.getBigCategory().setCtgId(bigCtgId);
				samllCtgService.modifyCtg(sctg);

			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			response.sendRedirect("/shop02/action/categoryMgr?act=loadPageAll");
			LOGGER.info("更新完后，再次显示所有商品类别！");

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
