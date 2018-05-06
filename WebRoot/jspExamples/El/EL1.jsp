<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="bean.UserBean"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>el表达式学习</title>
</head>
<body>
    第一种,简单取值:
    <%
    String data = "hi,amos!";
    request.setAttribute("data", data);
%>
    ${data}
    <br> 第二种,从bean中取值:
    <%
    	UserBean p = new UserBean();
        p.setName("amosli");
        session.setAttribute("user", p);
    %>
    ${user.name}  <!-- EL表达式比下面的语句简单 -->
    <br>
    <%=((UserBean) session.getAttribute("user")).getName()%><br>  <!-- 这种方式输出比EL复杂 -->
    <br> 第三种:从集合中取值:
    <%
        List<UserBean> users = new ArrayList<UserBean>();
    	UserBean a=new UserBean();a.setName("amosli");
    	users.add(a);
    	a=new UserBean();a.setName("hi_amos");
    	users.add(a);
        application.setAttribute("users", users);
    %>
    <br>从数组中取数据： 
    ${users[1].name }
    <br>
	<br>从map中取数据： 
    <%
        Map map = new HashMap();
    	UserBean c=new UserBean();c.setName("map--amosli");
        map.put("aa", c);
        c=new UserBean();c.setName("map--hi_amos");
        map.put("cc", c);

        request.setAttribute("map", map);
    %>
    ${map.cc.name }<br> 
    <%-- ${map.11.name } 一般情况下用点号进行取值,如果点号取不出来值,那么可以用[]来代替. --%>
    ${map['11'].name }<br>
    <br>遍历map，输出键和值： <br>
    <c:forEach items="${map}" var="entry">      
   		键：<c:out value="${entry.key}" />；     
   		值：<c:out value="${entry.value.name}" />  
   		<br>    
	</c:forEach> 
    
  EL中的隐含对象:<br>  
   
     ${requestScope.data}<br>
     ${sessionScope.user.name}<br>
     ${applicationScope.users[1].name}<br>
     
     <br>
     <br>
     获取从客户端表单传来的参数：<br>
         姓名：${param.name }
         电话：${paramValues.phone[0]}，${paramValues.phone[1]}
     
</body>
</html>