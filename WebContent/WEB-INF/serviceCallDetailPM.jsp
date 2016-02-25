<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
			
			
			<c:out value="${serviceCall.reportedBy.firstName}" /> <c:out value="${serviceCall.reportedBy.lastName}" /> <br>
		    <c:out value="${serviceCall.unit.property.propAddress1}" /> # <c:out value="${serviceCall.unit.unitNumber}" /><br>
		    <c:out value="${serviceCall.unit.property.propCity}" /> <c:out value="${serviceCall.unit.property.propState}" /> <c:out value="${tenant.unit.property.propZip}" /><br>
		     
		     Services Needed / Comments <br>
			<c:out value="${serviceCall.serviceCallDetail}" /><br>
			
			<c:if test="${serviceCall.pictures!=null}"> 
				Image(s)<br>
				<c:forEach var="picture" items="${serviceCall.pictures}">
				<img  alt="Image" src="displayImage?id=<c:out value="${picture.picId}" />">	<br>		
				</c:forEach>
			</c:if>
			
			<c:if test="${serviceCall.vendors!=null}"> 
			
			Vendor(s)<br>
			<c:forEach var="vendor" items="${serviceCall.vendors}">
			
			<c:out value="${vendor.firstName}" /> <c:out value="${vendor.lastName}" /><br>	
			<c:out value="${vendor.companyName}" /><br>	
			
			<img  alt="Image" src="displayImage?id=<c:out value="${vendor.picture.picId}" />">	<br>	
			</c:forEach>
		
			</c:if>
			

		<!-- end .content --></div>
	</jsp:attribute>
</my:propManager>