package com.smf.wqphd.filter;

import com.smf.wqphd.constant.Const;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 */
@WebFilter(urlPatterns ={"/pages/*","/emergency/*","/mq/*","/mt/*","/pm/*","/getResid","/changePass","/usermessage/*","/list","/search","/add","/delete","/edit","/selectmq","/addVoList"})
public class LoginFilter implements Filter {

    
    public LoginFilter() {
       
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//还原Http对象
       HttpServletRequest req = (HttpServletRequest)request;
       HttpServletResponse res= (HttpServletResponse)response;
		
       //通过请求对象，获取HttpSession
       //req.getSession();
        HttpSession session =  req.getSession(true);
        
        Object loginUser = session.getAttribute(Const.SESSION_KEY_USER);
        
//        System.out.println(req.getRequestURI());
        
        if(loginUser!=null 
        		|| req.getRequestURI().indexOf("/signin") >=0
        		|| req.getRequestURI().indexOf("login.html") >=0) {
        	
        	//如果登录成功，则可以继续访问 ，或正在进行登录操作也可以继续访问
    		// pass the request along the filter chain
    		chain.doFilter(request, response);
        	
        }else {
            //如果用户没有登录
        	//是网站跟目录解决网址的相对路径问题
        	res.sendRedirect(req.getContextPath()+"/login.html");
        }
		

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
