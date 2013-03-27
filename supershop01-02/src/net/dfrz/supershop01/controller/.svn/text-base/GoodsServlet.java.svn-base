package net.dfrz.supershop01.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dfrz.supershop01.domain.Administrator;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.AdministratorService;
import net.dfrz.supershop01.services.CategoryService;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.servicesimpl.AdministratorServiceImpl;
import net.dfrz.supershop01.servicesimpl.CategoryServiceImpl;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;
import net.dfrz.supershop01.utils.Page;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

/**                
 * Project: supershop01-02
 * ClassName: GoodsServlet                                                         
 * Comments: 商品处理表现层
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-16
 * @see  java.io.File
 * @see  java.io.FileInputStream
 * @see  java.io.IOException
 * @see import java.util.List
 * @see  javax.servlet.ServletException
 * @see  javax.servlet.ServletOutputStream
 * @see  javax.servlet.http.HttpServlet
 * @see  javax.servlet.http.HttpServletRequest
 * @see  javax.servlet.http.HttpServletResponse
 * @see  net.dfrz.supershop01.domain.Administrator
 * @see  net.dfrz.supershop01.domain.Category
 * @see  net.dfrz.supershop01.domain.Goods
 * @see  net.dfrz.supershop01.domain.SmallCategory
 * @see  net.dfrz.supershop01.exception.ApplicationException
 * @see  net.dfrz.supershop01.services.AdministratorService
 * @see  net.dfrz.supershop01.services.CategoryService
 * @see  net.dfrz.supershop01.services.GoodsService
 * @see  net.dfrz.supershop01.services.SmallCategoryService
 * @see  net.dfrz.supershop01.servicesimpl.AdministratorServiceImpl
 * @see  net.dfrz.supershop01.servicesimpl.CategoryServiceImpl
 * @see  net.dfrz.supershop01.servicesimpl.GoodsQueryHelper
 * @see  net.dfrz.supershop01.servicesimpl.GoodsServiceImpl
 * @see  net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl
 * @see  net.dfrz.supershop01.utils.Page
 * @see  org.apache.commons.fileupload.FileItem
 * @see  org.apache.commons.fileupload.FileUploadException
 * @see  org.apache.commons.fileupload.disk.DiskFileItemFactory
 * @see  org.apache.commons.fileupload.servlet.ServletFileUpload
 * @see  org.apache.commons.lang3.StringUtils
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @see #doPost(HttpServletRequest, HttpServletResponse)
 * @author J1205-YDP
 * @version 380
 */
public class GoodsServlet extends HttpServlet {

	public GoodsServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// int random = (int)Math.random();

		request.setCharacterEncoding("utf-8");
		File tempFile = new File(System.getProperty("java.io.tmpdir"));

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		factory.setRepository(tempFile);// 临时存储目录

		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setSizeMax(5000000);

		List<FileItem> fileItems = null;

		String act = null;

		if (sfu.isMultipartContent(request)) {

			try {
				fileItems = sfu.parseRequest(request);
				for (FileItem item : fileItems) {
					if (item.isFormField() && item.getFieldName().equals("act")) {

						act = item.getString("utf-8");
						break;
					}
				}

			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}

		} else
			act = request.getParameter("act").trim();
        
		if ("input".equals(act)) {

			CategoryService categoryService = new CategoryServiceImpl();
			SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();
			List<Category> bigCtgList = null;
			try {

				bigCtgList = categoryService.loadAll();
				request.setAttribute("biglist", bigCtgList);
				request.setAttribute("categorylist", categoryService.loadAll());
				request.getRequestDispatcher("/jsps/goods/input_goods.jsp")
						.forward(request, response);
			} catch (ApplicationException e) {
				request.setAttribute("err", e.getMessage());
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}

		} else if ("create".equals(act)) {

			Goods goods = new Goods();
			for (FileItem item : fileItems) {
				try {
					if (item.isFormField()
							&& item.getFieldName().equals("goodsname"))
						goods.setGoodsName(item.getString("utf-8"));
					else if (item.isFormField()
							&& item.getFieldName().equals("act"))
						continue;
					else if (item.isFormField()
							&& item.getFieldName().equals("goodsprice"))
						goods.setGoodsPrice(Double.parseDouble(item
								.getString("utf-8")));

					else if (item.isFormField()
							&& item.getFieldName().equals("goodsadmin"))
						goods.setGoodsAdminId(Integer.parseInt(item
								.getString("utf-8")));

					else if (item.isFormField()
							&& item.getFieldName().equals("goodsqty")) {
						int cnt = Integer.parseInt(item.getString("utf-8"));
						if (cnt == 0) {
							goods.setGoodsIsEmpty(2);
							goods.setGoodsQty(cnt);
						} else {
							goods.setGoodsIsEmpty(1);
							goods.setGoodsQty(cnt);
						}
					} else if (!item.isFormField()
							|| item.getFieldName().equals("goodsimage")) {
						byte[] goodsImage = new byte[(int) item.getSize()];
						item.getInputStream().read(goodsImage, 0,
								(int) item.getSize());
						goods.setGoodsImage(goodsImage);
					} else if (item.isFormField()
							&& item.getFieldName().equals("goodsdesc")) {
						if (item.getString("utf-8").equals(""))
							goods.setGoodsDesc("暂无商品说明");
						else
							goods.setGoodsDesc(item.getString("utf-8"));
					}

					else if (item.isFormField()
							&& item.getFieldName().equals("goodsctgid")) {
						try {
							goods.setGoodsCtgId(Integer.parseInt(item
									.getString("utf-8")));
						} catch (Exception e) {
							String detail = "请检查商品类别是否选对!";
							request.setAttribute("err", detail);
							request.getRequestDispatcher(
									"/action/goodsMgr?act=input").forward(
									request, response);
							return;
						}
					}
				} catch (ApplicationException e) {

					request.getRequestDispatcher("/jsps/error/error.jsp")
							.forward(request, response);
				}
			}

			try {
				GoodsService goodsService = new GoodsServiceImpl();
				goodsService.addGoods(goods);
			} catch (ApplicationException e) {

				String detail = "请检查商品类别是否选对!";
				request.setAttribute("err", e.getMessage() + detail);
				request.getRequestDispatcher("/jsps/goods/input_goods.jsp")
						.forward(request, response);
				return;
			}
			response
					.sendRedirect("/shop02/action/goodsMgr?act=loadPageGoods&seed=");
		} else if ("loadPageGoods".equals(act)) {
			try {
				Integer pageNo = null;
				GoodsQueryHelper helper = new GoodsQueryHelper();
				SmallCategoryService ctgService = new SmallCategoryServiceImpl();
				CategoryService categoryService = new CategoryServiceImpl();
				List<SmallCategory> ctgList = ctgService.loadall();
				List<Category> bigCtgList = categoryService.loadAll();

				if (StringUtils.isNotEmpty(request
						.getParameter("qurygoodsname"))) {
					helper.setGoodsName(request.getParameter("qurygoodsname"));
				}
				if (StringUtils.isNotEmpty(request
						.getParameter("qurygoodsctgid"))) {
					helper.setGoodsCtgId(Integer.parseInt(request
							.getParameter("qurygoodsctgid")));
				}
				else if(StringUtils.isNotEmpty(request
						.getParameter("qurygoodsbigctgid"))) {
					Integer bigCtgId = Integer.parseInt(request.getParameter("qurygoodsbigctgid"));
					SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();
					List<SmallCategory>sCtgList = smallCategoryService.loadallByBId(bigCtgId);
					helper.setGoodsCtgs(sCtgList);
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
				AdministratorService administratorService = new AdministratorServiceImpl();
				try {
					page = goodService.loadPagedGoods(page, helper);
					request.setAttribute("administrators", administratorService
							.loadAll());
					request.setAttribute("ctglist", ctgList);
					request.setAttribute("bigctglist", bigCtgList);
					request.setAttribute("pagedGoods", page);
					request.getRequestDispatcher("/jsps/goods/list_goods.jsp")
							.forward(request, response);
				} catch (ApplicationException e) {
					String detilStr = "查询输入不合法,查询失败";
					request.setAttribute("err", detilStr + e.getMessage());
					request.getRequestDispatcher("/jsps/goods/list_goods.jsp")
							.forward(request, response);
				}
			} catch (ApplicationException e) {
				// TODO: handle exception
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}

		} else if ("getimage".equals(act)) {
			try {
				double random = Math.random();
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
			}
		}

		else if ("delete".equals(act)) {
			try {
				int goodsId = Integer.parseInt(request.getParameter("goodsid"));

				GoodsService goodsService = new GoodsServiceImpl();
				try {
					goodsService.delete(goodsId);
				} catch (ApplicationException e) {
					// TODO: handle exception
					request.setAttribute("err", e.getMessage());
					request.getRequestDispatcher("/jsps/goods/list_goods.jsp")
							.forward(request, response);
					return;
				}

				response
						.sendRedirect("/shop02/action/goodsMgr?act=loadPageGoods");
			} catch (ApplicationException e) {
				// TODO: handle exception
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}
		} else if ("forupdate".equals(act)) {
			try {
				int goodsId = Integer.parseInt(request.getParameter("goodsid"));
				GoodsService goodsService = new GoodsServiceImpl();
				SmallCategoryService categoryService = new SmallCategoryServiceImpl();
				AdministratorService administratorService = new AdministratorServiceImpl();
				List<Administrator> administratorList = administratorService
						.loadAll();
				try {
					request.setAttribute("administrators", administratorList);
					request.setAttribute("ctgList", categoryService.loadall());
					request.setAttribute("goods", goodsService
							.getGoodsById(goodsId));
					request
							.getRequestDispatcher(
									"/jsps/goods/update_goods.jsp").forward(
									request, response);
				} catch (ApplicationException e) {
					request.setAttribute("err", e.getMessage());
					request.getRequestDispatcher("/jsps/goods/list_goods.jsp")
							.forward(request, response);
				}
			} catch (ApplicationException e) {
				// TODO: handle exception
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}
		}

		else if ("update".equals(act)) {
			try {
				Goods goods = new Goods();
				for (FileItem item : fileItems) {
					if (item.isFormField()
							&& item.getFieldName().equals("goodsname"))
						goods.setGoodsName(item.getString("utf-8"));
					else if (item.isFormField()
							&& item.getFieldName().equals("act"))
						continue;
					else if (item.isFormField()
							&& item.getFieldName().equals("goodsprice")) {

						goods.setGoodsPrice(Double.parseDouble(item
								.getString("utf-8")));
					} else if (item.isFormField()
							&& item.getFieldName().equals("goodsid")) {
						goods.setGoodsId(Integer.parseInt(item
								.getString("utf-8")));
					} else if (item.isFormField()
							&& item.getFieldName().equals("goodsctgid")) {
						goods.setGoodsCtgId(Integer.parseInt(item
								.getString("utf-8")));
					} else if (item.isFormField()
							&& item.getFieldName().equals("goodsadminid")) {

						goods.setGoodsAdminId(Integer.parseInt(item
								.getString("utf-8")));
					} else if (item.isFormField()
							&& item.getFieldName().equals("goodsqty")) {
						int cnt = Integer.parseInt(item.getString("utf-8"));
						if (cnt == 0) {
							goods.setGoodsIsEmpty(0);
							goods.setGoodsQty(cnt);
						} else {
							goods.setGoodsIsEmpty(1);
							goods.setGoodsQty(cnt);
						}
					} else if (!item.isFormField()
							&& item.getFieldName().equals("goodsimage")) {
						byte[] goodsImage = new byte[(int) item.getSize()];
						item.getInputStream().read(goodsImage, 0,
								(int) item.getSize());
						goods.setGoodsImage(goodsImage);
					} else if (item.isFormField()
							&& item.getFieldName().equals("goodsdesc"))
						goods.setGoodsDesc(item.getString("utf-8"));

				}
				GoodsService goodsService = new GoodsServiceImpl();
				try {
					goodsService.updateGoods(goods);
				} catch (ApplicationException e) {
					// e.printStackTrace();
					request.setAttribute("err", e.getMessage());
					request
							.getRequestDispatcher(
									"/jsps/goods/update_goods.jsp").forward(
									request, response);
					return;
					// TODO: handle exception
				}
				response
						.sendRedirect("/shop02/action/goodsMgr?act=loadPageGoods");
			} catch (ApplicationException e) {
				// TODO: handle exception
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}

		} else if ("getSubCtgs".equals(act)) {
			try {
				Integer bigCtg = null;
				if(request.getParameter("bigctgid").length()<=0) bigCtg =0;
				else bigCtg = Integer.parseInt(request.getParameter("bigctgid"));
				
				SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();
				List<SmallCategory> smallCtgList = smallCategoryService
						.getSubCtg(bigCtg);
				// ctg1-id:ctg1-name|ctg2-id:ctg2-name|......

				StringBuffer sb = new StringBuffer();
				for (SmallCategory ctg : smallCtgList) {
					sb.append(ctg.getSmallCtgId()).append(":").append(
							ctg.getSmallCtgName()).append("|");
				}
				if (sb.toString().length() > 0)
					sb.deleteCharAt(sb.length() - 1);

				System.out.println(sb.toString());

				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.write(sb.toString());
				out.flush();
				out.close();
			} catch (ApplicationException e) {
				// TODO: handle exception
				request.getRequestDispatcher("/jsps/error/error.jsp").forward(
						request, response);
			}

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
