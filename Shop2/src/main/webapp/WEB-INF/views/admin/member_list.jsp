<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 제목줄 -->
<div class="row">
	<div class="col-3">
		<div style="border-bottom: 2px solid #dddddd;">
			<h5>Member Manage</h5>
		</div>
	</div>
</div>
<!-- 제목줄이랑 거리두기위에 높이줌 -->
<div style="height: 30px;"></div>
<div class="row">
	<div class="col">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">TELL</th>
					<th scope="col">ADDR</th>
					<th scope="col">GENDER</th>
					<th scope="col">JOIN_DATE</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${memberList }" var="memberInfo">
					<tr>
						<td>${memberInfo.id }</td>
						<td>${memberInfo.name }</td>
						<td>${memberInfo.tell }</td>
						<td>${memberInfo.addr }</td>
						<c:choose>
							<c:when test="${memberInfo.gender eq null }">
								<td>정보 없음</td>
							</c:when>
							<c:otherwise>
								<td>${memberInfo.gender }</td>
							</c:otherwise>
						</c:choose>
						<td>${memberInfo.joinDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>