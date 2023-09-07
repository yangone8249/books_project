<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="/resources/css/signUp.css" />
</head>
<body>
	<jsp:include page="/resources/header/header.jsp"></jsp:include>
	<div id="borderDiv">
	
		<div>
			<span>회원가입 페이지입니다.</span><br/>
			<form action="/user/signUp" method="post">
				ID : <input type="text" name="id" placeholder="최대 10글자" maxlength="10"/><br/>
				PW : <input type="password" name="pw" placeholder="최대 20글자" maxlength="20"/><br/>
				
				<button type="submit">회원가입</button>
			</form>
		</div>
	</div>
<script type="text/javascript">
	const id = `${id}`;
	const pw = `${pw}`;
<<<<<<< HEAD
	const idCheck = `${idCheck}`;
	console.log("id : "+id);
	console.log("pw : "+pw);
	console.log("idCheck : "+idCheck);
=======
	console.log("id : "+id);
	console.log("pw : "+pw);
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	if(id == 1){
		alert("ID를 입력해주세요.");
	}
	if(pw == 1){
		alert("PW를 입력해주세요.");
	}
<<<<<<< HEAD
	if(idCheck == 1){
		alert("아이디가 중복되었습니다.");
	}
=======
>>>>>>> 727353784ff21ddea1623784970f933179313c00
	
</script>
</body>
</html>