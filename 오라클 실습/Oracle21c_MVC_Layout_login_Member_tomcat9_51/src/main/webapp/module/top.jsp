<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <!-- Begin Wrapper -->
   <div id="wrapper">
   
         <!-- Begin Header -->
         <div id="header">
         /module/top.jsp	<br/>
		       ��� �޴�	<br/><br/>
		       
<c:choose>
    <c:when test="${sessionScope.S_LEVEL eq null}">
   		
   		<c:out value="${sessionScope.S_LEVEL}" default="S_LEVEL ������ ��� �� null ���" /><br/>
   		
		<!-- 1 �α��� �� ȭ�� ���� -->	
		<a href="<%= request.getContextPath() %>/Min/m_insert_form.ksmart_m">01ȸ�����</a><br/>	       		 
		<form action="<%= request.getContextPath() %>/Login/login_pro.ksmart_m" method="post">
			���̵�:	<input type="text" name="id">
			��� : <input type="text" name="pw">
			<input type="submit" value="�α��ι�ư"> 
		</form> 
		<!-- 1 �α��� �� ȭ�� �� -->
    </c:when>
    <c:otherwise>
		<!-- 2 �α��� �� -->
		<c:if test="${S_LEVEL eq '������'}"> 
			<a href="<%= request.getContextPath() %>/Min/m_insert_form.ksmart_m">01ȸ�����</a>
			<a href="<%= request.getContextPath() %>/Msearch/m_search_list.ksmart_m">02ȸ���˻�</a>
			<a href="#">03��ǰ���</a>
			<a href="#">04��ǰ�˻�</a>	
			<a href="#">05��ǰȸ��join�˻�1</a>	<br/>	
		</c:if>
		<c:if test="${S_LEVEL eq '�Ǹ���'}"> 
			<a href="<%= request.getContextPath() %>/Min/m_insert_form.ksmart_m">01ȸ�����</a>
			<a href="#">03��ǰ���</a>
			<a href="#">04��ǰ�˻�</a>	
			<a href="#">05��ǰȸ��join�˻�1</a>	<br/>	
		</c:if>
		<c:if test="${S_LEVEL eq '������'}"> 
			<a href="<%= request.getContextPath() %>/Min/m_insert_form.ksmart_m">01ȸ�����</a>
			<a href="#">04��ǰ�˻�</a>	
			<a href="#">05��ǰȸ��join�˻�1</a>	<br/>	
		</c:if>
		<!-- 2 �α��� �� -->
		<c:out value="${sessionScope.S_NAME}" default="null�� ��� default ��°� " /> ��
		<c:out value="${sessionScope.S_LEVEL}" default="null�� ��� default ��°� " /> ���� �α��� ��
		<a href="<%= request.getContextPath() %>/Login/loginout.ksmart_m">�α׾ƿ�</a>
    </c:otherwise>
</c:choose>
		 </div>
		 <!-- End Header -->
