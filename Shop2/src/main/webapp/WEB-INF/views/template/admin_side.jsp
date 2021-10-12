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
	<div class="list-group">
		<c:forEach items="${sideMenuList }" var="sideMenuInfo">
			<a href="/admin/${sideMenuInfo.menuPass }" class="list-group-item list-group-item-action <c:if test="${sidePage eq sideMenuInfo.menuPass }">active</c:if>"aria-current="true">${sideMenuInfo.sideMenuName }</a> 
		</c:forEach>
	</div>
<%-- <c:if test="${sidePage eq 'memberManage' }">
	<div class="list-group">
		<a href="/admin/memberManage" class="list-group-item list-group-item-action <c:if test="${sidePage eq 'memberManage' }">active</c:if>">회원 관리</a> 
		<a href="/admin/selectMemberList" class="list-group-item list-group-item-action <c:if test="${sidePage eq 'selectMemberList' }">active</c:if>"aria-current="true"> 회원 조회 </a> 
	</div>
</c:if> --%>
</body>
</html>