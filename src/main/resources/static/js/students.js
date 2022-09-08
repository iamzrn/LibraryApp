$('document').ready(function() {

    $('#editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(student, status) {
            $('#id').val(student.id);
            $('[name="firstName"]').val(student.firstName);
            $('[name="lastName"]').val(student.lastName);
            $('[name="email"]').val(student.email);
            $('[name="address"]').val(student.address);
            $('[name="years"]').val(student.years);
            $('[name="identificationCode"]').val(student.identificationCode);
        });

        $('#editStudent').modal('show');
    });

    $('#deleteButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $('#confirmDelete').attr('href', href);

        $('#deleteStudent').modal('show');
    });
});