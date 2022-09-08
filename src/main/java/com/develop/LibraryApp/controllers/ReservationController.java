package com.develop.LibraryApp.controllers;

import com.develop.LibraryApp.models.Book;
import com.develop.LibraryApp.models.Reservation;
import com.develop.LibraryApp.models.Student;
import com.develop.LibraryApp.services.BookService;
import com.develop.LibraryApp.services.ReservationService;
import com.develop.LibraryApp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    private BookService bookService;
    private StudentService studentService;

    public ReservationController(ReservationService reservationService,
                                 BookService bookService, StudentService studentService) {
        this.reservationService = reservationService;
        this.bookService = bookService;
        this.studentService = studentService;
    }

    @GetMapping
    public String fetchReservations(Model model) {
        List<Reservation> listReservations = reservationService.fetchReservations();
        List<Student> listStudents = studentService.fetchStudents();
        List<Book> listBooks = bookService.fetchBooks();

        model.addAttribute("listReservations", listReservations);
        model.addAttribute("listStudents", listStudents);
        model.addAttribute("listBooks", listBooks);

        return "reservations";
    }

    @PostMapping("/add")
    public String addNewReservation(Reservation reservation) {
        reservationService.addNewReservation(reservation);
        return "redirect:/reservations";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteReservationById(Long id) {
        reservationService.deleteReservationById(id);
        return "redirect:/reservations";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public Optional<Reservation> findReservationById(Long id) {
        return reservationService.fetchReservationById(id);
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.GET})
    public String editStudent(Reservation reservation) {
        reservationService.addNewReservation(reservation);
        return "redirect:/reservations";
    }
}
