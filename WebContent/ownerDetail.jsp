<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><c:out value="${owner.firstName}" /> <c:out value="${owner.lastName}" /></title>
  	<meta name="robots" content="noindex,nofollow">
	<meta name="description" content="Class Assignemnt.">
	<meta name="keywords" content="homework, assignments">
    <link href="main.css" rel="stylesheet" type="text/css" media="screen">
</head>
<body>
<div class="header">
  
      <h1>Property management</h1>
  
  </div>
  
  <div class="nav"> 
      Home Screen | Owners | Properties | Units | Tenants | Service Calls | Vendors
  </div>

  <div class="content">

  <h2><c:out value="${owner.firstName}" /> <c:out value="${owner.middleName}" /> <c:out value="${owner.lastName}" /></h2>
 
 <c:forEach var="email" items="${owner.emailAddresses}">
  <c:out value="${email.emailAddressType}" /> <c:out value="${email.emailAddress}" /><br />
   </c:forEach>
   
<c:forEach var="address" items="${owner.addresses}">
	 	<c:if test="${address.primaryAddress==true}">
   			<h3>Primary Address</h3>
		</c:if>
   	<c:out value="${address.addressType}" /> <br />
 	<c:out value="${address.address1}" /> <br />
 <c:if test="${address.address2.length() != 0}">
   		 <c:out value="${address.address2}" /><br />Address2
 	</c:if>
  	<c:out value="${address.city}" />, <c:out value="${address.state}" />  <c:out value="${address.zip}" />  <br />
</c:forEach>

<c:forEach var="property" items="${owner.properties}">
  <c:out value="${property.address1}" /> <c:out value="${property.propertyType}" /><br />
   </c:forEach>

  </div>


</body>
</html>