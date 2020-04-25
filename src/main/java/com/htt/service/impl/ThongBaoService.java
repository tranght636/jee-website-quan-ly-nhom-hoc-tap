package com.htt.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.htt.constant.SystemConstant;
import com.htt.dao.IThongBaoDAO;
import com.htt.dao.impl.ThongBaoDAO;
import com.htt.model.ThongBaoModel;
import com.htt.service.IThongBaoService;

public class ThongBaoService implements IThongBaoService{
	@Inject
	IThongBaoDAO thongBaoDAO;
	public ThongBaoService() {
		thongBaoDAO = new ThongBaoDAO();
	}
	public List<ThongBaoModel> findAll() {
		return thongBaoDAO.findAll();
	}
	@Override
	public Integer createThongBao(ThongBaoModel thongBaoModel) {
		return thongBaoDAO.save(thongBaoModel);
	}

}
