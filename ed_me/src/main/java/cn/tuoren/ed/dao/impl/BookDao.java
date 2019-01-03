package cn.tuoren.ed.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.tuoren.ed.base.BaseDaoImpl;
import cn.tuoren.ed.domain.Book;
@Repository
public class BookDao extends BaseDaoImpl<Book> {
	public List<Book> queryByName(String nameStr){
		Query listQury=getSession().createQuery(" from Book where bookName like ?");
		listQury.setParameter(0, "%"+nameStr+"%");
		List<Book> rtnList=listQury.list();
		return rtnList;
	}
}
