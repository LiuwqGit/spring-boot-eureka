package com.yyit.marketOperation.message.entities;

import java.util.Date;

public class MessageRecordVO {
	private String id; // ObjectId,可以作为记录id
	private String msgContent;// 消息内容
	private int msgType;// 消息类型
	private Date sendTime;
	private String senderName;
	private String senderId;
	private String senderImage;
	private Boolean onthewallStatus;
	private Boolean isDeleted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public int getMsgType() {
		return msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderImage() {
		return senderImage;
	}

	public void setSenderImage(String senderImage) {
		this.senderImage = senderImage;
	}

	public Boolean getOnthewallStatus() {
		return onthewallStatus;
	}

	public void setOnthewallStatus(Boolean onthewallStatus) {
		this.onthewallStatus = onthewallStatus;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
