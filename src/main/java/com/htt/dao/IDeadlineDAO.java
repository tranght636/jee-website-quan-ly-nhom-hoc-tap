package com.htt.dao;

import java.util.List;

import com.htt.model.DeadlineModel;

public interface IDeadlineDAO {
	
	List<DeadlineModel> findAll();

}
