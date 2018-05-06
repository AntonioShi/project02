<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="vote" scope="page" class="database.DbBean"/>
<html>
<head>
	<title>网上调查表</title>
</head>
<%
	ResultSet rs = vote.executeQuery("select * from vote");
%>
<body bgcolor="#FFCCCC">
	<center>
	<font face="隶书" size="6">调查问卷,请您投票：</font><br>
    <font face="隶书" size="5">您认为哪种水果最好吃（单选）</font><p>
  	<Table width="114" border bgcolor="#FFFFCC">
  	
    <form action="vote.jsp">
		<% while(rs.next()) { %> 
	   		<TR><TD>
					<input type="radio" name="type" value=<%=rs.getString("id")%>>
					<%=rs.getString("content")%>
			</TD></TR>
		<%
			}
			rs.close();
		%>
		<TR align="center"><TD><Input type="submit" value="投票"></TD></TR>
	</form> 
	</Table>
	<br><A href="view.jsp">查看投票</A>
</center>  
</body>
</html>
