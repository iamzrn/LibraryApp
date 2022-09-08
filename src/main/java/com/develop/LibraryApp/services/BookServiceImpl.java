package com.develop.LibraryApp.services;

import com.develop.LibraryApp.models.Book;
import com.develop.LibraryApp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addNewBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> fetchBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}

