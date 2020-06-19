package com.htt.service2;

import java.util.List;

import javax.inject.Inject;

import com.htt.dao2.LessonDao;
import com.htt.entity.LessonEntity;

public class LessonService {
	@Inject
	LessonDao lessonDao;

	public List<LessonEntity> getLessonByCourse(Integer id) {
		return lessonDao.getLessonByCourse(id);
	}

	public Integer insertOne(LessonEntity lessonEntity) {
		lessonEntity.setStatus(1);
		return lessonDao.insertOne(lessonEntity);
	}

	public Object selectOne(int id) {
		return lessonDao.selectOne(id);
	}

	public Integer updateOne(LessonEntity lessonEntity) {
		return lessonDao.updateOne(lessonEntity);
	}

	public Object deleteOne(LessonEntity lessonEntity) {
		lessonEntity.setStatus(-1);
		return lessonDao.updateOne(lessonEntity);
	}
}
