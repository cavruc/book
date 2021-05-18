package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }


    public Book createNewBook(Book book) {
        return bookRepository.save(book);
    }
}
