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
	<c:forEach items="${itemList }" var="itemInfo">
		<c:forEach items="${itemInfo.imgList}" var="img">
			${img.attachedImgName}
		</c:forEach>
	</c:forEach>
<div class="row">
	<c:forEach items="${itemList }" var="itemInfo">
		<div class="col-2">
			<div class="card" style="width: 12rem;">
				<c:forEach items="${itemInfo.imgList}" var="imgInfo">
					<img src="/resources/images/${imgInfo.attachedImgName}" class="card-img-top" alt="...">
				</c:forEach>
				<div class="card-body text-center" style="padding: 0.2rem 1rem">
					<h5 class="card-title">
						${itemInfo.itemName }
					</h5>
					<p class="card-text">
						${itemInfo.itemPrice }
					</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
</body>
</html>