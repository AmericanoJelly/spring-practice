<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("newLine", "\n");
pageContext.setAttribute("newSpace", " ");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/add" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td><td><input type="text" name="name" value=""></td>
				<td>비밀번호</td><td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" value="" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="등록"></td>
			</tr>
		</table>
	</form>
	<br>
	
	<c:set var='count' value='${fn:length(list) }' />
	<c:forEach items='${list }' var='vo'>
	<table width=510 border=1>
		<tr>
			<td>[${count-status.index }]</td>
			<td>${vo.name }</td>
			<td>${vo.reg_date }</td>
			<td><a href="${pageContext.request.contextPath}/delete/${vo.no}">삭제</a></td> 
		</tr>
		<tr>
			<td colspan=4>${fn:replace(fn:replace(vo.message, newSpace, '&nbsp;'), newLine, '<br />')}</td>
		</tr>
	</table>
	</c:forEach>
	<br>
	
</body>
</html>