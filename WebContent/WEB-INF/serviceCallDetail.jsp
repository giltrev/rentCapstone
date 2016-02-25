<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
			
			
			<c:out value="${tenant.firstName}" /> your service call has been placed
		    <c:out value="${tenant.unit.property.propAddress1}" /> # <c:out value="${tenant.unit.unitNumber}" /><br>
		    <c:out value="${tenant.unit.property.propCity}" /> <c:out value="${tenant.unit.property.propState}" /> <c:out value="${tenant.unit.property.propZip}" />
		     
		     Services Needed / Comments <br>
			<c:out value="${serviceCall.serviceCallDetail}" /><br>
			Image(s)<br>
			<c:forEach var="picture" items="${serviceCall.pictures}">
			<img  alt="Image" src="displayImage?id=<c:out value="${picture.picId}" />">	<br>	
			<img  alt="Image" src="displayImage?id=2">	<br>	
			</c:forEach>
			
			
			<c:if test="${serviceCall.vendors!=null}"> 
			
			Vendor(s)<br>
			<c:forEach var="vendor" items="${serviceCall.vendors}">
			<c:out value="${vendor.companyName}" /><br>		
			</c:forEach>
		
			</c:if>
			

		<!-- end .content --></div>
	</jsp:attribute>
</my:layout>