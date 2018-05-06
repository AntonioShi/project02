<%@page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<% 
 	 Calendar  calendar = null;//Calendar为日历类，处理时间
 	 Date currentDate;
 	 calendar = Calendar.getInstance();
	 Date trialTime = new Date();//获取系统当前时间
	 calendar.setTime(trialTime);
     int hour=calendar.get(Calendar.HOUR_OF_DAY);
     
     if (hour<12){
%>
		<jsp:forward page="morning.jsp"/>
<%	}else{ %>
		<jsp:forward page="afternoon.jsp"/>
<% 	} %>

</html>

