	<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<my:propManager>
		<jsp:attribute name="body">
			<div class="content">
				<h3>Service Calls</h3>
				<table class="table table-hover">
				  <tr>
				    <th>ID</th>
				    <th>Address</th> 
				    <th>Service Call</th>
				    <th>Status</th>
				  </tr>
				  <c:forEach var="serviceCall" items="${serviceCalls}">
				  <tr class='clickable-row' data-href='AssignServiceCallRedirect?scId=<c:out value="${serviceCall.scId}" />'>
				    <td><c:out value="${serviceCall.scId}" /></td>
				    <td><c:out value="${serviceCall.unit.property.propAddress1}" /> # <c:out value="${serviceCall.unit.unitNumber}" /></td> 
				    <td><c:out value="${serviceCall.serviceCallDetail}" /></td>
				    <td><c:out value="${serviceCall.status}" /></td>
				  </tr>
				</c:forEach>
				</table>
			<!-- end .content --></div>
		</jsp:attribute>
	</my:propManager>
	
	
	