package com.yyit.marketOperation.message.entities;

import java.util.List;

/**
 * 过滤词设置实体
 * 
 * @author wbliuwq
 * @date 2016年12月27日
 */
public class FilterSetVO {
	private List<String> filterField;// 过滤词
	private String meetingId;// 会议ID
	private Boolean filterOn;// 是否启用过滤词

	public List<String> getFilterField() {
		return filterField;
	}

	public void setFilterField(List<String> filterField) {
		this.filterField = filterField;
	}

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public Boolean getFilterOn() {
		return filterOn;
	}

	public void setFilterOn(Boolean filterOn) {
		this.filterOn = filterOn;
	}

}
