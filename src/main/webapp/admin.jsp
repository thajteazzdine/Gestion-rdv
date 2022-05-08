<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Admin page</title>
  <link rel="icon" type="image/png" href="assets/icons/favicon.ico"/>
  <link rel="stylesheet" type="text/css" href="assets/css/lib/bootstrap.css">
  <script type="text/javascript" src="assets/js/lib/jquery-3.5.1.js"></script>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("username")==null) {
	response.sendRedirect("login.jsp");
} %>
  <div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="navbar-brand">WELCOME ADMIN</div>
		  <div class="collapse row justify-content-end mx-3 navbar-collapse" id="navbarSupportedContent">
		    <form class="form-inline my-2 my-lg-0" action="search" method ="post">
		      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="idOrName">
		      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		    </form>
		    <form class="form-inline my-2 my-lg-0" action="logout" >
		      <button class="btn btn-outline-info my-3 my-sm-0" type="submit">logout</button>
		    </form>
		  </div>
		</nav>

    <div class="input-group my-3">
        <div class="input-group-prepend ">
          <a href="nouveauRDV.jsp"><button type="button" class="btn btn-info">nouveau rendez-vous</button></a>
        </div>
    </div>
    <table class="table">
      <thead class="thead-light">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Date</th>
          <th scope="col">Time</th>
          <th scope="col">Nom Docteur</th>
          <th scope="col">Nom du patient</th>
          <th scope="col">Email</th>
          <th scope="col">Description</th>
          <th scope="col">Action</th>
        </tr>
      </thead>
     <tbody>
      <c:forEach items="${lists}" var="s">
          <tr>
            <th scope="row">${s.rdvID}</th>
            <td>${s.date}</td>
            <td>${s.time}</td>
            <td>${s.nomD}</td>
            <td>${s.nomP}</td>
            <td>${s.email}</td>
            <td>${s.description}</td>
            <td><a href="Delete?action=${s.rdvID}"><button type="button" class="btn btn-outline-info mx-2">supprimer</button></a></td>
          </tr>
      </c:forEach>
       </tbody>
    </table>
  </div>

</body>
</html>