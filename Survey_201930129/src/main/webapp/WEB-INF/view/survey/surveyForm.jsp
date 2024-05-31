<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>설문조사</title>
</head>
<body>
<h2>설문조사</h2>
<form:form action="" modelAttribute="surveyCommand" method="post">
    <form:errors />
    <p>
        <label>1. 당신의 희망 분야는?</label> <br>
        <label>
            <form:radiobutton value="서버" path="q1"/> 서버개발자
        </label>
        <label>
            <form:radiobutton value="프론트" path="q1"/> 프론트개발자
        </label>
        <label>
            <form:radiobutton value="풀스택" path="q1"/> 풀스택개발자
        </label>
        <br>
        <form:errors path="q1" cssStyle="color: red"/>
    </p>

    <p>
        <label>2. 가장 많이 사용하는 개발도구는?</label> <br>
        <label>
            <form:radiobutton value="Eclipse" path="q2"/> Eclipse
        </label>
        <label>
            <form:radiobutton value="IntelliJ" path="q2"/> IntelliJ
        </label>
        <label>
            <form:radiobutton value="VSCode" path="q2"/> VSCode
        </label>
        <br>
        <form:errors path="q2" cssStyle="color: red"/>
    </p>

    <p>
        <label>3. 하고 싶은 말</label> <br>
        <label>
            <form:input path="q3"/><br>
            <form:errors path="q3" cssStyle="color: red"/>
        </label>
    </p>

    <p>
        <label>4. 응답자 이름</label> <br>
        <label>
            <form:input path="respondentName"/><br>
            <form:errors path="respondentName" cssStyle="color: red"/>
        </label>
    </p>

    <p>
        <label>5. 응답자 나이</label> <br>
        <label>
            <form:input path="respondentAge"/><br>
            <form:errors path="respondentAge" cssStyle="color: red"/>
        </label>
    </p>

    <input type="submit" value="전송"/>
</form:form>
</body>
</html>