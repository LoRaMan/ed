package cn.tuoren.ed.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

/**
 * 用户
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */
@Entity
public class User {
	//与Department：多对1
	//与Role：多对1
	//与Message：多对多
	//与Menu：多对多
	//与File：多对多
	//与BorrowRecord：1对多
	
	private Long userId;//用户索引
	private Department department;//部门
	private Role role;//
	private Set<Message> messages=new HashSet<Message>();
	private Set<Menu> menus=new HashSet<Menu>();
	private Set<EdFile> files=new HashSet<EdFile>();
	private Set<BorrowRecord> records=new HashSet<BorrowRecord>();
	private String loginName;//登录名
	private String password;//密码
	private String employeeName;//雇员姓名
	private String employeeId;//工号
	private String phoneNumber;//手机号码
	private String email;//邮箱
	private Date createDate;//创建日期
	private int loginTimes;//登录次数
	private Date lastLoginDate;//最后登录时间
	private String lastLoginIp;//最后登录IP
	private String loginFlag;//登录标识
	private String delFlag;//删除标识
	private String remarks;//备注
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	public Set<EdFile> getFiles() {
		return files;
	}
	public void setFiles(Set<EdFile> files) {
		this.files = files;
	}
	public Set<BorrowRecord> getRecords() {
		return records;
	}
	public void setRecords(Set<BorrowRecord> records) {
		this.records = records;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public String getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
