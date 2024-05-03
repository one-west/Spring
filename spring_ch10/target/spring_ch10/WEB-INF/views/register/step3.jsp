<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-03
  Time: 오전 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h2>Step3 - 회원가입 완료</h2>
<p>
    <strong>${forData.name}님</strong>
</p>
<p>회원가입을 완료했습니다.</p>
<a href="<c:url value='/main'/>">메인화면으로</a>
</body>
</html>
