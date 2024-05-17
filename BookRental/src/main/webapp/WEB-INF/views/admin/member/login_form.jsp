<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../../include/title.jsp"/>
    <link rel="stylesheet" href="/resources/css/admin/login_form.css" type="text/css">
</head>
<body>
<jsp:include page="../../include/header.jsp"/>
<jsp:include page="../include/nav.jsp"/>
<section>
    <div id="section_wrap">
        <div class="word">
            <h3>LOGIN FORM</h3>
        </div>


        <div class="login_form">
            <form action="<c:url value="/admin/" />" name="login_form"
                  method="post">
                <input type="text" name="id" placeholder="input admin id"><br>
                <input type="password" name="password" placeholder="input admin password"><br>

                <input type="button" value="login" onclick="loginForm()"><br>
                <input type="reset" value="reset"><br>
            </form>
        </div>

        <div class="find_password_create_account">
            <a href="<c:url value="/admin/member/loginForm"/>">find password</a>
            <a href="<c:url value="/admin/member/createAccountForm"/>">create password</a>
        </div>
    </div>
</section>

<jsp:include page="../../include/footer.jsp"/>

<script type="text/javascript">
    function loginForm() {
        let form = document.login_form;

        if (form.id.value === '') {
            alert("input admin id");
            form.id.focus();
        }
        else if (form.password.value === '') {
            alert("input admin password");
            form.password.focus();
        } else {
            form.submit();
        }
    }
</script>
</body>
</html>
