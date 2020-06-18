package com.htt.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htt.constant.ActionConstant;
import com.htt.entity.ThongBaoEntity;
import com.htt.model.DeadlineModel;
import com.htt.model.ThongBaoModel;
import com.htt.service.IDeadlineService;
import com.htt.service.IThongBaoService;
import com.htt.service2.ThongBaoService;
import com.htt.utils.ConvertUtil;
import com.htt.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/api/thong-bao-deadline" })
public class ThongBaoVaDeadlineAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.ADD_THONG_BAO)) {
				postCreateThongBao(req, res);
			} else if (action.equals(ActionConstant.SAVE_EDIT_THONG_BAO)) {
				// getThongBaoById(req, res);
				postSaveEditThongBao(req, res);
			} else if (action.equals(ActionConstant.DELETE_THONG_BAO)) {
				postDeleteThongBao(req, res);
			} else if (action.equals(ActionConstant.ADD_DEADLINE)) {
				postCreateDeadline(req, res);
			} else if (action.equals(ActionConstant.SAVE_EDIT_DEADLINE)) {
				postSaveEditDeadline(req, res);
			} else if (action.equals(ActionConstant.DELETE_DEADLINE)) {
				postDeleteDeadline(req, res);
			}
		}

	}

	@Inject
	IThongBaoService thongBaoService;
	@Inject
	ThongBaoService thongBaoService2;
	@Inject
	IDeadlineService deadlineService;

	private void postCreateThongBao(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ThongBaoEntity thongBaoEntity = ConvertUtil.toModelOfAPI(ThongBaoEntity.class, req);
		if (thongBaoService2.createThongBao(thongBaoEntity) > 0) {
			DispatcherUtil.send(res, true);
		}

	}

	private void postSaveEditThongBao(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		/*
		 * ThongBaoModel model = ConvertUtil.toModelOfAPI(ThongBaoModel.class, req);
		 * Integer editThongBao = thongBaoService.update(model);
		 * DispatcherUtil.send(res, editThongBao);
		 */
		ThongBaoEntity thongBaoEntity = ConvertUtil.toModelOfAPI(ThongBaoEntity.class, req);
		Integer editThongBao =thongBaoService2.update(thongBaoEntity);
		DispatcherUtil.send(res, editThongBao);
	}

	private void postDeleteThongBao(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ThongBaoModel model = ConvertUtil.toModelOfAPI(ThongBaoModel.class, req);
		Boolean delThongBao = thongBaoService.deleteThongBao(model.getId());
		DispatcherUtil.send(res, delThongBao);
	}

	private void postCreateDeadline(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		DeadlineModel deadlineModel = ConvertUtil.toModelOfAPI(DeadlineModel.class, req);
		if (deadlineService.createDeadline(deadlineModel) != null) {
			DispatcherUtil.send(res, true);
		}
	}

	private void postSaveEditDeadline(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		DeadlineModel model = ConvertUtil.toModelOfAPI(DeadlineModel.class, req);
		Integer editDeadline = deadlineService.update(model);
		DispatcherUtil.send(res, editDeadline);
	}

	private void postDeleteDeadline(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		DeadlineModel model = ConvertUtil.toModelOfAPI(DeadlineModel.class, req);
		Boolean delDeadline = deadlineService.deleteDeadline(model.getId());
		DispatcherUtil.send(res, delDeadline);
	}

}
