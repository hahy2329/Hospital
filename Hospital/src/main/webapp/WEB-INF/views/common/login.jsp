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
	  <section class="home-slider owl-carousel">
      <div class="slider-item bread-item" style="background-image: url('${contextPath }/resources/dentacare-gh-pages/images/bg_1.jpg');" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container" data-scrollax-parent="true">
          <div class="row slider-text align-items-end">
            <div class="col-md-7 col-sm-12 ftco-animate mb-5">
              <p class="breadcrumbs" data-scrollax=" properties: { translateY: '70%', opacity: 1.6}"><span class="mr-2"><a href="index.html">Home</a></span> <span>Services</span></p>
              <h1 class="mb-3" data-scrollax=" properties: { translateY: '70%', opacity: .9}">방문해 주셔서 감사합니다.</h1>
            </div>
          </div>
        </div>
      </div>
    </section>
    
	<section class="ftco-section contact-section ftco-degree-bg">
      <div class="container">
        <div class="row d-flex mb-5 contact-info">
          <div class="col-md-12 mb-4">
            <h2 class="h4">Hospital Information</h2>
          </div>
          <div class="w-100"></div>
          <div class="col-md-3">
            <p><span>주소:</span> 서울특별시 송파구 잠실동 잠실역 8번출구 앞 30m</p>
          </div>
          <div class="col-md-3">
            <p><span>문의:</span>02-111-2222</p>
          </div>
          <div class="col-md-3">
            <p><span>Email:</span>abc@hospital.com</p>
          </div>
        </div>
        <div class="col-md-12 mb-4">
            <h1 class="h3">로그인</h1>
        </div>
        <div class="row block-9">
          <div class="col-md-6 pr-md-5">
            <form action="${contextPath }/login.do" method="post">
              <div class="form-group">
                <input type="text" name="loginId" class="form-control" placeholder="ID를 입력해주세요.">
              </div>
              <div class="form-group">
                <input type="password" name="loginPassword" class="form-control" placeholder="Password를 입력해주세요.">
              </div>
              <div>
              	<input type="submit" value="로그인" class="btn btn-primary btn-outline-primary"/>
              </div>
            </form>
            <br>
            <div>
            	<a href="${contextPath }/patient/register">일반 회원가입</a> /
 				<a href="${contextPath }/medical/register">의료진 회원가입</a>
            </div>
          </div>
        </div>
      </div>
    </section>
</body>
</html>