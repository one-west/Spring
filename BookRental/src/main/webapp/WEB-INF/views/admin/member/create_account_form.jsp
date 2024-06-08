<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="../../include/title.jsp"/>
  <link rel="stylesheet" href="<c:url value="/resources/css/admin/create_account_form.css"/>" type="text/css">
  <jsp:include page="../include/create_account_form_js.jsp"/>
</head>
<body>
<jsp:include page="../../include/header.jsp"/>
<jsp:include page="../include/nav.jsp"/>
<section>
  <div id="section_wrap">
    <div class="word">
      <h3>CREATE ACCOUNT FROM</h3>
    </div>

    <div class="create_account_form">
      <form action="<c:url value="/admin/member/createAccountConfirm" />" name="create_account_form"
            method="post">
        <input type="text" name="id" placeholder="input admin id"><br>
        <input type="password" name="password" placeholder="input admin password"><br>
        <input type="password" name="password_confirm" placeholder="input admin password confirm"><br>
        <input type="text" name="name" placeholder="input admin name"><br>

        <select name="gender">
          <option value="">select admin gender</option>
          <option value="M">Man</option>
          <option value="W">Woman</option>
        </select>
        <br>
        <input type="text" name="part" placeholder="input admin part"><br>
        <input type="text" name="position" placeholder="input admin position"><br>
        <input type="text" name="email" placeholder="input admin email"><br>
        <input type="text" name="phone" placeholder="input admin phone"><br>
        <input type="button" value="create account" onclick="createAccountForm()"><br>
        <input type="reset" value="reset"><br>
      </form>
    </div>

    <div class="login">
      <a href="<c:url value="/admin/member/loginForm"/>">login</a>
    </div>
  </div>
</section>

<jsp:include page="../../include/footer.jsp"/>
</body>
</html>
