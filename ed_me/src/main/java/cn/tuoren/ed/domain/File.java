package cn.tuoren.ed.domain;

import java.util.Date;
/**
 * 文件、文档
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class File {
	//与Audit：1对1
	//与Approve：1对1
	//与FileCategory:多对1
	//与Project：多对1
	//User：多对多
	private Long fileId;//文件索引
	private FileCategory category;//文件类别
	private Audit audit;
	private Approve approve;
	private Project project;//归属项目
	private Set<User> users;
	private String fileType;//文件类型
	private String fileName;//文件名
	private Double fileSize;//文件大小
	private Date uploadTime;//上传时间
	private String uploader;//上传人
	private String fileStatus;//文件状态
	private String secretLevel;//保密级别
	private String version;//文件版本
	private String path;//存储路径
	
	
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
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
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
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getFileStatus() {
		return fileStatus;
	}
	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}
	public String getSecretLevel() {
		return secretLevel;
	}
	public void setSecretLevel(String secretLevel) {
		this.secretLevel = secretLevel;
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
