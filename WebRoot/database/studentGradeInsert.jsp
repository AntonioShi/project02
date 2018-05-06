<%@ page language="java" import="java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head></head>
  
  <body>

	<% Connection conn = null;  Statement stmt = null; ResultSet rs = null;
		PreparedStatement pst;//预处理语句对象，用于集中执行多条sql语句，加快执行速度
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
				out.print("<BR>");	
			}
			
			//执行单条更新语句
			java.util.Date a=new java.util.Date();
			out.print(a+"<BR>");
			for(Integer i=300;i<400;i++)
				stmt.executeUpdate("INSERT INTO grade(学号) VALUES(" +i.toString()+")");
			
			java.util.Date b=new java.util.Date();
			out.print(b+"<BR>");
			out.print(b.getTime()-a.getTime());	
			out.print("<BR>");
			
			
			java.util.Date c=new java.util.Date();
			out.print(c+"<BR>");
			pst = conn.prepareStatement("INSERT INTO grade(学号) VALUES (?)");
			for (int i = 400; i < 500; i++) {
				pst.setInt(1, i);//设置第一个参数,注意数据类型
				pst.addBatch();//加入批处理 
			}
			pst.executeBatch();//执行批处理  批处理速度更快
			
			java.util.Date d=new java.util.Date();
			out.print(d+"<BR>");
			out.print(d.getTime()-c.getTime());	
			
			out.print("<BR><BR>");

			rs=stmt.executeQuery("select * from grade");//执行SQL语句得到结果集
			while(rs.next()){//遍历查询结果的每一条记录（一条记录包含多个字段）
				out.print(rs.getInt("学号")+"  "); //获取当前字段的值，注意数据类型
				out.print(rs.getString("姓名")+"  ");
				out.print(rs.getInt("语文")+"  ");
				out.print(rs.getInt("数学")+"  ");
				out.print(rs.getInt("英语")+"  ");
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
