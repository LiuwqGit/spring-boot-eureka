package com.yyit.marketOperation.message.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.yyit.marketOperation.message.entities.FilterSetVO;
import com.yyit.marketOperation.message.mongoentities.MessageSettings;

/**
 * 消息设置
 * 
 * @author wbliuwq
 * @date 2016年12月24日
 */
@Repository
public class MessageSettingsDAO {
	@Autowired
	public MongoTemplate mongoTemplate;
	@Autowired
	public GridFsTemplate gridfsTemplate;

	/**
	 * 设置消息是否上墙
	 * 
	 * @return
	 */
	public Boolean onthewallStatus(String content) {

		Boolean status = false;// 设置消息是否上墙
		/*
		 * 1:基本设置，是否开启上墙审核 2:内容设置，是否开启评论审批 3:过滤词是否启用， 4:是否属于过滤词。
		 */
		System.out.println("Before: " + content + "...");
		String before = content;
		System.out.println("Before is Equal: " + before.equals(content));
		if (!content.trim().toString().isEmpty()) {
			System.out.println("After:" + content + "...");
			String after = content.trim();
			System.out.println("After is Equal:" + after.equals(content));

			// 1: 1:基本设置，是否开启上墙审核,这个需要获取其他服务的接口
			// Boolean basicSet = false;//开启上墙审核true.关闭上墙审核false,是否开启，对结果没影响
			Boolean commentSet = true;
			Boolean filterOn = false;
			Boolean isfilterFiled = false;

			if (!commentSet) {
				// 未开启评论审批
				if (!filterOn) {
					// 未启用过滤词
					status = true;
				} else {
					if (!isfilterFiled) {
						// 不属于过滤词
						status = true;
					}
				}
			}
		}
		return status;
	}

	/**
	 * 设置是否开启评论审批
	 * 
	 * @param meetingId
	 * @param value
	 * @return
	 */
	public Boolean commentSet(String meetingId, Boolean value) {
		Query query = new Query(Criteria.where("meetingId").is(meetingId));
		Update update = new Update();
		update.set("approveOn", value);
		WriteResult wr = mongoTemplate.updateFirst(query, update, MessageSettings.class);
		if (wr.getN() > 0) {
			return true;
		}
		return false;

	}

	/**
	 * 设置过滤词
	 * 
	 * @param set
	 * @return
	 */
	public Boolean setFilter(FilterSetVO set) {
		String meetingId = set.getMeetingId();
		Boolean filterOn = set.getFilterOn();
		List<String> value = set.getFilterField();
		Query query = new Query(Criteria.where("meetingId").is(meetingId));
		Update update = new Update();
		update.set("filterOn", filterOn);
		update.addToSet("filterfield", value);
		WriteResult wr = mongoTemplate.updateFirst(query, update, MessageSettings.class);
		if (wr.getN() > 0) {
			return true;
		}
		return false;
	}
}
