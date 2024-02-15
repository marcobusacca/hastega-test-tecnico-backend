package it.hastega.spring.db.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.hastega.spring.db.pojo.Book;
import it.hastega.spring.db.repo.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByUserIdAndDeletedAtNull(int user_id) {
        return bookRepository.findByUserIdAndDeletedAtNull(user_id);
    }

    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }
}
