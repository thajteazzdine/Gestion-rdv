<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
	<title>login</title>
	<link rel="icon" type="image/png" href="assets/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="assets/css/login.css">
  	<link rel="stylesheet" type="text/css" href="assets/css/lib/bootstrap.css">
  	<script type="text/javascript" src="assets/js/lib/jquery-3.5.1.js"></script>
</head>
<body>

	<div class="wrapper fadeInDown">
  		<div id="formContent">
	   		 <div class="fadeIn first">
	      		<a href=""></a>
	    	 </div>
			    <form action="Login" method = "post">
			      <input type="text" id="login" class="fadeIn second" name="user" placeholder="utilisateur">
			      <input type="password" id="password" class="fadeIn third" name="pass" placeholder="password">
			      <input type="submit" class="fadeIn fourth" value="Log In">
			    </form>
		    <div id="formFooter">
		      <a class="underlineHover text-danger fadeIn fourth" ><c:out value="${state}"></c:out></a>

		    </div>
		</div>
	</div>

</body>
</html>