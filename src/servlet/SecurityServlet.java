package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if( ((String) request.getParameter("name")).equals("zhangshan") ){//验证用户名和密码
			request.getSession().setAttribute("username","zhangshan" );	//保存用户名到session，以后根据它来验证用户是否登录
			String aa=(String)request.getSession().getAttribute("originalUrl");
			response.sendRedirect(aa);//跳转到原始网页
		}else{
			response.sendRedirect("/project02/login.jsp");//跳转到其他网页
		}
	}

}
