<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Units for <c:out value="${property.propAddress1}" /></title>
    <link href="main.css" rel="stylesheet" type="text/css" media="screen">
</head>
<body>
<div class="container">

<jsp:include page="maininsert.jsp" />



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
  <div class="footer">
    <p>This .footer contains the declaration position:relative; to give Internet Explorer 6 hasLayout for the .footer and cause it to clear correctly. If you're not required to support IE6, you may remove it.</p>
    <!-- end .footer --></div>
<!-- end .container --></div>



</body>
</html>