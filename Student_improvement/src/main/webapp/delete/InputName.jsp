<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function check(){
		if(document.input.name.value == ""){
			alert("이름을 입력하세요");
			document.input.name.focus();
		} else {
			document.input.submit();
		}
	}
</script>
<%@ include file="/layout/header.jsp" %>	
<div align="center">	
 <h3> 삭제할 이름을 입력하세요 </h3>
 <form action = "/Student_improvement/delete/delete.jsp" method="post" name="input">
 	<table Style="width: 250px;">
		<tr>
				<th width="25%">Name</th>
				<td><input type="text" name="name"> </td>
		</tr>
		<tr>
				<td colspan="2" align="right">
					<input type="button" value = "삭제" onclick="javascript:check()">
					<input type="reset" value ="다시">
			</tr>
	</table>
	</form>
</div>
<%@ include file="/layout/footer.jsp" %>