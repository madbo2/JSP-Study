<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String value = request.getParameter("value");
	int code = Integer.parseInt(request.getParameter("code"));
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
		if(document.input.value.value == ""){
			alert("수정할 값을 입력하세요");
			document.input.value.focus();
		} else if(document.input.code.value ==""){
			alert("수정할 값을 입력하세요");
			document.input.value.focus();
		} else {
			document.input.submit();
		}
	}

</script>

<%@ include file="/layout/header.jsp" %>		
<div align="center">
	
	<!--  Post방식으로 전달합니다. Attribute에 지정된 Name은 Input Hidden으로 함께 넘겨줍니다. -->
	<form action = "/Student_improvement/update/update.jsp" method="post" name="input">
	<input type="hidden" name="name" value="<%=name%>">
	<table style="width:250px">
		<caption align="center"><h4>수정할 내용 입력</h4></caption>
			<tr>
				<th width="25%"> Code </th>
				<td><input type="text" name = "code" placeholder="1.학생 2.교수 3.관리자"></td>
				
			</tr>
			<tr>
				<th width="25%"> Value </th>
				<td><input type="text" name = "value" placeholder="value입력"></td>
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