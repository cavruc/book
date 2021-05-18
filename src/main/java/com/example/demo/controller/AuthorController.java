package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.service.AuthorService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@Data
public class AuthorController {

    public final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthor());
            }

            @PostMapping
            public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
                return ResponseEntity.ok(authorService.createAuthor(author));
            }

    @PostMapping("/{authorId}/add-book")
    public ResponseEntity<Author> addBookToAuthor(@PathVariable Long authorId, @RequestBody Book book) {
         return ResponseEntity.ok(authorService.addBookToAuthor(authorId, book));
    }
}
