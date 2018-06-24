<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>About Us</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Droid:400,700">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:900">
<link rel="stylesheet" href="resources/Css/uss.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
</head>
<body>
<div class="wrapper">
  <div class="nav">
    <div class="left">
      <ul>
  <li><a href="/PokemartFrontend/index">HOME</a></li>
  <li><a href="/PokemartFrontend/about">ABOUT</a></li>
      </ul>
    </div>
    <div class="right">
	<ul>
	<li><a href="/PokemartFrontend/login">Log In</a></li>
	<li><a href="/PokemartFrontend/register">Sign In</a></li>
	</ul>
	</div>
  </div>
<section class="about-us">
<div class="imgBx">
<img src="<%=request.getContextPath()%>/resources/Css/ab.jpg" />
</div>
<div class="content">
  <h1>HIGH</h1>
  <h2>VALUES</h2>
  <p>Our success is not only due to the quality of
 our work;<br/>it's down to attitude,our
 approach and the way we <br/>treat our clients.</p><br>
 </div>
 </section><br>
  <section class="about-features">
  <div class="container">
  <div class="row text-center">
  <div class="col-sm-3">
  <i class="fas fa-eye  fa-5x" aria-hidden="true" align="center"></i>
  <h3>FOCUS</h3>
  <p>We have a 100% commitement to <br>making
  all our sites the best <br> they can possibly be,no matter<br>
  what it takes to get there.</p>
  </div>
  <div class="col-sm-3">
  <i class="fa fa-heart fa-5x" aria-hidden="true"></i>
  <h3>PASSION</h3>
  <p>Our desire to produce good  <br>work runs deep – that’s what 
  <br> lets us handle every project with <br>
  fresh energy and enthusiasm.</p>
  </div>
  <div class="col-sm-3">
  <i class="fa fa-share-alt-square fa-5x" aria-hidden="true"></i>
  <h3>EMPATHY</h3>
  <p>While we share our knowledge  <br>and experience, we listen hard 
  <br> to understand your business <br>
  and your needs.</p>
  </div>
  <div class="col-sm-3">
  <i class="fa fa-users fa-5x" aria-hidden="true"></i>
  <h3>TEAMWORK</h3>
  <p>We are united with you in the <br>drive to get the best from your 
  <br> project – think of us as extra <br>members of your team with all 
  <br>the skills you need.
  </p>
  </div>
  </div>
  </div>
  </section>
</div>

</body>
</html>