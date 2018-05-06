<%@ page contentType="text/html;charset=gb2312" %>
<html>
<head>
<title>邮件发送成功</title>
<head>
<body bgcolor=pink>
	<h4>
	恭喜!邮件已成功发送<h4>
	<table cellspacing="2" cellpadding="2" border="1">
		<tr>
			<td>发送信箱:</td><td><%=request.getParameter("to")%></td>
		</tr><tr>
			<td>邮件主题:</td><td>
<%
	byte[] subjectTemp= request.getParameter("subject").getBytes("ISO8859_1");
	String subject=new String(subjectTemp);
 	out.println(subject);
%>
			</td></tr>
		<tr><td colspan="2" align=center>
			<a href="chap7-6.htm" style="color: rgb(ff,0,0)">返回</a>
		</td></tr>
	</table>
</body>
</html>