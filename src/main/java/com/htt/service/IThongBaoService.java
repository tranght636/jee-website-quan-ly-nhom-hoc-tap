package com.htt.service;

import java.util.List;

import com.htt.model.ThongBaoModel;

public interface IThongBaoService {

	List<ThongBaoModel> findAll();
	Integer createThongBao(ThongBaoModel thongBaoModel);
	ThongBaoModel findOne(Integer id);
	Integer update(ThongBaoModel model);
	Boolean deleteThongBao(Integer id);

}
