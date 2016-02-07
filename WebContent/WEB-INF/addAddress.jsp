<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
<p>
			<h2><c:out value="${owner.firstName}" /> <c:out value="${owner.middleName}" /> <c:out value="${owner.lastName}" /></h2>
			
 
		<h2>Addresses</h2>
			
		<form action="AddAddress" method="post">
		<input type="hidden" name="personId" value='<c:out value="${owner.personId}"/>' />
		<table width="696" border="0" cellspacing="10" cellpadding="4">
			<tr>
			    <th width="69" align="left" scope="col">Primary</th>
			    <th width="133" align="left" scope="col">Address Type</th>
			    <th width="467" align="left" scope="col">Address</th>
		  	</tr>
		  </table>
	<table id="addressTable" width="696" border="0" cellspacing="10" cellpadding="4"> 
		<c:forEach var="address" varStatus="status" items="${owner.addresses}">
	    	<input type="hidden" name ="addressId"  value='<c:out value="${address.addressId}"/>' />
	  		<tr<c:if test="${address.primaryAddress==true}"> class="primary" </c:if>>
	    		<td align="center" valign="top">
	    			
	    		</td>
	    		
				  <td valign="top">
					  	
					  	<c:out value="${address.addressType }" />
					
				 </td> 
				 <td valign="top">
				 	Address1 :
				 	<c:out value="${address.address1}" />
				    <br />
					Address2 :
					<c:out value="${address.address2}" />
					<br />
					City:
					<c:out value="${address.city}" />
					<br />
					State:
					<c:out value="${address.state}" />
					<br />
					Zip:
					<c:out value="${address.zip}" />
				</td> 
			</tr>
		</c:forEach>
			<tr>
	    		<td align="center" valign="top">
	    			
	    			<input type="radio" name="primaryAddress" value="true" />
	    		</td>
				  <td valign="top">
					  	<select name="addressType">
						      <option value="Work" >Work</option>
						      <option value="Home">Home</option>
						      <option value="Other">Other</option>
					    </select>
				 </td> 
				 <td valign="top">
				 	Address1 :
				 	<input type="text" name="address1" size="40" />
				    <br />
					Address2 :
					<input type="text" name="address2" size="40" />
					<br />
					City:
					<input type="text" name="city" size="40" />
					<br />
					State:
					<input type="text" name="state" size="40" />
					<br />
					Zip:
					<input type="text" name="zip" size="40"/>
				</td> 
			</tr>

	</table>
	<p>
		<input type="submit" value="submit" />
	</p>

</form>
		
		<!-- end .content --></div>
	</jsp:attribute>
</my:propManager>