package net.dfrz.supershop01.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
/**                
 * Project: supershop01-01
 * ClassName: CheckCodeServlet                                                        
 * Module ID: 4.6  
 * Comments: 验证码JPG图片  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-26
 * @see java.awt.Color
 * @see java.awt.Font
 * @see java.awt.Graphics
 * @see java.awt.image.BufferedImage
 * @see java.io.IOException
 * @see java.util.Random
 * @see javax.servlet.ServletException
 * @see javax.servlet.ServletOutputStream
 * @see javax.servlet.http.HttpServlet
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @see org.apache.commons.lang3.RandomStringUtils
 * @see com.sun.image.codec.jpeg.JPEGCodec
 * @see com.sun.image.codec.jpeg.JPEGImageEncoder
 * @see #height
 * @see #width
 * @see #doGet(HttpServletRequest, HttpServletResponse)
 * @see #doPost(HttpServletRequest, HttpServletResponse)
 * @author J1205-supershop01                                                     
 * @version Version 120 
 */
public class CheckCodeServlet extends HttpServlet {
	/**
	 * 图片的高度
	 */
	private int height=21;
	/**
	 * 图片的宽度
	 */
	private int width=57;

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
        /**
         * 设置输出数据的格式为image/jpeg
         */
		response.setContentType("image/jpeg");
		
		ServletOutputStream out=response.getOutputStream();
		/**
		 * 创建一个图片缓冲区
		 */
		BufferedImage bImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		/**
		 * 由绘图工具类获得该图片缓冲区的内容
		 */
		Graphics graphics=bImage.getGraphics();
		/**
		 * 设置图片的背景颜色并进行填充
		 */
		graphics.setColor(getColor(200,250));
		/**
		 * 定义图片的填充范围
		 */
		graphics.fillRect(0, 0, width, height);
		/**
		 * 设置图片内容的字体样式
		 */
		graphics.setFont(new Font("Times New Roman",Font.PLAIN,18));
		/**
		 * 随机产生200条干扰线条
		 */
		Random random=new Random();
		graphics.setColor(getColor(160, 200));
		for(int i=0;i<200;i++){
			int x1=random.nextInt(width);
			int y1=random.nextInt(height);
			int x2=random.nextInt(15);
			int y2=random.nextInt(15);
			graphics.drawLine(x1, y1, x1+x2, y1+y2);
		}
		/**
		 * 随机产生100个干扰点
		 */
		graphics.setColor(getColor(120, 240));
		for(int i=0;i<100;i++){
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			graphics.drawOval(x,y,0,0);
		}
		/**
		 * 随机产生4个随机数字或者大写字母
		 */
		String baseString="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String checkcode=RandomStringUtils.random(4,baseString);
		graphics.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
		graphics.drawString(checkcode,0, 16);
		/**
		 * 释放图缓冲区资源
		 */
		graphics.dispose();
		
		request.getSession().setAttribute("checkcode", checkcode);
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
		encoder.encode(bImage);
		
		out.flush();
		out.close();
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
	/**
	 * 
	 * @param fc - 颜色参数
	 * @param bc - 颜色参数
	 * @return Color
	 */
	public Color getColor(int fc,int bc){
		Random r=new Random();
		if(fc>255) fc=255;
		if(bc>255) bc=255;
		int red=fc+r.nextInt(bc-fc);//红
		int green=fc+r.nextInt(bc-fc);//绿
		int blue=fc+r.nextInt(bc-fc);//蓝
		return new Color(red,green,blue);
	}
}
