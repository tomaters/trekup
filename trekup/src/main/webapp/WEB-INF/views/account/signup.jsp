<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign up</title>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- JQuery -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="/common/style.css"/>
<!-- JavaScript -->
<script src="/WEB-INF/views/common/script.js"></script>
</head>
<body>
<!-- Header -->
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!-- Menu -->
<%@ include file="/WEB-INF/views/common/menu.jsp" %>
<!-- Footer -->
<%@ include file="/WEB-INF/views/common/footer.jsp" %>

<div class="container mt-5">
    <div class="row d-flex justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3 class="text-center">sign up</h3>
                </div>
                <div class="card-body">
                    <form action="<c:url value='/login' />" method="post">
                        <div class="mb-3">
                            <label for="username" class="form-label">username</label>
                            <input type="text" id="username" name="username" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">password</label>
                            <input type="password" id="password" name="password" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="name" class="form-label">name</label>
                            <input type="text" id="name" name="name" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="location" class="form-label">location</label>
                            <input type="text" id="location" name="location" class="form-control" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-light btn-outline-secondary text-dark mx-auto">create account</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>