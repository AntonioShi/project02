package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbBean {
	String dbUrl = "jdbc:mysql://localhost:3306/course";
	String dbUser = "root";
	String dbPassword = "123456";
	Connection connect = null;
	Statement stmt=null;
	ResultSet rs = null;

	public DbBean() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public boolean connection (){
		try {
			connect = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			stmt = connect.createStatement();
			return true;
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			return false;
		}		
	}

	public ResultSet executeQuery(String sql) {
		try {
			if(connection())//连接成功
				rs = stmt.executeQuery(sql);
			else
				rs= null;
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			return null;
		}
		return rs;
	}

	public ResultSet executeQueryWithoutConnection(String sql) {
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			rs= null;
		}
		return rs;
	}
	
	public int executeUpdate(String sql) {
		int result = 0;
		try {
			if(connection())//连接成功
				result = stmt.executeUpdate(sql);
			else
				result= -1;
			
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			result= -1;
		}
		return result;
	}
	
	public void executeUpdateWithoutConnection(String sql) throws SQLException {
		stmt.executeUpdate(sql);			
	}
	
	
	public void setAutoCommit(boolean f) throws SQLException{
		connect.setAutoCommit(f);//
		System.out.println(connect.getAutoCommit());
	}
	
	public void commit() throws SQLException{
		connect.commit();
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	
	
}
