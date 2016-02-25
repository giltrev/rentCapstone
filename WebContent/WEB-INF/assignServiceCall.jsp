<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
		    <p class="lead.less">
		    
		  	<strong><c:out value="${serviceCall.reportedBy.firstName}" /> <c:out value="${serviceCall.reportedBy.lastName}" /></strong><br>
		    <c:out value="${serviceCall.unit.property.propAddress1}" /> # <c:out value="${serviceCall.unit.unitNumber}" /><br>
		    <c:out value="${serviceCall.unit.property.propCity}" /> <c:out value="${serviceCall.unit.property.propState}" /> <c:out value="${tenant.unit.property.propZip}" /><br>
		    </p>
		    
		     <p class="lead.less">
           <label for="vendor">Best time to reach tenant:</label><br>
                
                <c:out value="${serviceCall.reachTime}" />
            </p>
                
                <form method="post" action="AssignServiceCall"> 
                <input type="hidden" name="scId" value="<c:out value="${serviceCall.scId}" />"> 
                <label for="createServiceCall">Services Needed / Comments</label>
				<textarea class="form-control" name='serviceCallDetail'  rows="3"> <c:out value="${serviceCall.serviceCallDetail}" /></textarea>
                
                    <c:if test="${not empty serviceCall.pictures}"> 
						Image(s)<br>
						<c:forEach var="picture" items="${serviceCall.pictures}">
							<img height="150" alt="Image" src="displayImage?id=<c:out value="${picture.picId}" />">	<br>
						</c:forEach>
					</c:if>
             
	               
	            
	            
	            
	             <p class="lead.less">
	             <label for="vendor">Vendor:</label><br>
	            <select name="vendorId">
	           	<c:forEach var="vendor" items="${vendors}">
				<option value="<c:out value="${vendor.personId}" />" > <c:out value="${vendor.companyName}" /></option>
				</c:forEach>
				</select>
			</p>
	           	<input type="submit" value="Assign">
		 	</form>
		    
		    
		    
		    
		<!-- end .content --></div>
	
	</jsp:attribute>
</my:propManager>