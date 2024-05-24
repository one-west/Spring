<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>응답</title>
</head>
<body>
<h2>응답</h2>
<p>1 : ${surveyCommand.q1}</p>
<p>2 : ${surveyCommand.q2}</p>
<p>3 : ${surveyCommand.q3}</p>
<p>4 : ${surveyCommand.respondentName}</p>
<p>5 : ${surveyCommand.respondentAge}</p>
<a href="<c:url value="/survey/surveyList" />">[응답 리스트 보기]</a>
</body>
</html>
