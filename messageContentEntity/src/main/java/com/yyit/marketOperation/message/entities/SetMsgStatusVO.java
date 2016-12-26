package com.yyit.marketOperation.message.entities;

import java.util.List;

/**
 * 设置消息的状态
 * 
 * @author wbliuwq
 * @date 2016年12月26日
 */
public class SetMsgStatusVO {
	private String meetingId;// 会议ID
	private List<String> msgIds;// 消息ID列表
	private Boolean status;// 状态 。 是否上墙，true 上墙，false 不上墙；是否删除，true 删除，false 未删除

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public List<String> getMsgIds() {
		return msgIds;
	}

	public void setMsgIds(List<String> msgIds) {
		this.msgIds = msgIds;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
