import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserInformationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost( request,  response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		String name = (String)request.getAttribute("name");
		String sex = (String)request.getParameter("sex");
		String[] interest = request.getParameterValues("interest");//用户可能多选,所以用数组接收
		String introduce = (String)request.getParameter("introduce");
		
		PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><meta http-equiv='content-type' content='text/html; charset=UTF-8'></head>");
        out.println("<body>");
		out.println("<p>姓名"+name+"</p>");
		
		if(sex.equals("nan")){
			out.print("<p>性别:男</p>");
		}else{
			out.print("<p>性别:女</p>");
		}
		
		if(interest==null){//用户可能一个爱好都没有选
			out.print("<p>无爱好");			
		}else{
			for(int i = 0; i < interest.length; i++){	
				if(i==0) out.print("<p>爱好:");
				if(interest[i].equals("sports")) out.print("运动;");
				if(interest[i].equals("swim")) out.print("游泳;");
				if(interest[i].equals("read")) out.print("读书;");
				if(interest[i].equals("write")) out.print("写作");
				if(i  == interest.length - 1) out.print("</p>");
			}			
		}

		out.println("<p></p>");
		out.println("<p>简介:"+introduce+"</p>");//这里可以不用判断是否为null,如果多行文本框没内容,传过来的是空字符串"";
        out.println("</body>");
        out.println("</html>");	
	}

}
