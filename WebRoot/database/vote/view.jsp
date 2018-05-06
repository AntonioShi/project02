<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.sql.*"%>

<jsp:useBean id="vote" scope="page" class="database.DbBean"/>

<%!
	int tot_num=0;
	int tmp_num=0;
%>

<HTML>
<HEAD> 
  <link rel="stylesheet" type="text/css" href="style.css">
</HEAD>
<BODY>  
  <table width="90%" border="0" cellspacing="2" cellpadding="3">
<%
   // 获取总票数
   ResultSet tmpRs = vote.executeQuery("select sum(numb) As totalnum from vote");
   tmpRs.next();
   tot_num = tmpRs.getInt("totalnum");
   tmpRs.close();
   
   ResultSet rs = vote.executeQuery("select * from vote");
   int i=1;
   while(rs.next()) { %>
    <tr bgcolor="#99CCFF"> 
			<td>选项<%=i%>：<%=rs.getString("content")%></td>
    </tr>
    <tr>
	        <%
				tmp_num = rs.getInt("numb");
			%>
			<td>投票率：<img src="back.gif" width="<%=Math.floor(tmp_num*200/tot_num)%>" height="8"> <%=Math.floor(tmp_num*100/tot_num)%>% 
			  [得：<%=tmp_num%>票 共：<%=tot_num%>票]</td>
	</tr>
<%  
    i++;
    }
%>
  </table>
  <% 
    rs.close();
  %>
</BODY>    
</HTML>
