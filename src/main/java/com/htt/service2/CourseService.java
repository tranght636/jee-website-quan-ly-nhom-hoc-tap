package com.htt.service2;

import javax.inject.Inject;

import com.htt.dao2.CourseDao;
import com.htt.entity.CourseEntity;

public class CourseService {
	
	@Inject
	CourseDao courseDao;
	
	public Integer insertOne(CourseEntity courseEntity) {
		courseEntity.setStatus(1);
		return courseDao.insertOne(courseEntity);
	}

	public Integer updateOne(CourseEntity courseEntity) {
		return courseDao.updateOne(courseEntity);
	}

	public Integer deleteByStatus(Integer id) {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setId(id);
		courseEntity.setStatus(-1);
		return courseDao.updateOne(courseEntity);
	}

	public CourseEntity selectOne(Integer id) {
		return courseDao.selectOne(id);
	}
	
}
