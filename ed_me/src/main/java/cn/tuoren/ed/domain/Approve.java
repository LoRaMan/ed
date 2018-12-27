package cn.tuoren.ed.domain;

import java.util.Date;

import javax.persistence.Entity;
/**
 * 文件批准类
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */
@Entity
public class Approve {
	//与File：1对1
	private Long approveId;//索引
	private EdFile file;//批阅的公文、文件等
	private String approver;//批准人
	private String isApproved;//批准人是否阅读
	private String approveAdvice;//批准意见
	private Date approveDate;//批准日期
	private String approvedStatus;//批准状态
	public Long getApproveId() {
		return approveId;
	}
	public void setApproveId(Long approveId) {
		this.approveId = approveId;
	}
	public EdFile getFile() {
		return file;
	}
	public void setFile(EdFile file) {
		this.file = file;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}
	public String getApproveAdvice() {
		return approveAdvice;
	}
	public void setApproveAdvice(String approveAdvice) {
		this.approveAdvice = approveAdvice;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public String getApprovedStatus() {
		return approvedStatus;
	}
	public void setApprovedStatus(String approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
	
	
}
