<%@ page import="daelim.book.rental.admin.member.AdminMemberVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="../../include/title.jsp"/>
  <link rel="stylesheet" href="/resources/css/admin/modify_account_form.css" type="text/css">
</head>
<body>
<jsp:include page="../../include/header.jsp"/>
<jsp:include page="../include/nav.jsp"/>
<section>
  <div id="section_wrap">
    <div class="word">
      <h3>MODIFY ACCOUNT FROM</h3>
    </div>
    <%
      AdminMemberVo loginedAdminMemberVo = (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
    %>
    <div class="modify_account_form">
      <form action="<c:url value="/admin/member/modifyAccountConfirm" />" name="modify_account_form"
            method="post">
        <input type="hidden" name="no" value="<%= loginedAdminMemberVo.getNo() %>">
        <input type="text" name="id" value="<%=loginedAdminMemberVo.getId()%>" placeholder="INPUT USER NAME." readonly
               disabled> <br>
        <input type="password" name="password" value="*******" readonly disabled> <br>
        <input type="text" name="name" value="<%=loginedAdminMemberVo.getName()%>" placeholder="INPUT USER NAME."><br>

        <select name="gender">
          <option value="">select admin gender</option>
          <option value="M" <% if (loginedAdminMemberVo.getGender().equals("M")) { %> selected <% } %>>Man</option>
          <option value="W" <% if (loginedAdminMemberVo.getGender().equals("W")) { %> selected <% } %>>Woman</option>
        </select>
        <br>
        <input type="text" name="part" value="<%= loginedAdminMemberVo.getPart() %>" placeholder="INPUT USER PART."><br>
        <input type="text" name="position" value="<%= loginedAdminMemberVo.getPosition() %>"
               placeholder="INPUT USER POSITION."><br>
        <input type="email" name="email" value="<%= loginedAdminMemberVo.getEmail() %>"
               placeholder="INPUT USER MAIL."><br>
        <input type="text" name="phone" value="<%= loginedAdminMemberVo.getPhone() %>" placeholder="INPUT USER PHONE.">
        <br>
        <input type="button" value="modify account" onclick="modifyAccountForm();">
        <input type="reset" value="reset">
      </form>
    </div>
  </div>
</section>
<jsp:include page="../include/modify_account_form_js.jsp"/>
<jsp:include page="../../include/footer.jsp"/>
</body>
</html>
