<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="bean.BlueBean" %> 
<HTML>
<HEAD>
<TITLE>猜猜看</TITLE>
</HEAD>

<BODY>
<!-- 声明一个javabean，在同一个session中有效 -->
	<jsp:useBean id="blueBean" class="bean.BlueBean" scope="session"/>
<!-- 	接收form表单传送过来的数据，并按照同名原则，赋值给blueBean的同名属性 -->
	<jsp:setProperty name="blueBean" property="*"/>
	<table>
		<tr>
			<TD>目的颜色</TD>
			<TD>所猜颜色</TD>
		</tr>
		<tr>
<!-- 		整数转变为16进制数，因为颜色是16进制的数 -->
			<td style="background-color:0000<%=Integer.toHexString(blueBean.getBlueColor())%>">目的颜色</td>
<!-- 		Integer.parseInt（“”），将字符串转换成整数 -->
			<td style="background-color:0000<%=Integer.toHexString(Integer.parseInt(blueBean.getGuess()))%>">所猜颜色</td>
		</tr>
	</table>
<%

	if (blueBean.getSuccess()){
		out.println("恭喜,猜对了!<p>");
		blueBean.initAnswer();//重新设置被猜数字
		out.println("<a href='guessColor.jsp'>再猜不同的数字吗?</a>");
	}
	else{
%>
	欢迎来玩猜颜色 
	<p>我想应该在<b><%=blueBean.getHintMsg()%></b><br>
		<form method="get" action="guessColor.jsp">
			请输入猜测值：<input name="guess" type="text">
			<input type="submit" value="确定">
		</form>
<%	}%>	
</BODY>
</HTML>
