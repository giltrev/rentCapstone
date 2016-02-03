<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
			<h2>Service Calls</h2>
			<ul>
				<c:forEach var="serviceCall" items="${serviceCalls}">
					<li><a href="serviceCall?scId=<c:out value="${serviceCall.scId}" />">  <c:out value="${serviceCall.serviceCallName}" /> <c:out value="${serviceCall.unit.unitId}" /> <c:out value="${serviceCall.unit.property.propName}" /></a></li>
				</c:forEach>
			</ul>
		<!-- end .content --></div>
	</jsp:attribute>
</my:propManager>