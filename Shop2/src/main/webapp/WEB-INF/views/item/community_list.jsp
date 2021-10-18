<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.pagingDiv a{
	color: black;
	text-decoration: none;
}
a.selectedPage{
	color : red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col">
			<nav class="navbar navbar-light bg-light">
				<form class="/item/boardList" method="post">
					<div class="container-fluid input-group">
						<select class="form-select me-2" aria-label="Default select example" name="searchKeyword">
							<option selected value="title">제목</option>
							<option value="writer">작성자</option>
						</select>
						<input type="text" class="form-control me-2" name="searchValue">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</div>
				</form>
			</nav>
		</div>
	</div>



<div class="row">
<<<<<<< HEAD
	<div class="col">
		<nav class="navbar navbar-light bg-light">
			<form class="/item/boardList" method="post">
				<div class="container-fluid input-group">
					<select class="form-select me-2" aria-label="Default select example" name="searchKeyword">
						<option selected value="title">제목</option>
						<option value="writer">작성자</option>
					</select>
					<input type="text" class="form-control me-2" name="searchValue">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</div>
			</form>
		</nav>
	</div>
</div>



<div class="row">
=======
>>>>>>> refs/remotes/origin/master
	<div class="col-8 text-center container-fluid">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">No</th>
					<th scope="col">글제목</th>
					<th scope="col">작성자</th>
					<th scope="col">등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.boardNum }</td>
						<td>${board.title }</td>
						<td>${board.writer }</td>
						<td>${board.createDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<div class="row">
	<div class="col text-center pagingDiv">
		<c:if test="${boardVO.prev }">
			<a href="/item/boardList?nowPage=${boardVO.beginPage -1 }">prev</a>
		</c:if>
		<c:forEach begin="${boardVO.beginPage }" end="${boardVO.endPage }" var="pageNumber">
			<a href="/item/boardList?nowPage=${pageNumber}" <c:if test="${boardVO.nowPage eq pageNumber }">class="selectedPage"</c:if>>${pageNumber}</a>
		</c:forEach>
		<c:if test="${boardVO.next }">
			<a href="/item/boardList?nowPage=${boardVO.endPage +1 }">next</a>
		</c:if>
	</div>
</div>

<div class="row">
	<div class="col text-center">
		<nav aria-label="...">
			<ul class="pagination justify-content-center">
				<li class="page-item <c:if test="${!boardVO.prev }">disabled</c:if>">
					<a class="page-link" href="/item/boardList?nowPage=${boardVO.beginPage -1 }">
						Previous
					</a>
				</li>
				<c:forEach begin="${boardVO.beginPage }" end="${boardVO.endPage }" var="pageNumber">
					<li class="page-item <c:if test="${boardVO.nowPage eq pageNumber }">active</c:if>" <c:if test="${boardVO.nowPage eq pageNumber }">aria-current="page"</c:if>>
						<a class="page-link" href="/item/boardList?nowPage=${pageNumber}">
							${pageNumber}
						</a>
					</li>
				</c:forEach>
				<li class="page-item <c:if test="${!boardVO.next }">disabled</c:if>" >
					<a class="page-link" href="/item/boardList?nowPage=${boardVO.endPage +1 }">
						Next
					</a>
				</li>
			</ul>
		</nav>
	</div>
</div>

<div class="row">
	<div class="col text-center">
		<button type="button" class="btn btn-primary">글쓰기</button>
	</div>
</div>
</body>
</html>