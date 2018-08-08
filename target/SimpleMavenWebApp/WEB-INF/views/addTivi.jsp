<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
.error {
	color: red;
}
</style>
<!------ Include the above in your HEAD tag ---------->
<title>Insert title here</title>
<script src='< c:url value="/resources/js/custom.js"/>'></script>
<link rel="stylesheet" href='< c:url value="/resources/css/styles.css"/>'/>
</head>
<body>
	<form class="form-horizontal" action='processAdd' modelAttribute="tivi" method="POST" >
  <fieldset>
    <div id="legend">
      <legend class="">Thêm tivi/Sửa thông tin</legend>
      <span style="font-weight: bold; color: red">${alert}</span>
    </div>
    
    <div class="control-group">
      <!-- Tên-tivi -->
      <label class="control-label" for="name">Tên tivi</label>
      <div class="controls">
        <input type="text" id="name" name="name" placeholder="" class="input-xlarge">
        <form:errors path="tivi.name" cssClass="error" />
      </div>
    </div>
    
    <div class="control-group">
      <!-- Hãng -->
      <label class="control-label" for="category">Hãng</label>
      <div class="controls">
      <button id ="btn-them" type="button" onclick="clickThem()">Thêm mới</button>
		<select id ="category" name ="category"">
	           <c:forEach  items="${listCategory}" var="listCategory">
	           <option value=${listCategory.getName()}>${listCategory.getName()}</option>
	           </c:forEach>
	 	</select>
	 	<input type="text" id ="temp" style="display: none" name ="temp" placeholder="" class="input-xlarge">
	 	<button type="button" id ="btn-ok" style="display: none" onclick="myFunction()">OK</button>
      </div>
    </div>
    
    <div class="control-group">
      <!-- Giá -->
      <label class="control-label" for="price">Giá</label>
      <div class="controls">
        <input type="text" id="price" name="price" placeholder="" class="input-xlarge">
        <form:errors path="tivi.price" cssClass="error" />
      </div>
    </div>
    
     <div class="control-group">
      <!-- Giảm giá -->
      <label class="control-label" for="discounted">Giảm giá</label>
      <div class="controls">
        <input type="text" id="discounted" name="discounted" placeholder="" class="input-xlarge"><span>%</span>
        <form:errors path="tivi.discounted" cssClass="error" />
      </div>
    </div>
    
     <div class="control-group">
      <!-- Mô tả -->
      <label class="control-label" for="subscription">Mô tả</label>
      <div class="controls">
       <textarea name='subscription' id='subscription'></textarea>
        <form:errors path="tivi.subscription" cssClass="error" />
      </div>
    </div>
    
        <div class="control-group">
      <!-- Hình ảnh -->
      <label class="control-label" for="image">Hình ảnh</label>
      <div class="controls">
       <input name='image' id='image'>
        <form:errors path="tivi.image" cssClass="error" />
      </div>
    </div>
   
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">Submit</button>
      </div>
    </div>
  </fieldset>
</form>

<form class="form-horizontal" action='processFind' method="POST">
  <fieldset>
    <div id="legend">
      <legend class="">Danh sách tivi</legend>
      <span style="font-weight: bold; color: red">${alert}</span>
    </div>
    
    <div class="control-group">
      <!-- Tên-tivi -->
      <label class="control-label" for="name">Tên tivi</label>
      <div class="controls">
        <input type="text" id="name" name="name" placeholder="" class="input-xlarge">
        <form:errors path="tivi.name" cssClass="error" />
      </div>
    </div>
    
    <div class="control-group">
      <!-- Hãng -->
      <label class="control-label" for="category">Hãng</label>
      <div class="controls">
		<select id ="category" name ="category">
			<option value=""></option>
	           <c:forEach  items="${listCategory}" var="listCategory">
	           <option value=${listCategory.getName()}>${listCategory.getName()}</option>
	           </c:forEach>
	 	</select>
      </div>
    </div>
    
    <div class="control-group">
      <!-- Giá -->
      <label class="control-label" for="price">Giá</label>
      <div class="controls">
        <input type="text" id="priceMin" name="priceMin" placeholder="" class="input-xlarge"><span> ~ </span>
        <input type="text" id="priceMax" name="priceMax" placeholder="" class="input-xlarge">
        <form:errors path="tivi.price" cssClass="error" />
      </div>
    </div>
   
   <div class="control-group">
      <!-- Đã bán -->
      <label class="control-label" for="bought">Đã bán</label>
      <div class="controls">
        <input type="checkbox" name="bought" value="1">
      </div>
      <!-- Chưa bán -->
      <label class="control-label" for="bought">Chưa bán</label>
      <div class="controls">
        <input type="checkbox" name="bought" value="0">
      </div>
    </div>
   
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">Tìm kiếm</button>
      </div>
    </div>
  </fieldset>
</form>

<div class="container">
  <h2>Kết quả tìm kiếm</h2>
  <table class="table table-bordered table-sm">
    <thead>
      <tr>
         <th>Tivi</th>
        <th>Hãng</th>
        <th>Giá</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
       <c:forEach items="${listTivi}" var="tv" varStatus="status">
        <tr>
            <td>${tv.name}</td>
            <td>${tv.category}</td>
            <td> <p><fmt:formatNumber value = "${tv.price}"/></p></td>
            <td><a href="${pageContext.request.contextPath}/tivi/delete?id=${tv.id}"><button class="btn btn-success">Xoá</button></a></a></td>
        </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>