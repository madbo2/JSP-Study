<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = (String)request.getAttribute("name");
	String value = (String)request.getAttribute("value");
	int code = (int)request.getAttribute("code");
	String codeValue = null;
	String strValue = null;
	
	switch(code){
	case 1:
		strValue = "학번";
		codeValue = "학생(1)";
		break;
	case 2:
		strValue = "과목";
		codeValue = "교수(2)";
		break;
	case 3:
		strValue = "부서";
		codeValue = "관리자(3)";
		break;
	}
%>
<script type="text/javascript">
	function check(){
		document.input.submit();
	}
</script>

<%@ include file="/layout/header.jsp" %>		
	<div align="center">
	<form action = "/Student_improvement/update/form.jsp" method="post" name="input">
	<input type="hidden" name="name" value="<%=name%>">
	<input type="hidden" name="code" value="<%=code%>">
	<input type="hidden" name="value" value="<%=value%>">
	<table style="width:250px">
	<caption align="center"><h4>수정 전 정보</h4></caption>
		<tr>
			<th width="25%">Name</th>
			<th><%=name %></th>
		</tr>
		<tr>
			<th width="25%"><%=strValue %></th>
			<th width="25%"><%=value %></th>	
		</tr>
		<tr>
			<th width="25%"><%=codeValue%></th>
			<th width="25%"><%=code %></th>
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