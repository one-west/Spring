<script type="text/javascript">
    function registerBookForm() {
        console.log('registerBookForm() CALLED!!');
        let form = document.register_book_form;
        if (form.name.value == '') {
            alert('INPUT BOOK NAME.');
            form.name.focus();
        } else if (form.author.value == '') {
            alert('INPUT BOOK AUTHOR.');
            form.author.focus();
        } else if (form.publisher.value == '') {
            alert('INPUT BOOK PUBLISHER.');
            form.publisher.focus();
        } else if (form.publishYear.value == '') {
            alert('INPUT BOOK PUBLISH YEAR.');
            form.publishYear.focus();
        } else if (form.isbn.value == '') {
            alert('INPUT BOOK ISBN.');
            form.isbn.focus();
        } else if (form.callNumber.value == '') {
            alert('INPUT BOOK CALL NUMBER.');
            form.callNumber.focus();
        } else if (form.rantalAble.value == '') {
            alert('SELECT BOOK RANTAL ABLE.');
            form.rantalAble.focus();
        } else if (form.file.value == '') {
            alert('SELECT IMAGE FILE');
            form.file.focus();
        } else {
            form.submit();
        }
    }
</script>