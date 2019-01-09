package cn.tuoren.ed.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.tuoren.ed.base.BaseDaoImpl;
import cn.tuoren.ed.domain.Book;
import cn.tuoren.ed.domain.BorrowRecord;

@Repository
public class BorrowRecordDao extends BaseDaoImpl<BorrowRecord> {
	public List<BorrowRecord> querybyborrowedStatus(String status) {
		Query listQury=getSession().createQuery(" from BorrowRecord,Book where borrowedStatus=? and BorrowRecord.bookId=Book.bookId");
		listQury.setParameter(0, status);
		List<BorrowRecord> rtnList=listQury.list();
		return rtnList;
	}
}
