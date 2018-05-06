<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<HTML>
<HEAD>
	<TITLE>网页中复选框使用</TITLE>
</HEAD>
<BODY bgcolor="#FFCCCC">

<%
   	String names[] = request.getParameterValues("name");
	request.setAttribute("names", names);
	
   	if(names != null) {
	   for(int i=0; i<names.length; i++) 
		   out.println(names[i] + "<br>");
   }
%>
	<br>paramValues:<br>	
	<c:if test="${paramValues.name != null}">
		<c:forEach var="name" items="${paramValues.name}" varStatus="status">
			${status.count} ：${name} <br>
		</c:forEach>
	</c:if>
	
	<br>request:<br>
	<c:forEach var="name" items="${requestScope.names}" varStatus="status">
		${status.count} ：${name} <br>
	</c:forEach>



</BODY>
</HTML>
