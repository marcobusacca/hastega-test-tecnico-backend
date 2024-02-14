package it.hastega.spring.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.hastega.spring.db.pojo.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByUserId(int user_id);
}
