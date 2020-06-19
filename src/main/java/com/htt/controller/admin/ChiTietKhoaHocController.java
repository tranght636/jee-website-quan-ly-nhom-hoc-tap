package com.htt.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htt.constant.ActionConstant;
import com.htt.entity.StageEntity;
import com.htt.service2.StageService;
import com.htt.utils.ConvertUtil;
import com.htt.utils.DispatcherUtil;
import com.htt.utils.StringUtil;

@WebServlet(urlPatterns = {"/admin/chi-tiet-khoa-hoc"})
public class ChiTietKhoaHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	StageService stageService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null) {
			if(action.equals(ActionConstant.CHI_TIET_KHOA_HOC.GET_STAGE_BY_COURSE)) {
				getStageByCourse(req, res);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null) {
			if(action.equals(ActionConstant.CHI_TIET_KHOA_HOC.CREATE_GIAI_DOAN)) {
				createGiaiDoan(req, res);
			}
		}
	}
	
	private void getStageByCourse(HttpServletRequest req, HttpServletResponse res) throws NumberFormatException, ServletException, IOException {
		String courseId = req.getParameter("courseId");
		if(!StringUtil.isNullOrEmpty(courseId)) {
			DispatcherUtil.send(res, stageService.getStageByCourseId(Integer.parseInt(courseId)));
		}
	}

	private void createGiaiDoan(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StageEntity stageEntity = ConvertUtil.toModelOfController(StageEntity.class, req);
		Integer result = stageService.insertOne(stageEntity);
		if(result > 0) {
			DispatcherUtil.redirect(req, res, "/admin/khoa-hoc?action=chi_tiet_khoa_hoc&id="+stageEntity.getCoursesId());
		}
	}
}
