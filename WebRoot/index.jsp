<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  servlet：<br>
  <a href="/project02/servlet/S1">仅仅servlet--显示用户信息</a><br><br>
  <a href="/project02/servlet/DispatcherForward?parm=3" target='_blank'>分派</a><br><br>
  <a href="/project02/servlet/SessionServlet" target='_blank'>Session，ServletContext</a><br><br>
  <a href="/project02/1.html" target='_blank'>用户验证、用户信息录入、统计成绩（init方法，ServletConfig类型，ServletContext类型），重定向，分派</a><br><br>
  <a href="/project02/admin/1.html" target='_blank'>受限网页（/admin/*  只允许有权限的用户访问）（filter,session）</a><br><br>


	jsp：<br>
	<a href="/project02/bean.jsp" target='_blank'>bean-jsp应用1(jsp:useBean)</a><br><br>  
  
  <a href="/project02/jspExamples/chesckBox.htm" target='_blank'>接收多个复选框</a><br><br>
  <a href="/project02/jspExamples/include/include-page.jsp" target='_blank'>include指令</a><br><br>
  <a href="/project02/jspExamples/include/error-use/include-page.jsp" target='_blank'>include指令--错误用法</a><br><br>
  <a href="/project02/jspExamples/include/include-action.jsp" target='_blank'>include动作</a><br><br>
  <a href="/project02/jspExamples/bean/1.html" target='_blank'>bean-jsp应用2</a><br><br>
  <a href="/project02/jspExamples/date/date.jsp" target='_blank'>判断上午下午（日历类、jsp:forward）</a><br><br>
  <a href="/project02/jspExamples/guessColorBean/guessColor.jsp" target='_blank'>猜颜色（bean、）</a><br><br>
  <a href="/project02/jspExamples/messageBoard/messageBoard.jsp" target='_blank'>消息板（application、Vector）</a><br><br>
  <a href="/project02/servlet/S1" target='_blank'>仅仅servlet--显示用户信息</a><br><br> 
  
  <a href="/project02/jspExamples/El/EL1.jsp?name=mike&phone=13712110950&phone=076922861112" target='_blank'>EL表达式（获取数据）</a><br><br>
  <br><br>购物车<br>
  <a href="/project02/servlet/GoodsServlet" target='_blank'>购物车(仅servlet)</a><br><br>
  <a href="/project02/jspExamples/cart/onlyjsp/goodsShow.jsp" target='_blank'>购物车(仅jsp,java代码嵌入html代码中)</a><br><br>	
  <a href="/project02/jspExamples/cart/jsp-no-java/goodsShow.jsp" target='_blank'>购物车(jsp中无Java代码、自定义标签)</a><br><br>
  <a href="/project02/jspExamples/cart/mvc/goodsShow.jsp" target='_blank'>购物车(MVC--java和jsp各司其职)</a><br><br>
  <a href="/project02/servlet/GoodsDatabaseServlet?type=show" target='_blank'>购物车(MVC+数据库)</a><br><br>
  	数据库：<br>
  	<a href="/project02/database/studentGradeInsert.jsp" target='_blank'>插入学生成绩</a> <br>
  	<a href="/project02/database/studentGradeUpdate.jsp" target='_blank'>更新学生成绩</a> <br>
  	<a href="/project02/database/studentGradeSelect.jsp" target='_blank'>显示学生成绩</a> <br>
  	<a href="/project02/database/studentGradePage.jsp" target='_blank'>仅仅jsp--分页显示学生成绩</a> <br>
  	<a href="/project02/servlet/StudentGradePageServlet" target='_blank'>同功能servlet--分页显示学生成绩</a> <br><br>
  	<a href="/project02/database/studentGradeTransaction.jsp" target='_blank'>事务处理</a> <br>

    <br><br>上传文件<br>
    <a href="/project02/jspExamples/uploadFile/uploadFile.jsp" target='_blank'>上传文件</a>
    
 	
 	<br><br>mvc模式<br>
    <a href="/project02/mvc/selectTable.html" target='_blank'>mvc模式--显示学生成绩</a>
    
    <a href="/project02/servlet/advance/GoodsServlet?page=1" target='_blank'>分页显示</a><br><br>
  </body>
</html>
