package cn.tuoren.ed.domain;

import java.util.Date;

import javax.persistence.Entity;
/**
 * 借阅记录
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */
@Entity
public class BorrowRecord {
	//与Book：多对1
	//与User：多对1
	private Long recordId;//借阅记录索引
	private Book book;//借出图书
	private User user;//借出人
	private Date borrowedDate;//借出时间
	private String borrowedStatus;//借出状态：借出or在库？
	private String returnDate;//归还时间
	
	public Long getRecordId() {
		return recordId;
	}
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	public String getBorrowedStatus() {
		return borrowedStatus;
	}
	public void setBorrowedStatus(String borrowedStatus) {
		this.borrowedStatus = borrowedStatus;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	
}
