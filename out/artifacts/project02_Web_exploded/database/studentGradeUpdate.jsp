<%@ page language="java" import="java.sql.*" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head></head>
  
  <body>

	<% Connection conn = null;  Statement stmt = null; ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();//加载mysql驱动程序
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course", "root", "123456");//参数包括数据库地址，用户名，密码
			stmt=conn.createStatement();//创建SQL语句对象
			
			rs=stmt.executeQuery("select * from grade");//执行SQL语句得到结果集
			while(rs.next()){//遍历查询结果的每一条记录（一条记录包含多个字段）
				out.print(rs.getString("姓名")+"  ");
				out.print(rs.getInt("数学")+"  ");
				out.print("<BR>");	
			}			
			
			//执行更新语句,  更新语句执行结果的返回值一般为一个整数，整数的值表示执行的情况
			//executeUpdate（）的返回值表示该条sql语句影响的记录数目，如果抛出异常，表示访问数据库出现异常
			int iBack =stmt.executeUpdate("UPDATE grade SET 数学=数学-10");			
			out.print("<BR><BR>有" + iBack + "条记录被修改！<BR><BR>");
			
			
			rs=stmt.executeQuery("select * from grade");//执行SQL语句得到结果集
			while(rs.next()){//遍历查询结果的每一条记录（一条记录包含多个字段）
				out.print(rs.getString("姓名")+"  ");
				out.print(rs.getInt("数学")+"  ");
				out.print("<BR>");	
			}	
		}
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
