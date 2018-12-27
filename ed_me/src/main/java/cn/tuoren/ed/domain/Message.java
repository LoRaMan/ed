package cn.tuoren.ed.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
/**
 * 消息类
 * @author wangqing 2018-12-5
 * @version 1.0.0
 */
@Entity
public class Message {
	//与User：多对多
	private Long messageId;//索引
	private Set<User> users=new HashSet<User>();
	private String msgContent;//消息文本
	private String msgType;//消息类型
	private String msgFromUrl;//消息来源，提供到达处理目标的url链接
	private Date receivedTime;//收到时间
	private Boolean isRead;//是否已读
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgFromUrl() {
		return msgFromUrl;
	}
	public void setMsgFromUrl(String msgFromUrl) {
		this.msgFromUrl = msgFromUrl;
	}
	public Date getReceivedTime() {
		return receivedTime;
	}
	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
	}
	public Boolean getIsRead() {
		return isRead;
	}
	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}
	
	
}
