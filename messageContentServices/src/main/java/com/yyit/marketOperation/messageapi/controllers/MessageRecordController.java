package com.yyit.marketOperation.messageapi.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yyit.marketOperation.message.entities.MessageVO;
import com.yyit.marketOperation.message.services.MessageRecordService;

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
	 * @return
	 */
	@RequestMapping(value = "/sendmessage", method = RequestMethod.POST)
	public Object sendmessage(@RequestBody MessageVO messageVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		messageRecordService.insert(messageVO);
		System.out.println(messageVO.getMsgContent());
		map.put("errmsg", "message" + "成功插入消息1");

		map.put("errcode", 0);
		map.put("data", data);

		return map;

	}

	@RequestMapping("/c")
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
