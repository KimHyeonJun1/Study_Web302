<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>

<h2>포맷라이브러리</h2>
<div>1. 날짜</div>
<c:set var="today" value="<%=new java.util.Date() %>"/>
<ul>
	<li>오늘: ${today }</li>
	<li>오늘 기본형태: <fmt:formatDate value="${today }"/></li>
	<li>오늘 사용자형식: <fmt:formatDate pattern="yyyy년 MM월 dd일 E HH:mm:ss" value="${today }"/> </li>	
</ul>

<div>2. 숫자</div>
<c:set var="salary" value="1200000"/>
<div><fmt:formatNumber value="${salary }" groupingUsed="false"/></div>
<div><fmt:formatNumber value="12300.123" pattern="###0000000.000"/></div>


</body>
</html>