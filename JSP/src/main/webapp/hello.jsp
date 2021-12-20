<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	private int age = 18;

	public void addAge(){
		age++;
	}
	%>  
    
<%
	String name = "김민준";
	//int age = 18;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<% addAge(); %>
		이름 : <%=name %>
		나이 : <%=age %>
		<%if(age >= 20){ %> 
			성인
		<%} else{%>
			미성년자
		<%}
		%>
	</div>
</body>
</html>