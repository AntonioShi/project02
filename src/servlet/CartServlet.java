package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.Good;
import bean.GoodItem;

public class CartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type=request.getParameter("type");
		if(type !=null){
			if(type.equals("buy")){//从购买商品来
				List<Good> goods=(ArrayList<Good>) this.getServletContext().getAttribute("goods");
				HttpSession session=request.getSession();
				Cart cart=(Cart) session.getAttribute("cart");
				if(cart==null){//第一次加入购物车
					cart=new Cart();
				}
				
				
				for(int i=0;i<goods.size();i++){
					String goodName=goods.get(i).getName();
					String numberString=request.getParameter(goodName);
					Integer number;
					number=Integer.parseInt(numberString);
					
					int index=-1;
					//检查购物车中是否有该商品	
					for(int j=0;j<cart.getGoods().size();j++){
						if(goodName.equals(cart.getGoods().get(j).getName())){
							index=j;
							break;
						}
							
					}
					
					if(index > -1){//购物车中有该商品						
						//更新购买数量
						cart.getGoods().get(index).setNumber(cart.getGoods().get(index).getNumber()+number);						
					}else{//购物车中没有该商品
						GoodItem goodItem=new GoodItem();
						goodItem.setName(goodName);
						goodItem.setNumber(number);
						goodItem.setPrice(goods.get(i).getPrice());
						cart.getGoods().add(goodItem);
					}
				}
				ServletContext aa=this.getServletContext();
				session.setAttribute("cart", cart);//保存 更新后的购物车
				
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
				out.println("<HTML>");
				out.println("  <HEAD><meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
				out.println("  <BODY>");
				out.print("<table width='324' height='120' border='1'> ");
				out.print("	<tr bgcolor='#F1FAFA'>");
				out.print("		<td>成功添加到购物车!</td>");
				out.print("		<td><a href='/project02/servlet/CartServlet?type=show'>查看购物车</a>");
				out.print("		<td><a href='/project02/servlet/GoodsServlet'>返回商品列表</a></td>");
				out.print("	</tr>");
				out.print("</table>");	
				
				
			}else if(type.equals("show")){//type 
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
				out.println("<HTML>");
				out.println("  <HEAD><meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
				out.println("  <BODY>");
				out.print("<table width='324' height='120' border='1'> ");
				out.print("	<tr bgcolor='#FFACAC'>");
				out.print("		<td>商品</td><td>单价</td><td>已购买数量</td><td>小计</td>");			
				out.print("	</tr>");

				Cart cart=(Cart) request.getSession().getAttribute("cart");
				if(cart==null){//第一次加入购物车
					cart=new Cart();
				}				
				
				//显示商品
				for(int i=0;i<cart.getGoods().size();i++){
					
					out.print("	<tr bgcolor='#F1FAFA'>");
					out.print("	<td>"	+cart.getGoods().get(i).getName()+"</td><td>"
										+cart.getGoods().get(i).getPrice()+"</td><td>"
										+cart.getGoods().get(i).getNumber()+" </td><td>"
										+cart.getGoods().get(i).getTotal()+" </td>");
					out.print("	</tr>");				
				}			
				out.print("<tr bgcolor='#FFACAC'><td colspan='4' align='right'>总计："
							+cart.getTotalMoney()+"</td></tr></table>");
			}
			
		}
		

	}
	

	

}
