<%@page import="myhomedao.*"%>
<%@page import="myhomedto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	MyHomeDTO dto = (MyHomeDTO)session.getAttribute("login");
	String password = request.getParameter("password");
	
	String msg = "";
	String url = "";
	
	if(!dto.getPassword().equals(password)){
		msg = "비밀번호가 틀렸습니다. 이전페이지로 돌아갑니다.";
		url = "/MyHome/member/mypage.jsp";
	}else{
		MyHomeDAO dao = MyHomeDAO.getInstance();
		boolean check = dao.deleteMember(dto.getNo());
		if(check){
			session.invalidate();
			msg = "회원 탈퇴가 성공적으로 이루어졌습니다. 첫 페이지로";
			url = "/MyHome/";
		}else{
			msg = "회원 탈퇴가 실패하였습니다. 다시 시도해주세요.";
			url = "/MyHome/member/deleteForm.jsp";
		}
		
	}
	request.setAttribute("msg", msg);
	request.setAttribute("url", url);
	
	pageContext.forward("/member/result.jsp");
	
%>












