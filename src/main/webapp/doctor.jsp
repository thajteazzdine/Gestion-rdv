<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Welcome Dr</title>
  <link rel="icon" type="image/png" href="assets/icons/favicon.ico"/>
  <link rel="stylesheet" type="text/css" href="assets/css/lib/bootstrap.css">
  <script type="text/javascript" src="assets/js/lib/jquery-3.5.1.js"></script>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("username")==null) {
	response.sendRedirect("login.jsp");
}%>

  <div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="navbar-brand">WELCOME ${model.nomUtilisateur} </div>
      <div class="row justify-content-end">
        <form class="form-inline my-2 my-lg-0" action="logout">
		      <button class="btn btn-outline-info my-2 my-sm-0" type="submit">logout</button>
		    </form>
      </div>
     
    </nav>

    <div class="input-group my-5 px-3">
      
        <div class="input-group-prepend ">
          Vos prochains rendez-vous sont les suivants:

        </div>
    </div>
    <table class="table table-striped mt-5">
      <thead >
        <tr>
          <th scope="col">Date</th>
          <th scope="col">Time</th>
          <th scope="col">Nom du patient</th>
          <th scope="col">Description</th>
        </tr>
      </thead>
     <tbody>
      <c:forEach items="${listrdv}" var="li">
          <tr>
            <th scope="row">${li.date}</th>
            <td>${li.time}</td>
            <td>${li.nomP}</td>
            <td>${li.description}</td>
          </tr> 
      </c:forEach>
       </tbody>
    </table>
  </div>

</body>
</html>