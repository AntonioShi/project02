<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="vote" scope="page" class="database.DbBean"/>
<html>
<head>
	<title>���ϵ����</title>
</head>
<%
	ResultSet rs = vote.executeQuery("select * from vote");
%>
<body bgcolor="#FFCCCC">
	<center>
	<font face="����" size="6">�����ʾ�,����ͶƱ��</font><br>
    <font face="����" size="5">����Ϊ����ˮ����óԣ���ѡ��</font><p>
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
		<TR align="center"><TD><Input type="submit" value="ͶƱ"></TD></TR>
	</form> 
	</Table>
	<br><A href="view.jsp">�鿴ͶƱ</A>
</center>  
</body>
</html>
