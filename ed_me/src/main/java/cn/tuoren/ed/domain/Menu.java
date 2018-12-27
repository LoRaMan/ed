package cn.tuoren.ed.domain;
/**
 * 
 * @author wangqing 2018-12-6
 * @version 1.0.0
 *
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Menu {
	//与User：多对多
	private Long menuId;//
	private Set<User> users=new HashSet<User>();
	private Menu parent;//父级菜单
	private Set<Menu> children=new HashSet<Menu>();//子菜单
	private String name;//名称
	private String href;//链接
	private Boolean isShow;//是否在菜单中显示
	private Boolean delFlag;//删除标记
	private String permission;//权限标识
	
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Menu getParent() {
		return parent;
	}
	public void setParent(Menu parent) {
		this.parent = parent;
	}
	public Set<Menu> getChildren() {
		return children;
	}
	public void setChildren(Set<Menu> children) {
		this.children = children;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Boolean getIsShow() {
		return isShow;
	}
	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}
	public Boolean getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
}
