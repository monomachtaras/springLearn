<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">  <%@include file="css/layout.css" %></style>

 
<title>Insert title here</title>
</head>
<body>
<div id="header"><tiles:insertAttribute name="header"></tiles:insertAttribute></div>
<div id="body"><tiles:insertAttribute name="body"></tiles:insertAttribute></div>
<div id="left"><tiles:insertAttribute name="left"></tiles:insertAttribute></div>


</body>
</html>