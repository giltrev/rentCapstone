<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<my:vendor>
	<jsp:attribute name="body">
		<div class="content">
			<h4>Service Call <c:out value="${serviceCall.scId}" /></h4>
			<blockquote>
			<strong><c:out value="${serviceCall.reportedBy.firstName}" /> <c:out value="${serviceCall.reportedBy.lastName}" /></strong> <br>
		    <c:out value="${serviceCall.unit.property.propAddress1}" /> # <c:out value="${serviceCall.unit.unitNumber}" /><br>
		    <c:out value="${serviceCall.unit.property.propCity}" /> <c:out value="${serviceCall.unit.property.propState}" /> <c:out value="${tenant.unit.property.propZip}" /><br>
		     </blockquote>
		    
		    <label  for="servicesComments">Services Needed / Comments</label>
		    
			<blockquote>
				<c:out value="${serviceCall.serviceCallDetail}" />
			</blockquote>
			
			 <p>
			<c:if test="${serviceCall.pictures!=null}"> 
				
				<label  for="images">Image(s):</label>
				<blockquote>
				<div class="row-fluid">
				<div class="row">
				<c:forEach var="picture" items="${serviceCall.pictures}">
					
						<img  height="150" alt="Image" src="displayImage?id=<c:out value="${picture.picId}" />">	
					
				</c:forEach>
				</div>
				</div>
				</blockquote>
			</c:if>
			
			</p>
			
			<div class="row-fluid">
			<form method="post" action="EditServiceCallVendor"> 
			<input type="hidden" name="scId" value="<c:out value="${serviceCall.scId}" />"> 
			<input type="hidden" name="vendorId" value="<c:out value="${vendor.personId}" />"> 
			
			<label  for="status">Service Call Status</label>
				<select class="form-control" name="status" >
				  <option <c:if test="${serviceCall.status == 'Open'}" >selected</c:if> >Open</option>
				  <option <c:if test="${serviceCall.status == 'Assigned'}" >selected</c:if> >Assigned</option>
				  <option <c:if test="${serviceCall.status == 'In Progress'}" >selected</c:if> >In Progress</option>
				  <option <c:if test="${serviceCall.status == 'Waiting On Parts'}" >selected</c:if> >Waiting On Parts</option>
				  <option <c:if test="${serviceCall.status == 'Complete'}" >selected</c:if> >Complete</option>
				</select>
			
			<p></p>
		
				<div class="form-group">
				    <label for="partsCost">Parts Cost</label>
				    <div class="input-group">
				    
				      <input type="text" name = "partsCost" class="form-control"  value="<c:out value="${serviceCall.partsCost}" />">
				     
				    </div>
				</div>
				<div class="form-group">
				    <label  for="laborCost">Labor Cost</label>
				    <div class="input-group">
				     
				      <input type="text" name = "laborCost" class="form-control"  value="<c:out value='${serviceCall.laborCost}' />" >
				      
				     
				     
				    </div>
				</div>
			
			
				<div class="form-group">
					<label for="vendorComments">Vendor Comments</label>
					<textarea class="form-control" name='vendorComments' rows="3" ><c:out value="${serviceCall.vendorComments}" /></textarea>
				</div>
				
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
				
			</form>
			
			</div>

		<!-- end .content --></div>
	</jsp:attribute>
</my:vendor>