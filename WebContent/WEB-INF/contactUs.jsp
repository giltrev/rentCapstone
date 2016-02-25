<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
 
		<h2>Contact Us</h2>
			
	<form class="form-horizontal" action="AddContact" method="post">
		<div class="form-group">
	    	<label for="fullName" class="col-sm-2 control-label">Full Name</label>
		    <div class="col-sm-10">
				<input type="text" class="form-control" name="fullName" placeholder="Full Name">
		    </div>
	  	</div>
	  	<div class="form-group">
	    	<label for="email" class="col-sm-2 control-label">Email</label>
		    <div class="col-sm-10">
				<input type="text" class="form-control" name="email" placeholder="email">
		    </div>
	  	</div>
	  	<div class="form-group">
	    	<label for="phone" class="col-sm-2 control-label">Phone</label>
		    <div class="col-sm-10">
				<input type="text" class="form-control" name="phone" placeholder="Phone">
		    </div>
	  	</div>
	  	<div class="form-group">
	    	<label for="city" class="col-sm-2 control-label">City</label>
		    <div class="col-sm-10">
				<input type="text" class="form-control" name="city" placeholder="City">
		    </div>
	  	</div>	
	  	<div class="form-group">
	    	<label for="state" class="col-sm-2 control-label">State</label>
		    <div class="col-sm-10">
				<input type="text" class="form-control" name="state" placeholder="State">
		    </div>
	  	</div>	
		<div class="form-group">
		<label for="comments" class="col-sm-2 control-label">Comments</label>
			<div class="col-sm-10">
				<textarea class="form-control" name='comments' rows="3"></textarea>
			</div>
		</div>
		 <input type="submit" value="SubmitForm">
	</form>
		
		<!-- end .content --></div>
	</jsp:attribute>
</my:layout>