<%@page import="myhomedao.MyHomeDAO"%>
<%@page import="myhomedto.MyHomeDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그인 처리...
	//쿠키파일 저장....
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	MyHomeDTO dto = new MyHomeDTO();
	
	dto.setId(id);
	dto.setPassword(password);
	
	MyHomeDAO dao = MyHomeDAO.getInstance();
	
	dto = dao.checkLogin(dto);
	
	boolean check = false;
	String msg = null;
	
	if(dto != null){
		msg = dto.getName() + "님이 로그인 하셨습니다.";
		check = true;
		
		//로그인 처리...
		session.setAttribute("login", dto);
		
		//쿠키파일 생성 유무
		
		//아이디 기억하기 체크 유무
		String ckid = request.getParameter("ckid");
		
		Cookie ck = null;
		
		Cookie[] cks = request.getCookies();	//검색
		
		if(cks != null){ 					//검색 결과가 존재하다면
			for(Cookie c : cks){
				if(c.getName().equals("ckid")){
					ck = c;
					break;
				}
			}
		}
		
		if(ckid != null){
			if(ck == null){
				//쿠키 객체 생성
				ck = new Cookie("ckid",id);
				
				//유효시간 설정
				ck.setMaxAge(60*60*24);
				
				//쿠키파일 생성
				response.addCookie(ck);				
			}else{
				if(!ck.getValue().equals(id)){
					ck.setValue(id);
					response.addCookie(ck);
				}
			}
		}else{
			if(ck != null){
				if(ck.getValue().equals(id)){
					ck.setMaxAge(0);
					response.addCookie(ck);
				}
			}
		}
		
	}else{
		msg = "아이디 혹은 비밀번호가 잘못되었습니다.";
	}
	
	request.setAttribute("check", check);
	request.setAttribute("msg", msg);
	
	pageContext.forward("/login/result.jsp");
%>























