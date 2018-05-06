<%@ page language="java" import="java.util.*,bean.Good" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  <body>
	
	<form action='/project02/servlet/CartMVCServlet'>
	  <table width='324' height='120' border='1'>
	    <tr bgcolor='#FFACAC'>
	      <td>商品</td><td>单价</td><td>购买数量</td>
	    </tr>
	    
	    <c:forEach items="${applicationScope.goods}"  var="good">      
	   		<tr>
		   		<td><c:out value="${good.name}" /></td>     
		   		<td><c:out value="${good.price}" /> </td>
		   		<td> <input name="${good.name}" type="text">  </td>
		   	</tr>
		</c:forEach> 	    
	    
		<tr bgcolor='#FFACAC'><td colspan='3' align='right'> <input type='submit' value='加入购物车'> </td></tr>
	  </table>
	  <input name='type' value='buy' type='hidden'>
	</form>

  </body>
</html>
