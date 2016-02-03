<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
			<h2>Edit Owner</h2>
			
			<div class="person">
		
<form action="EditOwner" method="post">
	<input type="hidden" name="personId" value='<c:out value="${person.personId}"/>' />
	<p>
		First Name:<br /><input name="firstName" type="text" value="<c:out value="${person.firstName}" />" size="40" /><br />
		Middle Name:<br /><input name="middleName" type="text" value="<c:out value="${person.middleName}" />" size="40" /><br />
		Last name:<br /><input name="lastName" type="text" value="<c:out value="${person.lastName}" />" size="40" /><br />
		Active<input type="radio" name="activePerson" value="true" <c:if test="${person.activePerson==true}"> checked</c:if> />
		Inactive<input type="radio" name="activePerson" value="false" <c:if test="${person.activePerson==false}"> checked </c:if> />  
	</p>

		<h2>Addresses</h2>
		<table width="696" border="0" cellspacing="10" cellpadding="4">
			<tr>
			    <th width="69" align="left" scope="col">Primary</th>
			    <th width="133" align="left" scope="col">Address Type</th>
			    <th width="467" align="left" scope="col">Address</th>
		  	</tr>
		  </table>
	<table id="addressTable" width="696" border="0" cellspacing="10" cellpadding="4"> 
		<c:forEach var="address" varStatus="status" items="${person.addresses}">
	    	<input type="hidden" name ="addressId"  value='<c:out value="${address.addressId}"/>' />
	  		<tr<c:if test="${address.primaryAddress==true}"> class="primary"</c:if>>
	    		<td align="center" valign="top">
	    			
	    			<c:out value="${status.index}" /> <input type="radio" name="primaryAddress" value="<c:out value="${status.index}" />" <c:if test="${address.primaryAddress==true}"> checked</c:if> />
	    		</td>
				  <td valign="top">
					  	<select name="addressType">
						      <option value="Work" <c:if test="${address.addressType=='Work' }"> selected</c:if>>Work</option>
						      <option value="Home" <c:if test="${address.addressType=='Home' }"> selected</c:if>>Home</option>
						      <option value="Other" <c:if test="${address.addressType=='Other' }"> selected</c:if>>Other</option>
					    </select>
				 </td> 
				 <td valign="top">
				 	Address1 :
				 	<input type="text" name="address1" size="40" value='<c:out value="${address.address1}" />' />
				    <br />
					Address2 :
					<input type="text" name="address2" size="40" value='<c:out value="${address.address2}" />' />
					<br />
					City:
					<input type="text" name="city" size="40" value='<c:out value="${address.city}" />' />
					<br />
					State:
					<input type="text" name="state" size="40" value='<c:out value="${address.state}" />' />
					<br />
					Zip:
					<input type="text" name="zip" size="40" value='<c:out value="${address.zip}" />' />
				</td> 
			</tr>
		</c:forEach>
	</table>
	
	<h2>Email Addresses</h2>

	
	<table>
		  <tr>
			    <th width="85" align="left" scope="col">Primary</th>
			    <th width="120" align="left" scope="col">Email Type</th>
			    <th width="385" align="left" scope="col">email Address</th>
		  </tr>
	</table>  
	<table id="emailTable" class= "tableContext">  
		 <c:forEach var="email" varStatus="status" items="${person.emailAddresses}">
		 	<c:if test="${email.emailAddressId != null}">
		   		<input type="hidden" name ="emailAddressId"  value='<c:out value="${email.emailAddressId}"/>' />
		 	</c:if>
		 	 <c:if test="${email.emailAddressId == null}">
		   		<input type="hidden" name ="emailAddressId"  value= "0" />
		 	</c:if>
			<tr<c:if test="${email.primaryEmail==true}"> class="primary"</c:if>>
		  	    <td>
			  	    
			  	    <c:out value="${status.index}" /> <input type="radio" name="primaryEmail"  value="<c:out value="${status.index}" />" <c:if test="${email.primaryEmail==true}"> checked</c:if> />
				</td>
			    <td>
					<select name="emailAddressType">
			   			  <option value="Work" <c:if test="${email.emailAddressType=='Work' }"> selected</c:if>  >Work</option>
			    		  <option value="Home" <c:if test="${email.emailAddressType=='Home' }"> selected</c:if>   >Home</option>
			    		  <option value="Other" <c:if test="${email.emailAddressType=='Other' }"> selected</c:if>   >Other</option>
			    	</select>
				</td>
				<td>
					<input name="emailAddress" type="text" size="40" value='<c:out value="${email.emailAddress}" />' />
				</td>
		   </tr>
		  </c:forEach>
	  </table>
	
	<h2>Phone Numbers</h2>
	<table width="600" border="0" cellspacing="1" cellpadding="1">
		  <tr>
			    <th width="85" align="left" scope="col">Primary</th>
			    <th width="123" align="left" scope="col">Phone Type</th>
			    <th width="382" align="left" scope="col">Phone Number</th>
		  </tr>
	</table>
	<table id="phoneTable" width="600" border="0" cellspacing="1" cellpadding="1">
		  	<c:forEach var="phoneNumber" varStatus="status" items="${person.phoneNumbers}">
				  <input type="hidden" name ="phoneNumberId"  value='<c:out value="${phoneNumber.phoneNumberId}"/>' />
				  <tr<c:if test="${phoneNumber.primaryNumber==true}"> class="primary"</c:if>>
				    	<td>
					 	   	<c:out value="${status.index}" /> <input type="radio" name="primaryNumber" value="<c:out value="${status.index}" />" <c:if test="${phoneNumber.primaryNumber==true}"> checked</c:if> />
					    </td>
					    <td>
							<select name="phoneType">
					      			<option value="Work" <c:if test="${phoneNumber.phoneType=='Work' }"> selected</c:if>  >Work</option>
					     	 		<option value="Home" <c:if test="${phoneNumber.phoneType=='Home' }"> selected</c:if>  >Home</option>
					    		  	<option value="Other" <c:if test="${phoneNumber.phoneType=='Other' }"> selected</c:if>  >Other</option>
					    	</select>
						</td>
					    <td>
							<input name="phoneNumber" type="text" value='<c:out value="${phoneNumber.phoneNumber}" /> ' />
						</td>
				  </tr>
		</c:forEach>
	</table>
		

	<p>
		<input type="submit" value="submit" />
	</p>

</form>

<!-- end .person --></div>	

		<!-- end .content --></div>
	</jsp:attribute>
</my:layout>