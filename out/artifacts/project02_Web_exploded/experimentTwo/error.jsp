<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head></head>

<body bgcolor=yellow>
	<jsp:include page="head.jsp" />
	<p>
		<font size=5 color=red> This is error.jsp. </font> <font size=2>
		<% 
     		String s=request.getParameter("mess");
     		out.println("<br>传递过来的错误信息"+s);
  		%> <br>
		<img src="b.jpg" width="120" height="120"></img>
		</font>
</body>
</html>
