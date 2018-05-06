package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserManageFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		if (session.getAttribute("userName") != null) {//检查是否登录			
			chain.doFilter(request, response);	//传给下个filter处理		
		} else {//没登录
			String originalUrl=req.getRequestURI();//获取用户请求的原始网址
			
			if(req.getQueryString()!=null) //把查询字符串加到网址
				originalUrl+="?"+req.getQueryString();   
			
			req.getSession().setAttribute("originalUrl", originalUrl);//保存原始网址到session
			res.sendRedirect("/project02/jspExamples/userManage/login.jsp");//跳转到登录网页，至此中断了过滤链
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.print("dfdfdf");

	}

}
