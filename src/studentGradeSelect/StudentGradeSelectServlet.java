package studentGradeSelect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GradeOperate;

import bean.GradeBean;

import database.DbBean;

public class StudentGradeSelectServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tableName=request.getParameter("tableName");

		GradeOperate gradeOperate=new GradeOperate();
		List<GradeBean> grades=gradeOperate.listAll(tableName);
		
		request.setAttribute("grades", grades);
		
		ServletContext context = getServletContext();//ServletContext存储全局数据
		RequestDispatcher rd = context.getRequestDispatcher("/mvc/selectTableResult.jsp");//设置分派的网址;
		rd.forward(request,response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


}
