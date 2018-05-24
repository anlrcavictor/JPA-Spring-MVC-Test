<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manufacturer</title>

<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>

</head>
<body>

	<div class="container-fluid">
	 <div class="row">
				<nav class="navbar navbar-inverse" style="margin-bottom:0px">
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
			        <li class="active"><a href="<c:url value="/products" />">Product <span class="sr-only">(current)</span></a></li>
			        <li><a href="<c:url value="/products/list" />">ProductList</a></li>
			        <li><a href="<c:url value="/manufacturers" />">Manufacturer</a></li>
			       </ul>
			      
			      
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
		</div>
	</div>


	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Manufacturer</h1>
			</div>
		</div>
	</section>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12"></div>

			<div class="row">
				<div class="col-md-3 col-md-offset-3">
					<legend>Manufacturer List</legend>
					<div class="table-responsive">
						<table id="example" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Name</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>


								<c:forEach items="${allManufacturers}" var="manufacturer">
									<tr>
										<td><c:out value="${manufacturer.name}" /></td>
										<td><a
											href="<c:url value="/manufacturers/manufacturer.delete?manufacturerId=${manufacturer.id}" />"
											class="btn btn-danger" type="button">Delete</a>
											<a
											href="<c:url value="/manufacturers/manufacturer.update?manufacturerId=${manufacturer.id}" />"
											class="btn btn-warning" type="button">Update</a>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>
			<div class="row">
				<div class="col-md-offset-3">
					<a href="${pageContext.request.contextPath}/manufacturers/add" class="btn btn-info"
						type="button">Add Manufacturer</a>
				</div>
			</div>
		</div>
	</div>
	

	
	
</body>
</html>