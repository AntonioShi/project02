<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head></head>
  
  <body bgcolor=yellow>
  <jsp:include page="head.jsp"/>
 <p><font size=2 color=red>
    This is three.jsp.
    </font>
  <font size=3>
  <% 
     String s=request.getParameter("ok");
     out.println("<br>传递过来的值是"+s);
  %>
  <br><img src="a.jpg" width="<%=s%>" height="<%=s%>" ></img>
  </font>
  </body>

</html>
