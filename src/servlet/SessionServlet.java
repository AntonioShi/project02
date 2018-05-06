package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionServlet extends HttpServlet {
	private Integer myServletValue=0;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost( request,  response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer mySessionValue;
		//session共享mySessionValue，先取出，然后赋值，最后保存到session
		try {//从session中取出mySessionValue
			mySessionValue= (Integer) request.getSession().getAttribute("mySessionValue");
			mySessionValue++;
		} catch (Exception e) {//第一次访问，此时session中无mySessionValue
			mySessionValue=1;
		}		
	
		request.getSession().setAttribute("mySessionValue",mySessionValue);
		//本servlet共享myServletValue
		myServletValue++;
		
		//所有servlet共享applicationValue，先取出，然后赋值，最后保存到ServletContext
		//结合SessionServlet1来观察applicationValue的变化
		Integer applicationValue=(Integer) this.getServletContext().getAttribute("applicationValue");
		applicationValue++;
		this.getServletContext().setAttribute("applicationValue", applicationValue);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		//显示数据
		out.print("    applicationValue is "+this.getServletContext().getAttribute("applicationValue")+"<br/><br/>");
		out.print("    myServletValue is "+myServletValue+"<br/><br/>");
		out.print("    mySessionValue is "+ request.getSession().getAttribute("mySessionValue")+"<br/><br/>");
	
		out.println("  </BODY>");		
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);//这里别少些了
		Integer a=0;
		this.getServletContext().setAttribute("applicationValue", a);

	}
}
