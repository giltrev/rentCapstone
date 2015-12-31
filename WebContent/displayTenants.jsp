<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Properties</title>
    <link href="main.css" rel="stylesheet" type="text/css" media="screen">
</head>
<body>
<div class="container">

<jsp:include page="maininsert.jsp" />



  <div class="content">
 <ul> 
<c:forEach var="tenant" items="${allTenants}">

<li><strong><a href="TenantDetail?personId=<c:out value="${tenant.personId}" />"> <c:out value="${tenant.firstName}" /> <c:out value="${tenant.middleName}" /> <c:out value="${tenant.lastName}" /></a></strong><br />
<c:out value="${tenant.unit.property.propAddress1}" /> <c:out value="${tenant.unit.unitNumber}" /></li>


</c:forEach>
</ul>



<!-- end .content --></div>
  <div class="footer">
    <p>This .footer contains the declaration position:relative; to give Internet Explorer 6 hasLayout for the .footer and cause it to clear correctly. If you're not required to support IE6, you may remove it.</p>
    <!-- end .footer --></div>
<!-- end .container --></div>



</body>
</html>