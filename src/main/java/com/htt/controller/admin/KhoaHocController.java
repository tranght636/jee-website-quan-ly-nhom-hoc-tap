package com.htt.controller.admin;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htt.constant.ActionConstant;
import com.htt.entity.ChapterEntity;
import com.htt.entity.CourseEntity;
import com.htt.entity.StageEntity;
import com.htt.model.KhoaHocModel;
import com.htt.service.IKhoaHocService;
import com.htt.service2.ChapterService;
import com.htt.service2.CourseService;
import com.htt.service2.StageService;
import com.htt.utils.ConvertUtil;
import com.htt.utils.DispatcherUtil;
import com.htt.utils.StringUtil;

@WebServlet(urlPatterns = {"/admin/khoa-hoc"})
public class KhoaHocController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	IKhoaHocService khoaHocService;
	
	@Inject
	CourseService courseService;
	@Inject
	StageService stageService;
	@Inject
	ChapterService chapterService;
	
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	private void setMessage(HttpServletRequest req) {
		String message = req.getParameter("message");
		if (message != null) {
			String alert = req.getParameter("alert");
			req.setAttribute("message", resourceBundle.getString(message));
			req.setAttribute("alert", alert);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(StringUtil.isNullOrEmpty(action)) {
			getKhoaHoc(req, res);
		} else if(action.equals(ActionConstant.KHOA_HOC.CHI_TIET_KHOA_HOC)) {
			getChiTietKhoaHoc(req,res);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(StringUtil.isNullOrEmpty(action)) {
			return;
		}
		if(action.equals(ActionConstant.KHOA_HOC.CREATE)) {
			postCreateKhoaHoc(req, res);
		} else if(action.equals(ActionConstant.KHOA_HOC.UPDATE)) {
			postUpdateKhoaHoc(req, res);
		}
	}
	
	private void getKhoaHoc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setMessage(req);
		List<KhoaHocModel> dsKhoaHoc = khoaHocService.findAll();
		req.setAttribute("courses", dsKhoaHoc);
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "KhoaHoc");//ThongBaoVaDeadline
	}

	private void getChiTietKhoaHoc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		CourseEntity courseEntity = courseService.selectOne(Integer.parseInt(id));
		req.setAttribute("course", courseEntity);
		List<StageEntity> stageEntities = stageService.getStageByCourseId(courseEntity.getId());
		req.setAttribute("stages", stageEntities);
		if(stageEntities.size() > 0) {
			List<ChapterEntity> chapterEntities = chapterService.getChapterByCourse(courseEntity.getId());
			req.setAttribute("chapters", chapterEntities);
		}
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ChiTietKhoaHoc");
	}

	

	private void postUpdateKhoaHoc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CourseEntity courseEntity = ConvertUtil.toModelOfController(CourseEntity.class, req);
		Integer result = courseService.updateOne(courseEntity);
		if(result > -1) {
			DispatcherUtil.redirect(req, res, "/admin/khoa-hoc?message=update_thanh_cong&alert=success");
		} else {
			DispatcherUtil.redirect(req, res, "/admin/khoa-hoc?message=update_that_bai&alert=error");
		}
	}

	private void postCreateKhoaHoc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CourseEntity courseEntity = ConvertUtil.toModelOfController(CourseEntity.class, req);
		Integer result = courseService.insertOne(courseEntity);
		if(result > -1) {
			DispatcherUtil.redirect(req, res, "/admin/khoa-hoc");
		} else {
			DispatcherUtil.redirect(req, res, "/admin/khoa-hoc?message=insert_fail&alert=error");
		}
	}

}
