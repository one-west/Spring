<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>
<h2><spring:message code="login.title" /></h2>
<form:form action="" modelAttribute="loginCommand" method="post">
    <form:errors />
    <p>
        <label for="email"><spring:message code="email"/> </label>
        <form:input path="email"/>
        <form:errors path="email"/>
    </p>
    <p>
        <label for="password"> <spring:message code="password"/></label>
        <form:password path="password"/>
        <form:errors path="password"/>
    </p>
    <p>
        <label><spring:message code="rememberEmail"/> </label>
        <form:checkbox path="rememberEmail"/>
    </p>
    <input type="submit" value="<spring:message code="login.btn"/>" />
</form:form>
</body>
</html>