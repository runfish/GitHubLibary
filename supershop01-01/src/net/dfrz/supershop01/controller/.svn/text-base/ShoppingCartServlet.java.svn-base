package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.dfrz.supershop01.domain.CartItem;
import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.ShoppingCart;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.services.ShoppingCartService;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.servicesimpl.ShoppingCartServiceImpl;
import net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;
/**                
 * Project: supershop01-01
 * ClassName: ShoppingCartServlet                                                          
 * Comments: 购物车表现层  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-2-24
 * @see java.io.IOException
 * @see java.io.PrintWriter
 * @see java.util.List
 * @see javax.servlet.ServletException
 * @see javax.servlet.http.HttpServlet
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @see net.dfrz.supershop01.domain.CartItem
 * @see net.dfrz.supershop01.domain.Customer
 * @see net.dfrz.supershop01.domain.Goods
 * @see net.dfrz.supershop01.domain.ShoppingCart
 * @see net.dfrz.supershop01.domain.SmallCategory
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see net.dfrz.supershop01.services.GoodsService
 * @see net.dfrz.supershop01.services.ShoppingCartService
 * @see net.dfrz.supershop01.services.SmallCategoryService
 * @see net.dfrz.supershop01.servicesimpl.GoodsServiceImpl
 * @see net.dfrz.supershop01.servicesimpl.ShoppingCartServiceImpl
 * @see net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @see #doPost(HttpServletRequest, HttpServletResponse)
 * @author J1205-HongHG
 * @version 292
 */
public class ShoppingCartServlet extends HttpServlet {
	private static final Logger LOGGER=Logger.getLogger(ShoppingCartServlet.class);
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
		response.setCharacterEncoding("utf-8");
		
		if(act.equals("add"))
		{
			/**
			 * 获得购物车对象，如果session空间不存在购物车对象，新建一个购物车对象并且重新保存到session空间
			 */
			ShoppingCart myCart=(ShoppingCart)request.getSession().getAttribute("mycart");
			if(myCart==null)
			{
				myCart=new ShoppingCart();
				myCart.setCartItemAmount(0);
				myCart.setTotalAmount(0.0);
			}
			/**
			 * 新建空的用户对象，以及空的商品对象
			 */
			Customer customer=null;
			Goods goods=null;
		
			try 
			{
				/**
				 * 判断用户是否已经登入,如果用户未登入拒绝用户访问购物车，抛出相应的异常
				 */
				customer=(Customer)request.getSession().getAttribute("customer");
				if(customer==null)
				{
					LOGGER.error("请登入商场帐号，才能点击加入购物车!");
					throw new ApplicationException("请登入商场帐号，才能点击加入购物车|login|");
				}
				
				/**
				 * 获取商品对象并且验证商品数量是否为零，为零拒绝将商品加入购物车，并抛出异常，否则将商品加入购物车中
				 */
				Integer goodsId=Integer.parseInt(request.getParameter("goodsid"));		
				GoodsService goodsService=new GoodsServiceImpl();
				goods=goodsService.getGoodsById(goodsId);
				if(goods.getGoodsQty()<=0)
				{
					LOGGER.error("对不起该商品暂时缺货，请选择其他商品进行购买！");
					throw new ApplicationException("对不起该商品暂时缺货，请选择其他商品进行购买！");
				}
				/**
				 * 将订单条目加入购物车对象前，对购物车的当前状态进行判断是否将新的商品加入购物车，当购物车商品数量已经达到上限则
				 * 拒绝用户继续将商品加入购物车中，并抛出相应的异常（当前设定的购物车商品数量上限为20件）
				 */
				if(myCart.getCartItemAmount()+1<=20)
				{
					ShoppingCartService shoppingCartService=new ShoppingCartServiceImpl();
					shoppingCartService.addGoodsToCart(goods, myCart);
					/**
					 * 将购物车对象重新保存到Session空间
					 */
					request.getSession().setAttribute("mycart", myCart);
					/**
					 * 抛出异常提示商品已经成功加入购物车中
					 */
					LOGGER.info("商品已经成功加入购物车！");
					throw new ApplicationException("商品已经成功加入购物车！"+"|"+myCart.getCartItemAmount()+":"+myCart.getTotalAmount()+"|");
				}
				else
				{
					LOGGER.error("对不起购物车已满，请先处理下购物车内的商品！");
					throw new ApplicationException("对不起购物车已满，请先处理下购物车内的商品！");
				}
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				PrintWriter pw=response.getWriter();
				pw.println(e.getMessage());
				e.printStackTrace();
			}
		}
		else if(act.equals("del"))
		{
			/**
			 * 获取要删除的购物车条目的编号
			 */
			Integer index=Integer.parseInt(request.getParameter("index"));
			/**
			 * 获取购物车对象，以及获取当前要删除的购物车条目对象，并进行购物车中的商品信息的删除操作
			 */
			ShoppingCart myCart=(ShoppingCart)request.getSession().getAttribute("mycart");
			CartItem cartItem=myCart.getCartList().get(index);
			ShoppingCartService shoppingCartService=new ShoppingCartServiceImpl();
			shoppingCartService.removeGoodsFromCart(cartItem, myCart);
			/**
			 * 更新session空间的购物车对象信息
			 */
			request.getSession().setAttribute("mycart", myCart);
			response.sendRedirect("/shop01/action/cartMgr?act=loadall");
		}
		else if(act.equals("changeqty")) 
		{
			/**
			 * 对购物车中的商品，进行商品数量的增减操作（一次只能加一或者减一操作）
			 * 获取数据修改的类型，type表示操作的类型，type=add表示增加商品数量，type=sub表示减少商品数量
			 */
			String type=request.getParameter("type");
			/**
			 * 获取要更改商品数量的购物车条目对象的购物车条目编号
			 * （购物车条目编号根据当前购物车条目对象在购物车对象数组中所在的地址的数组下标）
			 */
			Integer index=Integer.parseInt(request.getParameter("index"));
			/**
			 * 获取购物车对象并修改当前购物车中选中的商品的数量
			 */
			ShoppingCart myCart=null;
			CartItem cartItem=null;
			try 
			{
				/**
				 * 获取购物车对象以及要修改的购物车条目
				 */
				myCart=(ShoppingCart)request.getSession().getAttribute("mycart");
				cartItem=myCart.getCartList().get(index);
				/**
				 * 获取要增加的商品对象
				 */
				GoodsService goodsService = new GoodsServiceImpl();
				Goods goods = goodsService.getGoodsById(cartItem.getGoodsId());
				/**
				 * 根据type的类型进行购物车对象的相关操作
				 * 对当前购物车的状态进行一次判断,并判断该商品数量的库存情况
				 * 如果购物车中的商品数量已经满，则抛出相应的异常
				 * 如果用户要购买的商品数量已经超出了商品当前的库存数量，则抛出相应的异常拒绝用户的增加操作
				 * 当前购物车中的单件商品的数量为1时，则抛出异常拒绝用户的减少操作
				 */
				if(type.equals("add"))
				{
					if(myCart.getCartItemAmount()+1>20)
					{
						LOGGER.error("对不起购物车已满，请先处理下购物车内的商品！");
						throw new ApplicationException("对不起购物车已满，请先处理下购物车内的商品！");
					}
					
					if(goods.getGoodsQty()-cartItem.getGoodsQty()-1<=0)
					{
						LOGGER.error("对不起你选择的商品数量已达该商品的库存上限，无法继续增加！");
						throw new ApplicationException("对不起你选择的商品数量已达该商品的库存上限，无法继续增加！");
					}
				}
				else if(type.equals("sub"))
				{
					if(cartItem.getGoodsQty()-1<=0)
					{
						LOGGER.error("商品数量已经为1件不能再减，或者请点击删除,移除物品！");
						throw new ApplicationException("商品数量已经为1件不能再减，或者请点击删除,移除物品!");
					}
				}
				/**
				 * 当以上所有条件均满足要求时，才对需要修改的购物车中的购物车条目对象进行修改以及保存操作
				 */
				ShoppingCartService shoppingCartService=new ShoppingCartServiceImpl();
				shoppingCartService.updateCartAmount(cartItem, myCart, type);
	
							
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				PrintWriter out=response.getWriter();
				out.println("error|"+e.getMessage());
				return;
			}
			/**
			 * 做完购物车中的商品数量的修改后，对Session空间中的购物车进行更新，并将最新购物车状态信息返回用户界面
			 */
			request.getSession().setAttribute("mycart", myCart);
			PrintWriter out=response.getWriter();
			out.println("input|"+cartItem.getGoodsQty()+"|"+myCart.getCartItemAmount()+"|"+myCart.getTotalAmount()+"|"+(cartItem.getGoodsPrice()*cartItem.getGoodsQty())+"|");
		}
		else if(act.equals("loadall")) 
		{
			/**
			 * 获得购物车对象的全部信息，以便进行批量显示
			 */
			ShoppingCart myCart=(ShoppingCart)request.getSession().getAttribute("mycart");
			/**
			 * 如果购物车对象不存在，则创建一个空的购物车对象，但是不将其存入Session空间中
			 */
			if(myCart==null)
			{
				myCart=new ShoppingCart();
				myCart.setCartItemAmount(0);
				myCart.setTotalAmount(0.0);
			}
			/**
			 * 获取购物车信息显示所需的商品列表信息以及商品类别列表信息
			 */
			List<Goods>goodsList=null;
			List<SmallCategory>ctgList=null;
			try 
			{
				GoodsService goodsService=new GoodsServiceImpl();
				goodsList=goodsService.loadAll();
				SmallCategoryService smallCategoryService=new SmallCategoryServiceImpl();
				ctgList=smallCategoryService.loadall();
			} catch (ApplicationException e) {
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				// TODO: handle exception
			}
			/**
			 * 将购物车显示所需的所有信息存入RequestScope中
			 */
			request.setAttribute("mycart",myCart);
			request.setAttribute("goodslist", goodsList);
			request.setAttribute("ctgList", ctgList);
			request.getRequestDispatcher("/jsps/deals/cart_list.jsp").forward(request, response);
		}
		else if(act.equals("gotoconfirm"))
		{
			/**
			 * 用户对购物车中的商品进行结算时，页面跳转至订单信息填写界面
			 * 获得当前用户信息，以便完成首次进入订单填写界面时的的收货人信息的填写
			 * （由于Customer对象中不含有收货人信息的数组，所以暂时无法实现跟多收货人信息的选择，需手动填写）
			 */
			Customer customer = (Customer)request.getSession().getAttribute("customer");
			/**
			 * 获得当前购物车对象信息，已完成订单界面中用户所购买的商品信息的显示
			 */
			ShoppingCart myCart=(ShoppingCart)request.getSession().getAttribute("cart");
			/**
			 * 获取显示所需的商品对象以及商品类别列表信息
			 */
			List<Goods>goodsList=null;
			List<SmallCategory>ctgList=null;
			try 
			{
				GoodsService goodsService=new GoodsServiceImpl();
				goodsList=goodsService.loadAll();
				SmallCategoryService smallCategoryService=new SmallCategoryServiceImpl();
				ctgList=smallCategoryService.loadall();
			} catch (ApplicationException e) {
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				// TODO: handle exception
			}
			request.setAttribute("customer", customer);
			request.setAttribute("mycart",myCart);
			request.setAttribute("goodslist", goodsList);
			request.setAttribute("ctglist", ctgList);
			request.getRequestDispatcher("/jsps/deals/consignee_info.jsp").forward(request, response);
		}
		else if(act.equals("getmsg"))
		{
			/**
			 * 获得购物车对象的实时信息，以便能够在用户进行各种有关购物车操作时，可以实时的更新用户界面上的购物车状态信息
			 */
			ShoppingCart myCart=(ShoppingCart)request.getSession().getAttribute("mycart");
			/**
			 * 如果购物车对象不存在，则创建一个空的购物车对象，但是不将其存入Session空间中
			 */
			if(myCart==null)
			{
				myCart=new ShoppingCart();
				myCart.setCartItemAmount(0);
				myCart.setTotalAmount(0.0);
			}
			
			PrintWriter pw=response.getWriter();
			System.out.println("|"+myCart.getCartItemAmount()+":"+myCart.getTotalAmount()+"|");
			pw.println(myCart.getCartItemAmount()+":"+myCart.getTotalAmount());
			
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
