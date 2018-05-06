<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>FileUpload控件主页：http://commons.apache.org/proper/commons-fileupload/</head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <body>
  
  	上传功能的form中，必须设置：enctype="multipart/form-data"
  	
  	上传单个文件
	<form method="POST" enctype="multipart/form-data" action="/project02/servlet/UploadFileServlet">
	  	选择上传文件: <input type="file" name="upfile"><br/>
	  	文件相关信息: <input type="text" name="note"><br/><br/>
	  	<input type="submit" value="Press"> to upload the file!
	</form>
	<br><br><br>
	上传单个大文件
	<form method="POST" enctype="multipart/form-data" action="/project02/servlet/UploadBigFileServlet">
	  	选择上传文件: <input type="file" name="upfile"><br/>
	  	文件相关信息: <input type="text" name="note"><br/><br/>
	  	<input type="submit" value="Press"> to upload the file!
	</form>	
	<br><br><br>
	上传多个文件--后台按流处理文件
	<form method="POST" enctype="multipart/form-data" action="/project02/servlet/UploadStreamFileServlet">
	  	选择上传文件: <input type="file" name="upfile"><br/>
	  	选择上传文件: <input type="file" name="upfile1"><br/>
	  	文件相关信息: <input type="text" name="note"><br/><br/>
	  	<input type="submit" value="Press"> to upload the file!
	</form>		
  </body>
  
</html>
