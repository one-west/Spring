<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>응답</title>
</head>
<body>
<h2>응답</h2>
<p>1 : ${formData.Q1}</p>
<p>2 : ${formData.Q2}</p>
<p>3 : ${formData.Q3}</p>
<p>1 : ${formData.respondentName}</p>
<p>1 : ${formData.respondentAge}</p>
<a href="<c:url value="" />">[응답 리스트 보기]</a>
</body>
</html>
