<%@page import="student.StudentDTO.StudentDTO"%>
<%@page import="student.studentDAO.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	
	StudentDAO dao = new StudentDAO();
	
	StudentDTO dto = dao.selectOne(name);
	
	if(dto == null){
		String msg = "겁색 결과가 존재하지 않습니다.";
		request.setAttribute("msg", msg);
		pageContext.forward("/update/form.jsp");
	}
	
	request.setAttribute("name", dto.getName());
	request.setAttribute("code", dto.getCode());
	request.setAttribute("value", dto.getvalue());
	
	pageContext.forward("/update/form.jsp");
	
%>