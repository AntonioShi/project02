package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.GradeBean;
import database.DbBean;

public class GradeOperate {

	public List<GradeBean> listAll(String tableName){		
		DbBean dDbBean=new DbBean();
		
		ResultSet rs=dDbBean.executeQuery("select * from " + tableName ) ;
		
		List<GradeBean> grades=new ArrayList<GradeBean>();
		try {
			while(rs.next()){
				GradeBean grade=new GradeBean();
				grade.setChinese(rs.getInt("语文"));
				grade.setEnglish(rs.getInt("英语"));
				grade.setMath(rs.getInt("数学"));
				grade.setStuNum(rs.getInt("学号"));
				grade.setName(rs.getString("姓名"));	
				grades.add(grade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grades;
		
	}
}
