package com.htt.service2;

import javax.inject.Inject;

import com.htt.dao2.ThongTinDangKyLichDAO;
import com.htt.entity.ThongTinDangKyLichEntity;
import com.htt.utils.SessionUtil;

public class ThongTinDangKyLichService {
	@Inject
	ThongTinDangKyLichDAO thongTinDangKyLichDAO;

	public Object findAll() {
		return thongTinDangKyLichDAO.selectAllAddName(1);
	}

	public Object findByWeekInYear(String weekInYear) {
		return thongTinDangKyLichDAO.selectAllAddName(1, weekInYear);
	}

	public int saveThongTinDangKyLich(ThongTinDangKyLichEntity thongTinDangKyLichEntity) {
		
		Integer userId = SessionUtil.getUserId();
		thongTinDangKyLichEntity.setUserId(userId);
		thongTinDangKyLichEntity.setStatus(1);
		return thongTinDangKyLichDAO.insertOne(thongTinDangKyLichEntity);
	}

	public Object findByIdUser() {
		Integer userId = SessionUtil.getUserId();
		return thongTinDangKyLichDAO.findByIdUser(1, userId);
	}

}
