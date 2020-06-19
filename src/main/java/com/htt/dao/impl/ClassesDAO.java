package com.htt.dao.impl;

import java.util.List;

import com.htt.dao.IClassesDAO;
import com.htt.mapper.ClassesMapper;
import com.htt.model.ClassesModel;

public class ClassesDAO extends AbstractDAO<ClassesModel>  implements IClassesDAO{

	@Override
	public List<ClassesModel> findAll() {
		String sql = "select * from classes";
		return query(sql, new ClassesMapper());
	}

}
