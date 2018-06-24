<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700">
<link rel="stylesheet" href="resources/Css/s.css">
</head>
<body>
<div class="wrapper">
  <div class="nav">
    <div class="left">
	<ul>
	<li><a href="/PokemartFrontend/index">HOME</a></li>
	<li><a href="#">MENS</a></li>
	<li><a href="#">WOMENS</a></li>
	<li><a href="#">KIDS</a></li>
	<li><a href="#">ELECTRONICS</a></li>
	<li><a href="/PokemartFrontend/about">ABOUT</a></li>
	<li><a href="/PokemartFrontend/contact">CONTACT</a></li>
	
	</ul>
	</div>
	<div class="right">
	<ul>
	<li><a href="/PokemartFrontend/login">Log In</a></li>
	<li><a href="/PokemartFrontend/register">Sign In</a></li>
	</ul>
	</div>
  </div>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
  
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
	  <li data-target="#myCarousel" data-slide-to="3"></li>
	  <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>

   
    <div class="carousel-inner">

      <div class="item active">
        <img src="<%=request.getContextPath()%>/resources/Css/1.jpg" alt="Los Angeles" style="width:100%;">
        <div class="carousel-caption">
          
        </div>
      </div>

      <div class="item">
        <img src="<%=request.getContextPath()%>/resources/Css/2.jpg" alt="Chicago" style="width:100%;">
        <div class="carousel-caption">
         
        </div>
      </div>
    
      <div class="item">
        <img src="<%=request.getContextPath()%>/resources/Css/3.jpg" alt="New York" style="width:100%;">
        <div class="carousel-caption">
          
        </div>
      </div>
	  <div class="item">
        <img src="<%=request.getContextPath()%>/resources/Css/5.jpg" alt="New York" style="width:100%;">
        <div class="carousel-caption">
        
        </div>
      </div>
	  <div class="item">
        <img src="<%=request.getContextPath()%>/resources/Css/6.jpg" alt="New York" style="width:100%;">
        <div class="carousel-caption">
        
        </div>
      </div>
  
    </div>

    
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  </div>
  </body>
  </html>