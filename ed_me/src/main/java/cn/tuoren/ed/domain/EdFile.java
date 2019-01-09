package cn.tuoren.ed.domain;

import java.util.Date;
/**
 * 文件、文档
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */

import javax.persistence.Entity;
@Entity
public class EdFile {
	//与Audit：1对1，一个文件一个审核
	//与Approve：1对1，一个文件只能一个批准
	//与FileCategory:多对1，一个分类包含多个文件
	//与Project：多对1，一个项目包含多个文件
	//User：多对1，一个用户上传多个文件
	private Long fileId;//文件索引
	private FileCategory category;//文件类别
	private Audit audit;
	private Approve approve;
	private Project project;//归属项目
	private User uploadUser;//上传用户
	private String fileType;//文件类型
	private String fileName;//文件名
	private Double fileSize;//文件大小
	private Date uploadTime;//上传时间
	private String fileStatus;//文件状态
	private String isProjectFile;//是否为项目文件
	private String version;//文件版本
	private String path;//存储路径
	
	
	
	public User getUploadUser() {
		return uploadUser;
	}
	public void setUploadUser(User uploadUser) {
		this.uploadUser = uploadUser;
	}
	public String getIsProjectFile() {
		return isProjectFile;
	}
	public void setIsProjectFile(String isProjectFile) {
		this.isProjectFile = isProjectFile;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public FileCategory getCategory() {
		return category;
	}
	public void setCategory(FileCategory category) {
		this.category = category;
	}
	public Audit getAudit() {
		return audit;
	}
	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	public Approve getApprove() {
		return approve;
	}
	public void setApprove(Approve approve) {
		this.approve = approve;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Double getFileSize() {
		return fileSize;
	}
	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getFileStatus() {
		return fileStatus;
	}
	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
