<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.5.2.js" integrity="sha256-4hB8js20ecNtgi2CvaKoyvRCmrLSz58g1ckx91J1QDw=" crossorigin="anonymous"></script>
<!------ Include the above in your HEAD tag ---------->
<title>Insert title here</title>
<link rel="stylesheet" href='< c:url value="../resources/css/styles.css"/>'/>
<script src='< c:url value="/resources/js/custom.js"/>'></script>
</head>
<body>
<div class="container-fluid">
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container">	
				<div class="col-md-12">
					<div class="product col-md-3 service-image-left">
                    
						<center>
							<img id="item-display" src="${img}" alt=""></img>
						</center>
					</div>
					
					<div class="container service1-items col-sm-2 col-md-2 pull-left">
						<center>
							<a id="item-1" class="service1-item">
								<img src="http://www.corsair.com/Media/catalog/product/g/s/gs600_psu_sideview_blue_2.png" alt=""></img>
							</a>
							<a id="item-2" class="service1-item">
								<img src="http://www.corsair.com/Media/catalog/product/g/s/gs600_psu_sideview_blue_2.png" alt=""></img>
							</a>
							<a id="item-3" class="service1-item">
								<img src="http://www.corsair.com/Media/catalog/product/g/s/gs600_psu_sideview_blue_2.png" alt=""></img>
							</a>
						</center>
					</div>
				</div>
				<c:set var = "oldPrice" scope = "session" value = "${price/(1-(discounted/100))}"/>
				<div class="col-md-7">
					<div class="product-title" name="title" style="font-weight: bold;">${title}</div>
					<div class="product-desc" name="desc">
					<c:forEach  items="${desc}" var="listCategory">
	           			${listCategory}</br>
	           		</c:forEach></div>
					<div class="product-rating"><i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star-o"></i> </div>
					<hr>
					<div class="product-price" name="price"><p><fmt:formatNumber value = "${price}"/> Đ <span style="text-decoration: line-through; color: gray;"><fmt:formatNumber value = "${oldPrice}"/> Đ</span> <span style="color: red;">-${discounted}%</span></p></div>
					<hr>
					<div class="btn-group order">
						<button type="button" class="btn btn-success">
							Buy
						</button>
					</div>
				</div>
			</div> 
		</div>
	</div>
</div>

</div>
</body>
</html>