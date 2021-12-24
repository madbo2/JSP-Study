<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	
	//입력받은 Code를 통해 각 Code별 요구로 하는 Value를 처리하기 위한 코드
	//View에 직접적인 연관이 없이 코드만 실행됨. 
	
	int code = Integer.parseInt(request.getParameter("code"));
	
	String strValue = null;
	
	switch(code) {
		case 1:
			strValue = "학번";
		break;
		case 2:
			strValue = "과목";
			break;
		case 3:
			strValue = "부서";
			break;
	}
	request.setAttribute("code", code);
	request.setAttribute("strValue", strValue);
	
	pageContext.forward("/insert/form.jsp");
	
	//request 객체에 Attribute값을 저장하여 form.jsp파일로 넘겨줍니다.
%>