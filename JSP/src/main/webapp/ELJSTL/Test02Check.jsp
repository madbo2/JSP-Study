<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));

	request.setAttribute("x", x);
	session.setAttribute("y", y);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		${param['x'] } + ${param['y'] } = ${param['x'] + param['y'] }<br>
		${param['x'] } - ${param['y'] } = ${param['x'] - param['y'] }<br>
		${param.x } + ${param.y } = ${param.x * param.y }<br>
		${param.x } + ${param.y } = ${param.x / param.y }<br> 
		${requestScope.x } + ${sessionScope.y } = ${x / y }<br> 
	</body>
</html>
