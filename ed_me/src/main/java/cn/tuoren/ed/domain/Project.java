package cn.tuoren.ed.domain;
/**
 * 项目
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Project {
	//与File：1对多
	private Long projectId;//项目索引
	private Set<EdFile> files=new HashSet<EdFile>();
	private String projectName;//项目名称
	private String remark;
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Set<EdFile> getFiles() {
		return files;
	}
	public void setFiles(Set<EdFile> files) {
		this.files = files;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
