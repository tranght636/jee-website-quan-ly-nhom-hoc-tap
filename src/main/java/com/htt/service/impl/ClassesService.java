package com.htt.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.htt.dao.IClassesDAO;
import com.htt.model.ClassesModel;
import com.htt.service.IClassesService;

public class ClassesService implements IClassesService{
	@Inject
	IClassesDAO classesService;
	@Override
	public List<ClassesModel> findAll() {
		return classesService.findAll();
	}

}
