package com.yyit.marketOperation.message.entities;

/**
 * @author wbliuwq
 * @date 2016年12月24日
 */
public class MessageVO {

	private String meetingId;//会议ID
	private String msgContent;// 消息内容
	private int msgType;// 消息类型
	private String senderName;//发送消息的人员姓名
	private String senderId;//发送消息的人员唯一Id
	private String senderImage;//发送消息人员图片
	
	public String getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
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
	
	// 以下，我认为是从配置文件中获取
	// private Boolean onthewallStatus;//上墙状态 0 false 未上墙， 1 true 已上墙
	// private Boolean isDeleted;//删除状态 0 false 未删除， 1 true 已删除

}
