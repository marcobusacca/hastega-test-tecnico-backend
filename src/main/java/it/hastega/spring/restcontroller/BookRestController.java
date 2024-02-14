package it.hastega.spring.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.hastega.spring.db.pojo.Book;
import it.hastega.spring.db.serv.BookService;

@RestController
@RequestMapping("api/books")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooksByUserId(int user_id) {

        List<Book> books = bookService.findByUserId(user_id);

        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
