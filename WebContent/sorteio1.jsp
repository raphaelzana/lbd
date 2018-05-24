<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Exact Login Form Flat Responsive Widget Template :: w3layouts</title>
	<!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="Exact login Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //Meta-Tags -->

	<!-- Custom Theme files -->
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/font-awesome.css" rel="stylesheet"> <!-- Font-Awesome-Icons-CSS -->
	<!-- //Custom Theme files -->
	
	<!-- web font --> 
	<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext" rel="stylesheet">
	<!-- //web font --> 
	
</head>
<body>
	<!-- main -->
	<div class="main">
		<h1>MEU SORTEIO ONLINE</h1>
		<div class="main-w3lsrow">
			<!-- login form -->
			<div class="login-form login-form-left"> 
				<div class="agile-row">
					<div class="head">
						<h2>Dados do sorteio</h2>
						<span class="fa fa-lock"></span>
					</div>					
					<div class="clear"></div>
					<div class="login-agileits-top"> 	
						<form action="ControllerSorteio" method="post"> 
						<% 
						String nome = session.getAttribute("nomeSorteio").toString();
						String data = session.getAttribute("dataSorteio").toString();
						String desc = session.getAttribute("descricao").toString();
						String prem = session.getAttribute("premiacao").toString();
						%>
							<input type="text" class="name" name="sorteio" Placeholder=<%=nome %> required/>
							<input type="text" class="name" name="data" Placeholder=<%=data %>  required/>
							<input type="text" class="name" name="descr" Placeholder=<%=desc %>  required/>
							<input type="text" class="name" name="prem" Placeholder=<%=prem %>  required/>
							<input type="submit" name="botao" value="Inscrever-se">
							<input type="submit" name="botao" value="Sortear"> 
						</form>
					</div>
						<div class="login-agileits-bottom"> 
					</div> 
			</div>  
		</div>
		<!-- //login form -->
		
		<!--<div class="login-agileits-bottom1"> 
			<h3>or login with</h3>
		</div>
		-->
		
	<!-- social icons -->
<!-- 	<div class="social_icons agileinfo">
			<ul class="top-links">
				<li><a href="#" class="facebook"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a></li>
				<li><a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a></li>
				<li><a href="#" class="vimeo"><i class="fa fa-vimeo"></i></a></li>
			</ul>
		</div> 
		-->
		<!-- //social icons -->
		
		<!-- copyright -->
		<div class="copyright">
			<p> Â© 2018 Exact Login Form. All rights reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
		</div>
		<!-- //copyright --> 
	</div>	
	<!-- //main -->
	
</body>
</html>