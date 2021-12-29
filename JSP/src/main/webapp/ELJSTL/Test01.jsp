<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%--
	EL(Expression Language)
	 - 표현언어...
	 - 자바코드 대신 표현하기 쉽게 하기위해 사용하는 언어
	 - 내장
	 - <% %>과 <%= %>대신에 EL/JSTL 사용을 권장한다.
	 - 영역과 속성 내장객체들안의 속성을 사용가능하다.
	 - 자바 메소드,연산.....
	 - ${ 코드 }
 --%>
 
 <!-- 
 	<11개의 기본 객체>
	1 pageContext : JSP의 page 기본 객체와 동일함
	2 pageScope : pageContext 기본 객체에 저장된 속성의 <속성, 값> 매핑을 저장한 Map 객체 
	3 requestScope : request 기본 객체에 저장된 속성의 <속성, 값> 매핑을 저장한 Map 객체 
	4 sessionScope : session 기본 객체에 저장된 속성의 <속성, 값> 매핑을 저장한 Map 객체  
	5 applicationScope : 
	    application 기본 객체에 저장된 속성의 <속성, 값> 매핑을 저장한 Map 객체 
	6 param : 요청 파라미터의 <파라미터이름, 값> 매핑을 저장한 Map 객체
	  	       타입은 String (request.getParameter(이름)의 결과와 동일)
	7 paramValues :  요청 파라미터의 <파라미터이름, 값 배열>매핑을 저장한 Map 객체 
	                          타입은 String[] 
	8 header : 요청 정보의 <헤더이름, 값> 매핑을 저장한 Map 객체
		        request.getHeader(이름)의 결과와 동일
	9 headerValues : 요청 정보의 <헤더이름, 값 배열> 매핑을 저장한 Map 객체	
			         request.getHeaders(이름)의 결과와 동일
	10 cookie : <쿠키 이름, Cookie> 매핑을 저장한 Map 객체
			request.getCookies()로 구한 Cookie 배열로부터 매핑을 생성
	11 initParam : 초기화 파라미터의<이름, 값> 매핑을 저장한 Map 객체
		            application.getInitParameter(이름)의 결과와 동일 
  -->
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="400">
		<tr>
			<th width="50%">표현식</th>
			<th>값</th>
		</tr>
		<tr>
			<td align="center">\${ 25+36 }</td>
			<td align="center">${ 25+36 }</td>
		</tr>
		<tr>
			<td align="center">\${ 25/6 }</td>
			<td align="center">${ 25/6 }</td>
		</tr>
		<tr>
			<td align="center">\${ 25%6 }</td>
			<td align="center">${ 25%6 }</td>
		</tr>
		<tr>
			<td align="center">\${ 25>36 }</td>
			<td align="center">${ 25>36 }</td>
		</tr>
		<tr>
			<td align="center">\${ header['host'] }</td>
			<td align="center">${ header['host'] }</td>
		</tr>
		<tr>
			<td align="center">\${ header.host }</td>
			<td align="center">${ header.host }</td>
		</tr>
	</table>
</body>
</html>
