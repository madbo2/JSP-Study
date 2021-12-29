<%@page import="student.StudentDTO.StudentDTO"%>
<%@page import="student.studentDAO.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	
	StudentDAO dao = StudentDAO.getInstance();
	
	StudentDTO dto = dao.selectOne(name);
	
	if(dto == null){
		String msg = "겁색 결과가 존재하지 않습니다.";
		request.setAttribute("msg", msg);
		pageContext.forward("/update/form.jsp");
	}
	String codeValue = null;
	String strValue = null;
	
	switch(dto.getCode()){
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
	request.setAttribute("codeValue", codeValue);
	request.setAttribute("strValue", strValue);
	request.setAttribute("name", dto.getName());
	request.setAttribute("code", dto.getCode());
	request.setAttribute("value", dto.getvalue());
	
	
	
	pageContext.forward("/update/selectresult.jsp");
	
%>