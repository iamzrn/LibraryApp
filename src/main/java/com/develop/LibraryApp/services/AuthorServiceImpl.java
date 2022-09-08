package com.develop.LibraryApp.services;

import com.develop.LibraryApp.models.Author;
import com.develop.LibraryApp.models.Book;
import com.develop.LibraryApp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author addNewAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> fetchAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> fetchAuthorById(Long authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public void deleteAuthorById(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}

