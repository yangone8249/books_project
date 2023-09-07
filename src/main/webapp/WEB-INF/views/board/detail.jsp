<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/insert.css" />
</head>
<body>
	<jsp:include page="/resources/header/header.jsp"></jsp:include>
	<div id="firstContent">
		<div class="QnAContent">
			<form action="/board/update" method="get" enctype="multipart/form-data">
			<input type="hidden" value="${bvo.boardNum }" name="bno" id="bno"/>
			<div class="top">
				<div class="title"><span>도서 제목 : </span><input type="text" name="title" value="${bvo.boardTitle }" readonly/></div>
				<div class="writer"><span>저자 : </span><input type="text" name="writer" value="${bvo.boardWriter}" readonly/></div>
				<div class="email"><span>등록자 : </span><input type="text" name="user" value="${bvo.boardUser}" readonly/></div>
				<div class="file">
					<img id="img" src="/upload/${bvo.boardImg}" style="width:150px; height: 115px;">
					<input type="hidden" value="${bvo.boardImg}" name="img" />
				</div>
			</div>
			<div class="body">
				<div>도서 내용</div>
				<textarea rows="" cols="" name="content" readonly>${bvo.boardContent}</textarea>
			</div>
				<a href="/board/allList"><button type="button">이전</button></a>
				<c:if test="${user.userId eq bvo.boardUser || user.userId eq 'yang' }">
					<button type="submit">글 수정하기</button>
					<button type="button" onclick="alertEvent()">글 삭제하기</button></a>
				</c:if><br/>
				<div class="loan">
				<c:if test="${bvo.boardLoan eq 0 && bvo.boardAuth eq 0}">
					<a href="/board/loanUpdate?bno=${bvo.boardNum }&uno=${user.userNum}"><button type="button">도서 대출하기</button></a>			
				</c:if>
				<c:if test="${bvo.boardLoan eq user.userNum}">
					<a href="/board/loanDelete?bno=${bvo.boardNum }&uno=${user.userNum}"><button type="button">도서 반납하기</button></a>				
				</c:if>
				</div>
			</form>
		</div>
	
	
	
	
	</div>	
<script type="text/javascript">
		const title = `${title}`;
		const writer = `${writer}`;
		const file = `${file}`;
		const content = `${content}`;
		const img = `${img}`;
		console.log("title : "+title);
		console.log("writer : "+writer);
		console.log("file : "+file);
		console.log("content : "+content);
		console.log("img : "+img);
		if(title == 1){
			alert("제목을 입력해주세요.");
		}
		if(writer == 1){
			alert("저자를 입력해주세요.");
		}
		if(file == 1){
			alert("파일을 업로드해주세요.");
		}
		if(content == 1){
			alert("내용을 작성해주세요.");
		}
		if(img == 1){
			alert("이미지 파일로 업로드해주세요.");
		}
</script>
<script type="text/javascript" src="/resources/js/delete.js"></script>
</body>
</html>