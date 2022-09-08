package com.develop.LibraryApp.services;

import com.develop.LibraryApp.models.Author;
import com.develop.LibraryApp.models.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author addNewAuthor(Author author);

    List<Author> fetchAuthors();

    Optional<Author> fetchAuthorById(Long authorId);

    void deleteAuthorById(Long authorId);
}
