<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request.setCharacterEncoding("UTF-8");
	//request.setAttribute("name", "해태봉");

	//pageContext.forward("/move/end.jsp");

	//RequestDispatcher rd = request.getRequestDispatcher("/move/end.jsp");
	
	//rd.forward(request, response);
	
%>
 
<jsp:forward page="/move/end.jsp">
	<jsp:param value="해태봉" name="name"/>
</jsp:forward>




