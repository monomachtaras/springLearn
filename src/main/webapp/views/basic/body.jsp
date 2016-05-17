<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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

<form action="addPlayer" method="post">
name<input type="text" name="name"><br>
surname<input type="password" name="surname"><br>
YOB<input type="text" name="yearOfBirth"><br>
<input type="submit">
</form>
<!--  
<form action="addCity" method="post">
add city<input type="text" name="cityName">
<input type="submit">
</form>

<form action="connect" method="post">

<select name="bindCustomer"> 
<c:forEach items="${customers}" var="singleCustomer">
<option value="${singleCustomer.id}">${singleCustomer.eMail}</option>
</c:forEach>
 </select>
<select name="bindCity"> 
 <c:forEach items="${cities}" var="singleCity">
<option value="${singleCity.id}">${singleCity.cityName}</option>   
</c:forEach></select>
<input type="submit">

</form>



<sf:form action="sf" method="post" modelAttribute="emptyObj">
<sf:input path="login"/>
<sf:input path="password" type="password"/>
<sf:input path="eMail"/>
<input type="submit">
 </sf:form>
-->






</body>
</html>