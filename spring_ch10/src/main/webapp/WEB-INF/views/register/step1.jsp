<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sprin" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="member.register"/> </title>
</head>
<body>
<h2><spring:message code="term"/></h2>
<p>약관 내용</p>
<form action="step2" method="post">
    <label>
        <input type="checkbox" name="agree" value="true"><spring:message code="term.agree"/>
    </label>
    <input type="button" value="다음 단계로 이동" onclick="submit()">
</form>
</body>
</html>
