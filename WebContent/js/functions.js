       
    $("document").ready(function() {
        document.getElementById("addEmailRow").addEventListener("click", function (evt) {
        	 $("#emailTable tr:last").clone().appendTo("#emailTable");
        });
        document.getElementById("remRow").addEventListener("click", function (evt) {
        	remRow();
        });

        function addEmailRow() {
        	
            $("#emailTable tr:last").clone().appendTo("#emailTable");
        	
        }
//			$("#emailTable tr:last").after("<tr><td> <input type='radio' name='primaryEmail' value='true' />" +
//					"</td>  <td> <select name='emailAddressType'>"+
//
//				   			 " <option value='Work'>Work</option>"+
//				    		 " <option value='Home'>Home</option>"+
//				    		  "<option value='Other' >Other</option>"+
//				    		  "</select></td>"+
//				    		  "<td><input name='emailAddress' type='text' size='40'  />' />"+
//				    		  "</td> </tr>");
//	    }
        
   /*      function remRwo() {
			var lastRow = $("#emailTable tr:last");
			$("#emailTable tr:last").after("<tr><td>inserted Row</td><td>inserted Row</td><td>inserted Row</td>");
	    } */
        function remRow() {
    		if($("#emailTable tr").length != 2)
    			{
    				$("#emailTable tr:last-child").remove();
    			}
    	   else
    			{
    				alert("You cannot delete first row");
    			}
    	};
	});