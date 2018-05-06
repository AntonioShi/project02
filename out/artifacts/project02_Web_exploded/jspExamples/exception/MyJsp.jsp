<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'MyJsp.jsp' starting page</title>

  </head>
  
  <body>
		    下面将要发生错误!!!<br>
		<% 
			int a=9;
			int b=0;
			
		%>
		结果=<%=(a/b)%>
		
	</body>
</html>
