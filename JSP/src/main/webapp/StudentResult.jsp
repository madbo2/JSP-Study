<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    int java = Integer.parseInt(request.getParameter("java"));
    int jsp = Integer.parseInt(request.getParameter("jsp"));
    int spring = Integer.parseInt(request.getParameter("spring"));
    
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
			<th>Name</tr>
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
			<td><%= (java+jsp+spring)/3 %> </td>
		</tr>
		
		</table>
	
	</div>
</body>
</html>