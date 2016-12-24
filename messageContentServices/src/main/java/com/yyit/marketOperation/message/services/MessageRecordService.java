package com.yyit.marketOperation.message.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyit.marketOperation.message.dao.MessageRecordDAO;
import com.yyit.marketOperation.message.dao.MessageSettingsDAO;
import com.yyit.marketOperation.message.entities.MessageVO;
import com.yyit.marketOperation.message.mongoentities.MessageRecord;

@Service
public class MessageRecordService {
	@Autowired
	private MessageRecordDAO messageRecordDao;
	@Autowired
	private MessageSettingsDAO messageSettingsDao;

	public Boolean insert(MessageVO messageVO) {

		System.out.println("22 : " + messageVO != null);
		if (messageVO != null) {
			String msgContent = messageVO.getMsgContent();
			// 设置消息是否上墙
			Boolean onthewallStatus = messageSettingsDao.onthewallStatus(msgContent);

			MessageRecord messageRecord = new MessageRecord();

			messageRecord.setSenderName(messageVO.getSenderName());
			messageRecord.setMsgContent(msgContent);
			messageRecord.setMsgType(messageVO.getMsgType());
			messageRecord.setOnthewallStatus(onthewallStatus);
			messageRecord.setSenderImage(messageVO.getSenderImage());
			messageRecord.setSendTime(new Date());
			messageRecord.setIsDeleted(false);
			messageRecord.setSenderId(messageVO.getSenderId());

			messageRecordDao.insert(messageRecord);
		}
		return true;
	}
}
