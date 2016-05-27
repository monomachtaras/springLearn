<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
<h1>header</h1>
<select name="bindCustomer"> 
<c:forEach items="${players}" var="singlePlayer">
<option value="${singlePlayer.id}">${singlePlayer.name}</option>
</c:forEach>
 </select>
</body>
</html>