<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <!-- Begin Wrapper -->
   <div id="wrapper">
   
         <!-- Begin Header -->
         <div id="header">
         /module/top.jsp	<br/>
		       상단 메뉴	<br/><br/>
		       
<c:choose>
    <c:when test="${sessionScope.S_LEVEL eq null}">
   		
   		<c:out value="${sessionScope.S_LEVEL}" default="S_LEVEL 변수에 담긴 값 null 출력" /><br/>
   		
		<!-- 1 로그인 전 화면 시작 -->	
		<a href="<%= request.getContextPath() %>/Min/m_insert_form.ksmart_m">01회원등록</a><br/>	       		 
		<form action="<%= request.getContextPath() %>/Login/login_pro.ksmart_m" method="post">
			아이디:	<input type="text" name="id">
			비번 : <input type="text" name="pw">
			<input type="submit" value="로그인버튼"> 
		</form> 
		<!-- 1 로그인 전 화면 끝 -->
    </c:when>
    <c:otherwise>
		<!-- 2 로그인 후 -->
		<c:if test="${S_LEVEL eq '관리자'}"> 
			<a href="<%= request.getContextPath() %>/Min/m_insert_form.ksmart_m">01회원등록</a>
			<a href="<%= request.getContextPath() %>/Msearch/m_search_list.ksmart_m">02회원검색</a>
			<a href="#">03상품등록</a>
			<a href="#">04상품검색</a>	
			<a href="#">05상품회원join검색1</a>	<br/>	
		</c:if>
		<c:if test="${S_LEVEL eq '판매자'}"> 
			<a href="<%= request.getContextPath() %>/Min/m_insert_form.ksmart_m">01회원등록</a>
			<a href="#">03상품등록</a>
			<a href="#">04상품검색</a>	
			<a href="#">05상품회원join검색1</a>	<br/>	
		</c:if>
		<c:if test="${S_LEVEL eq '구매자'}"> 
			<a href="<%= request.getContextPath() %>/Min/m_insert_form.ksmart_m">01회원등록</a>
			<a href="#">04상품검색</a>	
			<a href="#">05상품회원join검색1</a>	<br/>	
		</c:if>
		<!-- 2 로그인 후 -->
		<c:out value="${sessionScope.S_NAME}" default="null일 경우 default 출력값 " /> 님
		<c:out value="${sessionScope.S_LEVEL}" default="null일 경우 default 출력값 " /> 권한 로그인 중
		<a href="<%= request.getContextPath() %>/Login/loginout.ksmart_m">로그아웃</a>
    </c:otherwise>
</c:choose>
		 </div>
		 <!-- End Header -->
