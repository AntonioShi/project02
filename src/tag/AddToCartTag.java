package tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import bean.Cart;
import bean.Good;
import bean.GoodItem;

public class AddToCartTag extends BodyTagSupport{
	private static final long serialVersionUID = 1L;

	public AddToCartTag(){}
	
	public int doStartTag(){
		HttpSession session=this.pageContext.getSession();
		HttpServletRequest request=(HttpServletRequest)this.pageContext.getRequest();

		List<Good> goods=(ArrayList<Good>) this.pageContext.getServletContext().getAttribute("goods");	

		Cart cart=(Cart) session.getAttribute("cart");//session是隐含对象，不用创建可以直接使用
		if(cart==null){//第一次加入购物车
			cart=new Cart();
		}
		
		
		for(int i=0;i<goods.size();i++){
			String goodName=goods.get(i).getName();
			String numberString=request.getParameter(goodName);//request是隐含对象，不用创建可以直接使用
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
	
		return Tag.SKIP_BODY;//忽略标签体的执行，直接执行doEndTag
	}
	
	public int doEndTag(){
		
		return Tag.EVAL_PAGE;//继续执行jsp剩余其它部分
	}
}
