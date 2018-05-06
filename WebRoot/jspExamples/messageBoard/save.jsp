<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<HTML>
<BODY>
<%!		//servlet的成员属性和成员方法
          //定义向量
         int i=0; 
         synchronized void sendMessage(ServletContext  application, String s) {   //synchronized 同步，java语言的技术
             Vector v=(Vector)application.getAttribute("mess");
             if(v==null)
             	v=new Vector(); 
             	             	 
            v.add(s);    //添加到向量末尾
            application.setAttribute("mess",v); 
          }
%>
<%
		//每次访问servlet都要执行的代码
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String messages = request.getParameter("messages");
		
		if (name!=null && name.isEmpty()) {
			name = "guest" + (int) (Math.random() * 10000);
		}
		if (title.isEmpty()) {
			title = "无标题";
		}
		if (messages.isEmpty()) {
			messages = "无信息";
		}
		
		String time = new Date().toString();
		String s = "#" + name + "#" + title + "#" + time + "#" + messages+ "#";
		sendMessage(application,s);//application  隐含对象
%>
	您的信息已经提交！
	<br>
	<a href="messageBoard.jsp">返回 </a>&nbsp;
	<A href="show.jsp">查看留言版</A>
</BODY>
</HTML>
