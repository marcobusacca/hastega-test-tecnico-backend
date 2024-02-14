package it.hastega.spring.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import it.hastega.spring.db.pojo.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
