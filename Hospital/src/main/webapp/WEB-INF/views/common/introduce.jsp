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

	<section class="ftco-section">
    	<div class="container">
    		<div class="row d-md-flex">
	    		<div class="col-md-6 ftco-animate img about-image order-md-last" style="background-image: url(${contextPath }/resources/dentacare-gh-pages/images/about.jpg);">
	    		</div>
	    		<div class="col-md-6 ftco-animate pr-md-5 order-md-first">
		    		<div class="row">
		          <div class="col-md-12 nav-link-wrap mb-5">
		            <div class="nav ftco-animate nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
		              <a class="nav-link active" id="v-pills-whatwedo-tab" data-toggle="pill" href="#v-pills-whatwedo" role="tab" aria-controls="v-pills-whatwedo" aria-selected="true">What we do</a>

		              <a class="nav-link" id="v-pills-mission-tab" data-toggle="pill" href="#v-pills-mission" role="tab" aria-controls="v-pills-mission" aria-selected="false">Our mission</a>

		              <a class="nav-link" id="v-pills-goal-tab" data-toggle="pill" href="#v-pills-goal" role="tab" aria-controls="v-pills-goal" aria-selected="false">Our goal</a>
		            </div>
		          </div>
		          <div class="col-md-12 d-flex align-items-center">
		            
		            <div class="tab-content ftco-animate" id="v-pills-tabContent">

		              <div class="tab-pane fade show active" id="v-pills-whatwedo" role="tabpanel" aria-labelledby="v-pills-whatwedo-tab">
		              	<div>
			                <h2 class="mb-4">고품질 서비스를 제공합니다.</h2>
			              	<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
			                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt voluptate, quibusdam sunt iste dolores consequatur</p>
				            </div>
		              </div>

		              <div class="tab-pane fade" id="v-pills-mission" role="tabpanel" aria-labelledby="v-pills-mission-tab">
		                <div>
			                <h2 class="mb-4">모든 환자를 수용합니다.</h2>
			              	<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
			                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt voluptate, quibusdam sunt iste dolores consequatur</p>
				            </div>
		              </div>

		              <div class="tab-pane fade" id="v-pills-goal" role="tabpanel" aria-labelledby="v-pills-goal-tab">
		                <div>
			                <h2 class="mb-4">환자의 요구사항을 빠르게 지원할 것입니다.</h2>
			              	<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
			                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt voluptate, quibusdam sunt iste dolores consequatur</p>
				            </div>
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
		    </div>
    	</div>
    </section>

    <section class="ftco-section-2">
    	<div class="container-wrap">
      	<div class="row d-flex no-gutters">
      		<div class="col-md-6 img" style="background-image: url(${contextPath }/resources/dentacare-gh-pages/images/about-2.jpg);">
      		</div>
      		<div class="col-md-6 d-flex">
      			<div class="about-wrap">
      				<div class="heading-section heading-section-white mb-5 ftco-animate">
		            <h2 class="mb-2">FrontToBack은 아래와 같은 진료로 진행됩니다.</h2>
		            <p>신경외과, 정형외과, 소아청소년과가 대표적이며, 그 외 다양한 진료를 받고 있습니다.</p>
		          </div>
      				<div class="list-services d-flex ftco-animate">
      					<div class="icon d-flex justify-content-center align-items-center">
      						<span class="icon-check2"></span>
      					</div>
      					<div class="text">
	      					<h3>신경외과</h3>
	      					<p>FrontToBack병원 신경외과는 신경계통에서 발생하는 질환을 진단하고 수술적으로 치료합니다. 신경계는 중추 신경계와 말초 신경계로 나뉘는데, 중추 신경계는 뇌와 척수로 구성, 말초 신경계는 뇌와 척수에서 시작해 각각의 장기 및 근육 그리고 피부 등으로 향하는 신경을 통칭하여 말합니다.</p>
      					</div>
      				</div>
      				<div class="list-services d-flex ftco-animate">
      					<div class="icon d-flex justify-content-center align-items-center">
      						<span class="icon-check2"></span>
      					</div>
      					<div class="text">
	      					<h3>정형외과</h3>
	      					<p>FrontToBack병원 정형외과는 척추질환, 고관절, 무릎, 어깨, 및 팔꿈치 질환, 족부 질환, 수부질환, 소아 등 세부적인 전문진료를 진행하고 있습니다.</p>
      					</div>
      				</div>
      				<div class="list-services d-flex ftco-animate">
      					<div class="icon d-flex justify-content-center align-items-center">
      						<span class="icon-check2"></span>
      					</div>
      					<div class="text">
	      					<h3>소아청소년과</h3>
	      					<p>FrontToBack병원 소아청소년과는 소아 알레르기, 호흡기 및 아토피 피부 질환, 유전 및 대사 질환, 내분비 질환, 뇌전증 등의 신경계 질환, 소아 혈액 조양 질환, 소아 심장 질환 등 세부적인 전문진료를 진행하고 있습니다.</p>
      					</div>
      				</div>
      			</div>
      		</div>
      	</div>
      </div>
    </section>
	<div>
		<br><hr><br>
	</div>
    <section class="ftco-section ftco-counter img" id="section-counter" style="background-image: url(${contextPath }/resources/dentacare-gh-pages/images/bg_1.jpg);" data-stellar-background-ratio="0.5">
    	<div class="container">
    		<div class="row d-flex align-items-center">
    			<div class="col-md-3 aside-stretch py-5">
    				<div class=" heading-section heading-section-white ftco-animate pr-md-4">
	            <h2 class="mb-3">Achievements</h2>
	            <p>병원의 업력, 의료진 수, 환자 수, 연간 다녀간 환자 수를 나타내었습니다.</p>
	          </div>
    			</div>
    			<div class="col-md-9 py-5 pl-md-5">
		    		<div class="row">
		          <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18">
		              <div class="text">
		                <strong class="number" data-number="15">0</strong>
		                <span>Years of Experience</span>
		              </div>
		            </div>
		          </div>
		          <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18">
		              <div class="text">
		                <strong class="number" data-number="4500">0</strong>
		                <span>Qualified Medical</span>
		              </div>
		            </div>
		          </div>
		          <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18">
		              <div class="text">
		                <strong class="number" data-number="1000">0</strong>
		                <span>FrontToBack Patient</span>
		              </div>
		            </div>
		          </div>
		          <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18">
		              <div class="text">
		                <strong class="number" data-number="320">0</strong>
		                <span>Patients Per Year</span>
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
	      </div>
    	</div>
    </section>
</body>
</html>