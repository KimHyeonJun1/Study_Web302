<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class= "member.MemberDTO"/>
<jsp:setProperty property="*" name="member" />

<jsp:getProperty property="name" name="member"/>
성별: <%=member.getGender() %>

</body>
</html>