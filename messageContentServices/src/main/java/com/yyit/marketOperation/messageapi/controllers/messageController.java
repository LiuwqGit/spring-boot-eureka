package com.yyit.marketOperation.messageapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class messageController {

	@RequestMapping("/test")
	public String test() {
		return "啦啦啦，成功rest api";
	}
}
