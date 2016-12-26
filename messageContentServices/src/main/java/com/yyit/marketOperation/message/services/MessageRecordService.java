package com.yyit.marketOperation.message.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyit.marketOperation.message.dao.MessageRecordDAO;
import com.yyit.marketOperation.message.dao.MessageSettingsDAO;
import com.yyit.marketOperation.message.entities.FilterVO;
import com.yyit.marketOperation.message.entities.MessageRecordVO;
import com.yyit.marketOperation.message.entities.MessageVO;
import com.yyit.marketOperation.message.entities.ReqConditionVO;
import com.yyit.marketOperation.message.entities.SetMsgStatusVO;
import com.yyit.marketOperation.message.mongoentities.MessageRecord;

@Service
public class MessageRecordService {
	@Autowired
	private MessageRecordDAO messageRecordDao;
	@Autowired
	private MessageSettingsDAO messageSettingsDao;

	/**
	 * 发送消息
	 * 
	 * @param messageVO
	 * @return
	 */
	public Boolean insert(MessageVO messageVO) {

		System.out.println("22 : " + messageVO != null);
		if (messageVO != null) {
			String msgContent = messageVO.getMsgContent();
			// 设置消息是否上墙
			Boolean onthewallStatus = messageSettingsDao.onthewallStatus(msgContent);

			MessageRecord messageRecord = new MessageRecord();

			messageRecord.setMeetingId(messageVO.getMeetingId());
			messageRecord.setSenderName(messageVO.getSenderName());
			messageRecord.setMsgContent(msgContent);
			messageRecord.setMsgType(messageVO.getMsgType());
			messageRecord.setOnthewallStatus(onthewallStatus);
			messageRecord.setSenderImage(messageVO.getSenderImage());
			messageRecord.setSendTime(new Date());
			messageRecord.setIsDeleted(false);
			messageRecord.setSenderId(messageVO.getSenderId());

			messageRecordDao.insert(messageRecord);
		} else {
			return false;
		}
		return true;
	}

	/**
	 * 请求历史消息
	 * 
	 * @param req
	 * @return
	 */
	public List<MessageRecordVO> receiveMessage(ReqConditionVO req) {
		List<MessageRecordVO> list = new ArrayList<>();
		list = messageRecordDao.receiveMessage(req);
		return list;
	}

	/**
	 * 获取消息列表
	 * 
	 * @param filterVO
	 * @return
	 */
	public List<MessageRecordVO> getMessageList(FilterVO filterVO) {
		List<MessageRecordVO> list = new ArrayList<>();
		list = messageRecordDao.getMessageList(filterVO);
		return list;
	}

	/**
	 * 设置是否上墙
	 * 
	 * @param setOnthewall
	 * @return
	 */
	public Boolean setOnthewall(SetMsgStatusVO setOnthewall) {
		Boolean bl = messageRecordDao.setOnthewall(setOnthewall);
		return bl;
	}

	/**
	 * 消息删除
	 * 
	 * @param setdelete
	 * @return
	 */
	public Boolean setdelte(SetMsgStatusVO setdelete) {
		Boolean bl = messageRecordDao.deleteMsg(setdelete);
		return bl;
	}
}
