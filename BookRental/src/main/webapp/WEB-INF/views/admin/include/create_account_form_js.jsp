<script type="text/javascript">
    function createAccountForm() {
        console.log("createAccountForm() CALLED!!");

        let form = document.create_account_form;
        if (form.id.value === '') {
            alert("input admin id.");
            form.id.focus();
        }
        else if (form.password.value === '') {
            alert("input admin password.");
            form.password.focus();
        }
        else if (form.password_confirm.value === '') {
            alert("input admin passwordConfirm.");
            form.password_confirm.focus();
        }
        else if (form.name.value === '') {
            alert("input admin name.");
            form.name.focus();
        }
        else if (form.email.value === '') {
            alert("input admin email.");
            form.email.focus();
        } else {
            return form.submit();
        }
    }
</script>