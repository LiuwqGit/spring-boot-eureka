package com.yyit.marketOperation.messageapi.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyit.marketOperation.message.entities.MessageRecordVO;
import com.yyit.marketOperation.message.services.MessageService;

@RestController
@RequestMapping("/api/message/")


public class messageController {

	@Autowired
	public MessageService messageService;
	
	@RequestMapping("/test")
	public String test() {
		return "啦啦啦，成功rest api";
	}

	@RequestMapping("/sendmessage")
	public Object sendmessage() {
		Map<String, Object> map = new HashMap<String, Object>();

		MessageRecordVO messageVO= new MessageRecordVO();

		messageService.insert(messageVO);
		
		map.put("errmsg", "message" + "成功插入消息" );
	
		map.put("errcode", 0);
		map.put("data", "{}");
		
		return map;

	}
}
