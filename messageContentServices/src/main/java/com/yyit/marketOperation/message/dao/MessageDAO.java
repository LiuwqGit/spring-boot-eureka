package com.yyit.marketOperation.message.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import com.yyit.marketOperation.message.mongoentities.MessageRecord;

@Component
public class MessageDAO {

	@Autowired
	public MongoTemplate mongoTemplate;
	@Autowired
	public GridFsTemplate gridfsTemplate;

	/**
	 * 保存消息
	 * @param messageRecord
	 */
	public void insert(MessageRecord messageRecord) {
		mongoTemplate.insert(messageRecord);
	}

}
