package com.yyit.marketOperation.messageapi.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息设置
 * 
 * @author wbliuwq
 * @date 2016年12月26日
 */
@RestController
@RequestMapping(value = "api/messageset")
public class MessageSettingsController {

	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public String set() {
		return "set page" + new Date();
	}
	
	
}
