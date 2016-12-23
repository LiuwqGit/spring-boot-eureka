package com.yyit.marketOperation.messageapi.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class messageController {

	@RequestMapping("/test")
	public String test() {
		return "啦啦啦，成功rest api";
	}

	@RequestMapping("/sendmessage")
	public Object sendmessage() {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("errmsg", "message");
		map.put("errcode", 0);
		map.put("data", "{}");
		
		return map;

	}
}
