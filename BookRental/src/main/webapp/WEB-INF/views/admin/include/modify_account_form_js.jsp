<script type="text/javascript">
    function modifyAccountForm() {
        console.log("Modify AccountForm() CALLED!!");

        let form = document.modify_account_form;
        if (form.id.value === '') {
            alert("input admin id.");
            form.id.focus();
        } else if (form.name.value === '') {
            alert("input admin name.");
            form.name.focus();
        } else if (form.email.value === '') {
            alert("input admin email.");
            form.email.focus();
        } else {
            return form.submit();
        }
    }
</script>