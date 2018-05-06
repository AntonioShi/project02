package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S1 extends HttpServlet {
	Integer aa;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (("aa").equals(username) && password.equals("bb")) {
				response.sendRedirect("http://www.csdn.net");//跳转到其他网页
			} else {
				userInterface(response);
			}
		} catch (Exception e) {
			userInterface(response);
		}
		Integer aa=(Integer) this.getServletContext().getAttribute("year");
		aa++;
		System.out.println(aa);
		this.getServletContext().setAttribute("year", aa);
		out.close();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);

		aa = Integer.parseInt(conf.getInitParameter("aa"));
		this.getServletContext().setAttribute("year", aa);
	}

	public void userInterface(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8"); 
		out.println("<!doctype html>");
		out.println("<head><meta charset='utf-8'><title>loginservlet</title></head>");
		out.println("<body bgcolor=\"#ffffff\">");
		out.println("<h1 align=center>欢迎第一次使用Servlet</h1>");
		out.println("<form method=post action='/project02/servlet/S1'");
		out.println("<br/>"+this.getClass().toString());
		out.println("用户名：<input type='text' name='username'><br/>");
		out.println("密码：<input type='password' name='password'><br/>");
		out.println("<input type=submit value='提交'><br/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
