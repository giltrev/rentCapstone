<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
			<p>
				Current User <c:out value="${propManager.firstName}" /> <c:out value="${propManager.lastName}" /> 
			</p>
 
		<h2>Add Tenant</h2>
			
	<form action="AddTenant" method="post">
		<p>
		First Name:<br /><input name="firstName" type="text"  size="40" /><br />
		Middle Name:<br /><input name="middleName" type="text"  size="40" /><br />
		Last name:<br /><input name="lastName" type="text" size="40" /><br />
		Active<input type="radio" name="activePerson" value="true" checked="checked"/><br />
		Inactive<input type="radio" name="activePerson" value="false" />  <br />
		First Name:<br /><input name="firstName" type="text"  size="40" /><br />
		Lease Start Date:<br /><input name="leaseStartDate" type="text"  size="40" /><br />
		Lease End Date:<br /><input name="leaseExpirationDate" type="text"  size="40" /><br />
		Driver's License Number:<br /><input name="dlNumber" type="text"  size="40" /><br />
		Driver's License State:<br /><input name="dlNumberState" type="text"  size="40" /><br />
		Property:<br /><input name="property" type="text"  size="40" /><br />
		Unit:<br /><input name="unitId" type="text"  size="40" /><br />
		
		
		
		</p>
		
			<h4>Email Address</h4>
			<table>

			<tr>
				<td>
					Email Address Type:<br />
						<select name=emailAddressType>
						      <option value="Work" >Work</option>
						      <option value="Home" selected="selected">Home</option>
						      <option value="Other">Other</option>
					    </select><br />
					Email Address:<br /><input name="emailAddress" type="text"  size="40" /><br />
					Primary:<input type="radio" name="primaryEmail" value="0" checked="checked"/>  <br />
				</td>

			
				<td>
					Email Address Type:<br />
						<select name=emailAddressType>
						      <option value="Work" selected="selected">Work</option>
						      <option value="Home" >Home</option>
						      <option value="Other">Other</option>
					    </select><br />
					Email Address:<br /><input name="emailAddress" type="text"  size="40" /><br />
					Primary:<input type="radio" name="primaryEmail" value="1" />  <br />
				</td>

		
				<td>
					Email Address Type:<br />
						<select name=emailAddressType>
						      <option value="Work" >Work</option>
						      <option value="Home" >Home</option>
						      <option value="Other" selected="selected">Other</option>
					    </select><br />
					Email Address:<br /><input name="emailAddress" type="text"  size="30" /><br />
					Primary:<input type="radio" name="primaryEmail" value="2" />  <br />
				</td>
			</tr>			
		</table>
		<h4>Phone Number</h4>
		<table>
			<tr>
				<td>
					Phone Number Type:<br />
						<select name=phoneType>
							<option value="Cell" selected="selected">Cell</option>
						    <option value="Work" >Work</option>
						  	<option value="Home" >Home</option>
							<option value="Other">Other</option>
					    </select><br /><br />
					Phone Number:<br /><input name="phoneNumber" type="text"  size="30" /><br />
					Primary:<input type="radio" name="primaryNumber" value="0" checked="checked" />  <br />
				</td>

				<td>
					Phone Number Type:<br />
						<select name=phoneType>
							<option value="Cell" >Cell</option>
						    <option value="Work"selected="selected" >Work</option>
						  	<option value="Home" >Home</option>
							<option value="Other">Other</option>
					    </select><br /><br />
					Phone Number:<br /><input name="phoneNumber" type="text"  size="30" /><br />
					Primary:<input type="radio" name="primaryNumber" value="1" />  <br />
				</td>

				<td>
					Phone Number Type:<br />
						<select name=phoneType>
							<option value="Cell" >Cell</option>
						    <option value="Work" >Work</option>
						  	<option value="Home" selected="selected">Home</option>
							<option value="Other">Other</option>
					    </select><br /><br />
					Phone Number:<br /><input name="phoneNumber" type="text"  size="30" /><br />
					Primary:<input type="radio" name="primaryNumber" value="2" />  <br />
				</td>
			</tr>
		</table>
	
	<h4>Previous Mailing Address</h4>
		<table>

			<tr>
				<td>
					AddressType<br />
						<select name="addressType">
						  	<option value="Previous" selected="selected">Previous</option>
					    </select><br /><br />
					
					
					Address1:<br /><input name="address1" type="text"  size="30" /><br />
					Address2:<br /><input name="address2" type="text"  size="30" /><br />
					City:<br /><input name="city" type="text" size="20" /><br />
					State:<br /><input name="state" type="text" size="15" /><br />
					Zip Code:<br /><input name="zip" type="text" size="15" /><br />
				</td>
				
			</tr>						
		</table>
		 <input type="submit" value="Add Tennat">
	</form>
		
		<!-- end .content --></div>
	</jsp:attribute>
</my:layout>