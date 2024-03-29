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
	
	<section class="ftco-section contact-section ftco-degree-bg">
		<div class="container">
			<div class="col-md-12 mb-4">
		            <h2 class="h4">불편/민원 접수</h2>
		    </div>
			    <table class="table table-sm">
			        <colgroup>
			            <col width=10%>
			            <col width=40%>
			            <col width=20%>
			            <col width=30%>
			        </colgroup>
			        <tr>
			        	<td>
			        		조회 : <span style="color: red;">${allBoardCnt }</span>개
			        	</td>
			            <td colspan="3" align="right">
			            	<input type="hidden" id="changeInput">
			            	<select id="onePageViewCnt" onchange="getBoardList();">
			            		<option<c:if test="${onePageviewCnt eq 5 }">selected</c:if>>5</option>
			            		<option<c:if test="${onePageviewCnt eq 7 }">selected</c:if>>7</option>
			            		<option<c:if test="${onePageviewCnt eq 10 }">selected</c:if>>10</option>
			            	</select>
			            </td>
			        </tr>
			        <tr align="center">
			            <th>번호</th>
			            <th>제목</th>
			            <th>조회수</th>
			            <th>작성일</th>
			        </tr>
			        <tbody id="boardList">
			        	<c:forEach var="complimentBoardDTO" items="${complimentBoardList }">
			        		<tr align="center">
			        			<c:set var="startBoardIdx" value="${startBoardIdx + 1 }"/>
			        			<td>${startBoardIdx }</td>
			        			<td align="center">
			        				<a href="${contextPath }/common/complimentBoardDetail?complimentBoardId=${complimentBoardDTO.complimentBoardId}">${complimentBoardDTO.complimentBoardSubject }</a>
			        			</td>
			        			<td>${complimentBoardDTO.complimentBoardReadCnt }</td>
			        			<td><fmt:formatDate value="${complimentBoardDTO.complimentBoardEnrollDt }" pattern="yyyy-MM-dd"/></td>
			        		</tr>
			        	</c:forEach>
			        </tbody>
			        <tr align="right">
			        	<td colspan="4">
			        		<input type="button" value="글쓰기" class="btn btn-primary btn-outline-primary" onclick="location.href='${contextPath}/common/complimentAddBoard'">
			        	</td>
			        </tr>
			        <tr>
			        	<td colspan="4" align="center">
			        		<select id="searchKeyword">
			        			<option value="total">전체검색</option>
			        			<option value="patientId">아이디</option>
			        			<option value="complimentBoardSubject">제목</option>
			        			<option value="complimentBoardContent">내용</option>
			        		</select>
			        		<input type="text" id="searchWord" name="searchWord" value="${searchWord }">
			        		<input type="button" value="검색" onclick="getBoardList()" class="btn btn-primary btn-outline-primary">
			        	</td>
			        </tr>
			    </table>
			    <div style="display: table; margin-left: auto; margin-right: auto">
                	<ul>
                    	<c:if test="${startPage > 10 }">
                        	<a href="${contextPath }/common/complimentBoard?currentPageNumber=${startPage - 10}&onePageViewCnt=${onePageViewCnt }&searchKeyword=${searchKeyword }&searchWord=${searchWord }">이전 &nbsp;</a>
                        </c:if>
                        	<c:forEach var="i" begin="${startPage }" end="${endPage }">
                        		<a href="${contextPath }/common/complimentBoard?currentPageNumber=${i }&onePageViewCnt=${onePageViewCnt  }&searchKeyword=${searchKeyword }&searchWord=${searchWord}">${i }&nbsp;</a>
                        	</c:forEach>
                        <c:if test="${endPage != allPageCnt && endPage >=10}">
                        	<a href="${contextPath }/common/complimentBoard?currentPageNumber=${startPage + 10}&onePageViewCnt=${onePageViewCnt  }&searchKeyword=${searchKeyword }&searchWord=${searchWord}">다음</a>	
                        </c:if>
                     </ul>
                 </div>
			</div>
		</section>
</body>
</html>