<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>



<%@ include file="/layout/header.jsp" %>		
<div align="center">
	<h3>정보 입력</h3>
	<form action = "/Student_improvement/select/checkcode.jsp" method="post" name="input">
	<!-- Attribute로 넘어온 객체는 다음 페이지로 넘어가게 되면 사라집니다. Data를 다시 넘겨주기 위해 hidden type의 전달자를 사용합니다.
		 post방식으로 개인정보를 넘겨주어 각 name,value,code값을 insert.jsp 에 parameter로 넘겨주게 됩니다. -->
		<table Style="width: 250px;">
			<tr>
				<th width="25%">검색할 코드</th>
				<td>
					<select name="code">
						<option value="1">학생</option>
						<option value="2">교수</option>
						<option value="3">직원</option>
					</select>
				 </td>
			</tr>
			
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value = "입력">
					<input type="reset" value ="다시">
			</tr>
		</table>
	</form>
</div>
<%@ include file="/layout/footer.jsp" %>