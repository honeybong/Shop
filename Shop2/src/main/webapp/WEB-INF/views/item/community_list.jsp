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
커밋테스트 23
<div class="row">
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
		<button type="button" class="btn btn-primary">글쓰기</button>
	</div>
</div>

</body>
</html>