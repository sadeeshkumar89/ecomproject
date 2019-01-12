<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Insert title here</title>
</head>
<body>
<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
<!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
 </ol>
 <div class="carousel-inner" role="listbox">
 <div class="item active">
                    <img class="first-slide" src="resources/images/laptop.jpg" alt="first slide" height="80%" width="80%" class="img-circle"> 
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>WELCOME TO THE CAR STORE</h1>
                            <p>Here You Can Browse And Buy Cars.Order Now For Your Amazing New Arrivals</p>
                        </div>
                    </div>
                </div>
  <div class="item">
                    <img class="second-slide" src="resources/images/mobilephones.jpg" alt="Second slide" height="80%" width="80%">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>The Car Store.</h1>
                            <p>online shopping can make your life more easier</p>
                        </div>
                    </div>
                </div> 
   <div class="item">
                    <img class="third-slide" src="resources/images/pc.jpg" alt="Third slide" height="80%" width="80%">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>The Car You Love</h1>
                            <p>live Freely,Work Happily And Drive Safely!!</p>
                        </div>
                    </div>
                </div>
                
   <div class="item">
                    <img class="forth-slide" src="resources/images/tab.jpg" alt="forth slide" height="80%" width="80%">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Any car can be a "cool" car</h1>
                            <p>your life,your car...you own it!!</p>
                        </div>
                    </div>
                </div>   
    
 </div>
 <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" ></span>
                <span class="sr-only">Next</span>
            </a>
</div>


</div>
</body>
</html>

