<%@ page language="java" import="java.util.*,bean.Good" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  <%!
	public void jspInit() {//jspInit是jsp的初始化成员方法，当jsp第一次运行时，会自动调用该方法
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
  %>
  </head>
  <body>
  
  	<% 	List<Good> goods=(ArrayList<Good>) this.getServletContext().getAttribute("goods");		
		if(goods!=null){
	%>
	
	<form action='addToCart.jsp'>
	  <table width='324' height='120' border='1'>
	    <tr bgcolor='#FFACAC'>
	      <td>商品</td><td>单价</td><td>购买数量</td>
	    </tr>
	   <% for(int i=0;i<goods.size();i++){//遍历并显示商品
			Good good=goods.get(i);	%>
		    <tr bgcolor='#F1FAFA'>
		      <td><%=good.getName() %></td>
		      <td><%=good.getPrice() %></td>
		      <td><input name='<%=good.getName() %>' type='text'></td>
		    </tr>
		<%} %>
		<tr bgcolor='#FFACAC'><td colspan='3' align='right'> <input type='submit' value='加入购物车'> </td></tr>
	  </table>
	  <input name='type' value='buy' type='hidden'>
	</form>
	
	<%} %>
  </body>
</html>
