<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request객체에 데이터 저장...setAttribute
	//request.setAttribute("name", "해태봉");
	
	//response.sendRedirect("/JSP/move/end.jsp");
	//response.sendRedirect("/JSP/move/end.jsp?name=해태봉");
	
	//response.sendRedirect("/JSP/move/end.jsp?name=" + URLEncoder.encode("해태봉","UTF-8"));
	//Java에서 한글을 넘겨주려면 URLEncoder.encode() Method 이용
%>



<script type="text/javascript">
	document.location.href = "/JSP/move/end.jsp?name=해태봉";
</script>


