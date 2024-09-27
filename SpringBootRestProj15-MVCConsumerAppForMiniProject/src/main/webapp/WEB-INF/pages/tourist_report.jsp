<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tourist Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty touristList}">
			<h1>The Tourist Info</h1>
			<table border="1" align="center" bgcolor="cyan">
				<tr>
					<th>TID</th>
					<th>Name</th>
					<th>City</th>
					<th>Budget</th>
					<th>Package Type</th>
					<th colspan="2">Operations</th>
				</tr>
				<c:forEach var="tst" items="${touristList}">
					<tr>
						<td>${tst.tid}</td>
						<td>${tst.name}</td>
						<td>${tst.city}</td>
						<td>${tst.budget}</td>
						<td>${tst.packageType}</td>
						<td><a href="edit?id=${tst.tid}">Edit</a></td>
						<td><a href="delete?id=${tst.tid}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>Tourists not found!</h1>
		</c:otherwise>
	</c:choose>
	<br>
	<h2 style="text-align: center">
		<a href="add">Add Tourist</a> <br>
	</h2>
	<br><br>
	<h1 style="color: green; text-align: center">${result}</h1>
</body>
</html>