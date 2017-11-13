<html>
<head>
<script src="jquery/jquery-3.2.1.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
 <div id="myCarousel" class="carousel slide" data-ride="carousel">
 	<ol class="carousel-indicators">
 	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
 	<li data-target="#myCarousel" data-slide-to="1" class="active"></li>
 	<li data-target="#myCarousel" data-slide-to="2" class="active"></li>
 	</ol>
	
 	<div class="carousel-inner">
  		<div class="item active">
  		<img class="img-rounded" class="img-responsive center-block" src="images/pic1.jpg" style="width:100%;height:80%" >
  		</div>
 		<div class="item">
  		<img class="img-rounded" class="img-responsive center-block" src="images/pic2.jpg" style="width:100%;height:80%" >
  		</div>
  		<div class="item">
  		<img class="img-rounded" class="img-responsive center-block" src="images/pic3.jpg" style="width:100%;height:80%" />
  		</div>
 	</div>


  <a href="#myCarousel" class="left carousel-control" data-slide="prev"> 
  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> 
  <span class="sr-only">Previous</span>  </a>
  
  <a href="#myCarousel" class="right carousel-control" data-slide="next"> 
  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> 
  <span class="sr-only">Next</span> </a>
  
 </div>
</div>

</body>
</html>
