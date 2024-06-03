<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<%@ include file="/msearch/m_search_form.jsp" %>
포워드 경로 /msearch/m_search_list.jsp 	<br><br>
<%-- <a href="${pageContext.request.contextPath}/Min/m_insert_form.ksmart_m">회원가입</a><br><br> --%>
회원 검색 						<br>
<table width="100%" border="1">
<tr>
	<td>아이디</td><td>비번</td><td>권한</td><td>이름</td><td>이메일</td><td>수정</td><td>삭제</td>
</tr>
<c:forEach items="${alm}" var="alm" varStatus="status">
	<tr>
		<td>${alm.ora_id}</td>
		<td>${alm.ora_pw}</td>
		<td>${alm.ora_level}</td>
		<td>${alm.ora_name}</td>
		<td>${alm.ora_email}</td>
		<td>
<a href="<%= request.getContextPath() %>/Mup/m_update_form.ksmart_m?send_id=${alm.ora_id}">수정버튼</a>
							<!-- 수정버튼 클릭시 경로 확장자 ksmart_m으로 변경 후 작업 시작 -->			
		</td>
		<td>
<a href="<%= request.getContextPath() %>/Mdel/m_delete_pro.ksmart_m?send_id=${alm.ora_id}">삭제버튼</a>
							<!-- 삭제버튼 클릭시 경로 확장자 ksmart_m으로 변경 후 작업 시작 -->			
		</td>	
	</tr>
</c:forEach>
</table>
<%@ include file="/module/hadan.jsp" %>

</body>
</html>