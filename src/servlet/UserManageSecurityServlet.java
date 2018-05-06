package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DbBean;

public class UserManageSecurityServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		//把业务逻辑代码（访问数据库）放到控制器（servlet）中，并不是最好的方式，也不是mvc模式
		DbBean dbBean=new DbBean();		
		int count=0;
		try {
			ResultSet rs=dbBean.executeQuery("select count(*) from user where userName='"+userName+"' and password='"+password+"'");
			rs.next();
			count=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(count==1){//登录成功
			request.getSession().setAttribute("userName",userName );	//保存用户名到session，以后根据它来验证用户是否登录
			String a=(String)request.getSession().getAttribute("originalUrl");
			response.sendRedirect((String)request.getSession().getAttribute("originalUrl"));//跳转到原始网页					
		}else{//登录失败
			response.sendRedirect("/project02/jspExamples/userManage/login.jsp?failure=1");
		}

	}

}
