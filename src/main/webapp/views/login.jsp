<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
			<c:if test="${alert != null && message != null}">
				<div class="alert alert-${alert}">
					<strong>${message}</strong>
				</div>
				</c:if>
				<form action="<c:url value='/login'/>" id="formLogin" method="post">

					<div class="form-group">
						<input type="text" class="form-control" id="username"
							name="username" placeholder="Username">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="Password">
					</div>
					<div class="forgot">
						<a href="reset.html">Forgot password?</a>
					</div>
					<input type="hidden" value="login" id="action" name="action" />
					<button type="submit" class="btn btn-primary">Login</button>

				</form>
			</div>
			<!-- <p class="botto-text">Designed by Sunil Rajput</p> -->
		</div>
	</div>
</body>
</html>