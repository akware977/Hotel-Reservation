<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>
<!-- Favicon -->
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<link rel="shortcut icon" type="image/x-icon" href="${path}/assets/img/favicon.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
.login-form {
    width: 340px;
    margin: 50px auto;
  	font-size: 15px;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
</style>
</head>
<body>

<div class="login-form">
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
    <form action="${path}/adduser" method="post">
        <h2 class="text-center">Register User</h2>    
        <div class="form-group">
           First Name <input type="text" class="form-control" name="fname" id="fname"  placeholder="first name" required="required">
        </div>
        <div class="form-group">
           Last Name <input type="text" class="form-control" name="lname" id="lname"  placeholder="last name" required="required">
        </div>
        <div class="form-group">
           Password <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Password" required="required">
        </div>
        <div class="form-group">
           Email <input type="email" class="form-control" name="email" id="email"  placeholder="email" required="required">
        </div>
        <div class="form-group">
           Mobile No <input type="text" class="form-control" name="mobileno" id="mobileno"  placeholder="mobile no" required="required">
        </div>
        <div class="form-group">
           <button type="submit" class="btn btn-primary btn-block"> Register </button>
        </div>
        <div align="center">
        	<a href="${path}/login"><i class="fa fa fa-sign-in"  style="font-size:30px; color:#3b5998" aria-hidden="true"></i></a>
        </div>
       
    </form>
    <!-- <p class="text-center"><a href="#">Create an Account</a></p> -->

    
</div>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-175203775-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-175203775-1');
</script>

</body>
</html>