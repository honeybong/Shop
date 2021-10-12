<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/template/js/menu.js?ver=6"></script>
<style type="text/css">
span:hover{
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col text-end">
			<c:choose>
				<c:when test="${not empty sessionScope.loginInfo }">
					${sessionScope.loginInfo.name } 왔는가 &nbsp;
					<a href="/member/Logout">Logout</a>
				</c:when>
				<c:otherwise>
					<a href="/member/join">Join</a> 
					<span data-bs-toggle="modal"data-bs-target="#loginModal">Login</span>
				</c:otherwise>
			</c:choose>
			
		</div>
	</div>
	<div class="row">
		<div class="col text-center">
			<h1>BOOK SHOP</h1>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<a class="navbar-brand" href="#">SHOP</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
						aria-controls="navbarNavAltMarkup" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
						<div class="navbar-nav">
							<c:choose>
								<c:when test="${empty sessionScope.loginInfo or sessionScope.loginInfo.isAdmin eq 'N' }">
									<a class="nav-link active" aria-current="page" href="#">Home</a>
									<c:forEach items="${categoryList }" var="categoryInfo">
									<a class="nav-link active" aria-current="page" href="/item/categoryManage">${categoryInfo.cateName }</a>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${menuList}" var="menuInfo">
										<a class="nav-link active" href="/admin/${menuInfo.menuPass }">${menuInfo.menuName}</a>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>



	<!-- login 창 띄우기 -->
	<form action="/member/login" method="post">
		<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">LOGIN</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="id1" name="id" placeholder="Id" required>
							<label for="floatingInput">ID</label>
						</div>
						<div class="form-floating">
							<input type="password" class="form-control" id="pw1" name="pw" placeholder="Password" required> 
							<label for="floatingPassword">PASSWORD</label>
						</div>
						<div class="col-12 d-grid">
							<input type="submit" class="btn btn-primary mt-4" value="L O G I N" onclick="goLogin();">
						</div>
					</div>
					<div class="modal-footer">
						<!-- <button type="button" class="btn btn-secondary"data-bs-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save changes</button> -->
					</div>
				</div>
			</div>
		</div>
	</form>


















</body>
</html>