<%@ page contentType="text/html;charset=gb2312" %>
<html>
<head>
<title>�ʼ����ͳɹ�</title>
<head>
<body bgcolor=pink>
	<h4>
	��ϲ!�ʼ��ѳɹ�����<h4>
	<table cellspacing="2" cellpadding="2" border="1">
		<tr>
			<td>��������:</td><td><%=request.getParameter("to")%></td>
		</tr><tr>
			<td>�ʼ�����:</td><td>
<%
	byte[] subjectTemp= request.getParameter("subject").getBytes("ISO8859_1");
	String subject=new String(subjectTemp);
 	out.println(subject);
%>
			</td></tr>
		<tr><td colspan="2" align=center>
			<a href="chap7-6.htm" style="color: rgb(ff,0,0)">����</a>
		</td></tr>
	</table>
</body>
</html>