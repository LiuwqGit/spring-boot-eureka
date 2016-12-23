package com.yyit.marketOperation.message.mongoentities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class MessageSettings {

	@Id
	private String id;//
	private Boolean filterOn;// 是否设置过滤字段， 0 false 不设置，1true 设置
	private List<String> filterfield;//过滤字段。
	private Date filterStartTime;///过滤开始时间
	private Date filterEndTime;////过滤结束时间
	private Date operationTime;//操作的时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getFilterOn() {
		return filterOn;
	}
	public void setFilterOn(Boolean filterOn) {
		this.filterOn = filterOn;
	}
	public List<String> getFilterfield() {
		return filterfield;
	}
	public void setFilterfield(List<String> filterfield) {
		this.filterfield = filterfield;
	}
	public Date getFilterStartTime() {
		return filterStartTime;
	}
	public void setFilterStartTime(Date filterStartTime) {
		this.filterStartTime = filterStartTime;
	}
	public Date getFilterEndTime() {
		return filterEndTime;
	}
	public void setFilterEndTime(Date filterEndTime) {
		this.filterEndTime = filterEndTime;
	}
	public Date getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
}
