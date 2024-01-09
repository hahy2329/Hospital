<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
 <title><tiles:insertAttribute name="title"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,500,600,700" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/animate.css">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/magnific-popup.css">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/aos.css">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/ionicons.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/jquery.timepicker.css">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/flaticon.css">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/icomoon.css">
    <link rel="stylesheet" href="${contextPath }/resources/dentacare-gh-pages/css/style.css">
    <script src="${contextPath }/resources/dentacare-gh-pages/js/jquery-3.2.1.min.js"></script>
    <script src="${contextPath }/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
	
	<!-- Header Section Begin -->
		<tiles:insertAttribute name="header"/>
	<!-- Header Section End -->
	
	<!-- Body Section Begin -->
		<tiles:insertAttribute name="body"/>
	<!-- Body Section End -->
	
	<!-- Footer Section Begin -->
		<tiles:insertAttribute name="footer"/>
	<!-- Footer Section End -->
	
	  <script src="js/jquery.min.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/popper.min.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/bootstrap.min.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/jquery.easing.1.3.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/jquery.waypoints.min.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/jquery.stellar.min.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/owl.carousel.min.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/jquery.magnific-popup.min.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/aos.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/jquery.animateNumber.min.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/bootstrap-datepicker.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/jquery.timepicker.min.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/google-map.js"></script>
  <script src="${contextPath }/resources/dentacare-gh-pages/js/main.js"></script>
	
</body>
</html>