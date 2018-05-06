<%@ page language="java" import="java.util.*,bean.Good,bean.PageParam" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  <body>

	 <table width='324' height='120' border='1'>
	    <tr bgcolor='#FFACAC'>
	      <td>商品</td><td>单价</td>
	    </tr>	    
	    <c:forEach items="${requestScope.goods}"  var="good">      
	   		<tr>
		   		<td><c:out value="${good.name}" /></td>     
		   		<td><c:out value="${good.price}" /> </td>		   		
		   	</tr>
		</c:forEach> 	    
	</table>
	 <table width='324' height='120' border='1'>     
	   	<tr>			
			<c:if test="${requestScope.pageParam.now > 1}">
				<td><a href="/project02/servlet/advance/GoodsServlet?page=1">首页</a></td>  
			</c:if>
			
			<c:if test="${requestScope.pageParam.now > 1}">
				<td><a href="/project02/servlet/advance/GoodsServlet?page=${requestScope.pageParam.pre}">上一页</a></td>  
			</c:if>			 
			
			<c:if test="${requestScope.pageParam.now < requestScope.pageParam.totalPage}">
				<td><a href="/project02/servlet/advance/GoodsServlet?page=${requestScope.pageParam.next}">下一页</a></td>
			</c:if>
			   
			
			<c:if test="${requestScope.pageParam.now < requestScope.pageParam.totalPage}">
				<td><a href="/project02/servlet/advance/GoodsServlet?page=${requestScope.pageParam.totalPage}">尾页</a></td>
			</c:if>	   		
		</tr>    
	</table>


  </body>
</html>
