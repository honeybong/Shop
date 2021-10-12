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
<!-- <div class="row justify-content-center"> 저스트 어쩌구 저거는 가운데정렬시켜줌
	<div class="col-3">
		<div style="border-bottom: 1px solid gray;">Categiry Manage</div>
	</div>
</div> -->

<!-- 제목줄 -->
<div class="row">
	<div class="col-3">
		<div style="border-bottom: 2px solid #dddddd;">
			<h5>Categiry Manage</h5>
		</div>
	</div>
</div>
<!-- 제목줄이랑 거리두기위에 높이줌 -->
<div style="height: 30px;"></div>
<!-- 카테고리추가란 -->
<div class="row">
	<div class="col">
		<div style="font-size: 12px; color: red; margin-bottom: 5px; ">
			*추가할상품 카테고리명을 입력하세요.
		</div>
		<form action="/admin/insertCategory" method="post">
			<div class="row mb-4">
				<div class="col-6">
					<div class="input-group mb-3">
						<label class="input-group-text" for="inputGroupSelect01">CATEGORY_NAME</label>
						<input type="text" class="form-control" name="cateName" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2" required>
						<button class="btn btn-primary" type="submit" id="button-addon2">추가</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<!-- 테이블공간 -->
<div class="row">
	<div class="col">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">No</th>
					<th scope="col">Category</th>
					<th scope="col">Name</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categoryList }" var="categoryInfo" varStatus="status">
					<tr>
						<th scope="row">${status.count }</th>
						<td>${categoryInfo.cateCode }</td>
						<td>${categoryInfo.cateName }</td>
						<td><input type="button" class="btn btn-primary" value="삭제" onclick="location.href='/admin/deleteCategory?cateCode=${categoryInfo.cateCode}'"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
	<!-- 여기까지 내가 한거 아래는 쌤이 한거 -->


<div class="row">
	<div class="col-12">
		<!-- 맨 윗줄 제목줄 -->
		<div class="row" style="margin-top: 10px;">
			<div class="col-5" style="border-bottom: 2px solid #dddddd;">
				<h5>ITEM CATEGORY MANAGE</h5>
			</div>
		</div>
		<!-- 제목이랑 인풋사이 공간주기위해 디브에 높이줌 -->
		<div style="height: 30px;"></div>
		<!-- 추가하기위한 인풋 -->
		<div class="row">
			<div class="col-10">
				<div style="font-size: 12px; color: red; margin-bottom: 5px;">
					*추가할상품 카테고리명을 입력하세요.
				</div>
				<form action="/admin/insertCategory" method="post">
				<div class="row">
					<div class="col-8">
						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1">ITEM_NAME</span>
							<input type="text" class="form-control" name="cateName"
								placeholder="Input here..." aria-label="Username"
								aria-describedby="basic-addon1">
						</div>
					</div>
					<div class="col-4">
						<input type="button" class="btn btn-primary" value=" 추 가 ">
					</div>
				</div>
				</form>
			</div>
		</div>
		<!-- 인풋이랑 테이블사이 공간주기위해 높이줌 -->
		<div style="height: 30px;"></div>
		<!-- 테이블공간 -->
		<div class="row">
			<div class="col">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">No</th>
							<th scope="col">ITEM_CODE</th>
							<th scope="col">ITEM_NAME</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${categoryList }" var="categoryInfo" varStatus="status">
						<tr>
							<td scope="row">${categoryList.size() - status.index }</td>
							<td>${categoryInfo.cateCode }</td>
							<td>${categoryInfo.cateName }</td>
							<td>
								<form action="/admin/deleteCategory" method="post">
									<input type="hidden" name="cateCode" value="${categoryInfo.cateCode }">
									<input type="submit" class="btn btn-primary" value="삭제" <%-- onclick="location.href='/admin/deleteCategory?cateCode=${categoryInfo.cateCode}'" --%>>
								</form>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>
</body>
</html>
