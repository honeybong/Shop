<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.myContainer{
   background-color: #F9F9F9;
   border-radius: 6px;
   padding: 16px;
}
</style>
</head>
<body>
<div class="row justify-content-center">
   <div class="col-11">
      <div class="row">
         <div class="col-5" style="border-bottom: 2px solid #0d6efd; font-style: italic; font-weight: bold;">
            <h5>REGISTRATION ITEM</h5>
         </div>
      </div>
      <div style="height: 20px;"></div>
      <div class="row">
         <div class="col myContainer">
            <form class="row g-3" action="/admin/regItem" method="post" enctype="multipart/form-data">
               <div class="col-6">
                  <label for="itemCategory" class="form-label">Choose Category</label>
                  <select class="form-select" id="itemCategory" name="cateCode">
                     <c:forEach items="${categoryList }" var="categoryInfo">
	                     <option value="${categoryInfo.cateCode }">${categoryInfo.cateName }</option>
                     </c:forEach>
                  </select>
               </div>
               <div class="col-12">
                  <label for="itemName" class="form-label">Input Item Name</label>
                  <input type="text" name="itemName" class="form-control" id="itemName" placeholder="input here..." required>
               </div>
               <div class="col-6">
                  <label for="itemPrice" class="form-label">Input Item Price</label>
                  <input type="text" name="itemPrice" class="form-control" id="itemPrice" placeholder="input here..." required>
               </div>
               <div class="col-12">
                  <label for="formFile" class="form-label">Choose representative Image</label>
                    <input class="form-control" type="file" id="formFile" name="file1">
               </div>
               <div class="col-12">
                  <label for="formFileMultiple" class="form-label">Choose Additory Images</label>
                    <input class="form-control" type="file" id="formFileMultiple" name="file2" multiple>
               </div>
               <div class="col-12 text-center">
                   <input type="submit" class="btn btn-primary" value="REGISTRATION">
                 </div>
            </form>
         </div>
      </div>
   </div>
</div>
</body>
</html>