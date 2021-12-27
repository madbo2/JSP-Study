<%@page import="student.StudentDTO.StudentDTO"%>
<%@page import="student.studentDAO.StudentDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	
	StudentDAO dao = new StudentDAO();
	
	List<StudentDTO> list = dao.select(name);
	
	request.setAttribute("list", list);
	request.setAttribute("msg", "이름 검색");
	
	pageContext.forward("/select/form.jsp");
	
	
%>