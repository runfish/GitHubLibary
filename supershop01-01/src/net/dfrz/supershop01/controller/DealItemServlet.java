package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.DealItemService;
import net.dfrz.supershop01.services.DealService;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.servicesimpl.DealItemServiceImpl;
import net.dfrz.supershop01.servicesimpl.DealServiceImpl;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;
import net.dfrz.supershop01.utils.Page;
/**                
 * Project: supershop01-01
 * ClassName: DealItemServlet                                                        
 * Module ID: 4.6  
 * Comments: ������Ŀ������ֲ� 
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-2-6
 *@see java.io.IOException
 *@see java.io.PrintWriter
 *@see java.util.List
 *@see javax.servlet.ServletException
 *@see javax.servlet.http.HttpServlet
 *@see javax.servlet.http.HttpServletRequest
 *@see javax.servlet.http.HttpServletResponse
 *@see net.dfrz.supershop01.domain.Category
 *@see  net.dfrz.supershop01.domain.Deal
 *@see net.dfrz.supershop01.domain.DealItem
 *@see  net.dfrz.supershop01.domain.Goods
 *@see  net.dfrz.supershop01.domain.SmallCategory
 *@see net.dfrz.supershop01.exception.ApplicationException
 *@see  net.dfrz.supershop01.services.DealItemService
 *@see  net.dfrz.supershop01.services.DealService
 *@see  net.dfrz.supershop01.services.GoodsService
 *@see  net.dfrz.supershop01.services.SmallCategoryService
 *@see  net.dfrz.supershop01.servicesimpl.DealItemServiceImpl
 *@see net.dfrz.supershop01.servicesimpl.DealServiceImpl
 *@see  net.dfrz.supershop01.servicesimpl.GoodsServiceImpl
 *@see  net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl
 *@see net.dfrz.supershop01.utils.Page
 *@see #doPost(HttpServletRequest, HttpServletResponse)
 *@see #doGet(HttpServletRequest, HttpServletResponse)
 * @author J1205-HongHG                                                      
 * @version Version 150 
 */
public class DealItemServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	
	public DealItemServlet() {
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
		/**
		 * ��ȡҪ��ѯ�Ķ��������ж�����Ŀ����Ϣ�Լ�������ϸ��Ϣ����װ��HTMLҳ�淵���û�����
		 */
		if("loadPageDealItem".equals(act))
		{
			/**
			 * ��ȡҪ��ѯ��ϸ��Ϣ�Ķ������
			 */
			Integer dealId=Integer.parseInt(request.getParameter("dealid"));
			request.getSession(false).setAttribute("dealId", dealId);
			
			try 
			{
				/**
				 * �����ݿ��ȡ��صĶ�����Ϣ���з�װ
				 */
				
				
				/**
				 * ����htmlҳ�棬�Ա���ʾ��������ϸ��Ϣ
				 */
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				/**
				 * ��ȡҪ�鿴��ϸ��Ϣ�Ķ�������
				 */
				DealService dealService=new DealServiceImpl();
				Deal deal=dealService.getDealById(dealId);
				
				out.print("<div>");
				out.print("<div style=\"border:1px solid gray;background:#eae7d7\">");
				out.print("����������Ϣ");
				out.print("</div>");
				out.print("<div>");
				out.print("�ջ�����:"+deal.getConsigneeInfo().split(":")[0]);
				out.print("</div>");
				out.print("<div>");
				out.print("�ջ���ַ��"+deal.getConsigneeInfo().split(":")[1]);
				out.print("</div>");
				out.print("<div>");
				out.print("�������룺"+deal.getConsigneeInfo().split(":")[2]);
				out.print("</div>");
				out.print("<div>");
				out.print("��ϵ��ʽ��"+deal.getConsigneeInfo().split(":")[3]);
				out.print("</div>");
				out.print("<div>");
				out.print("�������䣺"+deal.getConsigneeInfo().split(":")[4]);
				out.print("</div>");
				out.print("<hr>");
				if(deal.getPayPattern().equals("b"))
				{
					out.print("<div>");
					out.print("���ʽ���˻�֧��");
					out.print("</div>");
				}
				else if(deal.getPayPattern().equals("c"))
				{
					out.print("<div>");
					out.print("���ʽ������֧��");
					out.print("</div>");
				}
				if(deal.getReceivePattern().equals("b"))
				{
					out.print("<div>");
					out.print("�ջ���ʽ��ƽ��");
					out.print("</div>");
				}
				if(deal.getReceivePattern().equals("c"))
				{
					out.print("<div>");
					out.print("�ջ���ʽ�����");
					out.print("</div>");
				}
				if(deal.getReceivePattern().equals("d"))
				{
					out.print("<div>");
					out.print("�ջ���ʽ��ESM");
					out.print("</div>");
				}
				out.print("<hr>");
				out.print("<div>");
				out.print("�µ�ʱ�䣺"+deal.getDealDate());
				out.print("</div>");
				if(deal.getDealStatus().equals("a"))
				{
					out.print("<div>");
					out.print("����״̬��δ����");
					out.print("</div>");
				}
				if(deal.getDealStatus().equals("b"))
				{
					out.print("<div>");
					out.print("����״̬���ѷ���");
					out.print("</div>");
				}
				if(deal.getDealStatus().equals("c"))
				{
					out.print("<div>");
					out.print("����״̬�����˻�");
					out.print("</div>");
				}
				if(deal.getDealExamDate()!=null)
				{
					out.print("<div>");
					out.print("���ʱ�䣺"+deal.getDealExamDate());
					out.print("</div>");
				}
				else
				{
					out.print("<div>");
					out.print("���ʱ�䣺------");
					out.print("</div>");
				}
				/**
				 * ��ȡ������ϸ��Ϣ����Ķ�����Ŀ��Ϣ
				 * Ϊ����ѯ�Ķ����µ����ж�����Ŀ���±�д������Ŀ���itemId
				 */
				Page pagedDealItem=new Page();
				pagedDealItem.setPageSize(50);
				DealItemService dealItemService=new DealItemServiceImpl();
				pagedDealItem=dealItemService.loadPage(pagedDealItem, dealId);
				List<DealItem>dealItemList=(List<DealItem>)pagedDealItem.getPageContent();
			    Integer itemId  =  new Integer(1);
				
				out.print("<div style=\"border:1px solid gray;background:#eae7d7\">");
				out.print("������Ŀ��Ϣ");
				out.print("</div>");
				out.print("<div>");
				out.println("<table id=\"listtable\" cellpadding=\"0\" cellspacing=\"0\">");
				out.println("<tr>");
				out.print("<th>");
				out.print("��Ŀ���");
				out.print("</th>");
				out.print("<th>");
				out.print("��Ʒ����");
				out.print("</th>");
				out.print("<th>");
				out.print("��Ʒ����");
				out.print("</th>");
				out.print("<th>");
				out.print("��Ʒ����");
				out.print("</th>");
				out.print("<th>");
				out.print("��Ʒ����");
				out.print("</th>");
				out.print("<th>");
				out.print("��Ʒ�ܶ�");
				out.print("</th>");
				out.println("</tr>");
				for(DealItem item:dealItemList)
				{
					out.println("<tr>");
					out.print("<td>");
					out.print(itemId++);
					out.print("</td>");
					out.print("<td>");
					/**
					 * ��ȡ������ϸ��Ϣ�������Ʒ��Ϣ
					 */
					GoodsService goodsService=new GoodsServiceImpl();
					Goods goods=goodsService.getGoodsById(item.getDealGoodsId());
					out.print("<a href='/shop01/action/goodsMgr?act=getgoodsdetail&bigctgid=index&goodsid="+goods.getGoodsId()+"'" +
							 "target='_blank' title='����鿴��Ʒ��ϸ��Ϣ'>" +
							goods.getGoodsName()+"</a>");
					out.print("</td>");
					out.print("<td>");
					/**
					 * ��ȡ������ϸ��Ϣ�������Ʒ�����Ϣ
					 */
					SmallCategoryService smallCategoryService=new SmallCategoryServiceImpl();
					SmallCategory smallCategory=smallCategoryService.getCtg(item.getDealGoodsCtgId());
					Category category=smallCategory.getBigCategory();
					out.print(category.getCtgName()+"->"+smallCategory.getSmallCtgName());
					out.print("</td>");
					out.print("<td>");
					out.print(item.getItemGoodsPrice());
					out.print("</td>");
					out.print("<td>");
					out.print(item.getItemGoodsQty());
					out.print("</td>");
					out.print("<td>");
					out.print(item.getItemGoodsPrice()*item.getItemGoodsQty());
					out.print("</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.print("</div>");
				out.print("<div>");
				out.print("<input type=\"button\" value=\"����\" title=\"������ض����б�\" onclick=\"cleanChild(this)\" style=\"width:80px;\" />");
				out.print("</div>");
				out.print("</div>");
				
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
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

		doGet(request,response);
	}

}
