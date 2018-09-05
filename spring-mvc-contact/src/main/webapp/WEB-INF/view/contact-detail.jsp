<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<spring:url value='/resources/css/app.css'/>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Management</title>

</head>
<body>
	<h1>Contact Detail</h1>
	<form:form modelAttribute="contact" >
		<form:errors path="*" cssClass="error-box"/>
		<div class="input-group">
			<label>Full Name</label>
			<form:input path="name_contact"/>
		</div>
		<div class="input-group">
			<label>Gender</label>
			<form:select path="gender_contact" >
				<form:option value="Male">Male</form:option>
				<form:option value="Female">FeMale</form:option>
			</form:select>
		</div>
		<div class="input-group">
			<label>Birth Date</label>
			<form:input path="birthday_contact" type="date" />
		</div>
		<div class="input-group">
			<label>Address</label>
			<form:textarea path="address_contact" rows="2"/>
		</div>
		<div class="input-group">
			<label>Note</label>
			<form:textarea path="note_contact" rows="3"/>
		</div>
		<form:button name="action" value="abc">Save</form:button>
		<button type="button" onclick="window.location.href='<spring:url value="/contact" />'">Cancel</button>
	</form:form>
	
	
	<script src="<spring:url value='/resources/js/app.js' />" ></script>
</body>
</html>