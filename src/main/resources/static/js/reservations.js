$('document').ready(function() {

    $('#editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(reservation, status) {
            $('#id').val(reservation.id);
            $('[name="tookOn"]').val(reservation.tookOn);
        });

        $('#editReservation').modal('show');
    });

    $('#deleteButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $('#confirmDelete').attr('href', href);

        $('#deleteReservation').modal('show');
    });
});