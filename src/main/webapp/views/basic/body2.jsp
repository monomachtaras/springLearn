<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<h1>body </h1>
<form action="addGame" method="post">
p1set<input type="text" name="p1sets"><br>
p2set<input type="text" name="p2sets"><br>
<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}"/> 
<input type="submit">
</form>

<form action="connect" method="post">

<select name="bindGame"> 
<c:forEach items="${games}" var="singleGame">
<option value="${singleGame.id}">${singleGame.id}</option>
</c:forEach>
 </select>
 
<select name="bindPlayer1"> 
 <c:forEach items="${players}" var="singlePlayer">
<option value="${singlePlayer.id}">${singlePlayer.name}</option>   
</c:forEach></select>

<select name="bindPlayer2"> 
 <c:forEach items="${players}" var="singlePlayer2">
<option value="${singlePlayer2.id}">${singlePlayer2.name}</option>   
</c:forEach></select>

<input type="submit">
<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}"/> 
</form>

</body>
</html>