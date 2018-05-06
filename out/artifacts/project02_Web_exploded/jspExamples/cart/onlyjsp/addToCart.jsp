<%@ page language="java" import="java.util.*,bean.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%
	List<Good> goods=(ArrayList<Good>) this.getServletContext().getAttribute("goods");	
	Cart cart=(Cart) session.getAttribute("cart");//session是隐含对象，不用创建可以直接使用
	if(cart==null){//第一次加入购物车
		cart=new Cart();
	}
	
	
	for(int i=0;i<goods.size();i++){
		String goodName=goods.get(i).getName();
		String numberString=request.getParameter(goodName);//request是隐含对象，不用创建可以直接使用
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
	
	session.setAttribute("cart", cart);//保存 更新后的购物车
  %>

  </head>
  
  <body>
	<table width='324' height='120' border='1'>
	  <tr bgcolor='#F1FAFA'>
	    <td>成功添加到购物车!</td>
	    <td><a href='cartshow.jsp'>查看购物车</a>
	    <td><a href='goodsShow.jsp'>返回商品列表</a></td>
	  </tr>
	</table>
  </body>
</html>
