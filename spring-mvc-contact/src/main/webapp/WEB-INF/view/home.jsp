<%@page import="org.springframework.ui.Model"%>
<%@page import="com.green.spring.model.ContactModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
  	body {
 	 background-color: black;
	}
  </style>
<title>Contact Management</title>
</head>
<body>
	<h1>Contact List</h1>
	<div class="action">
		<button type="button" onclick="window.location.href='<spring:url value="/contact/create" />'">Add</button>
		<button type="button" onclick="window.location.href='<spring:url value="/call-history" />'">Call History</button>
	</div>
	<table class="table table-dark table-hover">
		<tr>
			<th>Avatar</th>
			<th>Name</th>
			<th>Birthday</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Note</th>
			<th colspan="2">Actions</th>
		<tr>
			<c:if test="${empty contacts}">
				<tr>
					<td colspan="6">Empty!</td>
				</tr>
			</c:if>
			<c:if test="${not empty contacts}">
				<c:forEach var="contact" items="${contacts}">
					<tr>
						<td><img src="resources/images/${contact.avatar_contact}" height="30px" width="30px"></td>
						<td>${contact.name_contact}</td>
						<td>${contact.birthday_contact}</td>
						<td>${contact.gender_contact}</td>
						<td>${contact.address_contact}</td>
						<td>
						
						<% int i=1;%>
						<c:forEach var="phone" items="${phone}">
							<c:if test="${phone.contact.id_contact==contact.id_contact}">
								<%=i++%>. ${phone.phone_contact}<br>
							</c:if>
						</c:forEach>
						</td>
						<td>
						
						<% int j=1;%>
						<c:forEach var="email" items="${email}">
							<c:if test="${email.contact.id_contact==contact.id_contact}">
								<%=j++%>. ${email.email_contact}<br>
							</c:if>
						</c:forEach>
						</td>
						<td>${contact.note_contact}</td>
						<td>
							<button type="button" onclick="window.location.href='<spring:url value="/contact/update?contactId=${contact.id_contact}" />'">Edit</button>
						</td>
						<td>
							<form:form action="/contact?contactId=${contact.id_contact}" method="delete">
								<button type="submit">Delete</button>
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</c:if>
	</table>
	<div class="container">
  <a href="#demo" class="btn btn-info" data-toggle="collapse">View phone</a>
  <div id="demo" class="collapse">
  
  </div>
</div>
	<script src="<spring:url value='/resources/js/app.js' />" ></script>
</body>
</html>