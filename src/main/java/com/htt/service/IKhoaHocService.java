package com.htt.service;

import java.util.List;

import com.htt.model.KhoaHocModel;

public interface IKhoaHocService {
	List<KhoaHocModel> findAll();
	KhoaHocModel findOne(Integer id);
}
