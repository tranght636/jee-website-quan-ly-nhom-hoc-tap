package com.htt.service2;

import javax.inject.Inject;

import com.htt.dao2.UserDoHomeworkDao;
import com.htt.entity.UserDoHomeworkEntity;
import com.htt.utils.SessionUtil;

public class UserDoHomeworkService {
	@Inject
	UserDoHomeworkDao userDoHomeworkDao;

	public int saveThongTinDangKyLich(UserDoHomeworkEntity userDoHomeworkEntity) {
		Integer userId = SessionUtil.getUserId();
		userDoHomeworkEntity.setUserId(userId);
		userDoHomeworkEntity.setStatus(1);
		return userDoHomeworkDao.insertOne(userDoHomeworkEntity);
	}
}
