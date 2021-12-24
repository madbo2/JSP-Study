<%@page import="student.studentDAO.StudentDAO"%>
<%@page import="student.StudentDTO.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String value = request.getParameter("value");
	int code = Integer.parseInt(request.getParameter("code"));
	
	StudentDTO dto = new StudentDTO(name, value, code);
	
	StudentDAO dao = new StudentDAO();
	
	boolean check = dao.insert(dto);
	
	String msg = null;
	
	if(check){
		msg = name+"님의 정보가 추가되었습니다.";
	} else {
		msg = name+"님의 정보 입력이 실패하였습니다.";
	}
	request.setAttribute("msg", msg);
	
	pageContext.forward("/insert/result.jsp");
%>