package com.htt.service2;

import java.util.List;

import javax.inject.Inject;

import com.htt.dao2.StageDao;
import com.htt.entity.StageEntity;

public class StageService {
	@Inject
	StageDao stageDao;
	
	public Integer insertOne(StageEntity stageEntity) {
		stageEntity.setStatus(1);
		return stageDao.insertOne(stageEntity);
	}
	
	public List<StageEntity> getStageByCourseId(Integer id) {
		return stageDao.getStageByCourseId(id);
	}
}
