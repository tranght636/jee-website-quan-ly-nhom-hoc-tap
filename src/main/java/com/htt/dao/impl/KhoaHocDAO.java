package com.htt.dao.impl;
import java.util.List;

import com.htt.dao.IKhoaHocDAO;
import com.htt.mapper.KhoaHocMapper;
import com.htt.model.KhoaHocModel;

public class KhoaHocDAO extends AbstractDAO<KhoaHocModel> implements IKhoaHocDAO {
	
	@Override
	public List<KhoaHocModel> findAll() {
		String sql = "select * from courses where status = 1";
		List<KhoaHocModel> dsKhoaHoc = query(sql, new KhoaHocMapper());
		return dsKhoaHoc;
	}

	@Override
	public KhoaHocModel findOne(Integer id) {
		return findOne("courses", new KhoaHocMapper(), id);
	}

}
