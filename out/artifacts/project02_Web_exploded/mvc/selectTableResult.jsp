<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> mvc模式中view部分 输出视图</head>
  
  <body>
    
    <c:forEach items="${requestScope.grades}" var="grade">
            ${grade.stuNum}, 
            ${grade.name}, 
            ${grade.chinese}, 
            ${grade.math}, 
            ${grade.english}
            <br/>            
    </c:forEach>
    
  </body>
</html>
