package com.htt.service2;

import javax.inject.Inject;

import com.htt.dao2.ThongTinDangKyLichDAO;

public class ThongTinDangKyLichService {
	@Inject
	ThongTinDangKyLichDAO thongTinDangKyLichDAO;

	public Object findAll() {
		return thongTinDangKyLichDAO.selectAllAddName(1);
	}

	public Object findByWeekInYear(String weekInYear) {
		return thongTinDangKyLichDAO.selectAllAddName(1, weekInYear);
	}

}
