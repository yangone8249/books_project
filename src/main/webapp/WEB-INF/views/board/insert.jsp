<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 질문 등록</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/insert.css" />
</head>
<body>
	<jsp:include page="/resources/header/header.jsp"></jsp:include>
	<div id="firstContent">
		<div class="QnAContent">
			<form action="/board/insert" method="post" enctype="multipart/form-data">
			<div class="top">
				<div class="title"><span>도서 제목 : </span><input type="text" name="title"/></div>
				<div class="writer"><span>저자 : </span><input type="text" name="writer"/></div>
				<div class="email"><span>등록자 : </span><input type="text" name="user" value="${user.userId }" readonly/></div>
				<div class="file">
					<img id="img" src="/resources/img/noImg.png" style="width:150px; height: 115px;">
					<span>이미지 첨부는 ("jpg", "png", "jpeg", "gif", "bmp")만 가능합니다. </span>
					<input type="file" id="file" name="file" onchange="fileChange()"/>
				</div>
			</div>
			<div class="body">
				<div>도서 내용</div>
				<textarea rows="" cols="" name="content"></textarea>
			</div>
				<button type="button">이전</button>
				<button type="submit">등록하기</button>
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
<script type="text/javascript" src="/resources/js/insert.js"></script>
</body>
</html>