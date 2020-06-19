package com.htt.service2;

import java.util.List;

import javax.inject.Inject;

import com.htt.dao2.ChapterDao;
import com.htt.entity.ChapterEntity;

public class ChapterService {
	@Inject
	ChapterDao chapterDao;
	
	public List<ChapterEntity> getChapterByCourse(Integer courseId){
		StringBuilder sql = new StringBuilder(" select c.*, ");
		sql.append(" s.name as stage_name ");
		sql.append(" from chapter c, (select id, name, courses_id from stage) s ");
		sql.append(" where 1 = 1 ");
		sql.append(" and c.stage_id = s.id ");
		sql.append(" and s.courses_id = ? ");
		sql.append(" order by c.stage_id ");
		return chapterDao.selecList(sql.toString(), courseId);
	}
}
