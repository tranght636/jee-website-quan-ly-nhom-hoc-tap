package com.htt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.htt.model.DeadlineModel;

public class DeadlineMapper implements RowMapper<DeadlineModel>{
	@Override
	public DeadlineModel mapRow(ResultSet resultSet) {
		try {
			DeadlineModel deadline = new DeadlineModel();
			deadline.setId(resultSet.getInt("id"));
			deadline.setTitle(resultSet.getString("title"));
			deadline.setContent(resultSet.getString("content"));
			deadline.setToClass(resultSet.getString("to_classes"));
			deadline.setDueDate(resultSet.getTimestamp("due_date"));
			deadline.setIsRegister(resultSet.getBoolean("is_register"));
			deadline.setYear(resultSet.getInt("year"));
			deadline.setWeek(resultSet.getInt("week"));
			deadline.setStatus(resultSet.getInt("status"));
			deadline.setCreatedDate(resultSet.getTimestamp("created_date"));
			deadline.setModifiedDate(resultSet.getTimestamp("modified_date"));
			deadline.setCreatedBy(resultSet.getInt("created_by"));
			deadline.setModifiedBy(resultSet.getInt("modified_by"));
			return deadline;
		} catch (SQLException e) {
			return null;
		}	
	}

}
