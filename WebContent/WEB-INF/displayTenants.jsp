<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
			<ul> 
				<c:forEach var="tenant" items="${allTenants}">
					<li><strong><a href="TenantDetail?personId=<c:out value="${tenant.personId}" />"> <c:out value="${tenant.firstName}" /> <c:out value="${tenant.middleName}" /> <c:out value="${tenant.lastName}" /></a></strong><br />
					<c:out value="${tenant.unit.property.propAddress1}" /> <c:out value="${tenant.unit.unitNumber}" /></li>
				</c:forEach>
			</ul>
		<!-- end .content --></div>
	</jsp:attribute>
</my:propManager>