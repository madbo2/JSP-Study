<%@page import="student.StudentDTO.StudentDTO"%>
<%@page import="student.studentDAO.StudentDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	
	StudentDAO dao = StudentDAO.getInstance();
	
	StudentDTO dto = dao.selectOne(name);
	
	if(dto != null){
		String val = null;
		
		switch(dto.getCode()){
		case 1:
			val = "학번";
			break;
		case 2:
			val = "과목";
			break;
		case 3:
			val = "부서";
			break;
		}
		
		request.setAttribute("val", val);
	}
	request.setAttribute("dto", dto);
	
	pageContext.forward("/update2/form.jsp");
%>