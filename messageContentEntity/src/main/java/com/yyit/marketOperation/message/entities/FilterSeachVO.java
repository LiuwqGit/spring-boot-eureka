package com.yyit.marketOperation.message.entities;

/**
 * 内容列表查询过滤
 * 
 * @author wbliuwq
 * @date 2016年12月27日
 */
public class FilterSeachVO {
	private String meetingId;// 会议ID
	private String senderName;// 内容发送者的昵称
	private String msgType;
	private Integer pageSize;// 每页显示（屏）的数量
	private Integer pageIndex;// 当前页(屏)

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
}
