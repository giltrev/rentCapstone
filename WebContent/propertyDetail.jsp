<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${property.propName}" /> <c:out value="${property.propAddress1}" /></title>
<link href="main.css" rel="stylesheet" type="text/css" media="screen">
</head>
<body>
<div class="container">

<jsp:include page="maininsert.jsp" />



  <div class="content">
<c:if test="${property.propAddress2 != null}">
   		<h1> <c:out value="${property.propName}" /></h1>
</c:if>

<h2><c:out value="${property.propAddress1}" /></h2>
<p><c:if test="${property.propAddress2 != null}">
   		 <c:out value="${property.propAddress2}" /><br />
</c:if>
<c:out value="${property.propCity}" />, <c:out value="${property.propState}" />  <c:out value="${property.propZip}" /><br />

Property Type: <c:out value="${property.propertyType}" /><br />
Number of Units: <c:out value="${property.numberOfUnits}" /><br />
Commission: <c:out value="${property.commission}" /><br />
Occupancy Rate:<c:out value="${property.ocupandyRate}" /></p>

<table>
<tr>
<th>Unit ID</th>
<th>Unit Number</th>
<th>Number of Bedrooms</th>
<th>Number of Baths</th>
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
  <div class="footer">
    <p>This .footer contains the declaration position:relative; to give Internet Explorer 6 hasLayout for the .footer and cause it to clear correctly. If you're not required to support IE6, you may remove it.</p>
    <!-- end .footer --></div>
<!-- end .container --></div>
</body>
</html>