package com.htt.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htt.model.KhoaHocModel;
import com.htt.service.IKhoaHocService;
import com.htt.utils.DispatcherUtil;

@WebServlet(urlPatterns = {"/admin/khoa-hoc"})
public class KhoaHocController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	IKhoaHocService khoaHocService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<KhoaHocModel> dsKhoaHoc = khoaHocService.findAll();
		req.setAttribute("courses", dsKhoaHoc);
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "khoaHoc");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		super.doPost(req, res);
	}
}
