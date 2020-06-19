package com.htt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.htt.model.ClassesModel;

public class ClassesMapper implements RowMapper<ClassesModel>{

	@Override
	public ClassesModel mapRow(ResultSet resultSet) {
		try {
			ClassesModel classes = new ClassesModel();
			classes.setId(resultSet.getInt("id"));
			classes.setName(resultSet.getString("name"));
			classes.setCourseId(resultSet.getInt("course_id"));
			classes.setIsDone(resultSet.getBoolean("is_done"));
			classes.setStatus(resultSet.getInt("status"));
			classes.setStatus(resultSet.getInt("status"));
			classes.setCreatedDate(resultSet.getTimestamp("created_date"));
			classes.setModifiedDate(resultSet.getTimestamp("modified_date"));
			classes.setCreatedBy(resultSet.getInt("created_by"));
			classes.setModifiedBy(resultSet.getInt("modified_by"));
			return classes;
		} catch (SQLException e) {
			return null;
		}	
	}

}
