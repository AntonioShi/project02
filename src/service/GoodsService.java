package service;

import java.util.ArrayList;
import java.util.List;

import bean.Good;
import bean.PageParam;
import dao.GoodsDao;
import database.DbBean;

public class GoodsService {
	public List<Good> getOnePage( Integer page,PageParam pageParam){
		DbBean dbBean=new DbBean();
		List<Good> goods=null;
		if(dbBean.connection()){
			GoodsDao goodsDao=new GoodsDao();		
			goods=goodsDao.getOnePage(dbBean,page,2);
			pageParam.setFirst(1);
			pageParam.setPre(page-1);
			
			Integer c=goodsDao.getCount(dbBean);
			
			if(c%2==0)
				c=c/2;
			else
				c=c/2+1;
			
			pageParam.setTotalPage(c);
			pageParam.setLast(c);
			pageParam.setNext(page+1);
			pageParam.setNow(page);
		
		}
		return goods;
	}
}
