package servlet.advance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Good;
import bean.PageParam;
import service.GoodsService;

public class GoodsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer page=0;
		try {
			page=Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GoodsService goodsService=new GoodsService();
		PageParam pageParam=new PageParam();
		List<Good> goods=goodsService.getOnePage(page,pageParam);
		request.setAttribute("goods", goods);
		request.setAttribute("pageParam", pageParam);
		
		ServletContext context = getServletContext();//ServletContext存储全局数据
		RequestDispatcher rd = context.getRequestDispatcher("/jspExamples/page/goodsPage.jsp");//设置分派的网址;
		rd.forward(request,response);
	}

}
