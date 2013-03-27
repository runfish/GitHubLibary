package net.dfrz.supershop01.utils;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**                
 * Project: supershop01-01
 * ClassName: RightFilter                                                       
 * Module ID: 4.6  
 * Comments: �û�����ϵͳ������  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-9
 * @see java.io.IOException
 * @see javax.servlet.Filter
 * @see javax.servlet.FilterChain
 * @see javax.servlet.FilterConfig
 * @see javax.servlet.ServletException
 * @see javax.servlet.ServletRequest
 * @see javax.servlet.ServletResponse
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @see #security
 * @see #code
 * @see #destroy()
 * @see #doFilter(ServletRequest, ServletResponse, FilterChain)
 * @see #init(FilterConfig)
 * @author J1205-supershop01                                                      
 * @version Version 10 
 */
public class RightFilter implements Filter {
	
	/**
	 * �������
	 */
	private String security=null;
	/**
	 * ��֤�����
	 */
	private String code=null;
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		
		String reqUri=req.getRequestURI(); //������ʵ�WEB��Դ
		
		String webSource=reqUri.substring(reqUri.lastIndexOf("/")+1);
		
		if(!(webSource.equals(security)||webSource.equals(code))){
			
		   if(req.getSession().getAttribute("admin")==null) //û�е�¼	
		   {
			   resp.sendRedirect("/shop02/action/securityMgr?act=gotoLogin");
			   return;
		   }
		}
				
		chain.doFilter(request, response);

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		security=filterConfig.getInitParameter("security");
		code=filterConfig.getInitParameter("code");
       
	}

}