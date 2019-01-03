package cn.tuoren.ed.service;

import java.util.List;

import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tuoren.ed.base.BaseServiceImpl;
import cn.tuoren.ed.dao.impl.BookDao;
import cn.tuoren.ed.domain.Book;

@Transactional
@Service
public class BookService extends BaseServiceImpl<Book> {
	@Autowired
	private BookDao bookDao;
	public List<Book> queryByName(String nameStr){
		return bookDao.queryByName(nameStr);
	}
}
