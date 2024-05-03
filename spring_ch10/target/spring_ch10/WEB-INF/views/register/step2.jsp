<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h2>Step2 - 회원 정보 입력</h2>
<form:form action="step3" modelAttribute="forData">
    <%--<form action="step3" method="post">--%>
    <p>
        <label for="name"> 이름 : </label>
        <form:input path="name"/>
            <%--        <input type="text" name="name" id="name" value="${forData.name}">--%>
    </p>
    <p>
        <label for="email"> 이메일 : </label>
        <form:input path="email"/>
            <%--    <input type="text" name="email" id="email" value="${forData.email}">--%>
    </p>
    <p>
        <label for="password"> 비밀번호 : </label>
        <form:password path="password"/>
            <%--    <input type="text" name="password" id="password">--%>
    </p>
    <p>
        <label for="confirmPassword"> 비밀번호 확인 : </label>
        <form:password path="confirmPassword"/>
            <%--    <input type="text" name="confirmPassword" id="confirmPassword">--%>
    </p>
    <input type="button" value="다음 단계로 이동" onclick="submit()">
    </form>
</form:form>
</body>
</html>
