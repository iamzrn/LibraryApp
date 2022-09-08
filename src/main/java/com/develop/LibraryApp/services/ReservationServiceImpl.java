package com.develop.LibraryApp.services;

import com.develop.LibraryApp.models.Book;
import com.develop.LibraryApp.models.Reservation;
import com.develop.LibraryApp.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation addNewReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> fetchReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> fetchReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public void deleteReservationById(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}

