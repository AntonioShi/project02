<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<HTML>
<BODY>

   <table align='center' border='2'  bgcolor='red'>
      <tr>
	       <td>留言者姓名</td>
	       <td>留言标题</td>
	       <td>留言时间</td>
	       <td>留言内容</td>
     </tr>
<%
       Vector v=(Vector)application.getAttribute("mess");//vector java的动态数组类 
       if(v!=null)   
	       for(int i=0;i<v.size();i++){            
	           String message=(String)v.elementAt(i);
	           StringTokenizer fenxi=new StringTokenizer(message,"#");
	           out.print("<tr bgcolor='pink' >");
	           int number=fenxi.countTokens();
	           for(int k=0;k<number;k++) { 
	             String str=fenxi.nextToken();            
	             if(k<number-1){
	                out.print("<td>"+str+"</td>");
	               }
	             else {//最后一个单元格里，用多行文本框显示留言内容
	                out.print("<td><TextArea rows=3 cols=12>"+str+"</TextArea></td>");
	               } 
	          }
	          out.print("</tr>");
	       } 
%>  </table>

</BODY>
</HTML>
