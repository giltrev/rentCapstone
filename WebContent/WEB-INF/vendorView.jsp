<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:person>
	<jsp:attribute name="body">
		<div class="content">
		    <h1>Welcome <c:out value="${vendor.firstName}" /> <c:out value="${vendor.lastName}" /></h1>
		    
		    
		    <h4>Here are your Service Calls:</h4>

		    <table>
		    	<tr>
			 		<th>
			    		Address
					</th>
			  		<th>
		    			Contact Name and Phone Number
		    	 	</th>
			  		<th>
		    			Best Time to Service
		    	 	</th>		    	 	
			  		<th>
		    			Service Requested
		    	 	</th>		    		
		    	</tr>
		   <c:forEach var="serviceCall" items="${vendor.serviceCalls}">
		   		<tr>
			 		<td>
			    		<c:out value="${serviceCall.unit.property.propAddress1}" />
					</td>
			  		<td>
		    			<c:out value="${serviceCall.unit.tenant.firstName}" /> <c:out value="${serviceCall.unit.tenant.lastName}" /><br>
		    			<c:forEach var="phoneNumber" items="${serviceCall.unit.tenant.phoneNumbers}">
		    				<c:out value="${phoneNumber.phoneType}" />: <c:out value="${phoneNumber.phoneNumber}" /><br>
		    			</c:forEach>
		    	 	</td>
			  		<td>
		    			<c:out value="${serviceCall.reachTime}" />
		    	 	</td>		    	 	
			  		<td>
		    			<c:out value="${serviceCall.serviceCallDetail}" />
		    	 	</td>		    		
		    	</tr>
		    			 	

			</c:forEach>
		    </table>
			 	

		    
		<!-- end .content --></div>
	
	</jsp:attribute>
</my:person>