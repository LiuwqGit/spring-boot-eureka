package com.yyit.marketOperation.message.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;

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
}
