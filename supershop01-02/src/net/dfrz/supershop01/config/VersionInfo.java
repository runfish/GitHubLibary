
package net.dfrz.supershop01.config;
/**                
 * Project: supershop01-02
 * ClassName: VersionInfo                                                        
 * Module ID: 4.6  
 * Comments: 当前工程的基本信息  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @author J1205-supershop01                                                      
 * @version Version 10 
 */
public final class VersionInfo {
    /**
     * 项目工程名称
     */
	public final static String APP_NAME="电子商务后台管理系统";
	/**
	 * 当前项目工程的版本号
	 */
    public final static String APP_VERSION="1.0";
    /**
     * 当前的项目工程的类型
     */
    public final static String APP_STATUS="Beta";
    /**
     * 项目工程的创建时间
     */
    public final static String APP_BUILDATE="2013-01-01";
    /**
     * 项目工程的buildver
     */
    public final static String APP_BUILDVER="#2";
    	
    /**
     * 工程项目的开发团队
     */
    public final static String APP_AUTHOR="JAVA1205 SuperShop01";
    /**
     * 项目工程隶属的公司名称
     */
    public final static String APP_WORKSTUDIO="2003-2012 东方锐智 ";
    /**
     * 将项目工程的基本信息整合成字符串返回
     * @return String
     */
    public final static String buildFooterStr()
    {
    	StringBuffer sb=new StringBuffer();

    	sb.append(APP_NAME);
    	sb.append(" "+"(版本:"+APP_STATUS+APP_VERSION);
    	sb.append(" &nbsp;&nbsp;Build:"+APP_BUILDVER);
    	sb.append(" "+APP_BUILDATE+")");
    	sb.append("&nbsp;&nbsp;&nbsp;&nbsp;开发团队:&nbsp;<a href=\"mailto:joeyang_ong@yahoo.com.cn\">"+APP_AUTHOR+"</a><br/>");
    	sb.append("(C)&nbsp;"+APP_WORKSTUDIO+"&nbsp;&nbsp;");

    	return sb.toString();	
    }
    
}
