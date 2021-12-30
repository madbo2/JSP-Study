<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
	.header {
		width: 1000px;
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
		border: 0;
		outline: 0;
		background-color:#FFFFFF;
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
				<input type="button" class="button" value="Login"> |
				<input type="button" class="button" value="Join"> |
				<input type="button" class="button" value="Board"> |
				<input type="button" class="button" value="Home">
		</div>
	</div>
	<div class="main">
		내용이 들어갑니다.
	</div>
	<div class="header">
		<div class="headline">
			<a>HtH Work copyright.</a>
		</div>
	</div>
</body>
</html>