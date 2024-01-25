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
	
	
	<section class="ftco-section">
			<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div class="row">
				  <div class="col-md-12 ftco-animate">
		            <div class="blog-entry">
		              <a href="blog-single.html" class="block-20" style="background-image: url('${contextPath }/resources/dentacare-gh-pages/images/image_1.jpg');">
		              </a>
		              <div class="text d-flex py-4">
		                <div class="meta mb-3">
		                  <div><a href="#"><span class="icon-calendar"></span><fmt:formatDate value="${complimentBoardDTO.complimentBoardEnrollDt }" /></a></div>
		                  <div><a href="#"><span class="icon-person"></span>${complimentBoardDTO.patientId }</a></div>
		                  <div>${complimentBoardDTO.complimentBoardReadCnt }</div>
		                </div>
		                <div class="desc pl-sm-3 pl-md-5">
			                <h3 class="heading">${complimentBoardDTO.complimentBoardSubject }</h3>
			                <p>${complimentBoardDTO.complimentBoardContent }</p>
			                <p><a href="${contextPath }/common/complimentAddComments?complimentBoardId=${complimentBoardDTO.complimentBoardId}" class="btn btn-primary btn-outline-primary">댓글 달기</a></p>
			              </div>
		              </div>
		            </div>
		          </div>
				</div>	
			   </div> 
			   
			  <div class="col-md-4 sidebar ftco-animate">
	            <div class="sidebar-box">
	              <form action="#" class="search-form">
	                <div class="form-group">
	                  <span class="icon fa fa-search"></span>
	                  <input type="text" class="form-control" placeholder="Type a keyword and hit enter">
	                </div>
	              </form>
	            </div>
	            <div class="sidebar-box ftco-animate">
	              <div class="categories">
	                <h3>Categories</h3>
	                <li><a href="#">Food <span>(12)</span></a></li>
	                <li><a href="#">Dish <span>(22)</span></a></li>
	                <li><a href="#">Desserts <span>(37)</span></a></li>
	                <li><a href="#">Drinks <span>(42)</span></a></li>
	                <li><a href="#">Ocassion <span>(14)</span></a></li>
	              </div>
	            </div>


	            <div class="sidebar-box ftco-animate">
	              <h3>Tag Cloud</h3>
	              <div class="tagcloud">
	                <a href="#" class="tag-cloud-link">dish</a>
	                <a href="#" class="tag-cloud-link">menu</a>
	                <a href="#" class="tag-cloud-link">food</a>
	                <a href="#" class="tag-cloud-link">sweet</a>
	                <a href="#" class="tag-cloud-link">tasty</a>
	                <a href="#" class="tag-cloud-link">delicious</a>
	                <a href="#" class="tag-cloud-link">desserts</a>
	                <a href="#" class="tag-cloud-link">drinks</a>
	              </div>
	            </div>
	
	            <div class="sidebar-box ftco-animate">
	              <h3>Paragraph</h3>
	              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus itaque, autem necessitatibus voluptate quod mollitia delectus aut, sunt placeat nam vero culpa sapiente consectetur similique, inventore eos fugit cupiditate numquam!</p>
	            </div>
	          </div>
			</div>
		</div>
	</section>

</body>
</html>