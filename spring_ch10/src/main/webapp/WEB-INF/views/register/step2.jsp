<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="member.register" /></title>
</head>
<body>
<h2><spring:message code="term" /></h2>
<p>약관 내용 (실제 데이터 영역)</p>
<form:form action="step3" modelAttribute="formData">
    <p>
        <label for="name"> 이름 : </label>
        <form:input path="name"/>
        <form:errors path="name"/>
            <%--        <input type="text" name="name" id="name" value="${forData.name}">--%>
    </p>
    <p>
        <label for="email"> 이메일 : </label>
        <form:input path="email"/>
        <form:errors path="email"/>
            <%--    <input type="text" name="email" id="email" value="${forData.email}">--%>
    </p>
    <p>
        <label for="password"> 비밀번호 : </label>
        <form:password path="password"/>
        <form:errors path="password"/>
            <%--    <input type="text" name="password" id="password">--%>
    </p>
    <p>
        <label for="confirmPassword"> 비밀번호 확인 : </label>
        <form:password path="confirmPassword"/>
        <form:errors path="confirmPassword"/>
            <%--    <input type="text" name="confirmPassword" id="confirmPassword">--%>
    </p>
    <input type="button" value="다음 단계로 이동" onclick="submit()">
</form:form>
</body>
</html>