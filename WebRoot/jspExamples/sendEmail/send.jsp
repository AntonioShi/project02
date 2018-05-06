<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page errorPage="errorPage.jsp" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.mail.*" %>
<%@ page import="javax.mail.internet.*" %>
<%@ page import="javax.activation.*" %>
<html>
<head>
<title>邮件发送</title>
</head>
<body>
<%
	String host = "sdu.edu.cn";
	String to = request.getParameter("to");
	String from = request.getParameter("from");
	String cs= request.getParameter("cs");
	String subject= request.getParameter("subject");
	String messageText=request.getParameter("body");
	boolean sessionDebug = false;
	//检测邮件地址是否合法
	if ((to.trim().indexOf("@")==-1)||(to.trim().length()<5)){
%>
	<jsp:forward page="err.jsp"/>
<%}
	if ((from.trim().indexOf("@")==-1)||(from.trim().length()<5)){
%>
	<jsp:forward page="err.jsp"/>
<%}
	if ((cs.trim().length()>0&&cs.trim().length()<5)||((cs.trim().length()!=0)&&(cs.trim().indexOf("@")==-1))){
%>
	<jsp:forward page="err1.jsp"/>
<%
	}
	Properties props = System.getProperties();
	props.put("mail.host", host);
	props.put("mail.transport.protocol", "smtp");
	Session mailSession = Session.getDefaultInstance(props, null);
	mailSession.setDebug(sessionDebug);
	try{
		Message msg = new MimeMessage(mailSession);
		msg.setFrom(new InternetAddress(from));
		InternetAddress[] addressTo = {new InternetAddress(to)};
		msg.setRecipients(Message.RecipientType.TO,addressTo);
		if (cs.trim().length()!=0){
			InternetAddress[] addressCc = {new InternetAddress(cs)};
			msg.setRecipients(Message.RecipientType.CC,addressCc);
		}
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(messageText);
		Transport.send(msg);
	}
	catch(Exception ex){
		out.println("邮件发送失败！");
	}
%>
<jsp:forward page="ok.jsp"/>
</body>
</html>
