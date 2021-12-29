<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript">
	function check(){
		document.input.submit();
	}
</script>

<%@ include file="/layout/header.jsp" %>		
	<div align="center">
	<form action = "/StudentELJSTL/update/form.jsp" method="post" name="input">
	<input type="hidden" name="name" value="${ requestScope.name }">
	<input type="hidden" name="code" value="${ requestScope.code }">
	<input type="hidden" name="value" value="${ requestScope.value }">
	<table style="width:250px">
	<caption align="center"><h4>수정 전 정보</h4></caption>
		<tr>
			<th width="25%">Name</th>
			<th>${ requestScope.name }</th>
		</tr>
		<tr>
			<th width="25%">${ requestScope.strValue }</th>
			<th width="25%">${ value }</th>	
		</tr>
		<tr>
			<th width="25%">${ codeValue }</th>
			<th width="25%">${ code }</th>
		</tr>
		<tr>
				<td colspan="2" align="right">
				<input type="button" value = "수정" onclick="javascript:check()">
				<input type="reset" value ="다시"> </td>
		</tr>
	</table>
	</form>
	</div>
<%@ include file="/layout/footer.jsp" %>