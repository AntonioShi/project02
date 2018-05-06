<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
  </head>
  
  <body>
      	<form method="post" action="/project02/servlet/UserManageSecurityServlet">
		<table>
    	<tr><td>用户验证录入:<br />用户名：<input type="text" name="userName"/></td></tr>
		<tr><td>密码：<input type="password" name="password"/></td></tr>
<!-- 		param是EL中的隐含对象 -->
		<c:if test="${param.failure=='1'}"><tr><td>用户名或密码错误!</td></tr></c:if>
		</table>
		<input type="submit" value="登录"/>
	</form>
  </body>
</html>
