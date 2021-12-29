<%@page import="student.StudentDTO.StudentDTO"%>
<%@page import="java.util.List"%>
<%@page import="student.studentDAO.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	StudentDAO dao = StudentDAO.getInstance();
	
	List<StudentDTO> list = dao.selectAll();
	
	request.setAttribute("list", list);
	
	pageContext.forward("/select/form.jsp");
%>