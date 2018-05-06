<%@ page language="java" import="java.sql.*"
	contentType="text/html;charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head></head>

<body>

	<% Connection conn = null;  Statement stmt = null; ResultSet rs = null;
		boolean defaultCommit = false;

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();//加载mysql驱动程序
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course", "root", "123456");//参数包括数据库地址，用户名，密码
			
			String strSQL1 = "INSERT INTO grade(学号) VALUES(9001)";
			String strSQL2 = "UPDATE grade SET 姓名='张三' WHERE 学号=9001";
			defaultCommit = conn.getAutoCommit();//记录当前事务状态（是否处于事务）
			conn.setAutoCommit(false);//将自动事务设成false，这样如果不执行到                           
			stmt = conn.createStatement();
			stmt.executeUpdate(strSQL1);
			//conn.rollback();
//分别屏蔽或显示以下语句，观察数据变化			
/* 			int i=0,j;
			j=3/i; */			
			
			stmt.executeUpdate(strSQL2);
			//“conn.commit()”语句所有SQL语句的执行结果不向数据库中提交
		    conn.commit();		     
			conn.setAutoCommit(defaultCommit);//恢复原始事务状态

		}
		catch(Exception e){
			conn.rollback();//发生异常则事务回滚
			e.printStackTrace();

			System.out.println(e.getMessage());
		}
		finally{
			rs=stmt.executeQuery("select * from grade");//执行SQL语句得到结果集
			while(rs.next()){//遍历查询结果的每一条记录（一条记录包含多个字段）
				out.print(rs.getString("姓名")+"  ");
				out.print(rs.getInt("数学")+"  ");
				out.print("<BR>");	
			}	
			
			conn.setAutoCommit(defaultCommit);//恢复之前的事务状态
			if (stmt != null)   stmt.close();		
			if (conn != null)  conn.close();

		}
	%>


</body>
</html>
