package com.yyit.marketOperation.message.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyit.marketOperation.message.dao.MessageSettingsDAO;
import com.yyit.marketOperation.message.entities.FilterSetVO;

/**
 * 消息设置业务逻辑
 * 
 * @author wbliuwq
 * @date 2016年12月27日
 */
@Service
public class MessageSettingsService {

	@Autowired
	private MessageSettingsDAO messageSettingsDao;
	/**
	 * 设置过滤词
	 * 
	 * @param set
	 * @return
	 */
	public Boolean setFilter(FilterSetVO set) {
		Boolean bl = messageSettingsDao.setFilter(set);
		return bl;
	}

}
