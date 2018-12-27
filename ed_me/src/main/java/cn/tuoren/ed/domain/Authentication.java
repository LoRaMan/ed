package cn.tuoren.ed.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;


/**
 * 功能权限类
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */
@Entity
public class Authentication {
	//与Role：多对多
	private Long id;
	private String url;
	private String name;
	private Set<Role> roles = new HashSet<Role>();
	private Authentication parent;
	private Set<Authentication> children = new HashSet<Authentication>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Authentication getParent() {
		return parent;
	}
	public void setParent(Authentication parent) {
		this.parent = parent;
	}
	public Set<Authentication> getChildren() {
		return children;
	}
	public void setChildren(Set<Authentication> children) {
		this.children = children;
	}
	
}
