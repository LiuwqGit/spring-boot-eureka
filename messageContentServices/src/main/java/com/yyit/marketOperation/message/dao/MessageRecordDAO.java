package com.yyit.marketOperation.message.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.yyit.marketOperation.message.entities.FilterSeachVO;
import com.yyit.marketOperation.message.entities.MessageRecordVO;
import com.yyit.marketOperation.message.entities.ReqConditionVO;
import com.yyit.marketOperation.message.entities.SetMsgStatusVO;
import com.yyit.marketOperation.message.mongoentities.MessageRecord;

/**
 * 消息记录
 * 
 * @author wbliuwq
 * @date 2016年12月24日
 */
@Repository
public class MessageRecordDAO {
	@Autowired
	public MongoTemplate mongoTemplate;
	@Autowired
	public GridFsTemplate gridfsTemplate;

	/**
	 * 保存消息
	 * 
	 * @param messageRecord
	 */
	public void insert(MessageRecord messageRecord) {
		mongoTemplate.insert(messageRecord);
	}

	/**
	 * 请求的历史消息
	 * 
	 * @param req
	 * @return
	 */
	public List<MessageRecordVO> receiveMessage(ReqConditionVO req) {
		List<MessageRecordVO> list = new ArrayList<MessageRecordVO>();

		Query query = new Query(
				Criteria.where("MeetingId").is(req.getMeetingId()).and("senderId").is(req.getReqPsnId()));
		int page = req.getPageIndex() - 1;
		if (page < 0) {
			page = 0;
		}

		Pageable pageable = new PageRequest(page, req.getPageSize());
		query.with(pageable);
		list = mongoTemplate.find(query, MessageRecordVO.class, "MessageRecord");
		return list;
	}

	/**
	 * 获取消息内容列表
	 * 
	 * @param filterVO
	 * @return
	 */
	public List<MessageRecordVO> getMessageList(FilterSeachVO filterVO) {
		List<MessageRecordVO> list = new ArrayList<MessageRecordVO>();

		Query query = new Query(Criteria.where("MeetingId").is(filterVO.getMeetingId()));
		if (!filterVO.getMsgType().isEmpty()) {
			query.addCriteria(Criteria.where("msgType").is(filterVO.getMsgType()));
		}
		if (!filterVO.getSenderName().isEmpty()) {
			query.addCriteria(Criteria.where("senderName").is(filterVO.getSenderName()));
		}
		int page = filterVO.getPageIndex() - 1;
		if (page < 0) {
			page = 0;
		}

		Pageable pageable = new PageRequest(page, filterVO.getPageSize());
		query.with(pageable);
		list = mongoTemplate.find(query, MessageRecordVO.class, "MessageRecord");
		return list;
	}

	/**
	 * 
	 * 设置是否上墙
	 * 
	 * @param setOnthewall
	 * @return
	 */
	public Boolean setOnthewall(SetMsgStatusVO setOnthewall) {
		Query query = new Query(Criteria.where("meetingId").is(setOnthewall.getMeetingId()));
		if (!setOnthewall.getMsgIds().isEmpty()) {
			query.addCriteria(Criteria.where("id").in(setOnthewall.getMsgIds()));
		}
		Update update = new Update();
		update.set("onthewallStatus", setOnthewall.getStatus());
		WriteResult wr = mongoTemplate.updateMulti(query, update, MessageRecord.class);
		if (wr.getN() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 删除消息
	 * 
	 * @param setdelete
	 * @return
	 */
	public Boolean deleteMsg(SetMsgStatusVO setdelete) {
		Query query = new Query(Criteria.where("meetingId").is(setdelete.getMeetingId()));
		if (!setdelete.getMsgIds().isEmpty()) {
			query.addCriteria(Criteria.where("id").in(setdelete.getMsgIds()));
		}
		Update update = new Update();
		update.set("isDeleted", setdelete.getStatus());
		WriteResult wr = mongoTemplate.updateMulti(query, update, MessageRecord.class);
		if (wr.getN() > 0) {
			return true;
		}
		return false;
	}
}
