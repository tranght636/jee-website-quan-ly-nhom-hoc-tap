package com.htt.dao2;

import java.util.List;

import com.htt.entity.StageEntity;

public class StageDao extends CommonDao<StageEntity> {

	public List<StageEntity> getStageByCourseId(Integer id) {
		String sql = "select * from stage where courses_id = ?";
		return selecList(sql, id);
	}

}
