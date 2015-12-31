<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><c:out value="${vendor.companyName}" /> </title>

    <link href="main.css" rel="stylesheet" type="text/css" media="screen">
</head>
<body>
<div class="container">

<jsp:include page="maininsert.jsp" />



  <div class="content">
<p><a href='EditOwnerRedirect?personId=<c:out value="${vendor.personId}" />'>editOwner</a>


  <h2><c:out value="${vendor.firstName}" /> <c:out value="${vendor.middleName}" /> <c:out value="${vendor.lastName}" /></h2>
 <c:out value="${vendor.companyName}" /> <br />
 <c:out value="${vendor.vendorType}" /> 
 
 <h2>Addresses</h2>  
 
<c:forEach var="address" items="${vendor.addresses}">
	 	<p><c:if test="${address.primaryAddress==true}">
   			Primary Address<br />
		</c:if>
<c:out value="${address.addressType}" /> Address<br />
 	<c:out value="${address.address1}" /> <br />
 <c:if test="${address.address2.length() != 0}">
   		 <c:out value="${address.address2}" /><br />
 	</c:if>
  	<c:out value="${address.city}" />, <c:out value="${address.state}" />  <c:out value="${address.zip}" />  </p>
</c:forEach>
 
  <h2>Email Addresses</h2>
 <c:forEach var="email" items="${vendor.emailAddresses}">
  <c:out value="${email.emailAddressType}" /> <c:out value="${email.emailAddress}" /><br />
   </c:forEach>
     <h2>Phone Numbers</h2>
 <c:forEach var="pNumber" items="${vendor.phoneNumbers}">
  <c:out value="${pNumber.phoneType}" /> <c:out value="${pNumber.phoneNumber}" /><br />
   </c:forEach>
   
 


    <!-- end .content --></div>
  <div class="footer">
    <p>This .footer contains the declaration position:relative; to give Internet Explorer 6 hasLayout for the .footer and cause it to clear correctly. If you're not required to support IE6, you may remove it.</p>
    <!-- end .footer --></div>
<!-- end .container --></div>


</body>
</html>