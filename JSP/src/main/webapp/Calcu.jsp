<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%!
	private int result;
	private int a=2,b=1;
	
	public int cal(int a,int b){
		
		this.result = a*b;
			
		return this.result;
	}
%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border = "4",width = "600", heigth="500", align="center">
		<caption><font size="5"><b>구구단 </b></font></caption>
			<tr align="center">
				<td><b>2단</b></td>
				<td><b>3단</b></td>
				<td><b>4단</b></td>
				<td><b>5단</b></td>
				<td><b>6단</b></td>
				<td><b>7단</b></td>
				<td><b>8단</b></td>
				<td><b>9단</b></td>
			</tr>
			<tr>
				<%for(int i=1;i>9;i++){ %>
				<td><%= this.a %> x <%=this.b %> = <%=result %>
				<%}%>
			</tr>
			
		</table>
	
	
	</div>

</body>
</html>