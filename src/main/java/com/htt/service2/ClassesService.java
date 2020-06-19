package com.htt.service2;

import javax.inject.Inject;

import com.htt.dao2.ClassesDAO;

public class ClassesService {
	@Inject
	ClassesDAO classesDAO;

	public Object findAll() {
		return classesDAO.selectAll(1);
	}

}
