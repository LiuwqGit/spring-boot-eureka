package com.yyit.marketOperation.message.responseenitities;

public class ResponseEntity {
private int errcode;//错误码
private String errmsg;//错误消息，正常为空
private Object data;//API接口 返回的数据
public int getErrcode() {
	return errcode;
}
public void setErrcode(int errcode) {
	this.errcode = errcode;
}
public String getErrmsg() {
	return errmsg;
}
public void setErrmsg(String errmsg) {
	this.errmsg = errmsg;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
}
