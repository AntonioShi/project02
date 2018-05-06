package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.Good;
import bean.GoodItem;

public class CartMVCService {
	public void CartUpdate(HttpServletRequest request,List<Good> goods){
		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		if(cart==null){//第一次加入购物车
			cart=new Cart();
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
		session.setAttribute("cart", cart);//保存 更新后的购物车
	}

}
