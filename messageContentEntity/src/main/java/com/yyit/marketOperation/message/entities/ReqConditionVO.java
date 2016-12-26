package com.yyit.marketOperation.message.entities;

/**
 * 请求历史消息记录
 * 
 * @author wbliuwq
 * @date 2016年12月26日
 */
public class ReqConditionVO {
	private String meetingId;// 会议ID
	private String ReqPsnId;// 请求人Id
	private Integer pageSize;// 每页显示（屏）的数量
	private Integer pageIndex;// 当前页(屏)

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getReqPsnId() {
		return ReqPsnId;
	}

	public void setReqPsnId(String reqPsnId) {
		ReqPsnId = reqPsnId;
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
