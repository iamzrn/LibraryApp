package com.develop.LibraryApp.controllers;

import com.develop.LibraryApp.models.Author;
import com.develop.LibraryApp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String fetchAuthors(Model model) {
        List<Author> listAuthors = authorService.fetchAuthors();

        model.addAttribute("listAuthors", listAuthors);

        return "authors";
    }

    @PostMapping("/add")
    public String addNewAuthor(Author author) {
        authorService.addNewAuthor(author);
        return "redirect:/authors";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteAuthorById(Long id) {
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public Optional<Author> findAuthorById(Long id) {
        return authorService.fetchAuthorById(id);
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.GET})
    public String editStudent(Author author) {
        authorService.addNewAuthor(author);
        return "redirect:/authors";
    }
}
