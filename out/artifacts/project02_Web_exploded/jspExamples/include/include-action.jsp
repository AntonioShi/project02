
<%@ page contentType="text/html;charset=UTF-8" %>
<html> 
<head>
<title>include动作</title>
</head>
<body bgcolor="#FFCCCC"> 
		<!-- tomcat目录\work\Catalina\localhost\项目名\包名，有Tomcat生成的jsp的.java和.class文件 --> 		
		<jsp:include page="header.jsp"/>
		<br>this is main content!<br>
		<jsp:include page="footer.jsp"/>
		
		仅当include动作不能满足要求时，我们才应该使用include指令。
</body>
</html> 