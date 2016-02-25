<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:tenant>
	<jsp:attribute name="body">
		<div class="content">
		    
		    
		    <c:out value="${tenant.firstName}" /> <c:out value="${tenant.lastName}" /><br>
		    <c:out value="${tenant.unit.property.propAddress1}" /> # <c:out value="${tenant.unit.unitNumber}" /><br>
		    <c:out value="${tenant.unit.property.propCity}" /> <c:out value="${tenant.unit.property.propState}" /> <c:out value="${tenant.unit.property.propZip}" />
		    
		    <form method="post" action="CreateServiceCall" enctype="multipart/form-data">
				<label for="createServiceCall">Best time to reach you</label>
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
			    <label for="exampleInputFile">Picture Upload</label>
			    <input type="file" name="photo"  ><br>
			    <input type="file" name="photo" ><br>
			    <input type="file" name="photo" ><br>
			    
			   
			  </div>

			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		     
		    
		   
		    
		    
		    
		<!-- end .content --></div>
	
	</jsp:attribute>
</my:tenant>