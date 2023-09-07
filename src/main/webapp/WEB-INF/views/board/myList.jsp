<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 리스트</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/list.css" />
</head>
<body>
	<jsp:include page="/resources/header/header.jsp"></jsp:include>
	<div id="firstContent">
		<div class="QnAContent">
			<div class="searchDiv">
				<h2>${user.userId }의 대출리스트 입니다.</h2>
			</div>
			<!-- 리스트 라인 -->
			<div class="boardDiv">
			<table border="1" id="table">
				<tr id="titleTable">	
					<td>순번</td>
					<td>썸네일</td>
					<td>제목</td>
					<td>저자</td>
					<td>내용</td>
					<td>등록일</td>
					<td>조회수</td>
					<td>등록자</td>
				</tr>
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.boardNum}</td>
						<td>
						<c:if test="${list.boardImg ne null && list.boardImg ne '' }">
							<img src="/upload/th_${list.boardImg}">
						</c:if>
						</td>
						<td><a href="/board/detail?bno=${list.boardNum }" style="color: #6928ff;font-weight: bold;">${list.boardTitle }</a></td> 
						<td>${list.boardWriter }</td>
						<td>${list.boardContent }</td>
						<td>${list.boardRegDate }</td>
						<td>${list.boardCount }</td>
						<td>${list.boardUser }</td>
					</tr>	
				</c:forEach>
			</table>
			</div>
			<div class="btnDiv">
				<a href="/"><button type="button">이전</button></a>
			</div>	
				<!-- 페이지네이션 위치 -->
				<!-- 컨트롤러에서 page정보를 싣고 와야함. -->
				<!-- startPage~endPage까지 숫자 반복 forEach -->
			<div class="pageDiv">
				<!-- 이전페이지 -->
				<c:if test="${ph.prev }">
					<a href="/board/myList?pageNo=${ph.startPage-1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">이전</a>
				</c:if>
				<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
					<a href="/board/myList?pageNo=${i }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i } | </a>
				</c:forEach>
				<!-- 다음페이지 -->
				<c:if test="${ph.next }">	
					<a href="/board/myList?pageNo=${ph.endPage+1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">다음</a>
				</c:if>
			</div>
		</div>
	</div>	
</body>
</html>