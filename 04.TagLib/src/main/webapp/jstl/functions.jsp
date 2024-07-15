<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<h2>함수라이브러리</h2>
<c:set var="library" value="  Functions Library " />
<div>${library }</div>
<ul>
	<li>문자열의 길이: ${fn: length(library) }</li>
	<li>문자열의 일부: ${fn: substring(library, 10, 13) }</li>
	<li>문자열의 일부: ${fn: substring(library, 10, fn: length(library)) }</li>
	
<c:set var="library" value="  Functions Library " />
	<li>공백제거: [${fn: trim(library) }]</li>	
</ul>

<c:set var="email" value="hong0204@naver.com"/>
<div>${email }</div>
<ul>
<li>특정문자열의 시작위치" ${fn: indexOf(email, "@") }</li>
<li>이메일 아이디: ${fn: substring(email,0 ,fn: indexOf(email, "@")) }</li>
<li>이메일 서비스: ${fn: substring(email, fn: indexOf(email, "@")+1, fn: length(email)) } </li>
<li>문자열 변경(com -> co.kr): ${fn: replace(email, "com",  "co.kr")}</li>
<li>문자열 변경(o -> e): ${fn: replace(email, "o", "e") }</li>
<li>대문자화 이메일: ${fn: toUpperCase(email) }</li>
<li>소문자화 이메일: ${fn: toLowerCase(library) }</li>
<li>존재 유무: ${fn: contains(email, "com") }</li>
<li>존재 유무: ${fn: contains(email, "co.kr") }</li>
<li><c:if test="${fn: contains(email, 'com') }">com 있음</c:if></li>
<li><c:if test="${not fn: contains(email, 'co.kr') }">co.kr 없음</c:if></li>
</ul>

<%
String fruits[] = {"귤", "감", "배"};
%>
<c:set var="fruits" value="<%= fruits %>"/>
<c:set var="subjects" value="java,jsp/css,oracle"/>
<ul>
	<li>${fruits }</li>
	<li>배열 요소를 하나로 연결: ${fn: join(fruits, "+") }</li>
	<li><c:forEach items="${fn: split(subjects, ',/') }" var="s" varStatus="state">
		<span>${state.index+1 }.${s} ${!state.last ? "," : "" }</span>	
		</c:forEach>
	</li>
</ul>
</body>
</html>