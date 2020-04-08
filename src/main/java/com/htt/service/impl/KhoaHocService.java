package com.htt.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.htt.dao.IKhoaHocDAO;
import com.htt.model.KhoaHocModel;
import com.htt.service.IKhoaHocService;

public class KhoaHocService implements IKhoaHocService {

	@Inject IKhoaHocDAO khoaHoc;
	
	@Override
	public List<KhoaHocModel> findAll() {
		return khoaHoc.findAll();
	}

}
