<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Board Remove</h2>
<form action="<c:url value='/board/boardRemove' />" method="post" >
<input name="boardNo" type="hidden" value="${param.boardNo}">
<div>비밀번호 확인 </div>
<input name="boardPw" type="password" value="${param.boardNo}"><br/>
<div>
	<input type="submit" value="삭제" />
	<input type="reset" value="초기화" />
	<a href="<c:url value='board/boardList' />">
	<input type="button" value="리스트" /></a>
</div>
</form>
</body>
</html>
