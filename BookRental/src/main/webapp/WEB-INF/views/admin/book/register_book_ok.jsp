<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="../../include/title.jsp"/>
  <link rel="stylesheet" href="<c:url value="/resources/css/admin/create_account_result.css"/>" type="text/css">
</head>
<body>
<jsp:include page="../../include/header.jsp"/>
<jsp:include page="../include/nav.jsp"/>
<section>
  <div id="section_wrap">
    <div class="word">
      <h3>REGISTER BOOK SUCCESS!!</h3>
    </div>
    <div class="others">
      <a href="<c:url value="/admin/book/admin/registerBookForm"/>">register book</a>
      <a href="<c:url value="/admin/"/>">home</a>
    </div>
  </div>
</section>

<jsp:include page="../../include/footer.jsp"/>
</body>
</html>
