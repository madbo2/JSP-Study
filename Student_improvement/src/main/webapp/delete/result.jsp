<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//앞서 전달받은 Attribute값을 String으로 받아와서 화면에 출력합니다.
	String msg = (String) request.getAttribute("msg");
%>

<%@ include file="/layout/header.jsp" %>		
	<h3><%=msg %></h3> 
<%@ include file="/layout/footer.jsp" %>