package com.htt.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htt.service2.ThongTinDangKyLichService;

@WebServlet(urlPatterns = { "/api/thong-tin-dang-ky-lich" })
public class ThongTinDangKyLichAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	ThongTinDangKyLichService thongTinDangKyLichService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//	getThongTinDangKyLich(req, res);
	}
	
	private void getThongTinDangKyLich(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

}
