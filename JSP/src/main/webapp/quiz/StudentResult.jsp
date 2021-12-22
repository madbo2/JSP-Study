
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    request.setCharacterEncoding("UTF-8");		//Post방식으로 한글을 넘겨받을때 처리함
    String name = request.getParameter("name");
    int java = Integer.parseInt(request.getParameter("java"));
    int jsp = Integer.parseInt(request.getParameter("jsp"));
    int spring = Integer.parseInt(request.getParameter("spring"));
    double average = (java+jsp+spring)/3.0;
    String format = "#.##";
    DecimalFormat avg = new DecimalFormat(format);
    
    String savg = avg.format(average);
      %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<table border = "1">
		<tr>
			<th>Name</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>JAVA</th>
			<td><%=java %></td>
		</tr>
		<tr>
			<th>JSP</th>
			<td><%=jsp %></td>
		</tr>
		<tr>
			<th>Spring</th>
			<td><%=spring %></td>
		</tr>
		<tr>
			<th>Sum</th>
			<td><%=java+jsp+spring %></td>
		</tr>
		<tr>
			<th>Average</th>
			<td><%=savg%></td>
			
    	
		</tr>
		
		</table>
	
	</div>
</body>
</html>