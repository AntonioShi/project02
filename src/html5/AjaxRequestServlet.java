package html5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.UserBean;

public class AjaxRequestServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserBean userBean=new UserBean();
		userBean.setName(request.getParameter("name"));
		userBean.setNum(request.getParameter("num"));
		
		Gson gson = new Gson();//google的json插件（能将java类的对象、数组转变成符合json格式的字符串，也能将符合json格式的字符串转换成为java类）
		String str = gson.toJson(userBean);//将userBean对象传换成符合json格式的字符串
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write(str);//将符合json格式的字符串传回给客户端
		out.flush();
		out.close();
	}

}
