<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
		    
		    

		    
		    <form method="post" action="CreateServiceCallPM" enctype="multipart/form-data">
		    	
		    	  <div class="form-group">
				    <label for="reportedBy">Reported By </label>
					<select class="form-control" name="tenantId">
					  <c:forEach var="tenant" varStatus="status" items="${tenants}">
					  	<option value="<c:out value='${tenant.personId}' />">
					   <c:out value='${tenant.lastName}' />, <c:out value='${tenant.firstName}' />
					  	</option>
						</c:forEach>
					</select>
				  </div>
		    
				<label for="createServiceCallPM">Best time to reach tenant</label>
				<div class="radio">
				  <label>
				    <input type="radio" name="reachTime" id="ASAP" value="ASAP" checked>
				    ASAP
				  </label>
				</div> 
				<div class="radio">
				  <label>
				    <input type="radio" name="reachTime" id="Morning" value="Morning">
				   	Morning
				  </label>
				</div> 
				<div class="radio">
					<label>
					    <input type="radio" name="reachTime" id="Afternoon" value="Afternoon">
						Afternoon
					</label>
				</div> 
				<div class="radio">
					<label>
					    <input type="radio" name="reachTime" id="Night" value="Night">
						Night
					</label>
				</div>	
				
				
				<label for="createServiceCall">Services Needed / Comments</label>
				<textarea class="form-control" name='serviceCallDetail' rows="3"></textarea>
				
				<div class="form-group">
				    <label for="vendor">Assign Vendor </label>
					<select class="form-control" name="vendorId">
					  <c:forEach var="vendor" varStatus="status" items="${vendors}">
					  
					 
					  
					  	<option value="<c:out value='${vendor.personId}' />">
					   <c:out value='${vendor.companyName}' />,  <c:out value='${vendor.firstName}' /> <c:out value='${vendor.lastName}' />
					  	</option>
						</c:forEach>
					</select>
				  </div>
				

			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		     
		    

		    
		    
		    
		    
		<!-- end .content --></div>
	
	</jsp:attribute>
</my:propManager>