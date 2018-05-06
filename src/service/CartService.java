package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.GoodItemDao;
import dao.GoodsDao;
import database.DbBean;

import bean.Cart;
import bean.Good;
import bean.GoodItem;

public class CartService {
	
	
	public Cart change(HttpServletRequest request){
		
		DbBean dbBean=new DbBean();
		
		if(dbBean.connection()){
			try {				
				boolean defaultCommit = dbBean.getConnect().getAutoCommit();//得到当前事务设定的值
				dbBean.setAutoCommit(false);//设置事务开始
				GoodsDao goodsDao=new GoodsDao();
				List<Good> goods=goodsDao.getAllWithDbBean(dbBean);
				GoodItemDao goodItemDao=new GoodItemDao();
				HttpSession session=request.getSession();
				Cart cart=(Cart) session.getAttribute("cart");
				
				String userName=(String)session.getAttribute("userName");
				if(cart==null){//没有入购物车信息					
					List<GoodItem> goodItems= goodItemDao.getByUserNameWithDbBean(dbBean,userName );
					
					if(goodItems==null){//用户没有旧的购物车信息
						cart=new Cart();
					}else{
						cart=new Cart();
						cart.setGoods(goodItems);//从数据库中提取购物车信息
					}					
				}	
				
				for(int i=0;i<goods.size();i++){
					String goodName=goods.get(i).getName();
					String numberString=request.getParameter(goodName);
					Integer number;
					number=Integer.parseInt(numberString);
					
					int index=-1;
					//检查购物车中是否有该商品	
					for(int j=0;j<cart.getGoods().size();j++){
						if(goodName.equals(cart.getGoods().get(j).getName())){
							index=j;
							break;
						}							
					}
					
					if(index > -1){//购物车中有该商品						
						//更新购买数量
						cart.getGoods().get(index).setNumber(cart.getGoods().get(index).getNumber()+number);						
					}else{//购物车中没有该商品
						GoodItem goodItem=new GoodItem();
						goodItem.setName(goodName);
						goodItem.setNumber(number);
						goodItem.setPrice(goods.get(i).getPrice());
						cart.getGoods().add(goodItem);
					}
				}				
				
				//更新到数据库
				System.out.println(dbBean.getConnect().getAutoCommit());
				goodItemDao.save(dbBean, userName, cart.getGoods());
				System.out.println(dbBean.getConnect().getAutoCommit());
				dbBean.commit();//提交事务
				dbBean.setAutoCommit(defaultCommit);

				return cart;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}		
		}
		return null;
	}

}
