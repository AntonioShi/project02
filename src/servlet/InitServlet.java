package servlet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Good;

public class InitServlet extends HttpServlet {

	public final static long serialVersionUID = 0;

	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
		
		//初始化商品列表		
		List<Good> goods=new ArrayList<Good>();
		Good good=new Good();
		good.setName("苹果");good.setPrice(6.00);
		goods.add(good);
		Good good1=new Good();
		good1.setName("梨子");good1.setPrice(4.00);
		goods.add(good1);
		ServletContext application = getServletContext();
		application.setAttribute("goods", goods);//保存为全局数据
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		doPost(request, response);
	}

}

