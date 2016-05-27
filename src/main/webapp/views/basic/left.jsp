<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<security:authorize access="isAnonymous()">
<a href="toLoginPage">click here to login</a><br>
</security:authorize>
<security:authorize access="isAuthenticated()">click here to logout
<form action="logout" method="post">
 <input type="submit">
 <input type="hidden" 	name="${_csrf.parameterName}"	value="${_csrf.token}"/> 
 </form>
</security:authorize>


<security:authorize access="isAuthenticated()">
<form action="addplayer" method="post"> add player <input type="submit">
<input type="hidden" 	name="${_csrf.parameterName}"	value="${_csrf.token}"/>
</form>
</security:authorize><br>

<form action="showAllGames" method="get"> show all games <input type="submit"></form><br>

<security:authorize access="isAuthenticated()">


<form  action="chooseMatch" method="post"> add points into match <input type="submit">
<select name="selGame"> 
<c:forEach items="${games}" var="singleGame">
<option value="${singleGame.id}">${singleGame.id}</option>
</c:forEach>
 </select>
<input type="hidden" 	name="${_csrf.parameterName}"	value="${_csrf.token}"/>
</form>
</security:authorize><br>
</body>
</html>