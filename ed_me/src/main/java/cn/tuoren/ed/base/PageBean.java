package cn.tuoren.ed.base;

import java.util.List;
/**
 * 分页
 * @author wanqging 2018-12-4
 * @version 1.0.0
 * @param <T>
 */
public class PageBean<T> {
	//传递的参数
	private int pageSize;//每页记录数
	private int currentPageCode;//当前页码
	//数据库查询
	private int totalRecords;//查询的总记录数
	private List<T> recordList; //查询的数据列表
	//计算
	private int totalPages;//总页码数
	private int startPageIndex;//分页显示页码开始索引
	private int endPageIndex;//分页显示页码结束索引
	
	public PageBean(int pageSize,int currentPageCode,int totalRecords, List<T> recordList){
		this.pageSize=pageSize;
		this.currentPageCode=currentPageCode;
		this.totalRecords=totalRecords;
		this.recordList=recordList;
		/**
		 * 计算totalPages：
		 * 1、当totalRecords<pageSize时，totalPages=(totalRecords/pageSize)+1 
		 * 2、当totalRecords>pageSize时：
		 * 		1）totalRecords==n*pageSize:totalPages=totalPages=totalRecords/pageSize 
		 * 		2）totalRecords>n*pageSize:totalPages=(totalRecords/pageSize)+1 
		 */
		totalPages=(totalRecords+pageSize-1)/pageSize;
		//总页码小于等于10页，显示全部
		if (totalPages<=10) {
			startPageIndex=1;
			endPageIndex=totalPages;
		} else {//总页码数>10
			//默认显示当前页，当前页前面的4页，当前页后面的5页
			startPageIndex=currentPageCode-4;
			endPageIndex=currentPageCode+5;
			//当前页前面的页码不足4页时，显示前10页
			if (startPageIndex<1) {
				startPageIndex=1;
				endPageIndex=10;
			}
			//当前页后面的页码不足5页时，显示后10页
			if (endPageIndex>totalPages) {
				startPageIndex=totalPages-9;
				endPageIndex=totalPages;
			}
		}
	}
	
	
	public int getStartPageIndex() {
		return startPageIndex;
	}
	public void setStartPageIndex(int startPageIndex) {
		this.startPageIndex = startPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPageCode() {
		return currentPageCode;
	}
	public void setCurrentPageCode(int currentPageCode) {
		this.currentPageCode = currentPageCode;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<T> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<T> recordList) {
		this.recordList = recordList;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
