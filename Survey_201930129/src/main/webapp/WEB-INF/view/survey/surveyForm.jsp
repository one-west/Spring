<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>설문조사</title>
</head>
<body>
<h2>설문조사</h2>
<form:form action="" modelAttribute="formData" method="post">
    <form:errors/>
    <p>

        <label for="Q1">1. 당신의 희망 분야는?</label>
        <form:radiobuttons path="Q1">
            <form:radiobutton value="서버" path="Q1"/> 서버개발자
            <form:radiobutton value="프론트" path="Q1"/> 프론트개발자
            <form:radiobutton value="풀스택" path="Q1"/> 풀스택개발자
        </form:radiobuttons>
        <form:errors path="email" cssStyle="color: red"/>
    </p>
    <p>
        <label for="Q2">2. 가장 많이 사용하는 개발도구는?</label>
        <form:radiobuttons path="Q2">
            <form:radiobutton value="Eclipse" path="Q2"/>
            <form:radiobutton value="IntelliJ" path="Q2"/>
            <form:radiobutton value="VSCode" path="Q2"/>
        </form:radiobuttons>
        <form:errors path="email" cssStyle="color: red"/>
    </p>
    <p>
        <label for="Q3">3. 하고 싶은 말</label>
        <form:input path="Q3"/> <br>
        <form:errors path="Q3" cssStyle="color: red"/>
    </p>
    <p>
        <label>응답자 이름</label>
        <form:input path="respondentName"/>
    </p>
    <p>
        <label>응답자 나이</label>
        <form:input path="respondentAge"/>
    </p>
    <input type="submit" value="전송"/>
</form:form>
</body>
</html>