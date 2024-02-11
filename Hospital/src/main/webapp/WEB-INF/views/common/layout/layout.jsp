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
    
    <!-- [Bootstrap] -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    
    <script src="${contextPath }/resources/dentacare-gh-pages/js/jquery-3.3.1.min.js"></script>
    <script src="${contextPath }/resources/ckeditor/ckeditor.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function execDaumPostcode() {
		    new daum.Postcode({
		        oncomplete: function(data) {
		
		            var fullRoadAddr = data.roadAddress; 
		            var extraRoadAddr = ''; 
		
		            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		                extraRoadAddr += data.bname;
		            }
		            if (data.buildingName !== '' && data.apartment === 'Y'){
		               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		            }
		            if (extraRoadAddr !== ''){
		                extraRoadAddr = ' (' + extraRoadAddr + ')';
		            }
		            if (fullRoadAddr !== ''){
		                fullRoadAddr += extraRoadAddr;
		            }
		
		            document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
		            document.getElementById('roadAddress').value = fullRoadAddr;
		            document.getElementById('jibunAddress').value = data.jibunAddress;
		          
		        }
		    }).open();
		}
	</script>
	<script>
		function execDaumPostMedicalcode() {
		    new daum.Postcode({
		        oncomplete: function(data) {
		
		            var fullRoadAddr = data.roadAddress; 
		            var extraRoadAddr = ''; 
		
		            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		                extraRoadAddr += data.bname;
		            }
		            if (data.buildingName !== '' && data.apartment === 'Y'){
		               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		            }
		            if (extraRoadAddr !== ''){
		                extraRoadAddr = ' (' + extraRoadAddr + ')';
		            }
		            if (fullRoadAddr !== ''){
		                fullRoadAddr += extraRoadAddr;
		            }
		
		            document.getElementById('medicalZipcode').value = data.zonecode; //5자리 새우편번호 사용
		            document.getElementById('medicalRoadAddress').value = fullRoadAddr;
		            document.getElementById('medicalJibunAddress').value = data.jibunAddress;
		          
		        }
		    }).open();
		}
	</script>
	
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
	
  <script src="${contextPath }/resources/dentacare-gh-pages/js/jquery.min.js"></script>
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