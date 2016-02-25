<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		
		<div class="content">
				<h3>Properties</h3>
				<table class="table table-hover">
				  <tr>
				    <th>Type</th> 
				    <th>Address</th>
				    <th>Owner</th>
				  </tr>
				  <c:forEach var="property" items="${properties}">
				  <tr class='clickable-row' data-href='PropertyDetail?propId=<c:out value="${property.propId}" />'>
				    <td><c:out value="${property.propertyType}" /></td> 
				    <td><c:out value="${property.propAddress1}" /> </td>
				    <td><c:out value="${property.owner.firstName}" /> <c:out value="${property.owner.lastName}" /></td>
				  </tr>
				</c:forEach>
				</table>
			<!-- end .content --></div>
		
		
	</jsp:attribute>
</my:propManager>