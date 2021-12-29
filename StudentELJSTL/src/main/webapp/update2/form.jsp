<%@page import="student.StudentDTO.StudentDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function check(){
		if(document.input.value.value==""){
			alert("${val}을 입력 하십시오!!");
			document.input.value.focus();
		}else{
			document.input.submit();
		}
	}
</script>

<%@ include file="/layout/header.jsp" %>
<div align="center">
	<h3>정보 수정</h3>
	<c:choose>
		<c:when test="${dto != null }">
		<form action="/StudentELJSTL/update2/checkUpdate.jsp" method="post" name="input">
			<input type="hidden" name="name"  value="${dto.name}">
			<table border="1" width="250">
				<tr>
					<th width="25%">Name</th>
					<td>${ dto.name }</td>
				</tr>
				<tr>
					<th width="25%">${ val }</th>
					<td><input type="text" name="value" value="${ dto.value }"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="button" value="수정" onclick="javascript:check()">
						<input type="reset" value="다시">
					</td>
				</tr>
			</table>
		</form>		
		</c:when>
		<c:otherwise>
			<h4>정보가 없습니다.</h4>
		</c:otherwise>
	</c:choose>
</div>
<%@ include file="/layout/footer.jsp" %>