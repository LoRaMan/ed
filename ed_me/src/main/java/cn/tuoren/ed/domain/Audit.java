package cn.tuoren.ed.domain;

import java.util.Date;

import javax.persistence.Entity;
/**
 * 文件审核类
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */
@Entity
public class Audit {
	//与File：1对1
	private Long auditId;//审核记录Id
	private EdFile file;//审核的公文、文件等
	private String auditor;//审核人
	private String isAudited;//是否已经审核过
	private String auditAdvice;//审核意见
	private Date auditDate;//审核时间
	private String auditStatus;//审核后的状态：通过or退回？
	public Long getAuditId() {
		return auditId;
	}
	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}
	public EdFile getFile() {
		return file;
	}
	public void setFile(EdFile file) {
		this.file = file;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getIsAudited() {
		return isAudited;
	}
	public void setIsAudited(String isAudited) {
		this.isAudited = isAudited;
	}
	public String getAuditAdvice() {
		return auditAdvice;
	}
	public void setAuditAdvice(String auditAdvice) {
		this.auditAdvice = auditAdvice;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	
}
