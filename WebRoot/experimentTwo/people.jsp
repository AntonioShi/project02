<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  </head>
<body BGCOLOR=yellow>
<font size=4>
	 <%!
	   int count;
	   StringBuffer person;
	   public void jige()
	   {  
	      if(count==0)
	       person=new StringBuffer();
	   }
	   public void addPerson(String p)
	   { 
	      if(count==0)
	      {
	        person.append(p);
	      } 
	      else
	      {
	        person.append(","+p);
	      }
	      count++;
	   }
	 %>
	 <%
	    String name=request.getParameter("name");
	    if(name.length()==0||name.length()>10)
	    {
	 %>   
	 		<jsp:forward page="inputName.jsp" />
	 <% } 
	    jige();
	    addPerson(name); 
	 %>
	 <br> <b>目前共有<%=count%>人浏览了该页面，他们的名字是：</b>
	 <br> <%=person%>
</font>
</body>
</html>

