<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%!
	
%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border = "1",width = "600", heigth="500", align="center">
		<caption><font size="5"><b>구구단 </b></font></caption>
			<tr align="center">
				<%for(int i=2; i<10;i++){ %>
				<td><%=i+"단"%></td>
				<%} %>
			</tr>
			<%for(int i=1;i<10;i++){ %>
			
			<tr>
				<%for(int j=2;j<10;j++){ %>
				<td> <%=j%>x<%=i %>=<%=j*i %></td>
				<%} %>
			</tr>
			<%} %>
			
		</table>
	
	
	</div>

</body>
</html>