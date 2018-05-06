<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>图片自动更新</title>
</head>
<body>
<%! int count=0;%>
<%
	if(count==4)
		count=0;
	response.setHeader("Refresh","4");
	count++;
%>
	<img src="images/<%=count%>.jpg"><br>
	<font color="brown" size="5">这是第<%=count%>张图片</font>
</body>
</html>
