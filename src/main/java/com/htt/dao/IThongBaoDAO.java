package com.htt.dao;

import java.util.List;

import com.htt.model.ThongBaoModel;

public interface IThongBaoDAO {
	List<ThongBaoModel> findAll();
	Integer save(ThongBaoModel thongBaoModel);

}
