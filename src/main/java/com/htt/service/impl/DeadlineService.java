package com.htt.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.htt.dao.IDeadlineDAO;
import com.htt.dao.impl.DeadlineDAO;
import com.htt.model.DeadlineModel;
import com.htt.service.IDeadlineService;

public class DeadlineService implements IDeadlineService{
	@Inject
	IDeadlineDAO deadlineDAO;
	public DeadlineService() {
		deadlineDAO =new DeadlineDAO();
	}
	public List<DeadlineModel> findAll() {
		return deadlineDAO.findAll();
	}

}
