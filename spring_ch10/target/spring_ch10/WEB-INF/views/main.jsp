<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-03
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainPage</title>
</head>
<body>
<h1>환영합니다.</h1>
<a href="<c:url value='/main' />">[첫 화면으로 이동]</a>
<a href="<c:url value='/register/step1' />">[회원가입]</a>
</body>
</html>
