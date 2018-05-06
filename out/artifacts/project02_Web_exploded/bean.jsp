<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="bean.BlueBean" %> 
<HTML>
<HEAD>
<TITLE>猜猜看</TITLE>
</HEAD>

<BODY>
	<%! Integer a=1; %>
	<jsp:useBean id="blueBean" class="bean.BlueBean" scope="session"/>
	<!-- 	接收form表单传送过来的数据，并按照同名原则，赋值给blueBean的同名属性 -->
	<jsp:setProperty name="blueBean" property="*"/>
	
	<jsp:getProperty name="blueBean" property="hintMsg"/>
	
	<%=blueBean.getHintMsg() %><br>
	
	<%=blueBean.getGuess() %><br>
	
	<%=blueBean.getSuccess() %><br>
	
	
	  
	<%=a++ %><br>

	<form method="post" action="bean.jsp">
		请输入猜测值：<input name="guess" type="text">
		<input type="submit" value="确定">
	</form>

</BODY>
</HTML>
