package com.develop.LibraryApp.services;

import com.develop.LibraryApp.models.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Reservation addNewReservation(Reservation reservation);

    List<Reservation> fetchReservations();

    Optional<Reservation> fetchReservationById(Long reservationId);

    void deleteReservationById(Long reservationId);
}
