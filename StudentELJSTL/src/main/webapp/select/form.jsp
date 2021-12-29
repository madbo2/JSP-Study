<%@page import="student.StudentDTO.StudentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<%@ include file="/layout/header.jsp"%>
	<div align="center">
	<h2>${ msg }</h2>
		<c:choose>
			<c:when test="${list == null }">
				<h2>정보가 없습니다.</h2>
			</c:when>
			<c:otherwise>
				<table border="1">
				<tr>
					<th>이름</th>
					<th>값</th>
					<th>분류</th>
				</tr>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.name }</td>
						<td>${dto.value }</td>
					<c:choose>
							<c:when test= "${ dto.code == 1}">
								<td>학번</td>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test= "${ dto.code == 2}">
								<td>과목</td>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test= "${ dto.code == 3}">
								<td>부서</td>
							</c:when>
						</c:choose>
					</tr>
				</c:forEach>
					</table>
			</c:otherwise>
		</c:choose>
	<%-- 	<%if(list == null){ %>
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
						<c:choose>
							<c:when test= "${ dto.code == 1}">
								<td>학번</td>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test= "${ dto.code == 2}">
								<td>과목</td>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test= "${ dto.code == 3}">
								<td>부서</td>
							</c:when>
						</c:choose>
						</tr>
						<%} %>	
			</table>
			<%} %> --%>
	</div>
<%@ include file="/layout/footer.jsp"%>