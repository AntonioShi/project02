<%@ page language="java" import="java.util.*,bean.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/myTagLib" prefix="myTag"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<myTag:addToCartTag/>
	<table width='324' height='120' border='1'>
	  <tr bgcolor='#F1FAFA'>
	    <td>成功添加到购物车!</td>
	    <td><a href='cartshow.jsp'>查看购物车</a>
	    <td><a href='goodsShow.jsp'>返回商品列表</a></td>
	  </tr>
	</table>
  </body>
</html>
