<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>rmsoft 과제1 양휘원</title>
	<link rel="stylesheet" type="text/css" href="resources/css/home.css" />
</head>
<body>
	<jsp:include page="/resources/header/header.jsp"></jsp:include>
	<div id="firstContent">
		
		<div>
			<c:if test="${user eq null }">
				<span>도서대출관리 프로그램입니다. 아이디와 패스워드를 입력해주세요.</span><br/>
				<form action="/user/login" method="post">
					ID : <input type="text" name="id" /><br/>
					PW : <input type="password" name="pw" /><br/>
					<button type="submit">로그인</button>
				</form>
				<br/>
				<div>
					<span>첫이용이시라면 회원가입을 해주세요.</span><br/>
					<a href="/user/signUp"><button type="button">회원가입 페이지로 이동</button></a>
				</div>
			</c:if>
			<c:if test="${user ne null }">
				<a href="/board/insert"><button type="button">도서 등록</button></a><br/>
				<a href="/board/allList"><button type="button">등록된 도서 리스트</button></a><br/>
				<a href="/board/myList"><button type="button">내 대출이력 확인</button></a><br/>
				<a href="/user/logout"><button type="button">로그아웃</button></a><br/>
			</c:if>
		</div>
	</div>
	<script type="text/javascript">
		const id = `${id}`;
		const pw = `${pw}`;
		const uvo = `${uvo}`;
		const ses = `${ses}`;
		console.log("id : "+id);
		console.log("pw : "+pw);
		console.log("uvo : "+uvo);
		console.log("ses : "+ses);
		if(id == 1){
			alert("ID를 입력해주세요.");
		}
		if(pw == 1){
			alert("PW를 입력해주세요.");
		}
		if(uvo == 1){
			alert("없는 계정입니다.");
		}
		if(ses == 1){
			alert("세션이 끊겼습니다. 다시 로그인해주세요.");
		}
</script>
</body>
</html>
