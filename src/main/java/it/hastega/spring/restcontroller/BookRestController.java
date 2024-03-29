package it.hastega.spring.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.hastega.spring.db.pojo.Book;
import it.hastega.spring.db.serv.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/books")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooksByUserId(int user_id) {

        List<Book> books = bookService.findByUserIdAndDeletedAtNull(user_id);

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> storeBook(@RequestBody Book bookForm) {

        Book book = new Book(bookForm.getTitle(), bookForm.getAuthor(), bookForm.getPlot(), bookForm.getReadingNumber(),
                bookForm.getIsbnCode(), bookForm.getUser());

        bookService.save(book);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody Book bookForm) {

        Book book = bookService.findById(id);

        book.setTitle(bookForm.getTitle());
        book.setAuthor(bookForm.getAuthor());
        book.setPlot(bookForm.getPlot());
        book.setReadingNumber(bookForm.getReadingNumber());
        book.setIsbnCode(bookForm.getIsbnCode());

        bookService.save(book);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {

        Book book = bookService.findById(id);
        book.markAsDeleted();

        bookService.save(book);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
