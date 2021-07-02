<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	String d = "watermelon";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
html, body {
	border:1px solid;
	margin:0;
	padding:0;
}
body {
	font-family:맑은 고딕;
}
#wrapper {
	position:absolute;
	width:500px;
	height:500px;
	top:50%;
	left:50%;
	transform: translate(-50%, -50%);
}
form {
	text-align:center;
	position:relative;
	top:50%;
	left:50%;
	transform: translate(-50%, -50%);
}
</style>
<title>로그인 화면</title>
</head>
<body>
<div id="wrapper">
	<form action="servlet" method="post">
		<fieldset>
		<legend>로그인</legend>
			<div>
			<label>ID: </label>
			<input name="id">
			</div>
			<div>
			<label>Password: </label>
			<input type="password" name="password"><br>
			</div>
			<div>
			<input type="submit" value="로그인"><br>
			</div>
		</fieldset>
	</form>
</div>
</body>
</html>
