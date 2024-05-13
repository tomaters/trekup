<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>trekup</title>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- JQuery -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="/style.css">
<!-- JavaScript -->
<script src="/script.js"></script>
</head>
<body>
<!-- Header -->
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!-- Menu -->
<%@ include file="/WEB-INF/views/common/menu.jsp" %>

<form:form>
	<div style="width=1500; margin=auto;">
		<div class="row d-flex m-3">
			<div class="d-flex justify-content-center">
				<table class="table table-striped" style="width:700px;">
					<thead class="thead-dark">
						<tr>
							<td colspan="3">
								<b>DATABASE TEST</b>
							</td>
						</tr>
					</thead>
					<tr>
						<td>
						1.1
						</td>
						<td>
						1.2
						</td>
						<td>
						1.3
						</td>
					</tr>
					<tr>
						<td>
						2.1
						</td>
						<td>
						2.2
						</td>
						<td>
						2.3
						</td>
					</tr>
					<tr>
						<td>
						3.1
						</td>
						<td>
						3.2
						</td>
						<td>
						3.3
						</td>
					</tr>
				</table>
			</div>
			<button type="submit" class="btn btn-light btn-outline-secondary text-dark mx-auto" style="width:150px;">Submit</button>
		</div>
	</div>
</form:form>
<!-- Footer -->
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>