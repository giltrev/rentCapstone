<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Display Vendors</title>
  	<meta name="robots" content="noindex,nofollow">
	<meta name="description" content="Class Assignemnt.">
	<meta name="keywords" content="homework, assignments">
    <link href="main.css" rel="stylesheet" type="text/css" media="screen">
</head>
<body>
<div class="container">

<jsp:include page="maininsert.jsp" />



  <div class="content">
  <h2>Vendors</h2>
  <ul>
<c:forEach var="vendor" items="${allVendors}">
<li><a href="VendorDetail?personId=<c:out value="${vendor.personId}" />">  <c:out value="${vendor.firstName}" /> <c:out value="${vendor.middleName}" /> <c:out value="${vendor.lastName}" /></a></li>
</c:forEach>
  </ul>
<!-- end .content --></div>
  <div class="footer">
    <p>This .footer contains the declaration position:relative; to give Internet Explorer 6 hasLayout for the .footer and cause it to clear correctly. If you're not required to support IE6, you may remove it.</p>
    <!-- end .footer --></div>
<!-- end .container --></div>



</body>
</html>