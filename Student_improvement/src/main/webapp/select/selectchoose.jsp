<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
<div align="center">
	<h3> 코드 입력 </h3>
	<input type="button" class="button" value="이름검색" onclick="document.location.href='/Student_improvement/select/nameSelect.jsp'">
	<input type="button" class="button" value="코드검색" onclick="document.location.href='/Student_improvement/select/codeSelect.jsp'">
	<input type="button" class="button" value="전체검색" onclick="document.location.href='/Student_improvement/select/selectAll.jsp'">
</div>
<%@ include file="/layout/footer.jsp"%>