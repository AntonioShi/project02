import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class controlServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String work = (String)request.getParameter("work");//获取客户端数据
		
		if(work==null){//用户未选择任何功能时,接收到的值为: null
			out.print("未选择功能!必须选择一种功能");
			return;
		}
		
		if(work.equals("yz")){//字符串的成员函数equal,还有很多类似的字符串处理成员函数,大家查资料
			String name = (String)request.getParameter("name");//获取客户端数据
			if(name.equals("zhangshan")){
				ServletConfig sc = this.getServletConfig();//获取本servlet的ServletConfig(通过它可以获得web.xml中本servlet的配置信息)
				String realPasswd = sc.getInitParameter(name);//获取本servlet在web.xml中配置的init-param参数
				String passwd = (String)request.getParameter("passwd");
				if(passwd.equals(realPasswd)){
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  EEE HH:mm:ss");//设置时间的显示方式,具体可查百度
					out.print(name);
					out.print("<p></p>");
					out.print(sdf.format(date));
				}
				else{
					response.sendRedirect("/project02/error.html");//重定向到其他网页
				}
			}
			else{
				response.sendRedirect("/project02/error.html");
			}
			
		}
		else if(work.equals("lr")){
			request.setAttribute("name", "zhangshan");//保存数据到request,数据在本请求有效
			ServletContext sc = this.getServletContext();//ServletContext是所有servlet共享的,
			RequestDispatcher rd = sc.getRequestDispatcher("/servlet/UserInformationServlet");//设置分派地址
			//rd.include(request, response);//准备传递request和response给其他servlet
			rd.forward(request, response);
		}
		else{
			String[] score = request.getParameterValues("score");
			ArrayList<Integer> scores = new ArrayList<Integer>();
			ServletConfig sc = this.getServletConfig();
			for(int i = 0; i < score.length; i++){
				scores.add(Integer.valueOf(sc.getInitParameter(score[i])));
			}
		
			Statistics s = new Statistics();
	        out.println("<html>");
	        out.println("<head><meta http-equiv='content-type' content='text/html; charset=UTF-8'></head>");
	        out.println("<body>");
			out.println("<p>所选课程平均成绩:"+s.average(scores)+"</p>");
			out.println("<p>所选课程最高成绩:"+s.max(scores)+"</p>");
		    out.println("</body>");
		    out.println("</html>");	
			
		}
	}

}
