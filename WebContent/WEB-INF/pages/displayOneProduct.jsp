<%@ include file="header.txt" %>

<h1>Product details</h1>

<table>
	<tr>
		<td>Name</td>
		<td><b>${requestScope.prd.productName}</b></td>
	</tr>
	<tr>
		<td>Quantity per unit</td>
		<td><b>${requestScope.prd.quantityPerUnit}</b></td>
	</tr>
	<tr>
		<td>Unit price</td>
		<td><b>\$${requestScope.prd.unitPrice}</b></td>
	</tr>
	<tr>
		<td>Units in stock</td>
		<td><b>${requestScope.prd.unitsInStock}</b></td>
	</tr>
	<tr>
		<td>Units on order</td>
		<td><b>${requestScope.prd.unitsOnOrder}</b></td>
	</tr>
	<tr>
		<td>Reorder level</td>
		<td><b>${requestScope.prd.reorderLevel}</b></td>
	</tr>
	<tr>
		<td>Discontinued?</td>
		<td><b>${requestScope.prd.discontinued==0?"No":"Yes"}</b></td>
	</tr>
</table>

<p>
<a href="edit-product?id=${requestScope.prd.productId}">Edit</a>
</p>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${requestScope.msg!=null}">
<script type="text/javascript">
	window.onload = function(){
		alert("${requestScope.msg}");
	};
</script>
</c:if>
<%@ include file="footer.txt" %>





