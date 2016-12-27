package com.yyit.marketOperation.messageapi.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yyit.marketOperation.message.entities.FilterSetVO;
import com.yyit.marketOperation.message.responseenitities.ResponseEntity;
import com.yyit.marketOperation.message.services.MessageSettingsService;

/**
 * 消息内容设置
 * 
 * @author wbliuwq
 * @date 2016年12月26日
 */
@RestController
@RequestMapping(value = "api/messageset")
public class MessageSettingsController {

	@Autowired
	private MessageSettingsService messageSettingsService;
	
	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public String set() {
		return "set page" + new Date();
	}
	
	@RequestMapping(value = "/filterset", method = RequestMethod.POST)	
	public Object filterSet(@RequestBody FilterSetVO set){
		ResponseEntity res = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();

		Boolean bl = messageSettingsService.setFilter(set); 
		if (bl) {
			res.setErrcode(0);
			res.setErrmsg("保存成功！");
		} else {
			res.setErrcode(8311);
			res.setErrmsg("保存失败！");
		}
		res.setData(data);
		return res;
	}
	
}
