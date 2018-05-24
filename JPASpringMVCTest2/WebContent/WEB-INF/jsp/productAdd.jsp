<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">-->

<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/datepicker.css"/>" rel="stylesheet">

<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js"/>"></script>





<script>
$( function() {
 
$( "#transDate" ).datepicker();
} );
 
</script>


<title>Product Add Page</title>
</head>
<body>

		<div class="container-fluid">
	 		<div class="row">
				<nav class="navbar navbar-default">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#">Anlrcavictor</a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			        <li class="active"><a href="#">Product <span class="sr-only">(current)</span></a></li>
			        <li><a href="#">Manufacturer</a></li>
			       </ul>
			      
			      
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
		</div>
	</div>
	


	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>Add products</p>
			</div>		
		</div>
	</section>
	<section class="container">
		<!-- watch out modelAttribute ! -->
		<form:form  modelAttribute="newProduct" class="form-horizontal" method="post">
			<fieldset>
				<legend>Add new product</legend>


				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Name</label>
					<div class="col-md-3">
						<form:input id="name" path="name" type="text" class="form:input-large form-control"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="price">Unit price</label>
					<div class="col-md-2">
						<div class="form:input-prepend">
							<form:input id="price" path="price" type="text" class="form:input-large form-control"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="stok">Stok</label>
					<div class="col-md-2">
						<div class="form:input-prepend">
							<form:input id="stok" path="stok" type="text" class="form-control"/>
						</div>
					</div>
				</div>	
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="transDate">Added date</label>
					<div class="col-md-2">
						<div class="form:input-prepend">
							<form:input id="transDate" path="transDate" type="text" class="form-control" readonly="true" />
						</div>
					</div>
				</div>		
				
					

				
				<%-- <div class="form-group">
					<label class="control-label col-lg-2" for="manufacturer">Manufacturer</label>
					<div class="col-lg-10">				
						
						<form:select id="manufacturer" path="manufacturer" type="text" class="form:input-large">
							<form:option value="Apple">Apple</form:option>
							<form:option value="Google">Google</form:option>
							<form:option value="Samsung">Samsung</form:option>
						</form:select>--%>
					
					<div class="form-group"> 
						<label class="control-label col-lg-2" for="manufacturer">Manufacturer</label>
							<div class="col-md-2"> 				 
					    		<form:select id="manufacturer" path="manufacturerName" type="text" class="form:input-large form-control" items="${manufacturerList}"/>		
					     	</div>		
					</div>

				
						
						

				
				
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
