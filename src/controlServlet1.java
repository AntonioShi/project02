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


public class controlServlet1 extends HttpServlet {
	static String name;
	static String password;
	static Integer english;
	static Integer math;
	static Integer sports;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void init(ServletConfig sc) throws ServletException {
		//sc可以直接用了
		
		//每一个servlet，都对应有一个ServletConfig类型的对象，可以通过它来获取servlet在webconfig.xml文件中servlet配置的参数信息
		
		super.init(sc);
		 name = sc.getInitParameter("name");//获取本servlet在web.xml中配置的init-param参数
		 password = sc.getInitParameter("password");
		 english = Integer.valueOf(sc.getInitParameter("english").toString());
		 math = Integer.valueOf(sc.getInitParameter("math").toString());
		 sports = Integer.valueOf(sc.getInitParameter("sports").toString());
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");//设置返回给客户的内容的类型和编码格式，这里表示返回一个html网页，返回数据的编码是utf8
		PrintWriter out = response.getWriter();
		String work = (String)request.getParameter("work");//通过request对象获取客户端数据，work是表单元素的name属性值，getparameter方法返回的是字符串类型，必须进行适当的数据类型转换
		
		if(work==null){//用户未选择任何功能时,接收到的值为: null
			out.print("未选择功能!必须选择一种功能");
			return;
		}
		
		if(work.equals("yz")){//字符串的成员函数equal,还有很多类似的字符串处理成员函数,大家查资料
			String name = (String)request.getParameter("name");//获取客户端数据
			if(name.equals(this.name)){
				String passwd = (String)request.getParameter("passwd");
				if(passwd.equals(this.password)){
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
			ArrayList<Integer> scores = new ArrayList<Integer>();//数组,要掌握ArrayList类的用法
			for(int i = 0; i < score.length; i++){
				if(score[i].equals("english") )
					scores.add(this.english);
				if(score[i].equals("math"))
					scores.add(this.math);
				if(score[i].equals("sports"))
					scores.add(this.sports);
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
