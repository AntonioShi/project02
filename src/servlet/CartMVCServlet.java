package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CartMVCService;
import bean.Cart;
import bean.Good;
import bean.GoodItem;

public class CartMVCServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type=request.getParameter("type");
		if(type !=null){
			if(type.equals("buy")){//从购买商品来
				
				//获取数据
				List<Good> goods=(ArrayList<Good>) this.getServletContext().getAttribute("goods");
				//调用M层对象的方法完成对数据的处理
				CartMVCService cartMVCService=new CartMVCService();
				cartMVCService.CartUpdate(request, goods);
				//给客户端展现结果
				response.sendRedirect("/project02/jspExamples/cart/mvc/addToCart.jsp");			
				
			}
			
		}
		

	}
	
}
