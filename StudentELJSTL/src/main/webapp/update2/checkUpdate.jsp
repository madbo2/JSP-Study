<%@page import="student.studentDAO.StudentDAO"%>
<%@page import="student.StudentDTO.StudentDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String value = request.getParameter("value");
	
	StudentDTO dto = new StudentDTO();
	
	dto.setName(name);
	dto.setValue(value);
	
	StudentDAO dao = StudentDAO.getInstance();
	
	int check = dao.update(dto);
	
	String msg = null;
	if(check != 0){
		msg = name + "님의 정보가 수정되었습니다.";
	}else{
		msg = "정보 수정에 실패하였습니다.";
	}
	
	request.setAttribute("msg", msg);
	
	pageContext.forward("/update2/result.jsp");
%>