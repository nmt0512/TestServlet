<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><dec:title default="Trang chủ" /></title>

	<!-- css -->
	<link href="<c:url value='/template/web/css/styles.css' />" rel="stylesheet" type="text/css" media="all" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="icon" type="image/x-icon" href="<c:url value='template/web/assets/favicon.ico' />" />
</head>
<body>
	<!-- header -->
	<%@include file="/common/web/header.jsp" %>
	
	<div class="big-container">
    	<dec:body/>
    </div>
    
    <!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	
	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>	
	<!-- Core theme JS-->
    <script src="<c:url value='/template/web/js/scripts.js' />"></script>
</body>
</html>