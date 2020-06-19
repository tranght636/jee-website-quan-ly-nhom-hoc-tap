<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>

</head>
<body>
	<!-- start add user -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-6">
				<div class="input-group md-form form-sm form-2 pl-0 "
					style="margin-bottom: 5px;">
					<div class="input-group-prepend">
						<span id="preWeek"
							class="btn input-group-text red lighten-3 backward span-ward"></span>
					</div>
					
					<input id="idInputWeek" type="week" name="idInputWeek"
						style="width: 200px; height: 30px; border: 1px solid #999;" <c:if test = "${not empty weekInYear}"> value="${weekInYear}" </c:if> />
					<div class="input-group-append ">
						<span id="nextWeek"
							class="btn input-group-text red lighten-3 forward span-ward"
							style="border-top-right-radius: 4px; border-bottom-right-radius: 4px;"></span>
					</div>
				</div>
			</div>
			<%-- <div class="col-sm-6">
				<div class="div-select-filter">
					Lọc: <select name="ClassesNameThongBao" id="ClassesNameThongBao"
						class="select-filter" style="margin-bottom: 0px; float: right;">
						<!--  position: absolute; float: 0 -->
						<option value="Tất cả">Tất cả</option>
						<c:forEach var="classes" items="${dsClasses}">
							<c:choose>
								<c:when test="${clazz == classes.name }">
									<option value="${classes.name }" selected>${classes.name }</option>
								</c:when>
								<c:otherwise>
									<option value="${classes.name }">${classes.name }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <select name="loaiThongBao" class="slbtnSort">
						<option value="TatCa">Tất cả</option>
						<option value="ChuaDangKy">Chưa đăng ký</option>
						<option value="S2">Sáng thứ 2</option>
						<option value="C2">Chiều thứ 2</option>
						<option value="S3">Sáng thứ 3</option>
						<option value="C3">Chiều thứ 3</option>
						<option value="S4">Sáng thứ 4</option>
						<option value="C4">Chiều thứ 4</option>
						<option value="S5">Sáng thứ 5</option>
						<option value="C5">Chiều thứ 5</option>
						<option value="S6">Sáng thứ 6</option>
						<option value="C6">Chiều thứ 6</option>
						<option value="S7">Sáng thứ 7</option>
						<option value="C7">Chiều thứ 7</option>
						<option value="S8">Sáng chủ nhật</option>
						<option value="C8">Chiều chủ nhật</option>
					</select>
				</div>
			</div> --%>

		</div>
		<table id="dtVerticalScrollExample"
			class="table table-striped table-bordered table-sm cellspacing=0 width=100%" 
			style="text-align: center; color: black; overflow-x: scroll;">
			<thead>
				<tr>
					<th scope="col" rowspan="2">STT</th>
					<th scope="col" rowspan="2">Họ Tên</th>
					<th scope="col" rowspan="2">Lớp</th>
					<th scope="col" colspan="2">Thứ 2</th>
					<th scope="col" colspan="2">Thứ 3</th>
					<th scope="col" colspan="2">Thứ 4</th>
					<th scope="col" colspan="2">Thứ 5</th>
					<th scope="col" colspan="2">Thứ 6</th>
					<th scope="col" colspan="2">Thứ 7</th>
					<th scope="col" colspan="2">chủ nhật</th>
				</tr>
				<tr>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
					<th scope="col">S</th>
					<th scope="col">C</th>
				</tr>
			</thead>
			<tbody>
				<%-- <c:forEach var = "i" begin = "0" end = "${dsDangKyLich.size()}"> --%>

				<c:forEach var="i" items="${dsDangKyLich}">
					<tr>
						<%-- <th scope="row">${i+1}</th> --%>
						<th scope="row"></th>
						<td class="d-flex w-100 justify-content-between">${i.username}
							<%-- <td class="d-flex w-100 justify-content-between">${dsDangKyLich.get(i).getName()} --%>
							<small class="text-muted"></small>
						</td>
						<td>${i.className }</td>
						<td><c:if test='${i.schedule.contains("S2")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C2")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S3")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C3")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S4")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C4")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S5")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C5")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S6")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C6")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S7")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C7")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("S8")}'>x</c:if></td>
						<td><c:if test='${i.schedule.contains("C8")}'>x</c:if></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<script src="<c:url value='/js/admin/ThongTinDangKyLich.js' />"></script>
</body>
</html>
