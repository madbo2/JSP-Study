<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
</head>

<body>

	<div class="header">
		<div class="headline">
				<a href="\student\index.jsp"> 정보 관리 사이트</a>
		</div>
	</div>	
	<div align="center">
		
			<input type = "button" class="button" value="입력">
		
			<input type = "button" class="button" value="수정">
		
			<input type = "button" class="button" value="삭제">	
		
			<input type = "button" class="button" value="검색">
	
	</div>
	<div class="main">