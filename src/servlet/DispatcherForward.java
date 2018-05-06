package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherForward extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//http://localhost:8080/project02/servlet/DispatcherForward?parm=3
		String parm=request.getParameter("parm");
		
		ServletContext context = getServletContext();//ServletContext存储全局数据
		RequestDispatcher rd = null;
		
		//进行处理
		if(parm==null || parm.isEmpty()) {
		    rd = context.getRequestDispatcher("/fail.jsp");//设置分派的网址
		}else{
			request.setAttribute("parm1", "I am happy!");//设置request的属性（任意添加，该属性在request范围类有效）
		    rd = context.getRequestDispatcher("/servlet/DispatcherForwardNext");//设置分派的网址
		}
		rd.forward(request,response);

	}

}
