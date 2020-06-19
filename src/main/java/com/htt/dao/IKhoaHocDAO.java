package com.htt.dao;
import java.util.List;

import com.htt.model.KhoaHocModel;

public interface IKhoaHocDAO {
	List<KhoaHocModel> findAll();
	KhoaHocModel findOne(Integer id);
}
