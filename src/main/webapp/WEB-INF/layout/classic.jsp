<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="..//layout/taglib.jsp"%>

<tilesx:useAttribute name="current" />

<!DOCTYPE html>
<html lang="ru">
<head>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

<style type="text/css">
body { padding-top: 70px; }
</style>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

<!--
  <div class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<spring:url value="/" />">JBA</a>
          </div>
#bs-example-navbar-collapse-1

-->    


	<c:out value="${current}" />
	<div class="container">
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">

				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<spring:url value="/" />">auctiONLINE</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="${current == 'index'?'active':''}"><a href='<spring:url value="/" />'>Home </a></li>
						<security:authorize access="hasRole('ADMIN')">
							<li class="${current == 'users'?'active':''}"><a href='<spring:url value="/users.html" />'>Users</a></li>
						</security:authorize>
						<security:authorize access="! isAuthenticated()">
							<li class="${current == 'login'?'active':''}"><a href='<spring:url value="/login.html" />'>Войти</a></li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<li class="${current == 'account'?'active':''}"><a href='<spring:url value="/account.html" />'>My account</a></li>
							<li><a href='<spring:url value="/logout" />'>ВЫйти</a></li>
						</security:authorize>
						<li class="${current == 'register'?'active':''}"><a href='<spring:url value="/register.html" />'>Регистрация</a></li>

						<li><a href="#">!?!?!</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

		<tiles:insertAttribute name="body" />
a </br>
a</br>
a</br>
a</br>
a</br>
a</br>
a</br>
		<br /> <br />

		<tiles:insertAttribute name="footer" />

	</div>
</body>
</html>