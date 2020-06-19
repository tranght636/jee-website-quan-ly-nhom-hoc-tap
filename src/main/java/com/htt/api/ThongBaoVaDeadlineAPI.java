package com.htt.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htt.constant.ActionConstant;
import com.htt.entity.DeadlineEntity;
import com.htt.entity.ThongBaoEntity;
import com.htt.model.DeadlineModel;
import com.htt.model.ThongBaoModel;
import com.htt.service.IDeadlineService;
import com.htt.service.IThongBaoService;
import com.htt.service2.DeadlineService;
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
	@Inject
	DeadlineService deadlineService2;

	private void postCreateThongBao(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ThongBaoEntity thongBaoEntity = ConvertUtil.toModelOfAPI(ThongBaoEntity.class, req);
		if (thongBaoService2.createThongBao(thongBaoEntity) > 0) {
			DispatcherUtil.send(res, true);
		}
	}

	private void postSaveEditThongBao(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ThongBaoEntity thongBaoEntity = ConvertUtil.toModelOfAPI(ThongBaoEntity.class, req);
		Integer editThongBao =thongBaoService2.update(thongBaoEntity);
		DispatcherUtil.send(res, editThongBao);
	}

	private void postDeleteThongBao(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ThongBaoEntity model = ConvertUtil.toModelOfAPI(ThongBaoEntity.class, req);
		Integer delThongBao = thongBaoService2.deleteThongBao(model);
		DispatcherUtil.send(res, delThongBao);
	}

	private void postCreateDeadline(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		DeadlineEntity deadlineModel = ConvertUtil.toModelOfAPI(DeadlineEntity.class, req);
		if (deadlineService2.createDeadline(deadlineModel) != null) {
			DispatcherUtil.send(res, true);
		}
		
	}

	private void postSaveEditDeadline(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		DeadlineEntity model = ConvertUtil.toModelOfAPI(DeadlineEntity.class, req);
		Integer editDeadline = deadlineService2.update(model);
		DispatcherUtil.send(res, editDeadline);
	}

	private void postDeleteDeadline(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		DeadlineEntity model = ConvertUtil.toModelOfAPI(DeadlineEntity.class, req);
		Integer delDeadline = deadlineService2.deleteDeadline(model);
		DispatcherUtil.send(res, delDeadline);
	}

}
