<script type="text/javascript">
    function findPassword() {
        console.log('findPassword() CALLED!!');

        let form = document.find_password_form;

        if (form.id.value == '') {
            alert('INPUT ADMIN ID.');
            form.id.focus();
        } else if (form.name.value == '') {
            alert('INPUT INPUT ADMIN NAME.');
            form.name.focus();
        } else if (form.email.value == '') {
            alert('INPUT ADMIN MAIL.');
            form.email.focus();
        } else {
            form.submit();
        }
    }
</script>