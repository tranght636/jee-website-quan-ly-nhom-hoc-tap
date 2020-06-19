package com.htt.service2;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.htt.dao2.ThongBaoDAO;
import com.htt.entity.ThongBaoEntity;

public class ThongBaoService {
	@Inject
	ThongBaoDAO thongBaoDAO;

	public List<ThongBaoEntity> findAll(Integer status) {
		return thongBaoDAO.selectAll(status);
	}
	public Integer createThongBao(ThongBaoEntity thongBao) {
		thongBao.setStatus(1);
		return thongBaoDAO.insertOne(thongBao);
	}
	
	public ThongBaoEntity findOne(Integer id) {
		return thongBaoDAO.selectOne(id);
	}

	public Integer update(ThongBaoEntity thongBao) {
		Date now = new Date();
		Timestamp timestamp = new Timestamp(now.getTime());
		thongBao.setModifiedDate(timestamp);
		return thongBaoDAO.updateOne(thongBao);
	}

	public Integer deleteThongBao(ThongBaoEntity thongBao) {
		return thongBaoDAO.deleteOne(thongBao);
	}

	//
	public List<ThongBaoEntity> findByClass(String userName, String password) {
		return thongBaoDAO.selecList(userName, password);
	}



	
}
