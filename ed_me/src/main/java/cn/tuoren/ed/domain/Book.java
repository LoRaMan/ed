package cn.tuoren.ed.domain;

import java.util.Date;

import java.util.HashSet;
/**
 * 图书类
 * @author wangqing 2018-12-5
 * @version 1.0
 * 
 */
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Book {
	//与BorrowRecord：一对多
	private Long bookId;//索引
	private Set<BorrowRecord> records=new HashSet<BorrowRecord>();//借出记录
	private String bookName;//书名
	private String bookAuthor;//作者
	private String bookPress;//出版社
	private String bookCategory;//类别
	private Date warehousingDate;//入库时间
	private String ISBN_Number;//图书编号
	private String bookPrice;//单价
	private String operator;//操作人
	private String version;//版本
	private String bookShelf;//所在书架
	private String synopsis;//简介
	private int amount;//数量
	private int borrowed;  //已借阅
	private int remain;  //可借阅
	
	public int getBorrowed() {
		return borrowed;
	}
	public void setBorrowed(int borrowed) {
		this.borrowed = borrowed;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Set<BorrowRecord> getRecords() {
		return records;
	}
	public void setRecords(Set<BorrowRecord> records) {
		this.records = records;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPress() {
		return bookPress;
	}
	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public Date getWarehousingDate() {
		return warehousingDate;
	}
	public void setWarehousingDate(Date warehousingDate) {
		this.warehousingDate = warehousingDate;
	}
	public String getISBN_Number() {
		return ISBN_Number;
	}
	public void setISBN_Number(String iSBN_Number) {
		ISBN_Number = iSBN_Number;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getBookShelf() {
		return bookShelf;
	}
	public void setBookShelf(String bookShelf) {
		this.bookShelf = bookShelf;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
