package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Data
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final BookService bookService;

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author addBookToAuthor(Long authorId, Book book) {
        Book newBook = bookService.createNewBook(book);
        Author author = authorRepository.findById(authorId)
                .orElseThrow(EntityNotFoundException::new);
        author.getBooks().add(newBook);
//        authorRepository.save(author);
        return author;
    }
}
