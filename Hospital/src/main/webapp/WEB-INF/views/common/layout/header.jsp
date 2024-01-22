<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="${contextPath }/">Denta<span>Care</span></a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
		          <li class="nav-item"><a href="${contextPath }/" class="nav-link">Home</a></li>
		          <li class="nav-item"><a href="${contextPath }/common/introduce" class="nav-link">병원 소개</a></li>
				<c:if test="${sessionScope.patientId ne null }">		          
		          <li class="nav-item"><a href="services.html" class="nav-link">진료 예약</a></li>
		          <li class="nav-item"><a href="services.html" class="nav-link">의료진 정보</a></li>
		          <li class="nav-item"><a href="${contextPath }/common/complimentBoard" class="nav-link">불편/민원 접수</a></li>
		          <li class="nav-item"><a href="services.html" class="nav-link">직원을 칭찬합니다.</a></li>
		        </c:if>
		        <c:if test="${sessionScope.medicalId ne null }">  
		          <li class="nav-item"><a href="contact.html" class="nav-link">불편/민원 관리</a></li>
		          <li class="nav-item"><a href="contact.html" class="nav-link">예약 관리</a></li>
		          <li class="nav-item"><a href="contact.html" class="nav-link">출퇴근 도장</a></li>
		          <li class="nav-item"><a href="contact.html" class="nav-link">메일 관리</a></li>
	        	</c:if>
	        	<c:choose>
		        	<c:when test="${sessionScope.patientId eq null and sessionScope.medicalId eq null }">
			          <li class="nav-item cta"><a href="${contextPath }/common/login" class="nav-link"><span>로그인</span></a></li>
		        	</c:when>
		        	<c:otherwise>
					  <c:if test="${sessionScope.patientId ne null }">
					  		<li class="nav-item cta"><a href="#" class="nav-link"><span>${sessionScope.patientName }님 환영해요.</span></a></li>  
					  		<li class="nav-item cta"><a href="${contextPath }/patient/logout" class="nav-link"><span>로그아웃</span></a></li>
					  </c:if>
					  <c:if test="${sessionScope.medicalId ne null }">
					  		<li class="nav-item cta"><a href="#" class="nav-link"><span>${sessionScope.medicalName }님 환영해요.</span></a></li>
					  		<li class="nav-item cta"><a href="${contextPath }/medical/logout" class="nav-link"><span>로그아웃</span></a></li>
					  </c:if> 		        	
		        	</c:otherwise>
		        </c:choose>	
	        </ul>
	      </div>
	    </div>
	  </nav>
    

</body>
</html>