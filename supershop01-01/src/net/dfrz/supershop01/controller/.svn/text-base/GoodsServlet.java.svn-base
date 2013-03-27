package net.dfrz.supershop01.controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.CategoryService;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.servicesimpl.CategoryServiceImpl;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;
import net.dfrz.supershop01.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**                
 * Project: supershop01-01
 * ClassName: GoodsServlet                                                      
 * Module ID: 4.6  
 * Comments: 商城商品管理商品信息表现层
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-3-17
 * @see java.io.FileInputStream
 * @see java.io.IOException
 * @see java.io.PrintWriter
 * @see java.util.List
 * @see javax.servlet.ServletException
 * @see javax.servlet.ServletOutputStream
 * @see javax.servlet.http.HttpServlet
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @see net.dfrz.supershop01.domain.Category
 * @see net.dfrz.supershop01.domain.Goods
 * @see net.dfrz.supershop01.domain.SmallCategory
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.services.CategoryService
 * @see net.dfrz.supershop01.services.GoodsService
 * @see net.dfrz.supershop01.services.SmallCategoryService
 * @see net.dfrz.supershop01.servicesimpl.CategoryServiceImpl
 * @see net.dfrz.supershop01.servicesimpl.GoodsQueryHelper
 * @see net.dfrz.supershop01.servicesimpl.GoodsServiceImpl
 * @see net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl
 * @see net.dfrz.supershop01.utils.Page
 * @see org.apache.commons.lang3.StringUtils
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @author J1205-YDP                                                     
 * @version Version 416 
 */
public class GoodsServlet extends HttpServlet {
	private static final Logger LOGGER=Logger.getLogger(GoodsServlet.class);
	/**
	 * Constructor of the object.
	 */
	public GoodsServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//int random = (int)Math.random();

		request.setCharacterEncoding("utf-8");

		String act = request.getParameter("act").trim();
		int indexStr = act.indexOf("|");
		Integer bigCtgId = null;
		if (indexStr != -1) {

			bigCtgId = Integer.parseInt(act.substring(indexStr + 1));
			act = act.substring(0, indexStr);

		}

		if ("loadPageGoods".equals(act)) {
			try {
				Integer pageNo = null;

				GoodsQueryHelper helper = new GoodsQueryHelper();

				CategoryService categoryService = new CategoryServiceImpl();

				List<Category> ctgList = categoryService.loadAll();

				if (StringUtils.isNotEmpty(request
						.getParameter("qurygoodsname"))) {
					helper.setGoodsName(request.getParameter("qurygoodsname"));
				}
				if (StringUtils.isNotEmpty(request
						.getParameter("qurygoodsctgid"))) {
					helper.setGoodsCtgId(Integer.parseInt(request
							.getParameter("qurygoodsctgid")));
				}
				String minPrice = request.getParameter("qurymingoodsprice");
				String maxPrice = request.getParameter("qurymaxgoodsprice");
				if (StringUtils.isNotEmpty(minPrice)) {
					helper.setMinGoodsPrice(Double.parseDouble(minPrice));
				}
				if (StringUtils.isNotEmpty(maxPrice)) {
					helper.setMaxGoodsPrice(Double.parseDouble(maxPrice));
				}
				if (StringUtils.isNotEmpty(request
						.getParameter("qurygoodsempty"))) {
					helper.setGoodsIsEmpty(request
							.getParameter("qurygoodsempty"));
				}

				if (request.getParameter("pageNo") != null) {
					pageNo = Integer.parseInt(request.getParameter("pageNo"));
				}

				Page page = new Page();
				if (pageNo != null)
					page.setPageNo(pageNo);

				GoodsService goodService = new GoodsServiceImpl();
				try {
					page = goodService.loadPagedGoods(page, helper);
					request.setAttribute("ctglist", ctgList);
					request.setAttribute("pagedGoods", page);
					request.getRequestDispatcher("/jsps/main/menu.jsp")
							.forward(request, response);
				} catch (ApplicationException e) {
					String detilStr = "查询输入不合法,查询失败";
					request.setAttribute("err", detilStr + e.getMessage());
					request.getRequestDispatcher("/jsps/main/menu.jsp")
							.forward(request, response);
				}
			} catch (ApplicationException e) {
				// TODO: handle exception
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}
		}

		else if ("getgoodsbyid".equals(act)) {

			List<SmallCategory> smallCategoryList = null;
			try {
				Page page = new Page();

				GoodsQueryHelper helper = new GoodsQueryHelper();

				GoodsService goodService = new GoodsServiceImpl();

				GoodsService goodsService = new GoodsServiceImpl();

				SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();

				page = goodsService.getGoodsByBigCtgId(page, helper, bigCtgId);

				smallCategoryList = smallCategoryService
						.getSmallCtgByBigId(bigCtgId);

				request.setAttribute("bigctgid", bigCtgId);

				request.setAttribute("sctglist", smallCategoryList);

				request.setAttribute("pagedGoods", page);

				request.getRequestDispatcher("/jsps/goods/show_goods.jsp")
						.forward(request, response);
				LOGGER.info("进入商品显示页面！");
			} catch (ApplicationException e) {

				request.setAttribute("err", e.getMessage());

				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}

		}

		else if ("getsubgoodsbyid".equals(act)) {

			int subId = Integer.parseInt(request.getParameter("subctgid"));
			int bigctg = Integer.parseInt(request.getParameter("bigctgid"));
			List<SmallCategory> smallCategoryList = null;
			try {

				Page page = new Page();

				GoodsQueryHelper helper = new GoodsQueryHelper();

				GoodsService goodService = new GoodsServiceImpl();

				GoodsService goodsService = new GoodsServiceImpl();

				SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();

				page = goodsService.getGoodsBySubCtgId(page, helper, subId);

				smallCategoryList = smallCategoryService
						.getSmallCtgByBigId(bigctg);
				request.setAttribute("bigctgid", bigctg);

				request.setAttribute("subctgid", subId);

				request.setAttribute("sctglist", smallCategoryList);

				request.setAttribute("pagedGoods", page);

				request.getRequestDispatcher("/jsps/goods/show_ctg_goods.jsp")
						.forward(request, response);

			} catch (ApplicationException e) {

				request.setAttribute("err", e.getMessage());

				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}

		}

		else if ("loadPageSubCtgGoods".equals(act)) {
			try {
				Integer pageNo = null;

				GoodsQueryHelper helper = new GoodsQueryHelper();

				SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();

				int bigCtg = Integer.parseInt(request.getParameter("bigctgid"));

				List<SmallCategory> smallCategoryList = smallCategoryService
						.getSmallCtgByBigId(bigCtg);

				if (StringUtils.isNotEmpty(request
						.getParameter("qurygoodsname"))) {
					helper.setGoodsName(request.getParameter("qurygoodsname"));
				}
				if (StringUtils.isNotEmpty(request
						.getParameter("qurygoodsctgid"))) {
					helper.setGoodsCtgId(Integer.parseInt(request
							.getParameter("qurygoodsctgid")));
				}
				String minPrice = request.getParameter("qurymingoodsprice");
				String maxPrice = request.getParameter("qurymaxgoodsprice");
				if (StringUtils.isNotEmpty(minPrice)) {
					helper.setMinGoodsPrice(Double.parseDouble(minPrice));
				}
				if (StringUtils.isNotEmpty(maxPrice)) {
					helper.setMaxGoodsPrice(Double.parseDouble(maxPrice));
				}
				if (StringUtils.isNotEmpty(request
						.getParameter("qurygoodsempty"))) {
					helper.setGoodsIsEmpty(request
							.getParameter("qurygoodsempty"));
				}

				if (request.getParameter("pageNo") != null) {
					pageNo = Integer.parseInt(request.getParameter("pageNo"));
				}

				Page page = new Page();
				if (pageNo != null)
					page.setPageNo(pageNo);

				GoodsService goodService = new GoodsServiceImpl();
				try {
					page = goodService.getGoodsByBigCtgId(page, helper, bigCtg);
					request.setAttribute("bigctgid", bigCtg);
					request.setAttribute("sctglist", smallCategoryList);
					request.setAttribute("pagedGoods", page);
					request.getRequestDispatcher("/jsps/goods/show_goods.jsp")
							.forward(request, response);
				} catch (ApplicationException e) {
					String detilStr = "查询输入不合法,查询失败";
					request.setAttribute("err", detilStr + e.getMessage());
					request.getRequestDispatcher("/jsps/error/error.jsp")
							.forward(request, response);
				}
			} catch (ApplicationException e) {
				// TODO: handle exception
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}
		}

		else if ("loadPageLastSubCtgGoods".equals(act)) {

			Integer pageNo = null;

			GoodsQueryHelper helper = new GoodsQueryHelper();

			SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();

			int bigCtg = Integer.parseInt(request.getParameter("bigctgid"));

			int subCtg = Integer.parseInt(request.getParameter("subctgid"));

			List<SmallCategory> smallCategoryList = smallCategoryService
					.getSmallCtgByBigId(bigCtg);

			if (StringUtils.isNotEmpty(request.getParameter("qurygoodsname"))) {
				helper.setGoodsName(request.getParameter("qurygoodsname"));
			}
			if (StringUtils.isNotEmpty(request.getParameter("qurygoodsctgid"))) {
				helper.setGoodsCtgId(Integer.parseInt(request
						.getParameter("qurygoodsctgid")));
			}
			String minPrice = request.getParameter("qurymingoodsprice");
			String maxPrice = request.getParameter("qurymaxgoodsprice");
			if (StringUtils.isNotEmpty(minPrice)) {
				helper.setMinGoodsPrice(Double.parseDouble(minPrice));
			}
			if (StringUtils.isNotEmpty(maxPrice)) {
				helper.setMaxGoodsPrice(Double.parseDouble(maxPrice));
			}
			if (StringUtils.isNotEmpty(request.getParameter("qurygoodsempty"))) {
				helper.setGoodsIsEmpty(request.getParameter("qurygoodsempty"));
			}

			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			}

			Page page = new Page();
			if (pageNo != null)
				page.setPageNo(pageNo);

			GoodsService goodService = new GoodsServiceImpl();
			try {
				page = goodService.getGoodsBySubCtgId(page, helper, subCtg);
				request.setAttribute("subctgid", subCtg);
				request.setAttribute("bigctgid", bigCtg);
				request.setAttribute("sctglist", smallCategoryList);
				request.setAttribute("pagedGoods", page);
				request.getRequestDispatcher("/jsps/goods/show_ctg_goods.jsp")
						.forward(request, response);
			} catch (ApplicationException e) {
				String detilStr = "查询输入不合法,查询失败";
				request.setAttribute("err", detilStr + e.getMessage());
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}

		}

		else if ("getgoodsdetail".equals(act)) {

			String CtgId = request.getParameter("bigctgid");
			int goodsId = Integer.parseInt(request.getParameter("goodsid"));
			if (CtgId.equals("index")) {
				try {
					CategoryService categoryService = new CategoryServiceImpl();
					List<Category> categoryList = categoryService.loadAll();
					GoodsService goodsService = new GoodsServiceImpl();
					Goods goods = goodsService.getGoodsById(goodsId);
					request.setAttribute("bigctglist", categoryList);
					request.setAttribute("goods", goods);
					request.getRequestDispatcher(
							"/jsps/goods/show_goods_detail.jsp").forward(
							request, response);
				} catch (ApplicationException e) {
					request.setAttribute("err", e.getMessage());
					request.getRequestDispatcher("/jsps/error/error.jsp")
							.forward(request, response);

				}

			} else {

				try {
					int bigid = Integer.parseInt(CtgId);
					SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();
					GoodsService goodsService = new GoodsServiceImpl();
					List<SmallCategory> smallCtgList = smallCategoryService
							.getSmallCtgByBigId(bigid);
					Goods goods = goodsService.getGoodsById(goodsId);

					request.setAttribute("sctglist", smallCtgList);
					request.setAttribute("goods", goods);
					request.setAttribute("bigctgid", bigid);

					request.getRequestDispatcher(
							"/jsps/goods/show_goods_detail.jsp").forward(
							request, response);
					LOGGER.info("进入商品信息详细页面！");
				} catch (ApplicationException e) {
					request.setAttribute("err", e.getMessage());
					request.getRequestDispatcher("/jsps/error/error.jsp")
							.forward(request, response);

				}

			}

		}

		else if ("getimage".equals(act)) {
			try {

				int goodsId = Integer.parseInt(request.getParameter("goodsid"));
				GoodsService goodsService = new GoodsServiceImpl();
				byte[] goodsImage = goodsService.loadGoodsImageById(goodsId);

				response.setContentType("image/jpeg");

				ServletOutputStream sos = response.getOutputStream();

				if (goodsImage != null && goodsImage.length > 0) {
					sos.write(goodsImage);
				} else {
					String relPath = request.getRealPath("/")
							+ "pics/default.gif";
					FileInputStream fis = new FileInputStream(relPath);
					byte[] defaultImage = new byte[fis.available()];
					fis.read(defaultImage);
					sos.write(defaultImage);
					fis.close();
				}
				sos.flush();
				sos.close();

			} catch (ApplicationException e) {
				// TODO: handle exception
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
				return;
			}
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
