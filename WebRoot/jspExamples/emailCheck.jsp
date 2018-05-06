<%@ page contentType="text/html;charset=UTF-8" %>
<HTML>
<head>df</head>
<BODY bgcolor=FFCC99><Font size=3>
	<P> 请输入E-mail： <BR>
	<FORM action="" method=get name=form>
  		<INPUT  name="mail" type="text" id="mail" size="30">
  		<INPUT TYPE="submit" value="确定" name=submit>
	</FORM>
<%
      String str=request.getParameter("mail");
      if(str!=null){
         int index=str.indexOf("@");
         if(index==-1){
  %>
			<BR>
			您的email地址中不含“@”。 
<%
         }
        else{
         	int pot=str.indexOf(".");
         	if(pot==-1){
  %>
				<BR>
				您的email地址中不含“.”。 
<%
         	}
        	else{
	           int space=str.indexOf(" ");
 	          if(space!=-1){
%>
				<BR>
				您的email地址含有非法的空格。 
<%
           	}  
           	else{
             	int start=str.indexOf("@");
             	int end=str.lastIndexOf("@");
             	if(start!=end){
%>
					<BR>
					您的email地址有两个以上的符号“@”。 
<%
              	}
             	else{
              	  out.print("<BR>"+str);
%>
					<BR>
					您的email地址书写正确。 
<%
				}
              }
            }
         }
       }
  %>
</Font> 
</BODY>
</HTML>
