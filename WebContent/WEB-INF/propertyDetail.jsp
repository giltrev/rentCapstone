<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
			<c:if test="${property.propAddress2 != null}">
				<h3> <c:out value="${property.propName}" /></h3>
			</c:if>
			
			<h4><c:out value="${property.propAddress1}" /></h4>
			<p>
				<c:if test="${property.propAddress2 != null}">
					<c:out value="${property.propAddress2}" /><br />
				</c:if>
				<c:out value="${property.propCity}" />, <c:out value="${property.propState}" />  <c:out value="${property.propZip}" /><br />
				Property Type: <c:out value="${property.propertyType}" /><br />
				Number of Units: <c:out value="${property.numberOfUnits}" /><br />
				Commission: <c:out value="${property.commission}" /><br />
				Occupancy Rate:<c:out value="${property.ocupandyRate}" />
			</p>
			
			<table>
					<tr>
						<th>Unit ID</th>
						<th>Unit Number</th>
						<th>Bedrooms</th>
						<th>Baths</th>
						<th>Rent Rate</th>
						<th>Square Feet</th>
						<th>Floor Plan</th>
					</tr>
				<c:forEach var="unit" items="${property.units}">
					<tr>
						<td><c:out value="${unit.unitId}" /> </td>
					 	<td><c:out value="${unit.unitNumber}" /> </td>
					 	<td><c:out value="${unit.numberOfBedrooms}" /> </td>
					 	<td><c:out value="${unit.numberOfBathrooms}" /> </td>
					   	<td><c:out value="${unit.rentRate}" /> </td>
					    <td><c:out value="${unit.squareFootage}" /> </td>
						<td><c:out value="${unit.floorplan}" /> </td>
					</tr>
				</c:forEach>
			</table>

		<!-- end .content --></div>
	</jsp:attribute>
</my:propManager>