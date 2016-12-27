package com.yyit.marketOperation.messageapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yyit.marketOperation.message.entities.FilterSeachVO;
import com.yyit.marketOperation.message.entities.MessageRecordVO;
import com.yyit.marketOperation.message.entities.MessageVO;
import com.yyit.marketOperation.message.entities.ReqConditionVO;
import com.yyit.marketOperation.message.entities.SetMsgStatusVO;
import com.yyit.marketOperation.message.responseenitities.ResponseEntity;
import com.yyit.marketOperation.message.services.MessageRecordService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "api/message")
public class MessageRecordController {

	@Autowired
	public MessageRecordService messageRecordService;

	@RequestMapping("/test")
	public String test() {
		return "啦啦啦，成功rest api--messageRecordController";
	}

	/**
	 * 发送消息
	 * 
	 * errcode 1001
	 * 
	 * @return
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	@ApiOperation(value = "send message", httpMethod = "POST", response = Object.class, notes = "send message info")
	public Object sendmessage(
			@ApiParam(required = true, name = "paramData", value = "message json data") @RequestBody MessageVO messageVO) {

		ResponseEntity res = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();

		Boolean bl = messageRecordService.insert(messageVO);

		System.out.println(messageVO.getMsgContent());
		if (bl) {
			res.setErrcode(0);
			res.setErrmsg("消息发送成功！");
		} else {
			res.setErrcode(8001);
			res.setErrmsg("消息发送异常！");
		}
		res.setData(data);
		return res;

	}

	/**
	 * 接收消息
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/receive", method = RequestMethod.POST)
	public Object receiveMessage(@RequestBody ReqConditionVO req) {
		ResponseEntity res = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();

		List<MessageRecordVO> list = messageRecordService.receiveMessage(req);
		data.put("list", list);
		data.put("total", list.size());
		res.setErrcode(0);
		res.setErrmsg("请求消息记录成功！");

		res.setData(data);
		return res;
	}

	/**
	 * 内容页面，消息列表
	 * 
	 * @param filterVO
	 * @return
	 */
	@RequestMapping(value = "/contentlist", method = RequestMethod.POST)
	public Object contentList(@RequestBody FilterSeachVO filterVO) {
		ResponseEntity res = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();

		List<MessageRecordVO> list = messageRecordService.getMessageList(filterVO);
		data.put("list", list);
		data.put("total", list.size());
		res.setErrcode(0);
		res.setErrmsg("获取消息内容列表成功！");

		res.setData(data);
		return res;
	}

	@RequestMapping(value = "/setonthewall", method = RequestMethod.POST)
	public Object setOnthewall(@RequestBody SetMsgStatusVO setOnthewall) {

		ResponseEntity res = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();

		Boolean bl = messageRecordService.setOnthewall(setOnthewall);
		if (bl) {
			res.setErrcode(0);
			res.setErrmsg("设置上墙成功！");
		} else {
			res.setErrcode(8300);
			res.setErrmsg("设置异常！");
		}
		res.setData(data);
		return res;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Object deletemsg(@RequestBody SetMsgStatusVO setdelete) {
		ResponseEntity res = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();

		Boolean bl = messageRecordService.setdelte(setdelete);
		if (bl) {
			res.setErrcode(0);
			res.setErrmsg("消息删除成功！");
		} else {
			res.setErrcode(8301);
			res.setErrmsg("消息删除异常！");
		}
		res.setData(data);
		return res;
	}

	@RequestMapping("/compire")
	public void compire() {
		String a = "  Hello World!  ";
		String b = "Hello World!";

		System.out.println("a--" + a + "--");
		System.out.println("b--" + b + "--");
		System.out.println(a.equals(b));
		a = a.trim();
		System.out.println("a--" + a + "--");
		System.out.println(a.equals(b));
	}
}
