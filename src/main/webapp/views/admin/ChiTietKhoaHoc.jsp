<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
        </head>

        <body>

            <div class="input-group md-form form-sm form-2 pl-0 ">
                <h3>Khoá học: ${course.getName()}</h3>
                <button type="button" class="btn btn-outline-danger ml-4 mb-2" data-toggle="modal" data-target="#add-giai-doan">Thêm giai đoạn</button>
                <button type="button" class="btn btn-outline-primary ml-2 mb-2" data-toggle="modal" data-target="#AddUserModalCenter">Thêm bài học</button>
                <button type="button" class="btn btn-outline-success ml-2 mb-2" data-toggle="modal" data-target="#AddUserModalCenter">Thêm buổi học</button>
                <button onclick="goBack()" class="btn btn-primary mb-2" type="button" style="position: absolute; right: 0;">Thoát</button>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <!-- tblStage -->

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Giai đoạn</h6>
                            </div>
                            <div class="card-body">
                                <div>
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Tên</th>
                                                <th>Mô tả</th>
                                                <th>Ghi chú</th>
                                                <th>Thao tác</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="stage" items="${stages}">
                                                <tr>
                                                    <td>${stage.name}</td>
                                                    <td>${stage.description}</td>
                                                    <td>${stage.note}</td>
                                                    <td>
	                                                    <i class="fa fa-pencil" aria-hidden="true" style="margin-right: 2px;"></i>
	                                                    <i class="fa fa-trash" aria-hidden="true"></i>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-12">
                                <!-- tblChapter -->

                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Bài học</h6>
                                    </div>
                                    <div class="card-body">
                                        <div>
                                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>Tên giai đoạn</th>
                                                        <th>Tên bài học</th>
                                                        <th>Thao tác</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="chapter" items="${chapters}">
                                                        <tr>
                                                            <td>${chapter.stageName}</td>
                                                            <td>${chapter.name}</td>
                                                            <td>
	                                                            <i class="fa fa-pencil" aria-hidden="true" style="margin-right: 2px;"></i>
	                                                            <i class="fa fa-trash" aria-hidden="true"></i>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="col-sm-12">
                                <!-- tblLesson -->

                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- start Modal edit user -->
            <div class="modal fade" id="add-giai-doan" tabindex="-1" role="dialog" aria-labelledby="EditUserModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Giai đoạn</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
                        </div>

                        <form id="course-modal" action="/admin/chi-tiet-khoa-hoc?action=create_giai_doan" method="post">
                            <input id="stage-id" name="id" hidden="true" />
                            <input id="course-id" name="coursesId" hidden="true" value="${course.getId()}">
                            <div class="modal-body div-dangki">
                                <div class="form-group row">
                                    <label for="courses-name" class="col-sm-3 col-form-label">Giai đoạn:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="stage-name" name="name">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="courses-start-time" class="col-sm-3 col-form-label">Mô tả:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="description" name="description">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="courses-end-time" class="col-sm-3 col-form-label">Ghi chú:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="note" name="note">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                <button id="btn-create-stage" type="submit" class="btn btn-primary">Lưu</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- end Modal edit user -->

            <script src="<c:url value='/js/admin/ChiTietKhoaHoc.js' />"></script>
        </body>

        </html>