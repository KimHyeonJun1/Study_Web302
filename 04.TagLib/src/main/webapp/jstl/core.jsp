<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>

<h2>페이지 URL연결</h2>
<div><a target = "_blank"href="<c:url value='http://www.naver.com'/>">네이버</a></div>

<h2>반복문 : 향상된forEach</h2>
<div>전화번호</div>
<c:forEach items= "${phones }" var="phone">
	<div>
	
	${phone.key} : ${phone.value}

	</div>
</c:forEach>


<h2>반복문 : 향상된forEach</h2>
<div>과목명</div>
<c:forEach items="${ subjects}" var="subject" varStatus="status"> 
	<div>
	<c:if test="${status.first }">처음</c:if>
	${status.last ? "끝" : "" }
	${status.index+1} : ${subject }
	<c:if test="${status.last }">끝</c:if>
	<div>
</c:forEach>


<h2>반복문 : 일반forEach</h2>
<div>1~10까지</div>
<c:forEach var="no" begin="1" end="10">
	<c:set var="sum" value="${sum + no }"/>
<span>${no }</span>
</c:forEach>
 <span> = ${sum}</span>

<hr>
<h2>조건문: choose</h2>
<c:set var="score" value="78"/>
<c:choose> 
	<c:when test="${score - 90 >=0 }"><c:set var="grade" value="A"/> </c:when>
	<c:when test="${score - 80 ge 0 }"><c:set var="grade" value="B"/></c:when>
	<c:when test="${score - 70 ge 0 }"><c:set var="grade" value="C"/></c:when>
	<c:when test="${score - 60 ge 0 }"><c:set var="grade" value="D"/></c:when>
	<c:otherwise><c:set var="grade" value="F"/></c:otherwise>
</c:choose>
<!-- >= 대신 ge 써도됨 -->
<div>성적: ${score } ${grade }학점</div>
<hr>
<h2>조건문: if</h2>
<c:set var="no1" value="30"/>
<c:set var="no2" value="20"/>
<div>${no1 } 과 ${no2 } 중 더 큰 수 :
<c:if test="${no1 - no2 gt 0 }">${no1 }</c:if> 
<!-- gt 는 < -->
<c:if test="${no1 - no2 lt 0 }">${no2 }</c:if>
<!--  li 는 > -->
</div>
<hr>
<h2>변수선언</h2>
<c:set var="name" value="홍길동"/>
<div>이름: ${name}</div>

<c:remove var="name"/>
<div>이름: ${name}</div>

</body>
</html>