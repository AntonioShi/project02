package servlet;

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

import bean.Good;

import dao.GoodsDao;
import database.DbBean;

public class GoodsDatabaseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type=request.getParameter("type");
		if(type!=null){
			if(type.equals("show")){
				GoodsDao goodsDao=new GoodsDao();//使用对数据库进行操作的dao
				List<Good> goods=goodsDao.getAll();

				if(goods==null)	{			
					response.sendRedirect("/project02/fail.jsp");
				}else{				
					request.setAttribute("goods", goods);
					ServletContext sc = this.getServletContext();//ServletContext是所有servlet共享的,
					RequestDispatcher rd = sc.getRequestDispatcher("/jspExamples/cart/database/goodsShow.jsp");//设置分派地址
					rd.forward(request, response);
				}
			}			
			
		}
	}

}
