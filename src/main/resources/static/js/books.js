$('document').ready(function() {

    $('#editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(book, status) {
            $('#id').val(book.id);
            $('[name="title"]').val(book.title);
            $('[name="publicationDate"]').val(book.publicationDate);
            $('[name="description"]').val(book.description);
            $('[name="numberOfPages"]').val(book.numberOfPages);
        });

        $('#editBook').modal('show');
    });

    $('#deleteButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $('#confirmDelete').attr('href', href);

        $('#deleteBook').modal('show');
    });
});