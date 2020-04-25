package com.htt.dao.impl;

import java.util.List;

import com.htt.dao.IDeadlineDAO;
import com.htt.mapper.DeadlineMapper;
import com.htt.model.DeadlineModel;

public class DeadlineDAO extends AbstractDAO<DeadlineModel> implements IDeadlineDAO {

	@Override
	public List<DeadlineModel> findAll() {
		String sql = "select * from deadline where status = 1";
		return query(sql, new DeadlineMapper());
	}

}
