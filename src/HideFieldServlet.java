import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HideFieldServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost( request,  response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String hideFiledValue=request.getParameter("hiddenField");//隐藏域例子
		
		if(hideFiledValue==null){
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			
			out.println(" <form id='form1' name='form1' method='post' action='/project02/servlet/HideFieldServlet'>");
			out.println(" 		name<input type='text' name='textfield'/>");
			out.println(" 		<input type='hidden' name='hiddenField' value='i am hidden'/>");
			out.println(" 		<input type='submit' ' value='submit' />");	
			out.println("  </form>		");	
			
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}else{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			
			out.println(" hidden value is " +hideFiledValue);
	
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();			
		}
	}

}
