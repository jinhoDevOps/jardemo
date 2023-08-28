package com.example.jardemo;

import com.example.jardemo.repository.BookRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestAPI {

    private final BookRepository bookRepository;

    public RestAPI(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Book book) {
        bookRepository.save(book);
        return "Add";
    }

    @PostMapping("/update/{id}")
    public String update(@RequestBody Book toBook, @PathVariable int id) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setAuthor(toBook.getAuthor());
                    book.setTitle(toBook.getTitle());
                    book.setPrice(toBook.getPrice());
                    bookRepository.save(book);
                    return "update success";
                })
                .orElse("not valid");
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return bookRepository.findById(id)
                .map(book -> {
                    bookRepository.delete(book);
                    return "delete success";
                })
                .orElse("Not valid");
    }
}
