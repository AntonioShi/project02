package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Good;

public class GoodsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		List<Good> goods=(ArrayList<Good>) this.getServletContext().getAttribute("goods");
		
		if(goods!=null){		
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
			out.println("  <BODY>");

			//提交表单
			out.print("<form action='/project02/servlet/CartServlet'> ");
			
			out.print("<table width='324' height='120' border='1'> ");
			out.print("	<tr bgcolor='#FFACAC'>");
			out.print("		<td>商品</td><td>单价</td><td>购买数量</td>");			
			out.print("	</tr>");
			
			//显示商品
			for(int i=0;i<goods.size();i++){
				Good good=goods.get(i);				
				out.print("	<tr bgcolor='#F1FAFA'>");
				out.print("		<td>"+good.getName()+"</td><td>"+good.getPrice()
									 +"</td><td> <input name='"+good.getName()+"' type='text'></td>");
				out.print("	</tr>");				
			}			
			out.print("<tr bgcolor='#FFACAC'><td colspan='3' align='right'> <input type='submit' value='加入购物车'> </td></tr></table>");
			out.print("	<input name='type' value='buy' type='hidden'>");//通过隐藏域（客户端用户看不见）传递信息到服务器
					
			out.print("</form>");

			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		
		}
	}
	
	
	public void init(ServletConfig sc) throws ServletException {
		//初始化商品列表
		super.init(sc);
		List<Good> goods=new ArrayList<Good>();
		Good good=new Good();
		good.setName("苹果");good.setPrice(6.00);
		goods.add(good);
		Good good1=new Good();
		good1.setName("梨子");good1.setPrice(4.00);
		goods.add(good1);	
		ServletContext servletContex=sc.getServletContext();
		servletContex.setAttribute("goods", goods);//保存为全局数据

	}	

}
