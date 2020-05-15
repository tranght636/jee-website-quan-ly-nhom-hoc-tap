package com.htt.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htt.constant.ActionConstant;
import com.htt.model.DeadlineModel;
import com.htt.model.ThongBaoModel;
import com.htt.service.IDeadlineService;
import com.htt.service.IThongBaoService;
import com.htt.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/admin/thong-bao-deadline" })
public class ThongBaoVaDeadlineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IThongBaoService thongBaoService;
	@Inject
	IDeadlineService deadlineService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// DispatcherUtil.returnViewNameAdminAndSetPageName(req,
		// res,"ThongBaoVaDeadline");
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.THONG_BAO_VA_DEADLINE)) {
				getThongBaovaDeadline(req, res);
				// DispatcherUtil.returnViewNameAdminAndSetPageName(req,
				// res,"ThongBaoVaDeadline");
			} else if (action.equals(ActionConstant.ADD_THONG_BAO)) {
				DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "AddThongBao");
			} else if (action.equals(ActionConstant.EDIT_THONG_BAO)) {
				String strID = req.getParameter("id");
				if (strID != null) {
					Integer id = Integer.parseInt(strID);
					ThongBaoModel thongBao = thongBaoService.findOne(id);
					req.setAttribute("thongBao", thongBao);
				}
				DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "EditThongBao");
			} else if (action.equals(ActionConstant.VIEW_THONG_BAO)) {
				String strID = req.getParameter("id");
				if (strID != null) {
					Integer id = Integer.parseInt(strID);
					ThongBaoModel thongBao = thongBaoService.findOne(id);
					req.setAttribute("thongBao", thongBao);
				}
				DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ViewThongBao");
			} else if (action.equals(ActionConstant.ADD_DEADLINE)) {
				DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "AddDeadline");
			}else if (action.equals(ActionConstant.EDIT_DEADLINE)) {
				String strID = req.getParameter("id");
				if (strID != null) {
					Integer id = Integer.parseInt(strID);
					DeadlineModel deadline = deadlineService.findOne(id);
					req.setAttribute("deadline", deadline);
				}
				DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "EditDeadline");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		/*
		 * String action = req.getParameter("action"); if (action != null) { if
		 * (action.equals(ActionConstant.CREATE_THONG_BAO)) { createThongBao(req, res);
		 * } }
		 */

	}

	private void getThongBaovaDeadline(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		List<ThongBaoModel> dsThongBao = thongBaoService.findAll();
		if (dsThongBao != null) {
			req.setAttribute("dsThongBao", dsThongBao);
		}
		List<DeadlineModel> dsDeadline = deadlineService.findAll();
		if (dsDeadline != null) {
			req.setAttribute("dsDeadline", dsDeadline);
		}
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongBaoVaDeadline");
	}
	/*
	 * private void createThongBao(HttpServletRequest req, HttpServletResponse res)
	 * throws ServletException, IOException{ ThongBaoModel thongBaoModel =
	 * ConvertUtil.toModelOfController(ThongBaoModel.class, req); int
	 * i=thongBaoService.createThongBao(thongBaoModel); if(
	 * thongBaoService.createThongBao(thongBaoModel) != 0) {
	 * DispatcherUtil.redirect(req, res,
	 * "/admin/thong-bao-deadline?action=thong_bao_va_deadline");
	 * //System.out.println(thongBaoService.createThongBao(thongBaoModel)); } }
	 */

}
