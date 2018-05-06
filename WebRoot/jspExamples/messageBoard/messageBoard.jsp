<%@ page contentType="text/html;charset=UTF-8" %>
<HTML>
<title>简易留言板</title>
<BODY bgcolor="#FFCCCC">
	<FORM action="save.jsp" method="post" name="form">
		<font color="#660000" size="4" face="隶书">您的名字</font>： 
		<INPUT type="text" name="name">
		<P>
			<font color="#660000" size="4" face="隶书">留言标题</font>： 
			<INPUT type="text" name="title">
		<P>
			<font color="#660000" size="4" face="隶书">留言：</font><BR>
			<TEXTAREA name="messages" rows="6" cols="50"></TEXTAREA>
			<BR> <INPUT type="submit" value="提交留言" name="submit">
	</FORM>
	
	<FORM action="show.jsp" method="post" name="form1">
		<INPUT type="submit" value="查看留言板" name="look">
	</FORM>
</BODY>
</HTML>
