<%@ page language="java" import="java.util.*,bean.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head></head>
  
  <body>
	<table width='324' height='120' border='1'>
	  <tr bgcolor='#FFACAC'>
	    <td>商品</td><td>单价</td><td>已购买数量</td><td>小计</td>
	  </tr>
	    <c:forEach items="${sessionScope.cart.goods}"  var="good">      
	   		<tr>
		   		<td><c:out value="${good.name}" /></td>     
		   		<td><c:out value="${good.price}" /> </td>
		   		<td><c:out value="${good.number}" />  </td>
		   		<td><c:out value="${good.total}" />  </td>
		   	</tr>
		</c:forEach>	  
	  <tr bgcolor='#FFACAC'>
	    <td colspan='4' align='right'>总计：${sessionScope.cart.totalMoney}</td>
	  </tr>
	</table>
  </body>
</html>
