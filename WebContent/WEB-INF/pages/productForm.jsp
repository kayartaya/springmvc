<%@ include file="header.txt"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<h1>Product details</h1>


<sf:form commandName="prd" action="save-product" >

<sf:hidden path="productId" />
<sf:hidden path="categoryId" />
<sf:hidden path="supplierId" />

<table>
	<tr>
		<td>Name</td>
		<td><sf:input path="productName" size="20" />
			<sf:errors path="productName" cssClass="err" />
		</td>
	</tr>
	<tr>
		<td>Quantity per unit</td>
		<td><sf:input path="quantityPerUnit" size="30" /></td>
	</tr>
	<tr>
		<td>Unit price</td>
		<td><sf:input path="unitPrice" size="10" />
			<sf:errors path="unitPrice" cssClass="err" />
		</td>
	</tr>
	<tr>
		<td>Units in stock</td>
		<td><sf:input path="unitsInStock" size="10" />
			<sf:errors path="unitsInStock" cssClass="err" />
		</td>
	</tr>
	<tr>
		<td>Units on order</td>
		<td><sf:input path="unitsOnOrder" size="10" />
			<sf:errors path="unitsOnOrder" cssClass="err" />
		</td>
	</tr>
	<tr>
		<td>Reorder level</td>
		<td><sf:input path="reorderLevel" size="10" />
			<sf:errors path="reorderLevel" cssClass="err" />
		</td>
	</tr>
	<tr>
		<td>Discontinued?</td>
		<td>
			<sf:radiobutton path="discontinued" value="0" /> No
			<sf:radiobutton path="discontinued" value="1" /> Yes
		</td>
	</tr>
</table>

<p>
	<button>Save</button>
	<a href="./">Cancel</a>
</p>

</sf:form>

<%@ include file="footer.txt"%>