package com.develop.LibraryApp.services;

import com.develop.LibraryApp.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    
    Book addNewBook(Book book);

    List<Book> fetchBooks();

    Optional<Book> fetchBookById(Long bookId);

    void deleteBookById(Long bookId);
}
