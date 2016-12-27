package com.yyit.marketOperation.message.mongoentities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="messageSettings")
public class MessageSettings {

	@Id
	private String id;//
	private Boolean approveOn;//是否开启评论审批，审核消息，开启审核，默认不上墙。关闭，默认上墙。
 
	private Boolean filterOn;// 是否启用过滤字段， 0 false 不启用，1true 启用
	private List<String> filterfield;//过滤字段。 
	private Date operationTime;//操作的时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	 
	public Boolean getApproveOn() {
		return approveOn;
	}
	public void setApproveOn(Boolean approveOn) {
		this.approveOn = approveOn;
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
	public Date getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
	 
}
