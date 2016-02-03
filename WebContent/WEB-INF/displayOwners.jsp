<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		  	<div class="content">
			  	<h2>Owners</h2>
			  	<ul>
					<c:forEach var="owner" items="${allOwners}">
						<li><a href="OwnerDetails?personId=<c:out value="${owner.personId}" />">  <c:out value="${owner.firstName}" /> <c:out value="${owner.middleName}" /> <c:out value="${owner.lastName}" /></a></li>
					</c:forEach>
				</ul>
			<!-- end .content --></div>
	</jsp:attribute>
</my:propManager>