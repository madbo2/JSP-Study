<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function check(){	// 경고창 함수 생성
		//alert(document.f.name.value);
		//document객체를 사용하여 'f'로 지정된 name 요소들을 제어함.
		// alert 함수를 이용하여 경고표시 후 focuse()함수 사용하여 표시함
		// 모든 경고를 해결하였을때 button으로 설정한 전송 부분을 submit()함수로 실행시킴(전달)
		if(document.f.name.value ==""){
			alert("이름을 입력하십시오");
			document.f.name.focuse();
		} else if(document.f.java.value ==""){
			alert("java을 입력하십시오");
			document.f.java.focuse();
		} else if(document.f.jsp.value =="") {
			alert("jsp을 입력하십시오");
			document.f.jsp.focuse();
		} else if(document.f.spring.value =="") {
			alert("spring을 입력하십시오");
			document.f.spring.focuse();
		} else {
			document.f.submit();
		}
	}

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="/JSP/quiz/StudentResult.jsp" method="post" name="f">
			<table border = "1">
				<tr>
					<th>Name</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>java</th>
					<td><input type="text" name="java"></td>
				</tr>
				<tr>
					<th>jsp</th>
					<td><input type="text" name="jsp"></td>
				</tr>
				<tr>
					<th>spring</th>
					<td><input type="text" name="spring"></td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="button" value="전송" onclick="javascript:check()"> 
						<input type="reset" value="다시">
					</th>
				</tr>
				
			</table>
			
		</form>
	</div>
</body>
</html>