<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- ����� ��� -->
<!-- <link rel="stylesheet" type="text/css" href="./css/main.css" /> -->
<!-- ������ ���1 : ������ : ������Ʈ�� ����Ǹ� ���ߴ�. ��? ���� 1�ﰳ ���� ���� -->
<!-- <link rel="stylesheet" type="text/css" href="/layoutMG45/css/main.css" /> -->
<!-- ������ ���2 -->
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css" />
</head>
<body>
<%@ include file="/module/top.jsp" %>
<%@ include file="/module/left.jsp" %>
<%@ include file="/msearch/m_search_form.jsp" %>
������ ��� /msearch/m_search_list.jsp 	<br><br>
<%-- <a href="${pageContext.request.contextPath}/Min/m_insert_form.ksmart_m">ȸ������</a><br><br> --%>
ȸ�� �˻� 						<br>
<table width="100%" border="1">
<tr>
	<td>���̵�</td><td>���</td><td>����</td><td>�̸�</td><td>�̸���</td><td>����</td><td>����</td>
</tr>
<c:forEach items="${alm}" var="alm" varStatus="status">
	<tr>
		<td>${alm.ora_id}</td>
		<td>${alm.ora_pw}</td>
		<td>${alm.ora_level}</td>
		<td>${alm.ora_name}</td>
		<td>${alm.ora_email}</td>
		<td>
<a href="<%= request.getContextPath() %>/Mup/m_update_form.ksmart_m?send_id=${alm.ora_id}">������ư</a>
							<!-- ������ư Ŭ���� ��� Ȯ���� ksmart_m���� ���� �� �۾� ���� -->			
		</td>
		<td>
<a href="<%= request.getContextPath() %>/Mdel/m_delete_pro.ksmart_m?send_id=${alm.ora_id}">������ư</a>
							<!-- ������ư Ŭ���� ��� Ȯ���� ksmart_m���� ���� �� �۾� ���� -->			
		</td>	
	</tr>
</c:forEach>
</table>
<%@ include file="/module/hadan.jsp" %>

</body>
</html>