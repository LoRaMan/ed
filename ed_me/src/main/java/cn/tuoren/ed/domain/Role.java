package cn.tuoren.ed.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
/**
 * 角色
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */

@Entity
public class Role {
	
	//与User：1对多
	//与Authentication：多对多
	private Long roleId;//索引
	private Set<User> users=new HashSet<User>();//用户（1---多）
	private Set<Authentication> authentications=new HashSet<Authentication>();//权限（多----多）
	private String roleName;//角色名称
	private String englishName;//英文名称
	private String roleType;//角色类型
	private String useable;//是否可用
	private Date createDate;//创建时间
	private String remarks;//备注
	private String code;//备注
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Authentication> getAuthentications() {
		return authentications;
	}
	public void setAuthentications(Set<Authentication> authentications) {
		this.authentications = authentications;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getUseable() {
		return useable;
	}
	public void setUseable(String useable) {
		this.useable = useable;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
