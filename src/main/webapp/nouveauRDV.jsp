<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Ajouter un nouveau rdv</title>
  <link rel="stylesheet" type="text/css" href="assets/css/lib/bootstrap.css">
  <link rel="icon" type="image/png" href="assets/icons/favicon.ico"/>
  	<link rel="stylesheet" type="text/css" href="assets/css/util.css">
	<link rel="stylesheet" type="text/css" href="assets/css/main.css">
	<link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="assets/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="assets/vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="assets/vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="assets/vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="assets/vendor/daterangepicker/daterangepicker.css">
  <script type="text/javascript" src="assets/js/lib/jquery-3.5.1.js"></script>
</head>
<body>
<body>
<%if(session.getAttribute("username")==null) {
	response.sendRedirect("login.jsp");
}%>

	<div class="container-contact100">
		<div class="wrap-contact100">
			<form class="contact100-form validate-form" action="AjouteRDV" method="post">
				<span class="contact100-form-title">
					Rendez-vous
				</span>

				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<input class="input100" id="name" type="text" name="nomD" placeholder="Nom docteur">
					<label class="label-input100" for="name">
						<span class="lnr lnr-user"></span>
					</label>
				</div>
				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<input class="input100" id="name" type="text" name="nomP" placeholder="Nom patient">
					<label class="label-input100" for="name">
						<span class="lnr lnr-user"></span>
					</label>
				</div>

				<div class="wrap-input100 ">
					<input class="input100" id="name" type="date" name="date" >
					<label class="label-input100" for="name">
						<span class="lnr lnr-calendar-full"></span>
					</label>
				</div>

				<div class="wrap-input100 " >
					<input class="input100" id="name" type="time" name="time" placeholder="Nom patient">
					<label class="label-input100" for="name">
						<span class="lnr lnr-hourglass"></span>
					</label>
				</div>

				

				<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
					<input class="input100" id="email" type="text" name="email" placeholder="Email patient">
					<label class="label-input100" for="email">
						<span class="lnr lnr-envelope"></span>
					</label>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Description is required">
					<textarea class="input100" name="desc" placeholder="Decription..."></textarea>
				</div>

				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn">
							Confirmer
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="assets/vendor/animsition/js/animsition.min.js"></script>
	<script src="assets/vendor/bootstrap/js/popper.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/select2/select2.min.js"></script>
	<script src="assets/vendor/daterangepicker/moment.min.js"></script>
	<script src="assets/vendor/daterangepicker/daterangepicker.js"></script>
	<script src="assets/vendor/countdowntime/countdowntime.js"></script>



	<div id="dropDownSelect1"></div>
	<script src="assets/js/main.js"></script>
</body>

</body>
</html>