package com.yyit.marketOperation.message.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yyit.marketOperation.message.dao.MessageDAO;
import com.yyit.marketOperation.message.entities.MessageRecordVO;
import com.yyit.marketOperation.message.mongoentities.MessageRecord;

@Service
@Component
public class MessageService {

	@Autowired
	private MessageDAO messagedao;

	public Boolean insert(MessageRecordVO messageRecordVO) {

		MessageRecord messageRecord = new MessageRecord();

		messageRecord.setSenderName(messageRecordVO.getSenderName());
		messageRecord.setMsgContent(messageRecordVO.getMsgContent());
		messageRecord.setMsgType(messageRecordVO.getMsgType());
		messageRecord.setOnthewallStatus(messageRecordVO.getOnthewallStatus());
		messageRecord.setSenderImage(messageRecordVO.getSenderImage());
		messageRecord.setSendTime(new Date());
		messageRecord.setIsDeleted(false);
		messageRecord.setSenderId(messageRecordVO.getSenderId());

		messagedao.insert(messageRecord);
		return true;
	}
}
