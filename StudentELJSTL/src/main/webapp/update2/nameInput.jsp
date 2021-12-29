<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function check(){
		if(document.input.name.value == ""){
			alert("이름을 입력하십시오!");
			document.input.name.focus();
		}else{
			document.input.submit();
		}
	}
</script>
<%@ include file="/layout/header.jsp" %>
<div align="center">
	<h3>정보 입력</h3>
	<form action="/StudentELJSTL/update2/update.jsp" method="post" name="input">
		<table style="width: 300px;">
			<tr>
				<th>수정할 이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="입력" onclick="javascript:check()">
					<input type="reset" value="다시">
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="/layout/footer.jsp" %>