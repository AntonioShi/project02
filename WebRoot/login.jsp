<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
  </head>
  
  <body>
  	<form method="post" action="/project02/servlet/SecurityServlet">
		<table>
    	<tr><td>用户验证录入:<br />用户名：<input type="text" name="name"/></td></tr>
		<tr><td>密码：<input type="password" name="passwd"/></td></tr>
		</table>
		<input type="submit" name="sub" value="提交"/>
	</form>
  </body>
</html>
