<%@page import="student.studentDAO.StudentDAO"%>
<%@page import="student.StudentDTO.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//Post방식으로 넘겨온 Data들의 형식으 UTF-8로 지정하여 사용합니다. (한글)
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	
	String value = request.getParameter("value");
	int code = Integer.parseInt(request.getParameter("code"));
	System.out.println(name);
	System.out.println(value);
	System.out.println(code);
	
	StudentDTO dto = new StudentDTO(name, value, code);
	
	StudentDAO dao = StudentDAO.getInstance();
	
	int check = dao.update(dto);
	
	String msg = null;
	
	if(check != 0){
		msg = name+"님의 정보가 수정되었습니다.";
	} else {
		msg = name+"님의 정보 입력이 실패하였습니다.";
	}
	request.setAttribute("msg", msg);
	
	pageContext.forward("/update/result.jsp");
	
%>