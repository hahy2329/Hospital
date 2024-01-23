<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

	var isValid = false;
	
	$().ready(function(){
		
		$(document).on("click", "#btnOverlapped", function(){
			
			$(".answer").empty();
			
			var loginId = $("#loginId").val();
			var loginPassword = $("#loginPassword").val();
			
			if(loginPassword ==''){
				alert("패스워드를 입력해 주세요.");
				$(".answer").append("<p style='color: red;'>" + "패스워드를 입력해 주세요." + "</p>");
				return;
			}
			
			$.ajax({
				
				type : "get",
				url : "${contextPath}/common/checkLoginInfo?loginId="+loginId + "&loginPassword=" + loginPassword,
				success : function(data){
					if(data == "successLoginInfo"){
						alert("인증이 완료 되었습니다.");
						$("#btnOverlapped").remove();
						$(".answer").append("<p style='color: green;'>" + "인증이 완료 되었습니다." + "</p>");
						isValid = true;
					}else{
						alert("패스워드를 다시 확인해 주세요.");
						$(".answer").append("<p style='color: red;'>" + "패스워드를 확인해 주세요." + "</p>");
						isValid = false;
					}
				}		
			});
		});
		
		$("form").submit(function(){
			
			if(isValid == true){
				return true;
			}else{
				alert("계정 인증을 확인해 주세요.");
				return false;
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
		                <input type="text" name="loginId" id="loginId" value="${sessionScope.patientId }" class="form-control" placeholder="ID를 입력해주세요." readonly="readonly">
		                <input type="password" name="loginPassword" id="loginPassword" class="form-control" placeholder="Password를 입력해주세요." required="required">
		                <input type="button" id="btnOverlapped" class="btn btn-primary btn-outline-primary" value="인증">
		                <p class="answer"></p>
		              </div>      
		              <div class="form-group">
		                <input type="text" name="complimentBoardSubject" class="form-control" placeholder="제목을 입력해 주세요." required="required">
		              </div>
		              <div class="form-group">
              			<textarea name="complimentBoardContent" id="appointment_message" class="form-control" cols="50" rows="30" placeholder="메세지를 입력해 주세요." required="required"></textarea>
            		  </div>
		              <div>
		              	<input type="submit" value="게시글 작성" class="btn btn-primary btn-outline-primary"/>
		              	<br>
		              </div>
		            </form>
		          </div>
		      </div>
		 </div>
	 </section>
</body>
</html>