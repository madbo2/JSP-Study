<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% 
	//codeCheck 에서 넘겨받은 Request를 각 String, int 객체로 생성하여 사용합니다.
	String strValue= (String)request.getAttribute("strValue");
	int code = (int)request.getAttribute("code");
%>
<script type="text/javascript">
	function check(){
		if(document.input.name.value == ""){
			alert("이름 입력");
			document.input.name.focus();
		} else if(document.input.value.value ==""){
			alert("<%=strValue%> 입력");
			document.input.name.focus();
		} else {
			document.input.submit();
		}
	}
</script>

<%@ include file="/layout/header.jsp" %>		
<div align="center">
	<h3>정보 입력</h3>
	<form action = "/Student_improvement/insert/insert.jsp" method="post" name="input">
		<input type="hidden" name="code" value="<%=code%>">
		<table Style="width: 250px;">
			<tr>
				<th width="25%">Name</th>
				<td><input type="text" name="name"> </td>
			</tr>
			<tr>
				<th width="25%"><%=strValue%></th>
				<td><input type="text" name="value"> </td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value = "입력" onclick="javascript:check()">
					<input type="reset" value ="다시">
			</tr>
		</table>
	</form>
</div>
<%@ include file="/layout/footer.jsp" %>