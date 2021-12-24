<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String msg = (String) request.getAttribute("msg");
%>

<%@ include file="/layout/header.jsp" %>		
	<h3><%=msg %></h3> 
<%@ include file="/layout/footer.jsp" %>