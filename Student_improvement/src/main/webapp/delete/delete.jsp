<%@page import="student.StudentDTO.StudentDTO"%>
<%@page import="student.studentDAO.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	
	String name = (String)request.getParameter("name");
	
	StudentDAO dao = new StudentDAO();
	
	boolean check = dao.delete(name);
	String msg = null;
	
	if(check){
		msg = name+"의 정보 삭제가 성공적으로 이루어졌습니다.";
		
	} else {
		msg = name+"의 정보 삭제가 실패하였습니다.";
	}
	
	request.setAttribute("msg", msg);
	pageContext.forward("/delete/result.jsp");
	
	
%>