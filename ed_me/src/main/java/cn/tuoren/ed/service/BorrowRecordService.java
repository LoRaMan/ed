package cn.tuoren.ed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tuoren.ed.base.BaseServiceImpl;
import cn.tuoren.ed.dao.impl.BookDao;
import cn.tuoren.ed.dao.impl.BorrowRecordDao;
import cn.tuoren.ed.domain.Book;
import cn.tuoren.ed.domain.BorrowRecord;

@Transactional
@Service
public class BorrowRecordService extends BaseServiceImpl<BorrowRecord> {
	@Autowired
	private BorrowRecordDao borrowRecordDao;
	public List<BorrowRecord> querybyborrowedStatus(String status){
		return borrowRecordDao.querybyborrowedStatus(status);
	}
}
