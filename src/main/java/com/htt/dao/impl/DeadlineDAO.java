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

	@Override
	public Integer save(DeadlineModel deadlineModel) {
		String sql = "INSERT INTO `dbjeejspservlet`.`deadline`"
				+ "(`title`, `content`, `to_classes`, `due_date`, `is_register`, `year`, `week`, "
				+ "`status`, `created_date`, `modified_date`, `created_by`, `modified_by`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?);";
		return insert(sql, deadlineModel.getTitle(), deadlineModel.getContent(), deadlineModel.getToClass(),
				deadlineModel.getDueDate(),deadlineModel.getIsRegister(),deadlineModel.getYear(),deadlineModel.getWeek(),
				deadlineModel.getStatus(), deadlineModel.getCreatedDate(), deadlineModel.getModifiedDate(),
				deadlineModel.getCreatedBy(), deadlineModel.getModifiedBy());

	}

	@Override
	public DeadlineModel findOne(Integer id) {
		String sql = "SELECT * FROM dbjeejspservlet.deadline WHERE id = ?";
		
		List<DeadlineModel> deadline = query(sql, new DeadlineMapper(), id);
		return deadline.isEmpty() ? null : deadline.get(0);
	}

}
