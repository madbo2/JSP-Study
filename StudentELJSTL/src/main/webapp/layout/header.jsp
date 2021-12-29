<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
	.header {
		width: 400px;
		margin: 20px auto;
		text-align: center;
	}
	
	.headline {
		border: 1px black solid;
		width: inherit;
		font-size: 30px;
		font-weight: bold;
		padding: 15px 0px;
	}

	.button{
		font-weight: bold;
		font-size: large;
		margin: 20px;
	}
	
	.main{
		width: 400px;
		text-align: center;
		margin: 20px auto;
		min-height: 300px;
	}
	
	a:link {
		text-decoration: none;
		color: black;
	}
	
	a:visited {
		text-decoration: none;
		color: black;
	}
	
	a:hover {
		color: pink;
	}
	
	table,tr,td,th {
		border: 1px black solid;
		border-spacing: 0px;
	}

</style>
<title>정보 관리 페이지</title>
</head>

<body>

	<div class="header">
		<div class="headline">
				<a href='\StudentELJSTL\Index.jsp'> 정보 관리 사이트</a>
		</div>
	</div>	
	<div align="center">
		
			<input type = "button" class="button" value="입력" onclick="document.location.href='/StudentELJSTL/insert/code.jsp'">
		
			<input type = "button" class="button" value="수정" onclick="document.location.href='/StudentELJSTL/update2/nameInput.jsp'">
		
			<input type = "button" class="button" value="삭제" onclick="document.location.href='/StudentELJSTL/delete/InputName.jsp'">	
		
			<input type = "button" class="button" value="검색" onclick="document.location.href='/StudentELJSTL/select/selectchoose.jsp'">
	
	</div>
	<div class="main">