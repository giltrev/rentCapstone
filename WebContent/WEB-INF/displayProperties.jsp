<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
			<c:forEach var="owner" items="${allOwners}">
				<h2><c:out value="${owner.firstName}" /> <c:out value="${owner.middleName}" /> <c:out value="${owner.lastName}" /></h2>
				<ul>
					<c:forEach var="property" items="${owner.properties}">
						<li> <a href="PropertyDetail?propId=<c:out value="${property.propId}" />"> <c:out value="${property.propertyType}" /> at <c:out value="${property.propAddress1}" /></a> </li>
					</c:forEach>
				</ul>
			</c:forEach>
		<!-- end .content --></div>
	</jsp:attribute>
</my:layout>