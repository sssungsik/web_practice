<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 상대경로 방법 -->
<!-- <link rel="stylesheet" type="text/css" href="./css/main.css" /> -->
<!-- 절대경로 방법1 : 문제점 : 프로젝트명 변경되면 망했다. 왜? 관련 1억개 파일 변경 -->
<!-- <link rel="stylesheet" type="text/css" href="/layoutMG45/css/main.css" /> -->
<!-- 절대경로 방법2 -->
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css" />
</head>
<body>
<%@ include file="/module/top.jsp" %>
<%@ include file="/module/left.jsp" %>
<form action="<%= request.getContextPath() %>/Mup/m_update_pro.ksmart_m" method="post">
<table border="1">
<tr>
	<td>아이디</td>
	<td><input type="text" name="ora_id" size="20" value="${m.ora_id}" readonly></td>
<tr>
<tr>
	<td>암호</td>
	<td><input type="text" name="ora_pw" size="20" value="${m.ora_pw}"></td>
<tr>
<tr>
	<td>권한</td>
	<td><input type="text" name="ora_level" size="20" value="${m.ora_level}"></td>
<tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="ora_name" size="20" value="${m.ora_name}"></td>
<tr>
<tr>
	<td>이메일</td>
	<td><input type="text" name="ora_email" size="20" value="${m.ora_email}"></td>
<tr>
<tr>
	<td colspan="4"><input type="submit" value="회원수정버튼"></td>
</tr>
</table>
</form>

<%@ include file="/module/hadan.jsp" %>
</body>
</html>
