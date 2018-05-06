<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

<%
	String str1 = request.getParameter("str1"); 
	String str2 = request.getParameter("str2"); 
	if(str1==null ||str1.length()==0){
		out.print("字符串1为空");
		return;
	}
	if(str2==null ||str2.length()==0){
		out.print("字符串2为空");
		return;
	}
//	if(str1==str2)                  //错误的比较方法
	if(str1.compareTo(str2)==0)         //使用compareTo进行比较
//	if(str1.equals(str2))                        //使用equals进行比较
		out.print("两个字符串相同！"+ "<P>");
	else
		out.print("两个字符串不同！"+ "<P>");
	out.println("字符串1为: " + str1 + "<br>");
	out.println("字符串2为: " + str2 + "<P>");
	out.println("连接两个字符串: " + str1+str2);
%>


  </body>
</html>