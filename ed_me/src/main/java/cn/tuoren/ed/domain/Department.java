package cn.tuoren.ed.domain;
/**
 * 部门实体类
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Department {
	//与User：1对多
	
	private Long departmentId;//部门Id
	private Set<User> users=new HashSet<User>();
	private String departmentName;//部门名称
	private String remarks;//备注
	
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
