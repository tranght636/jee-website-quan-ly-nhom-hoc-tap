<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!-- Navigation -->

<div style="margin-bottom: 20px;">
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="    background-color: #4e73df; ">

      <div class="container">
        <a class="navbar-brand" href="<c:url value="/trang-chu"/>">Quản Lý Khóa Học Tập</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="<c:url value="/trang-chu"/>">Trang chủ
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link" href="<c:url value="/thong-tin-dang-ky-lich"/>">Thông tin đăng ký lịch
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link" href="<c:url value="/thoi-khoa-bieu"/>">Thời khóa biểu
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link" href="<c:url value="/diemr-danh"/>">Điểm danh
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <c:if test="${not empty USERMODEL}">
              <li class="nav-item">
                <a class="nav-link" href='#'>Wellcome, ${USERMODEL.username}</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<c:url value='/logout?action=logout' />" >Thoát</a>
              </li>
            </c:if>
            <c:if test="${empty USERMODEL}">
              <li class="nav-item">
                <a class="nav-link" href='<c:url value="/login?action=login"/>'>Đăng nhập</a>
              </li>
            </c:if>
          </ul>
        </div>
      </div>
</nav>
</div>