<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>FileUpload控件主页：http://commons.apache.org/proper/commons-fileupload/</head>
  
  <body>
  
  	上传功能的form中，必须设置：enctype="multipart/form-data"
	<form method="POST" enctype="multipart/form-data" action="/project02/servlet/UploadBigFileServlet">
	  	选择上传文件: <input type="file" name="upfile"><br/>
	  	文件相关信息: <input type="text" name="note"><br/><br/>
	  	<input type="submit" value="Press"> to upload the file!
	</form>
	
  </body>
  
</html>
