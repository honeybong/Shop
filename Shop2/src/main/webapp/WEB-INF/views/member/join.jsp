<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/member/js/join.js?ver=19"></script>
</head>
<body>
	<div class="row justify-content-center">
		<div class="col-6">
			<form class="row g-3" action="/member/join" method="post" id="joinForm">
				<!-- 아이디 -->
				<div class="col-9">
					<label for="id" class="form-label">ID</label>
					<input type="text"class="form-control" id="id" name="id">
				</div>
				<div class="col-3 d-grid" id="chechIdDiv">
					<label for="btn2" class="form-label">&nbsp;</label>
					<button type="button" class="btn btn-primary" id="btn2" onclick="checkId();">중복확인</button>
				</div>
				
				
				
				<!-- 비밀번호 -->
				<div class="col-12">
					<label for="pw" class="form-label">PASSWORD</label> 
					<input type="password" class="form-control" id="pw" name="pw" required>
				</div>
				<!-- 비밀번호 확인 -->
				<div class="col-12">
					<label for="c_pw" class="form-label">CONFIRM PASSWORD</label> 
					<input type="password" class="form-control" id="c_pw" required>
				</div>
				<!-- 이름 -->
				<div class="col-12">
					<label for="name" class="form-label">NAME</label> <input
						type="text" class="form-control" id="name" name="name" required>
				</div>
				<!-- 전화번호 -->
				<div class="col-4">
					<label for="tell1" class="form-label">TELL</label> <select
						id="tell1" class="form-select" name="tells">
						<option value="010" selected>010</option>
						<option value="011">011</option>
					</select>
				</div>
				<div class="col-4">
					<label for="tell2" class="form-label">&nbsp;</label> <input
						type="text" class="form-control" id="tell2" name="tells" required>
				</div>
				<div class="col-4">
					<label for="tell3" class="form-label">&nbsp;</label> <input
						type="text" class="form-control" id="tell3" name="tells" required>
				</div>
				<!-- 주소 -->
				<div class="col-9">
					<label for="addr1" class="form-label">ADDRESS</label> 
					<input type="text" class="form-control" id="addr" name="addres">
				</div>
				<div class="col-3 d-grid">
					<label for="btn1" class="form-label">&nbsp;</label>
					<button type="submit" class="btn btn-primary" id="btn1">검색</button>
				</div>
				<div class="col-12 mt-2">
					<input type="text" class="form-control" id="addr2" name="addres">
				</div>
				<!-- 성별 -->
				<div class="col-12">
					<div class="col">
						<label for="" class="form-label">GENDER</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender"
							id="inlineRadio1" value="male" checked> <label
							class="form-check-label" for="inlineRadio1">남자</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender"
							id="inlineRadio2" value="female"> <label
							class="form-check-label" for="inlineRadio2">여자</label>
					</div>
				</div>
				<div class="col-12 d-grid">
					<input type="button" class="btn btn-primary disabled" id="joinBtn" value="J o i n" onclick="goJoin();">
				</div>
			</form>
		</div>
	</div>
</body>
</html>

















