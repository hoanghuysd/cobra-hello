<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>Spring boot</title>
    <script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/home.js"></script>

    <c:url value="/styles/home.css" var="jstlCss" />
    <link href="${jstlCss}" type="text/css"  rel="stylesheet" />
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Spring Boot</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <h1>Spring Boot Web JSP Example By HuyHV</h1>
        <h2>${message}</h2>
        <h3>Thank you</h3>
    </div>

</div>
</body>

</html>