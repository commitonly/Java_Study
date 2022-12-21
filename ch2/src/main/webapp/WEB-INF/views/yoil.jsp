<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%-- 이렇게 미리 들어갈 값을 생각해서 만들어 놓는것을 EL이라고 한다 EL(Expression Language)--%>
<%-- 아래에 이렇게 출력될 자리를 만들어놓으면 모델 객체에 값이 아래에 들어가서 클라이언트에게 전달되는 것이다 --%>
<h1>year=<%=request.getParameter("year")%></h1>
<p> ${year}년 ${month}월 ${day}일은 ${yoil}입니다.</p>

</body>
</html>
