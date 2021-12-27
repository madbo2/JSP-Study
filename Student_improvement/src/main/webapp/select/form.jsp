<%@page import="student.StudentDTO.StudentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<StudentDTO> list = (List<StudentDTO>)request.getAttribute("list");
	String code = null;
	String msg = (String)request.getAttribute("msg");
%>        
<%@ include file="/layout/header.jsp"%>
	<div align="center">
	<h2><%=msg %></h2>
		<%if(list == null){ %>
			<h2>정보가 없습니다.</h2>
			<%}else { %>
			<table border="1">
				<tr>
					<th>이름</th>
					<th>값</th>
					<th>분류</th>
				</tr>
				<%for(StudentDTO dto: list){ %>
					<tr>
						<td><%=dto.getName() %></td>
						<td><%=dto.getvalue() %></td>
						<%
							switch(dto.getCode()){
							case 1:
								code = "학번";
								break;
							case 2:
								code = "과목";
								break;
							case 3:
								code = "부서";
								break;
							}
							%>
							<td><%=code %></td>
						</tr>
						<%} %>	
			</table>
			<%} %>
	</div>
<%@ include file="/layout/footer.jsp"%>