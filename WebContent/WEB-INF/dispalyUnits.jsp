<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
		  <h2><c:out value="${property.propName}" /> <c:out value="${property.propAddress1}" /> </h2>
		
			<c:forEach var="unit" items="${property.units}">
			 	<c:out value="${unit.unitNumber}" /> <br />
			 	<c:out value="${unit.numberOfBedrooms}" /> <br />
			 	<c:out value="${unit.numberOfBathrooms}" /> <br />
			   	<c:out value="${unit.rentRate}" /> <br />
			    <c:out value="${unit.squareFootage}" /> <br />
				<c:out value="${unit.floorplan}" /> <br />
			</c:forEach>
		
		<!-- end .content --></div>
	</jsp:attribute>
</my:layout>