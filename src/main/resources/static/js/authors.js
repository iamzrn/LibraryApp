$('document').ready(function() {

    $('#editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(author, status) {
            $('#id').val(author.id);
            $('[name="firstName"]').val(author.title);
            $('[name="lastName"]').val(author.lastName);
            $('[name="email"]').val(author.email);
        });

        $('#editAuthor').modal('show');
    });

    $('#deleteButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $('#confirmDelete').attr('href', href);

        $('#deleteAuthor').modal('show');
    });
});