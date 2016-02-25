<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<my:vendor>
	<jsp:attribute name="body">
		<div class="content">
		    <h3>Welcome <c:out value="${vendor.firstName}" /> <c:out value="${vendor.lastName}" /></h3>
		    
		    
		    <h4>Here are your Service Calls:</h4>

		    <table class="table table-hover">
				  <tr>
				    <th>ID</th>
				    <th>Contact</th> 
				    <th>Phone Numbers</th> 
				    <th>Address</th> 
				    <th>Service Call</th>
				    <th>Status</th>
				  </tr>
				  <c:forEach var="serviceCall" items="${vendor.serviceCalls}">
						  <tr class='clickable-row' data-href='ServiceCallEditVendorRedirect?scId=<c:out value="${serviceCall.scId}" />'>
						    <td> <c:out value="${serviceCall.scId}" /> </td>
						    <td><c:out value="${serviceCall.reportedBy.firstName}" />  <c:out value="${serviceCall.reportedBy.lastName}" /></td> 
							<td>			   
						    <c:forEach var="phoneNumber" items="${serviceCall.reportedBy.phoneNumbers}">
						    		<c:if test="${phoneNumber.primaryNumber}"> 
						    		<c:out value="${phoneNumber.phoneNumber}" />
						    		</c:if>
						    </c:forEach>
						    </td>
						    <td><c:out value="${serviceCall.unit.property.propAddress1}" /> # <c:out value="${serviceCall.unit.unitNumber}" /></td> 
						    <td><c:out value="${serviceCall.serviceCallDetail}" /></td>
						    <td><c:out value="${serviceCall.status}" /></td>
						  </tr>
				</c:forEach>
			</table>
		    
		<!-- end .content --></div>
	
	</jsp:attribute>
</my:vendor>