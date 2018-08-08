<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
<!------ Include the above in your HEAD tag ---------->
<title>Insert title here</title>
<link rel="stylesheet" href='< c:url value="/resources/css/styles.css"/>'/>
</head>
<body>
<div>
<a href="${pageContext.request.contextPath}/login"><button class="btn btn-success">Login</button></a>
<a href="${pageContext.request.contextPath}/user/registration"><button class="btn btn-success">Register</button></a>
</div>
<div class="row">
  <div class="col-3">
	<div class="panel panel-default" style="padding: 60px;">
	  <div class="panel-heading">
	    <h3 class="panel-title">Thương hiệu</h3>
	  </div>
	  <div class="panel-body">
	    <ul class="list-group">
	     <c:forEach  items="${listCategory}" var="listCategory">
	    	<li class="list-group-item">${listCategory[0]} (${listCategory[1]})</li>
	    </c:forEach>
	  </ul>
	  </div>
	  
	</div>
</div>
  <div class="col-9">
  <div class"list-product">
  <c:forEach  items="${listTivi}" var="tivi">
  <c:set var = "oldPrice" scope = "session" value = "${tivi.price/(1-tivi.discounted/100)}"/>
  <a href="${pageContext.request.contextPath}/tivi/get?id=${tivi.id}"><div class="col-4" style="float: left;">
  	<div class="jumbotron"  style="background: none;">
  	<img alt="tivi" src="${tivi.image}">
	  <p>${tivi.name}</p>
	  <p><fmt:formatNumber value = "${tivi.price}"/> Đ <span style="text-decoration: line-through; color: gray;"><fmt:formatNumber value = "${oldPrice}"/> Đ</span> <span style="color: red;">-${tivi.discounted}%</span></p>
	</div>
	</div>
 </a>
 </c:forEach>
 </div>
 <nav aria-label="Page navigation example"  style="float: left;">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link ${isDisable}" href="${pageContext.request.contextPath}/?page=${param.page-1}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
        <span class="sr-only">Previous</span>
      </a>
    </li>
    <c:forEach begin="1" end="${totalPage}" var="p">
	   <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/?page=${p}">${p}</a></li>
	</c:forEach>
    <li class="page-item">
      <a class="page-link ${isDisableNext}" href="${pageContext.request.contextPath}/?page=${param.page+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
</nav>
  </div>
</div>
</body>
</html>