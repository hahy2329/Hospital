<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
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
			<div class="col-md-12 mb-4">
		            <h2 class="h4">불편/민원 게시글 작성</h2>
		    </div>
			<div class="row block-9">
		          <div class="col-md-6 pr-md-5">
		            <form action="${contextPath }/common/complimentAddBoard" method="post">
		              <div class="form-group">
		                <input type="text" name="loginId" id="loginId" class="form-control" minlength="6" maxlength="15" placeholder="ID를 입력해주세요." required="required">
		                <input type="password" name="loginPassword" id="loginPassword" class="form-control" placeholder="Password를 입력해주세요." required="required">
		                <input type="button" id="btnOverlapped" class="btn btn-primary btn-outline-primary" value="인증">
		                <p class="answer"></p>
		              </div>      
		              <div class="form-group">
		                <input type="text" name="medicalName" class="form-control" placeholder="이름을 입력해주세요." required="required">
		              </div>
		              <div> 	
		                <input type="text" class="form-control" value="생년월일을 선택해주세요." readonly="readonly">
		              <div>
		                <select id="birthY" class="form-control" required="required">
		                    <c:forEach var="i" begin="0" end="2024">
		                    	<option>${2024-i }</option>
		                    </c:forEach>
		                </select>
		              </div>	
		              	<div>
		                 	<select id="birthM" class="form-control" required="required">
		                       <c:forEach var="i" begin="1" end="12">
		                            	<c:choose>
		                            		<c:when test="${i<10 }">
		                            			<option>0${i }</option>
		                            		</c:when>
		                            		<c:otherwise>
		                            			<option>${i }</option>
		                            		</c:otherwise>
		                            	</c:choose>
		                          </c:forEach>
		                      </select>
		                 </div>
		                 <div>
		                     <select id="birthD" class="form-control" required="required">
		                           <c:forEach var="i" begin="1" end="31">
		                            	<c:choose>
		                            		<c:when test="${i<10 }">
		                            			<option>0${i }</option>
		                            		</c:when>
		                            		<c:otherwise>
		                            			<option>${i }</option>
		                            		</c:otherwise>
		                            	</c:choose>
		                            </c:forEach>
		                      </select>
		                  </div>
		                      <input type="hidden" name="medicalBirth"/>
		                <div> 	
		                	<input type="email" class="form-control" id="medicalEmail" name="medicalEmail" placeholder="E-mail을 입력해주세요." required="required">
		              		<p class="answerEmail"></p>    
		              		<input type="button" id="btnOverlappedEmail" value="중복확인">
		              	</div>
		              	<div>
		              		<input type="text" id="medicalZipcode" name="medicalZipcode"  class="form-control" placeholder="우편번호" required="required">
		              		<input type="button" value="검색" onclick="execDaumPostMedicalcode();" class="btn btn-primary btn-outline-primary"> 
		              		<input type="text" id="medicalRoadAddress" name="medicalRoadAddress"  class="form-control" placeholder="도로명 주소" required="required">
		              		<input type="text" id="medicalJibunAddress" name="medicalJibunAddress"  class="form-control" placeholder="지번 주소" required="required">
		              		<input type="text" id="medicalNamujiAddress" name="medicalNamujiAddress"  class="form-control" placeholder="나머지 주소">
		              	</div>
		              	<div class="form-group">
			                <input type="text" name="medicalCode" id="medicalCode" class="form-control" placeholder="의료진 인증 코드를 입력해주세요." required="required">
			                <p class="answerCode"></p>
			                <input type="button" id="btnOverlappedCode" value="중복확인">
		              	</div>
		              	    <br>
		                </div>
		              <div>
		              	<input type="submit" value="전송" class="btn btn-primary btn-outline-primary"/>
		              <br>
		              </div>
		            </form>
		          </div>
		   </div>
		</div>
	</section>
</body>
</html>