<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> User </title>

<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">

<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

</head>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
  <span class="w3-bar-item w3-right"><img src="assets/images/logo.png"/></span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="assets/images/avatar2.png" class="w3-circle w3-margin-right" style="width:46px">
    </div>
    <div class="w3-col s8 w3-bar">
      <span>Welcome, <strong>Username</strong></span>
    </div>
  </div>
  <hr>
  <div class="w3-container">
    <h5>Dashboard</h5>
  </div>
  <div class="w3-bar-block">
  	<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
    <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <a href="${path}/admin_index" class="w3-bar-item w3-button w3-padding"><i class="fa fa-home fa-fw"></i> Home </a>
    <a href="${path}/adminuser" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw"></i> User </a>
    <a href="${path}/rooms" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-bed fa-fw"></i> Rooms </a>
    <a href="${path}/rooms" class="w3-bar-item w3-button w3-padding"><i class="fa fa-newspaper-o fa-fw"></i> RoomType </a>
    <a href="${path}/bookings" class="w3-bar-item w3-button w3-padding"><i class="fa fa-tag fa-fw"></i> Bookings </a>
    <a href="${path}/logout" class="w3-bar-item w3-button w3-padding"><i class="fa fa-sign-out fa-fw"></i> Logout </a>
<br><br>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Rooms Page</b></h5>
  </header>
  
  <div class="w3-container">	
	<h4 style="color:red;" >${message} </h4>
	
	<form action="${path}/addrooms" method="post" >
		Room No : 	 <input type="text" name="roomno" id="roomno" value="${rooms.roomno}" placeholder="rooms no" <c:if test="${(rooms.roomno) == 0 }"> disabled </c:if> /><br/><br/>
		<label for="cars"> Room Type : </label>
		  
		  <select id="roomtype" name="roomtype">
		    <c:forEach items="${roomTypelist}" var="roomTypelist">
				<option value="${roomTypelist.roomtypeno}"> ${roomTypelist.roomtype} </option>
			</c:forEach>
		  </select>
		<br/><br/>
		<c:if test="${(rooms.roomno) != 0 }"> <input type="submit" value="Update Room type" /> </c:if>
		<c:if test="${(rooms.roomno) == 0 }"> <input type="submit" value="Add Room type" /> </c:if>
		
	</form>
	
	</div>
	<hr>
	
	<div class="w3-container">	 
	<table class="w3-table w3-striped w3-white">
			<tr>
				<th>Room No </th>
				<th>Room Type </th>
				<th>Last Checked Out Date </th>				
			</tr>
			<c:forEach items="${roomslist}" var="rooms">
			<tr>
				<td><a href="updaterooms?id=${rooms.roomno}" >${rooms.roomno} </a></td> 
				<td><c:set var="roomtype" value="${rooms.roomType}"></c:set> ${roomtype.roomtype}</td>
				<td>${rooms.lastCheckoutDate}</td>				
			</tr>
			</c:forEach>
	</table>
	</div>
	
	  <!-- Footer -->
  <footer class="w3-container w3-padding-16 w3-light-grey">
    <h4>FOOTER</h4>
  </footer>
  
</div>


<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}

// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script>

</body>
</html>