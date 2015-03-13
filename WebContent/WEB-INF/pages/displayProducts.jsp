<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.txt" %>

<table border="1">
	<tr>
		<th>Product Id</th>
		<th>Name</th>
		<th>Quantity per unit</th>
		<th>Unit price</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${requestScope.products}" var="p">
	<tr>
		<td>${p.productId}</td>
		<td>${p.productName}</td>
		<td>${p.quantityPerUnit}</td>
		<td>${p.unitPrice}</td>
		<td>
			<a href="product?id=${p.productId}">Details</a> |
			<a href="delete-product?id=${p.productId}">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>

<%@ include file="footer.txt" %>





