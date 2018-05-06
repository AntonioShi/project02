<%@ page language="java" import="java.sql.*" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head></head>
  
  <body>

	<%	Connection conn = null;  Statement stmt = null; ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();//加载mysql驱动程序
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course", "root", "123456");//参数包括数据库地址，用户名，密码
			stmt=conn.createStatement();//创建SQL语句对象
			rs=stmt.executeQuery("select * from grade");//执行SQL语句得到结果集
			while(rs.next()){//遍历查询结果的每一条记录（一条记录包含多个字段）
				out.print(rs.getInt("学号")+"  "); //获取当前字段的值，注意数据类型
				out.print(rs.getString("姓名")+"  ");
				out.print(rs.getInt("语文")+"  ");
				out.print(rs.getInt("数学")+"  ");
				out.print(rs.getInt("英语")+"  ");
				out.print("<BR>");	}}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			stmt.close();//关闭语句对象
			conn.close();//关闭数据库连接，以便其他人使用
		}
	%>


  </body>
</html>
