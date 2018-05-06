package studentGradeSelect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentGradePageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Integer PageSize = 2;
		Integer Page = 1;
		Integer totalPage = 1;
		Integer totalrecord = 0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();// 加载mysql驱动程序
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/course", "root", "123456");// 参数包括数据库地址，用户名，密码
			stmt = conn.createStatement();// 创建SQL语句对象

			// 统计记录总数
			String strSQL = "SELECT count(*) as recordcount FROM grade";
			rs = stmt.executeQuery(strSQL);
			if (rs.next())
				totalrecord = rs.getInt("recordcount");

			// 计算总页数
			if (totalrecord % PageSize == 0)// 如果是当前页码的整数倍
				totalPage = totalrecord / PageSize;
			else
				// 如果最后还空余一页
				totalPage = (int) Math.floor(totalrecord / PageSize) + 1; // Math是java的数学类

			if (totalPage == 0)
				totalPage = 1;

			// 获取用户要求的页码
			if (request.getParameter("Page") == null
					|| request.getParameter("Page").equals(""))
				Page = 1;
			else
				Page = Integer.parseInt(request.getParameter("Page"));

			// 分页查询，先计算 该页第一条记录 在查询结果中是第几条记录 from
			Integer from = (Page - 1) * PageSize + 1;

			// limit是mysql的特有select 子句，专门用来支持分页查询 ， 语法：LIMIT M,N
			// 从第10条记录开始检索20条记录，语句如下： select * from sys_option limit 10,20
			strSQL = "SELECT * FROM grade limit " + from.toString() + ","
					+ PageSize.toString();
			rs = stmt.executeQuery(strSQL);
			out.print("<TABLE BORDER='1'>");

			while (rs.next()) {
				out.print("<TR><TD>" + rs.getString("学号") + "</TD>");
				out.print("<TD>" + rs.getString("姓名") + "</TD>");
				out.print("<TD>" + rs.getString("语文") + "</TD>");
				out.print("<TD>" + rs.getString("数学") + "</TD>");
				out.print("<TD>" + rs.getString("英语") + "</TD></TR>");
			}
			out.print("</TABLE>");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		out.println("<FORM Action='studentGradePage.jsp' Method='GET'>");

		if (Page != 1) {
			out.print("   <A HREF=/project02/servlet/StudentGradePageServlet?Page=1>第一页</A>");
			out.print("   <A HREF=/project02/servlet/StudentGradePageServlet?Page=" + (Page - 1) + ">上一页</A>");
		}
		if (Page != totalPage) {
			out.print("   <A HREF=/project02/servlet/StudentGradePageServlet?Page=" + (Page + 1) + ">下一页</A>");
			out.print("   <A HREF=/project02/servlet/StudentGradePageServlet?Page=" + totalPage + ">最后一页</A>");
		}
		
		out.println("<BR>");
		out.println("  输入页数：<input TYPE='TEXT' Name='Page' SIZE='3'> ");
		out.println("页数:<font COLOR='Red'>"+Page+"/"+totalPage+"</font>");
		out.print(" </FORM></BODY></BODY> ");
		out.flush();
		out.close();
	}

}
