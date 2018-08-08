<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
	<form class="form-horizontal" action='processRegister' modelAttribute="userDto" method="POST" >
  <fieldset>
    <div id="legend">
      <legend class="">Register</legend>
      <span style="font-weight: bold; color: red">${alert}</span>
    </div>
    <div class="control-group">
      <!-- E-mail -->
      <label class="control-label" for="email">E-mail</label>
      <div class="controls">
        <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
        <form:errors path="userDto.email" cssClass="error" />
      </div>
    </div>
   
    <div class="control-group">
      <!-- First Name -->
      <label class="control-label" for="firstName">First Name</label>
      <div class="controls">
        <input type="text" id="firstName" name="firstName" placeholder="" class="input-xlarge">
        <form:errors path="userDto.firstName" cssClass="error" />
      </div>
    </div>
    
    <div class="control-group">
      <!-- Last Name -->
      <label class="control-label" for="lastName">Last Name</label>
      <div class="controls">
        <input type="text" id="lastName" name="lastName" placeholder="" class="input-xlarge">
        <form:errors path="userDto.lastName" cssClass="error" />
      </div>
    </div>
    
    <div class="control-group">
      <!-- Address -->
      <label class="control-label" for="address">Address</label>
      <div class="controls">
        <input type="text" id="address" name="address" placeholder="" class="input-xlarge">
        <form:errors path="userDto.address" cssClass="error" />
      </div>
    </div>
    
     <div class="control-group">
      <!-- Phone -->
      <label class="control-label" for="phone">Phone</label>
      <div class="controls">
        <input type="text" id="phone" name="phone" placeholder="" class="input-xlarge">
        <form:errors path="userDto.phone" cssClass="error" />
      </div>
    </div>
 
    <div class="control-group">
      <!-- Password-->
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
        <form:errors path="userDto.password" cssClass="error" />
      </div>
    </div>
 
    <div class="control-group">
      <!-- Password -->
      <label class="control-label"  for="matchingPassword">Password (Confirm)</label>
      <div class="controls">
        <input type="password" id="matchingPassword" name="matchingPassword" placeholder="" class="input-xlarge">
      	<form:errors path="userDto.matchingPassword" cssClass="error" />
      	<form:errors path="userDto" cssClass="error" />
      </div>
    </div>
 
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success" onclick="verifyRegistation()">Register</button>
      </div>
    </div>
  </fieldset>
</form>
</body>
</html>