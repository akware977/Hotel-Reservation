<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Index</title>

<!-- Data Table Start -->  
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<!-- Data Table END -->

<script>
	$(document).ready(function() {
	$('#example').DataTable( {
		"order": [],
		"scrollX": true,
		"pageLength": 10
		});
	});
</script>

<!-- Date Picker -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<script>
  $( function() {
    var dateFormat = "yyyy-mm-dd",
      from = $( "#checkindate" )
        .datepicker({
          minDate : 0,
          defaultDate: "+1w",
          changeMonth: true,
          numberOfMonths: 2
        })
        .on( "change", function() {
          to.datepicker( "option", "minDate", getDate( this ) );
        }),
      to = $( "#checkoutdate" ).datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 2
      })
      .on( "change", function() {
        from.datepicker( "option", "maxDate", getDate( this ) );
      });
 
    function getDate( element ) {
      var date;
      try {
        date = $.datepicker.parseDate( dateFormat, element.value );
      } catch( error ) {
        date = null;
      }
 
      return date;
    }
  } );
  </script>
 <!-- Date Picker -->

</head>
<body>
	
	User Index page<br/><br/>
	
	
	<div>
	<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
		<h2>Select Check In-Out Dates</h2>
		
		<form action="${path}/searchrooms" method="post">
			<input type="hidden" id="userid" name="userid" value="1" >
			<label for="checkindate">CheckIn</label>
			<input type="text" id="checkindate" name="checkindate" autocomplete="off" >
			<label for="to">CheckOut</label>
			<input type="text" id="checkoutdate" name="checkoutdate" autocomplete="off" >
			<input type="submit" value="Submit Dates" />
		</form>
	
	</div>
	<br/><br/>
	<table id="example" class="display" style="width:100% ">
        <thead>
            <tr>
                <th> Room No </th>
                <th> Room Type </th>
                <th> Capacity <i class="fa fa-bed" aria-hidden="true"></i> </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${roomslist}" var="rooms">
            <tr>
                <td> ${rooms.roomno} </td>
                <c:set var="roomtype" value="${rooms.roomType}"></c:set> 
                <td> ${roomtype.roomtype} </td>
                <td> ${roomtype.capacity}  </td>
            </tr>
        </c:forEach>
        </tbody>        
        
     </table>

     
<script type="text/javascript">
	$(document).ready(function() {
	    $('#example').DataTable();
	} );
</script>


        
        
</body>
</html>