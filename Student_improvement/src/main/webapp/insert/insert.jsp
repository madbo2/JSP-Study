<%@page import="student.studentDAO.StudentDAO"%>
<%@page import="student.StudentDTO.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	//앞서 작성한 Java Class File을 기반으로 DATA들을 DB에 추가해 줍니다.
	
	//Post방식으로 넘겨온 Data들의 형식으 UTF-8로 지정하여 사용합니다. (한글)
	request.setCharacterEncoding("UTF-8");

	//앞서 form에서 작성되어 넘겨받은 Data들을 getParameter를 통해 새롭게 객체에 저장합니다.
	String name = request.getParameter("name");
	String value = request.getParameter("value");
	int code = Integer.parseInt(request.getParameter("code"));
	
	// 앞서 작성한 Java 기반의 Data 처리 객체들을 지정하고 JDBC를 통해 DB에 추가시켜 줍니다.
	StudentDTO dto = new StudentDTO(name, value, code);
	
	StudentDAO dao = new StudentDAO();
	
	boolean check = dao.insert(dto);
	
	String msg = null;
	
	// 작업의 성공 유무 확인을 Request내부 Attribute에 추가시켜 forward 형식으로 전달합니다.
	if(check){
		msg = name+"님의 정보가 추가되었습니다.";
	} else {
		msg = name+"님의 정보 입력이 실패하였습니다.";
	}
	request.setAttribute("msg", msg);
	
	pageContext.forward("/insert/result.jsp");
%>