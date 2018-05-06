<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head></head>
  
<body bgcolor=yellow>
<jsp:include page="head.jsp"/>
 <form action="" method=get name=form>
   请输入1至100之间的整数：<input type="text" name="ok"> 
   <br> <input type="submit" value="送出" name=submit>
  </form> 

<%  
    String a=request.getParameter("ok");
    if(a==null)
    { a="0";
    }
    try
    {
       int b=Integer.parseInt(a);
       if(b>=1&&b<=50)
       {
%>      <jsp:forward page="two.jsp" >
          <jsp:param name="ok" value="<%=b%>" />
        </jsp:forward>
<%     }
      else if(b>50&&b<=100)
       {
%>      <jsp:forward page="three.jsp" >
          <jsp:param name="ok" value="<%=b%>" />
        </jsp:forward>
<%     }
     }
    catch(Exception e)
     {
%>      <jsp:forward page="error.jsp" > 
           <jsp:param name="mess" value="<%=e.toString()%>" />
        </jsp:forward>
<%   }
%>
</body>

</html>
