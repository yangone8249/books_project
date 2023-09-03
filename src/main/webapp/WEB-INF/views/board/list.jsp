<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 질문 등록</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/list.css" />
</head>
<body>
	<jsp:include page="/resources/header/header.jsp"></jsp:include>
	<div id="firstContent">
		<div class="QnAContent">
			<div class="searchDiv">
				<form action="/board/allList" method="get">
					<c:set value="${pgh.pgvo.type }" var="typed"></c:set>
					<select name="type">
					<!-- selected : 현재 내가 선택한 값 -->
						<option ${typed == null?'selected':'' }>선택</option>
						<option ${typed eq 't' ? 'selected':'' }value="t">제목</option>
						<option ${typed eq 'c' ? 'selected':'' }value="c">내용</option>
						<option ${typed eq 'w' ? 'selected':'' }value="w">저자</option>
						<option ${typed eq 'tc' ? 'selected':'' }value="tc">제목 + 내용</option>
						<option ${typed eq 'tw' ? 'selected':'' }value="tw">제목 + 저자</option>
						<option ${typed eq 'cw' ? 'selected':'' }value="cw">내용 + 저자</option>
					</select>
						<input type="text" name="keyword" placeholder="Search" value="${ph.pgvo.keyword }">
						<input type="hidden" name="pageNo" value="1">
						<input type="hidden" name="qty" value="${ph.pgvo.qty }">
					<button type="submit">Search</button>
					<div>등록된 도서 : ${count }</div>
				</form>
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
					<td>대출여부</td>
				</tr>
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.boardNum}</td>
						<td>
						<c:if test="${list.boardImg ne null && list.boardImg ne '' }">
							<img src="/upload/th_${list.boardImg}">
						</c:if>
						</td>
						<td><a href="/brd/detail" style="color: #6928ff;font-weight: bold;">${list.boardTitle }</a></td> 
						<td>${list.boardWriter }</td>
						<td>${list.boardContent }</td>
						<td>${list.boardRegDate }</td>
						<td>${list.boardCount }</td>
						<td>${list.boardUser }</td>
						<td>${list.boardLoan }</td>
					</tr>	
				</c:forEach>
			</table>
			</div>
			<div class="btnDiv">
				<a href="/board/insert"><button onclick="emailCheck()">새 질문 등록</button></a>
				<a href="/board/page?type='w'&keyword=${ses.id }"><button>내가쓴 글 보기</button></a> <br>
			</div>	
				<!-- 페이지네이션 위치 -->
				<!-- 컨트롤러에서 page정보를 싣고 와야함. -->
				<!-- startPage~endPage까지 숫자 반복 forEach -->
			<div class="pageDiv">
				<!-- 이전페이지 -->
				<c:if test="${pgh.prev }">
					<a href="/brd/page?pageNo=${pgh.startPage-1}&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">이전</a>
				</c:if>
				<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
					<a href="/brd/page?pageNo=${i }&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">${i } | </a>
				</c:forEach>
				<!-- 다음페이지 -->
				<c:if test="${pgh.next }">	
					<a href="/brd/page?pageNo=${pgh.endPage+1 }&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">다음</a>
				</c:if>
			</div>
		</div>
	</div>	
</body>
</html>