<%@page import="myhomedto.MyHomeDTO"%>
<%@page import="myhomedao.MyHomeDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	//MyHomeDTO dto = new MyHomeDTO();
	//dto.setId(request.getParameter("id"));
	//dto.setPassword(request.getParameter("password"));
	//dto.setName(request.getParameter("name"));
	//dto.setEmail(request.getParameter("email"));
	//dto.setTel1(request.getParameter("tel1"));
	//dto.setTel2(request.getParameter("tel2"));
	//dto.setTel3(request.getParameter("tel3")); 
%>
<!-- 
	jsp액션 태그
	 - JAVA코드를 대신 적을수 있게 만드는 태그
	useBean - 클래스의 객체를 생성해주는 태그
		- Class의 Default 생성자를 호출합니다.
		- id - 객체명
		- class - 사용할 클래스의 완전한 경로
		- scope - 사용할 범위 ... page,request,session,application
		
	setProperty - 객체의 멤버변수의 값을 파라미터값으로 넘어온 데이터를 셋팅해주는 태그
		- 자동으로 DTO의 setter와 연결되어 자동으로 데이터를 넣어준다..
		- property - 셋팅할 property명
		- name - 사용할객체명
		
	자동으로 연결되는 DTO는 Default 생성자가 사용되고, 자동으로 연결되어 입력되는 데이터들은
	setter가 사용되므로 dto의 기본 형식은 규정되어 있다.
-->


<jsp:useBean id="dto" class="myhomedto.MyHomeDTO" scope="page"/>
<jsp:setProperty property="*" name="dto"/>	
<!--  DTO 안에 없는 값은 자동 연결시켜주어도 자동으로 버려짐 -->

<%
	
	//dto.setName("");

	MyHomeDAO dao = MyHomeDAO.getInstance();

	boolean check = dao.insert(dto);
	out.write("<script>");
	if(check){
		out.write("alert('회원 가입에 성공하셧습니다..로그인페이지로..');");
		out.write("location.href='/MyHome/login/login.jsp?id=" + dto.getId() + "';");
		// 입력받은 ID값을 Login 창으로 넘겨주어서 띄워줌. (Get 방식)
	}else{
		out.write("alert('회원가입에 실패하셨습니다...이전페이지로..');");
		out.write("history.back();");
	}
	out.write("</script>");
%>