package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Good;
import bean.GoodItem;
import database.DbBean;

public class GoodItemDao {
	public List<GoodItem> getByUserNameWithDbBean(DbBean dbBean,String userName){
		List<GoodItem> goodItems=new ArrayList<GoodItem>();
		try {
			ResultSet rs=dbBean.executeQueryWithoutConnection("select * from gooditems where userName='"+userName+"'");					
			while(rs.next()){
				GoodItem goodItem=new GoodItem();
				goodItem.setName(rs.getString("name"));
				goodItem.setPrice(rs.getDouble("price"));
				goodItem.setNumber(rs.getInt("number"));
				goodItems.add(goodItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		if(goodItems.size()==0)
			return null;
		
		return goodItems;
	}
	
	public void save(DbBean dbBean,String userName, List<GoodItem> goodItems) throws SQLException{
		//先删除，再添加
		dbBean.executeUpdateWithoutConnection("delete from gooditems where userName='"+userName+"'");					

		//为了提高运行效率（非编程效率），不用通用数据库操作类DbBean
		PreparedStatement  preStatement=dbBean.getConnect()
				.prepareStatement("insert into gooditems(userName,name,price,number) values(?,?,?,?)");	
		
		System.out.println(preStatement.getConnection().getAutoCommit());
		
		for(int i=0;i<goodItems.size();i++){
			//设置实参
			preStatement.setString(1, userName);
			preStatement.setString(2, goodItems.get(i).getName());
			preStatement.setDouble(3, goodItems.get(i).getPrice());
			preStatement.setInt(4, goodItems.get(i).getNumber());
			
			preStatement.addBatch();//加入批处理 
		}
		
		preStatement.executeBatch();
		
	}
	
	

}
