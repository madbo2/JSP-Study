<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	private int age = 18;

	public void addAge(){
		age++;
	}
	%>  
    
<%
	String name = "�����";
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
		�̸� : <%=name %>
		���� : <%=age %>
		<%if(age >= 20){ %> 
			����
		<%} else{%>
			�̼�����
		<%}
		%>
	</div>
</body>
</html>