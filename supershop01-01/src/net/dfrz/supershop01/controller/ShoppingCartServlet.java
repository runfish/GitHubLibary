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
 * Comments: ���ﳵ���ֲ�  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-2-24
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
			 * ��ù��ﳵ�������session�ռ䲻���ڹ��ﳵ�����½�һ�����ﳵ���������±��浽session�ռ�
			 */
			ShoppingCart myCart=(ShoppingCart)request.getSession().getAttribute("mycart");
			if(myCart==null)
			{
				myCart=new ShoppingCart();
				myCart.setCartItemAmount(0);
				myCart.setTotalAmount(0.0);
			}
			/**
			 * �½��յ��û������Լ��յ���Ʒ����
			 */
			Customer customer=null;
			Goods goods=null;
		
			try 
			{
				/**
				 * �ж��û��Ƿ��Ѿ�����,����û�δ����ܾ��û����ʹ��ﳵ���׳���Ӧ���쳣
				 */
				customer=(Customer)request.getSession().getAttribute("customer");
				if(customer==null)
				{
					LOGGER.error("������̳��ʺţ����ܵ�����빺�ﳵ!");
					throw new ApplicationException("������̳��ʺţ����ܵ�����빺�ﳵ|login|");
				}
				
				/**
				 * ��ȡ��Ʒ��������֤��Ʒ�����Ƿ�Ϊ�㣬Ϊ��ܾ�����Ʒ���빺�ﳵ�����׳��쳣��������Ʒ���빺�ﳵ��
				 */
				Integer goodsId=Integer.parseInt(request.getParameter("goodsid"));		
				GoodsService goodsService=new GoodsServiceImpl();
				goods=goodsService.getGoodsById(goodsId);
				if(goods.getGoodsQty()<=0)
				{
					LOGGER.error("�Բ������Ʒ��ʱȱ������ѡ��������Ʒ���й���");
					throw new ApplicationException("�Բ������Ʒ��ʱȱ������ѡ��������Ʒ���й���");
				}
				/**
				 * ��������Ŀ���빺�ﳵ����ǰ���Թ��ﳵ�ĵ�ǰ״̬�����ж��Ƿ��µ���Ʒ���빺�ﳵ�������ﳵ��Ʒ�����Ѿ��ﵽ������
				 * �ܾ��û���������Ʒ���빺�ﳵ�У����׳���Ӧ���쳣����ǰ�趨�Ĺ��ﳵ��Ʒ��������Ϊ20����
				 */
				if(myCart.getCartItemAmount()+1<=20)
				{
					ShoppingCartService shoppingCartService=new ShoppingCartServiceImpl();
					shoppingCartService.addGoodsToCart(goods, myCart);
					/**
					 * �����ﳵ�������±��浽Session�ռ�
					 */
					request.getSession().setAttribute("mycart", myCart);
					/**
					 * �׳��쳣��ʾ��Ʒ�Ѿ��ɹ����빺�ﳵ��
					 */
					LOGGER.info("��Ʒ�Ѿ��ɹ����빺�ﳵ��");
					throw new ApplicationException("��Ʒ�Ѿ��ɹ����빺�ﳵ��"+"|"+myCart.getCartItemAmount()+":"+myCart.getTotalAmount()+"|");
				}
				else
				{
					LOGGER.error("�Բ����ﳵ���������ȴ����¹��ﳵ�ڵ���Ʒ��");
					throw new ApplicationException("�Բ����ﳵ���������ȴ����¹��ﳵ�ڵ���Ʒ��");
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
			 * ��ȡҪɾ���Ĺ��ﳵ��Ŀ�ı��
			 */
			Integer index=Integer.parseInt(request.getParameter("index"));
			/**
			 * ��ȡ���ﳵ�����Լ���ȡ��ǰҪɾ���Ĺ��ﳵ��Ŀ���󣬲����й��ﳵ�е���Ʒ��Ϣ��ɾ������
			 */
			ShoppingCart myCart=(ShoppingCart)request.getSession().getAttribute("mycart");
			CartItem cartItem=myCart.getCartList().get(index);
			ShoppingCartService shoppingCartService=new ShoppingCartServiceImpl();
			shoppingCartService.removeGoodsFromCart(cartItem, myCart);
			/**
			 * ����session�ռ�Ĺ��ﳵ������Ϣ
			 */
			request.getSession().setAttribute("mycart", myCart);
			response.sendRedirect("/shop01/action/cartMgr?act=loadall");
		}
		else if(act.equals("changeqty")) 
		{
			/**
			 * �Թ��ﳵ�е���Ʒ��������Ʒ����������������һ��ֻ�ܼ�һ���߼�һ������
			 * ��ȡ�����޸ĵ����ͣ�type��ʾ���������ͣ�type=add��ʾ������Ʒ������type=sub��ʾ������Ʒ����
			 */
			String type=request.getParameter("type");
			/**
			 * ��ȡҪ������Ʒ�����Ĺ��ﳵ��Ŀ����Ĺ��ﳵ��Ŀ���
			 * �����ﳵ��Ŀ��Ÿ��ݵ�ǰ���ﳵ��Ŀ�����ڹ��ﳵ�������������ڵĵ�ַ�������±꣩
			 */
			Integer index=Integer.parseInt(request.getParameter("index"));
			/**
			 * ��ȡ���ﳵ�����޸ĵ�ǰ���ﳵ��ѡ�е���Ʒ������
			 */
			ShoppingCart myCart=null;
			CartItem cartItem=null;
			try 
			{
				/**
				 * ��ȡ���ﳵ�����Լ�Ҫ�޸ĵĹ��ﳵ��Ŀ
				 */
				myCart=(ShoppingCart)request.getSession().getAttribute("mycart");
				cartItem=myCart.getCartList().get(index);
				/**
				 * ��ȡҪ���ӵ���Ʒ����
				 */
				GoodsService goodsService = new GoodsServiceImpl();
				Goods goods = goodsService.getGoodsById(cartItem.getGoodsId());
				/**
				 * ����type�����ͽ��й��ﳵ�������ز���
				 * �Ե�ǰ���ﳵ��״̬����һ���ж�,���жϸ���Ʒ�����Ŀ�����
				 * ������ﳵ�е���Ʒ�����Ѿ��������׳���Ӧ���쳣
				 * ����û�Ҫ�������Ʒ�����Ѿ���������Ʒ��ǰ�Ŀ�����������׳���Ӧ���쳣�ܾ��û������Ӳ���
				 * ��ǰ���ﳵ�еĵ�����Ʒ������Ϊ1ʱ�����׳��쳣�ܾ��û��ļ��ٲ���
				 */
				if(type.equals("add"))
				{
					if(myCart.getCartItemAmount()+1>20)
					{
						LOGGER.error("�Բ����ﳵ���������ȴ����¹��ﳵ�ڵ���Ʒ��");
						throw new ApplicationException("�Բ����ﳵ���������ȴ����¹��ﳵ�ڵ���Ʒ��");
					}
					
					if(goods.getGoodsQty()-cartItem.getGoodsQty()-1<=0)
					{
						LOGGER.error("�Բ�����ѡ�����Ʒ�����Ѵ����Ʒ�Ŀ�����ޣ��޷��������ӣ�");
						throw new ApplicationException("�Բ�����ѡ�����Ʒ�����Ѵ����Ʒ�Ŀ�����ޣ��޷��������ӣ�");
					}
				}
				else if(type.equals("sub"))
				{
					if(cartItem.getGoodsQty()-1<=0)
					{
						LOGGER.error("��Ʒ�����Ѿ�Ϊ1�������ټ�����������ɾ��,�Ƴ���Ʒ��");
						throw new ApplicationException("��Ʒ�����Ѿ�Ϊ1�������ټ�����������ɾ��,�Ƴ���Ʒ!");
					}
				}
				/**
				 * ��������������������Ҫ��ʱ���Ŷ���Ҫ�޸ĵĹ��ﳵ�еĹ��ﳵ��Ŀ��������޸��Լ��������
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
			 * ���깺�ﳵ�е���Ʒ�������޸ĺ󣬶�Session�ռ��еĹ��ﳵ���и��£��������¹��ﳵ״̬��Ϣ�����û�����
			 */
			request.getSession().setAttribute("mycart", myCart);
			PrintWriter out=response.getWriter();
			out.println("input|"+cartItem.getGoodsQty()+"|"+myCart.getCartItemAmount()+"|"+myCart.getTotalAmount()+"|"+(cartItem.getGoodsPrice()*cartItem.getGoodsQty())+"|");
		}
		else if(act.equals("loadall")) 
		{
			/**
			 * ��ù��ﳵ�����ȫ����Ϣ���Ա����������ʾ
			 */
			ShoppingCart myCart=(ShoppingCart)request.getSession().getAttribute("mycart");
			/**
			 * ������ﳵ���󲻴��ڣ��򴴽�һ���յĹ��ﳵ���󣬵��ǲ��������Session�ռ���
			 */
			if(myCart==null)
			{
				myCart=new ShoppingCart();
				myCart.setCartItemAmount(0);
				myCart.setTotalAmount(0.0);
			}
			/**
			 * ��ȡ���ﳵ��Ϣ��ʾ�������Ʒ�б���Ϣ�Լ���Ʒ����б���Ϣ
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
			 * �����ﳵ��ʾ�����������Ϣ����RequestScope��
			 */
			request.setAttribute("mycart",myCart);
			request.setAttribute("goodslist", goodsList);
			request.setAttribute("ctgList", ctgList);
			request.getRequestDispatcher("/jsps/deals/cart_list.jsp").forward(request, response);
		}
		else if(act.equals("gotoconfirm"))
		{
			/**
			 * �û��Թ��ﳵ�е���Ʒ���н���ʱ��ҳ����ת��������Ϣ��д����
			 * ��õ�ǰ�û���Ϣ���Ա�����״ν��붩����д����ʱ�ĵ��ջ�����Ϣ����д
			 * ������Customer�����в������ջ�����Ϣ�����飬������ʱ�޷�ʵ�ָ����ջ�����Ϣ��ѡ�����ֶ���д��
			 */
			Customer customer = (Customer)request.getSession().getAttribute("customer");
			/**
			 * ��õ�ǰ���ﳵ������Ϣ������ɶ����������û����������Ʒ��Ϣ����ʾ
			 */
			ShoppingCart myCart=(ShoppingCart)request.getSession().getAttribute("cart");
			/**
			 * ��ȡ��ʾ�������Ʒ�����Լ���Ʒ����б���Ϣ
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
			 * ��ù��ﳵ�����ʵʱ��Ϣ���Ա��ܹ����û����и����йع��ﳵ����ʱ������ʵʱ�ĸ����û������ϵĹ��ﳵ״̬��Ϣ
			 */
			ShoppingCart myCart=(ShoppingCart)request.getSession().getAttribute("mycart");
			/**
			 * ������ﳵ���󲻴��ڣ��򴴽�һ���յĹ��ﳵ���󣬵��ǲ��������Session�ռ���
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
