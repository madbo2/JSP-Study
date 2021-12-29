<%@page import="student.StudentDTO.StudentDTO"%>
<%@page import="java.util.List"%>
<%@page import="student.studentDAO.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int code = Integer.parseInt(request.getParameter("code"));

	StudentDAO dao = StudentDAO.getInstance();
	
	List<StudentDTO> list = dao.select(code);
	
	request.setAttribute("list", list);
	request.setAttribute("msg", "code Select");
	
	pageContext.forward("/select/form.jsp");
%>