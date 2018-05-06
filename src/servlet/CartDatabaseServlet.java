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

import service.CartService;

import bean.Cart;
import bean.Good;
import bean.GoodItem;

public class CartDatabaseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type=request.getParameter("type");
		if(type !=null){
			if(type.equals("buy")){//从购买商品来
				//控制层（servlet）调用service
				//service层，表示业务逻辑，dao层表示数据库操作层，业务逻辑层调用dao层获取数据，进行处理，然后调用dao层保存数据
				CartService cartService=new CartService();				
				Cart cart=cartService.change(request);
				if(cart!=null){
					request.getSession().setAttribute("cart", cart);//保存 更新后的购物车
					response.sendRedirect("/project02/jspExamples/cart/database/addToCart.jsp");
				}else{
					response.sendRedirect("/project02/fail.jsp");
				}
			}
			
		}
				
	}

}
