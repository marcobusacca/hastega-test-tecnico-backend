package it.hastega.spring.auth.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.hastega.spring.auth.db.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
