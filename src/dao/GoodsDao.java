package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DbBean;

import bean.Good;

public class GoodsDao {
	public List<Good> getAll(){
		DbBean dbBean=new DbBean();
		List<Good> goods=new ArrayList<Good>();
		try {
			ResultSet rs=dbBean.executeQuery("select * from goods");					
			while(rs.next()){
				Good good=new Good();
				good.setName(rs.getString("name"));
				good.setPrice(rs.getDouble("price"));
				goods.add(good);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
		return goods;
	}

	public List<Good> getAllWithDbBean(DbBean dbBean){
		List<Good> goods=new ArrayList<Good>();
		try {
			ResultSet rs=dbBean.executeQueryWithoutConnection("select * from goods");					
			while(rs.next()){
				Good good=new Good();
				good.setName(rs.getString("name"));
				good.setPrice(rs.getDouble("price"));
				goods.add(good);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
		return goods;
	}
	
	public List<Good> getOnePage(DbBean dbBean, Integer page,Integer pageSize){
		List<Good> goods=new ArrayList<Good>();
		Integer start= (page-1)*pageSize;
		String sql="select * from goods limit "+start.toString()+","+pageSize.toString();
		try {
			ResultSet rs=dbBean.executeQueryWithoutConnection(sql);					
			while(rs.next()){
				Good good=new Good();
				good.setName(rs.getString("name"));
				good.setPrice(rs.getDouble("price"));
				goods.add(good);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	
		return goods;
	}
	
	public Integer getCount(DbBean dbBean){
		String sql="select count(*) as aa from goods";
		Integer c=0;
		try {
			ResultSet rs=dbBean.executeQueryWithoutConnection(sql);					
			while(rs.next()){
				c=rs.getInt("aa");				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	
		return c;
	}
	
}
