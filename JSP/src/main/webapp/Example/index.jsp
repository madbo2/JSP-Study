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

	<div align="center">
		<table border="1" cellspacing="0px" width="400" height="70">
		<tr>
			<th>
				<font size="5"> 정보 관리 사이트 </font>
			</th>
		</tr>	
		</table>
	</div>
	
	<div align="center">
		<table width="400" height="100">
		<tr align="center">
		<td>
			<input type = "button" value="입력">
		</td>
		<td>
			<input type = "button" value="수정">
		</td>
		<td>
			<input type = "button" value="삭제">	
		</td>
		<td>
			<input type = "button" value="검색">
		</td>
		</tr>
		</table>
	
	</div>
	<div align="center">
		<table width="400px" height="50">
			<tr align="center">
				<td>내용물</td>
			</tr>
		</table>
	</div>
	

</body>
</html>