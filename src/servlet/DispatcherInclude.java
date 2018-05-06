package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherInclude extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			ServletContext context = getServletContext();//ServletContext存储全局数据
			
			RequestDispatcher rd = context.getRequestDispatcher("/servlet/HeaderServlet");//设置分派的网址

			RequestDispatcher rd1 = context.getRequestDispatcher("/servlet/FooterServlet");//设置分派的网址

		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		ServletContext application=this.getServletContext();

		rd.include(request,response);//包含头部
		
		out.println("in servletA");
		
		rd1.include(request,response);//包含尾部

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}


}
