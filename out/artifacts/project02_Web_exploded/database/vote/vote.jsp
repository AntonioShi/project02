<%@ page contentType="text/html;charset=UTF-8"%>

<jsp:useBean id="vote" scope="page" class="database.DbBean"/>

<%
	String rb = request.getParameter("type");
	if (rb != null && rb != "") {
		String sql = "Update vote Set numb=numb+1 where id=" + rb;
		vote.executeUpdate(sql);
	}
%>	

<jsp:forward page="view.jsp"/>
