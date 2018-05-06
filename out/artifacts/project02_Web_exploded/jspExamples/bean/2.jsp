<%@ page contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<title>JavaBean使用</title>
</head>
<body>
	<jsp:useBean id="data" scope="page" class="bean.UserBean" />
	<jsp:setProperty name="data" property="name" param="name"  />
	<jsp:setProperty name="data" property="num" param="do" />

	姓名：<font color="#663366">
			<jsp:getProperty name="data" property="name"/>
		</font><br>
	职业：<font color="#663366">
		<jsp:getProperty name="data" property="num"/>
		</font><br>
</body>
</html>
