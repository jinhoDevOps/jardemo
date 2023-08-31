package com.example.jardemo;

import com.example.jardemo.repository.BookRepository;
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

//    @PostMapping("/add")
//    public String add(@RequestBody Book book) {
//        bookRepository.save(book);
//        return "Add";
//    } // 원래코드
@PostMapping("/add")
public String add(@RequestBody Book book) {
    int id = book.getId();
    if (id != 0) {
        // ID가 지정된 경우
        if (bookRepository.findById(id).isPresent()) {
            return "Error: ID already exists";
        }
        bookRepository.save(book);
        return "Add with specified ID";
    } else {
        // ID가 지정되지 않은 경우
        bookRepository.save(book);
        return "Add with generated ID";
    }
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
