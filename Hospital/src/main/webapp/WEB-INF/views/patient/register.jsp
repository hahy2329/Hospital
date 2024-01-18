<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
	var isValidId = false;
	var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
	var isValidEmail = false;
	
	var pattern1 = /[0-9]/;
	var pattern2 = /[a-zA-Z]/;
	var pattern3 = /[~!@\#$%<>^&*]/;
	
	
	$().ready(function(){
		
		$(document).on("click", "#btnOverlapped", function(){
			
			$(".answer").empty();
			
			var patientId = $("#patientId").val();
			
			if(patientId == ''){
				alert("ID를 입력하세요.");
				$(".answer").append("<p style='color: red;'>" + "ID를 입력해 주세요." + "</p>");
				return;
			}
			if(patientId.search(/\s/) != -1){
				alert("공백은 허용할 수 없습니다.");
				$(".answer").append("<p style='color: red;'>" + "공백은 허용할 수 없습니다." + "</p>");
				return false;
			} //공백 체크
			if(special_pattern.test(patientId) == true){
				alert("특수문자는 허용할 수 없습니다.");
				$(".answer").append("<p style='color: red;'>" + "특수문자는 사용할 수 없습니다." + "</p>");
				return false;
			} //특수문자 체크
			
			$.ajax({
				type : "get",
				url : "${contextPath}/patient/checkDuplicatedId?patientId=" + patientId,
				success : function(data){
					if(data == "duplicate"){
						alert("사용할 수 있는 ID입니다.");
						$(".answer").append("<p style='color: green;'>" + "중복체크 완료" + "</p>");
						$("#btnOverlapped").remove();
						isValidId = true;
					}else{
						alert("사용할 수 없는 ID입니다.");
						$(".answer").append("<p style='color: red;'>" + "사용할 수 없는 ID입니다." + "</p>");
						isValidId = false;
					}
				}
			});
		});
		
		$(document).on("click", "#btnOverlappedEmail", function(){
			
			$(".answerEmail").empty();
			
			var patientEmail = $("#patientEmail").val();
			
			if(patientEmail == ''){
				alert("Email을 입력해 주세요.");
				$(".answerEmail").append("<p style='color: red;'>" + "Email을 입력해 주세요." + "</p>");
				return;
			}
			
			$.ajax({
				
				type : "get",
				url : "${contextPath}/patient/checkDuplicatedEmail?patientEmail" + patientEmail,
				success : function(data){
					if(data == "duplicateEmail"){
						alert("사용할 수 있는 Email입니다.");
						$(".answerEmail").append("<p style='color: green;'>" + "사용할 수 있는 Email입니다." + "</p>");
						$("#btnOverlappedEmail").remove();
						isValidEmail = true;
					}else{
						alert("사용할 수 없는 Email입니다.");
						$(".answerEmail").append("<p style='color: red;'>" + "사용할 수 없는 Email입니다." + "</p>");
						isValidEmail = false;
					}
				}	
			});
		});
		$("form").submit(function(){
			
			if(isValidId == false){
				alert("ID를 확인해 주세요.");
				return false;
			}
			if(isValidEmail == false){
				alert("Email을 확인해 주세요.");
				return false;
			}
			if($("#patientPw").val() == ''){
				alert("패스워드를 확인해 주세요.");
				return false;
			}
			if(isValidId == true && isValidEmail == true){
				if($("#patientPw").val() == $("#confirmPasswd").val()){
					if(!pattern1.test($("#patientPw").val()) || !pattern2.test($("#patientPw").val()) || !pattern3.test($("#patientPw").val()) || $("#patientPw").val().length<8 || $("#patientPw").val().length>50){
						
						alert("영문+숫자+특수기호 8자리 이상으로 구성하여야 합니다.");
						return false;
						
					}else{
						$("[name='patientBirth']").val($("#birthY").val() + "-" + $("#birthM").val()+"-" + $("#birthD").val());
						return true;
					}
				}else{
					
					alert("패스워드를 확인해 주세요.");
					return false;
					
				}
				
			}
			
			
		});
		
		
	});

</script>
</head>
<body>
	  <section class="home-slider owl-carousel">
      <div class="slider-item bread-item" style="background-image: url('${contextPath }/resources/dentacare-gh-pages/images/bg_1.jpg');" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container" data-scrollax-parent="true">
          <div class="row slider-text align-items-end">
            <div class="col-md-7 col-sm-12 ftco-animate mb-5">
              <p class="breadcrumbs" data-scrollax=" properties: { translateY: '70%', opacity: 1.6}"><span class="mr-2"><a href="index.html">Home</a></span> <span>Services</span></p>
              <h1 class="mb-3" data-scrollax=" properties: { translateY: '70%', opacity: .9}">Our Service Keeps you Smile</h1>
            </div>
          </div>
        </div>
      </div>
    </section>
    
	<section class="ftco-section contact-section ftco-degree-bg">
		<div class="container">
			<div class="col-md-12 mb-4">
		            <h2 class="h4">일반 회원가입</h2>
		    </div>
			<div class="row block-9">
		          <div class="col-md-6 pr-md-5">
		            <form action="${contextPath }/patient/register" method="post">
		              <div class="form-group">
		                <input type="text" name="patientId" id="patientId" class="form-control" placeholder="ID를 입력해주세요.">
		                <p class="answer"></p>
		                <input type="button" id="btnOverlapped" value="중복확인">
		              </div>
		              <div class="form-group">
		                <input type="password" name="patientPw" id="patientPw" class="form-control" placeholder="Password를 입력해주세요.">
		                <input type="password" id="confirmPasswd" placeholder="비밀번호를 다시 입력해주세요." class="form-control">
		              </div>              
		              <div class="form-group">
		                <input type="text" name="patientName" class="form-control" placeholder="이름을 입력해주세요.">
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
		                      <input type="hidden" name="patientBirth"/>
		                <div> 	
		                	<input type="email" class="form-control" id="patientEmail" name="patientEmail" placeholder="E-mail을 입력해주세요.">
		              		<p class="answerEmail"></p>    
		              		<input type="button" id="btnOverlappedEmail" value="중복확인">
		              	</div>
		              	<div>
		              		<input type="text" id="patientZipcode" name="patientZipcode"  class="form-control" placeholder="우편번호">
		              		<input type="button" value="검색" onclick="execDaumPostcode();" class="btn btn-primary btn-outline-primary"> 
		              		<input type="text" id="patientRoadAddress" name="patientRoadAddress"  class="form-control" placeholder="도로명 주소">
		              		<input type="text" id="patientJibunAddress" name="patientJibunAddress"  class="form-control" placeholder="지번 주소">
		              		<input type="text" id="patientNamujiAddress" name="patientNamujiAddress"  class="form-control" placeholder="나머지 주소">
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