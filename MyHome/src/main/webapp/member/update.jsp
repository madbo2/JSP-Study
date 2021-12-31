<%@page import="myhomedao.MyHomeDAO"%>
<%@page import="myhomedto.MyHomeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	MyHomeDTO login = (MyHomeDTO)session.getAttribute("login");
	//dto.setEmail(request.getParameter("email"));
	//dto.setTel1(request.getParameter("tel1"));
	//dto.setTel2(request.getParameter("tel2"));
	//dto.setTel3(request.getParameter("tel3"));
	
	// 처음부터 Login에 직접적으로 Set 하여 사용하지 않는 이유는
	// 만약 Data 수정에 실패하게 되면 현재 접속한 Session의 Login을 수정하게 되면 문제가생긴다.
	// 그러므로 새로운 객체를 통해 수정하고 수정이 성공하면 session의 login 객체에 다시 set해준다.
	MyHomeDTO dto = new MyHomeDTO();
	dto.setNo(login.getNo());
	dto.setEmail(request.getParameter("email"));
	dto.setTel1(request.getParameter("tel1"));
	dto.setTel2(request.getParameter("tel2"));
	dto.setTel3(request.getParameter("tel3"));
	
	
	boolean check = MyHomeDAO.getInstance().updateMember(dto);
	
	String msg = null;
	String url = null;
			
	if(check){
		//session.setAttribute("login", login);
		login.setEmail(request.getParameter("email"));
		login.setTel1(request.getParameter("tel1"));
		login.setTel2(request.getParameter("tel2"));
		login.setTel3(request.getParameter("tel3"));
		msg = "수정완료 MyPage로";
		url = "MyHome/member/mypage.jsp";
		
	}else{
		msg = "수정실패 이전페이지로";
		url = "MyHome/member/updateform.jsp";
	}
	request.setAttribute("msg", msg);
	request.setAttribute("url", url);
	
	pageContext.forward("/member/result.jsp");
	
	
%>