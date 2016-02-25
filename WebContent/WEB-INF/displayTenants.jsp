<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
			<h3>Tenants</h3>
				<table class="table table-hover">
				  <tr>
				    <th>Name</th> 
				    <th>Address</th>
				  </tr>
				  <c:forEach var="tenant" items="${allTenants}">
				  <tr class='clickable-row' data-href='TenantDetail?personId=<c:out value="${tenant.personId}" />'>
				    <td><c:out value="${tenant.firstName}" /> <c:out value="${tenant.middleName}" /> <c:out value="${tenant.lastName}" /></td> 
				    <td><c:out value="${tenant.unit.property.propAddress1}" /> <c:out value="${tenant.unit.unitNumber}" /></td>
				  </tr>
				</c:forEach>
				</table>
			
			
			
		<!-- end .content --></div>
	</jsp:attribute>
</my:propManager>