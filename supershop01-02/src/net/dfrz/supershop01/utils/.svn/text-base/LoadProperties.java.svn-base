package net.dfrz.supershop01.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**                
 * Project: supershop01-02
 * ClassName: LoadProperties                                                        
 * Module ID: 4.6  
 * Comments: 加载配置文件  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-3-5
 * @Author J1205-supershop01                                                      
 * @version Version 10 
 */
public class LoadProperties {

	/**
	 * 读取配置文件的信息的静态方法
	 * @param keyName -查询的路径类型
	 * @return String
	 */
	public static String loadProperties(String keyName) {
		
		InputStream in = LoadProperties.class.getClassLoader().getResourceAsStream(
				"./net/dfrz/supershop01/config/fileUrl.properties");
		Properties p = new Properties();
		try {
			p.load(in);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return p.getProperty(keyName);
	}
}
