<%-- 
    Document   : index
    Created on : Sep 15, 2015, 3:23:46 PM
    Author     : laiqueali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
String cmsUrl = request.getContextPath().toString();
%>

<!DOCTYPE html>
<html ng-app="cms">
<head>
<link rel="shortcut icon" href="resources/images/favicon.ico"
	type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts Management System</title>

<jsp:include page="head.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready(function() {
		console.log("Related path: ");
		console.log(<%=cmsUrl%>);
	});
</script>
</head>
<body ng-controller="indexCtrl">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbarCollapse"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#" ng-click="refresh();">Contact Management System</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="nav navbar-nav navbar-right navbar-cms">
					<li class="nav-li"><a href="<%=cmsUrl%>/auth">Member Area</a></li>					
					<li class="nav-li"><a href="<%=cmsUrl%>/about-us">About Us</a></li>
					<li class="nav-li"><a href="<%=cmsUrl%>/contact-us">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div id="main">
		<div ng-view=""></div>
	</div>

</body>
</html>