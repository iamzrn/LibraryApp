package com.develop.LibraryApp.controllers;

import com.develop.LibraryApp.models.Author;
import com.develop.LibraryApp.models.Book;
import com.develop.LibraryApp.services.AuthorService;
import com.develop.LibraryApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    private AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String fetchBooks(Model model) {
        List<Book> listBooks = bookService.fetchBooks();
        List<Author> listAuthors = authorService.fetchAuthors();

        model.addAttribute("listBooks", listBooks);
        model.addAttribute("listAuthors", listAuthors);

        return "books";
    }

    @PostMapping("/add")
    public String addNewBook(Book book) {
        bookService.addNewBook(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteBookById(Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public Optional<Book> findBookById(Long id) {
        return bookService.fetchBookById(id);
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.GET})
    public String editBook(Book book) {
        bookService.addNewBook(book);
        return "redirect:/books";
    }
}
