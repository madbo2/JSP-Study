<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
<div align="center">
	<h3> 코드 입력 </h3>
	<input type="button" class="button" value="학생" onclick="document.location.href='/Student_improvement/insert/codeCheck.jsp?code=1'">
	<input type="button" class="button" value="교수" onclick="document.location.href='/Student_improvement/insert/codeCheck.jsp?code=2'">
	<input type="button" class="button" value="관리자" onclick="document.location.href='/Student_improvement/insert/codeCheck.jsp?code=3'">
</div>
<%@ include file="/layout/footer.jsp"%>