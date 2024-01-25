<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-12 ftco-animate">
		<div class="blog-entry" data-aos-delay="200">
			<a href="blog-single.html" class="block-20" style="background-image: url('${contextPath }/resources/dentacare-gh-pages/images/image_3.jpg');">
			</a>
			<div class="text d-flex py-4">
		    	<div class="meta mb-3">
		        	<div><fmt:formatDate value="${complimentBoardDTO.complimentBoardEnrollDt }" /></div>
		            <div>${complimentBoardDTO.patientId }</div>
		            <div>조회수 : ${complimentBoardDTO.complimentBoardReadCnt }</div>
		         </div>
		       <div class="desc pl-sm-3 pl-md-5">
			        <h3 class="heading">${complimentBoardDTO.complimentBoardSubject }</h3>
			        <p>${complimentBoardDTO.complimentBoardContent }</p>
			        <p><a href="${contextPath }/common/complimentAddComments" class="btn btn-primary btn-outline-primary">댓글 달기</a></p>
			   </div>
		     </div>
		 </div>
	</div>
</body>
</html>