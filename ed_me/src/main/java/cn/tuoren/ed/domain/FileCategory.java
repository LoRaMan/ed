package cn.tuoren.ed.domain;
/**
 * 文件类别
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class FileCategory {
	//与File：1对多
	private Long categoryId;//类别Id
	private Set<EdFile> files=new HashSet<EdFile>();
	private String categoryName;//类别名称
	private String remarks;//备注
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Set<EdFile> getFiles() {
		return files;
	}
	public void setFiles(Set<EdFile> files) {
		this.files = files;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
