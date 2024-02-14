package it.hastega.spring.auth.db.pojo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.hastega.spring.db.pojo.Book;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Book> books;

    public User() {
    }

    public User(String name, String surname, String email) {
        setName(name);
        setSurname(surname);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // INTERFACE "USER_DETAILS" METHOD

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Supponendo che l'applicazione non utilizzi i ruoli per ora
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        // L'utente non dispone di una password
        return "";
    }

    @Override
    public String getUsername() {
        // L'username è rappresentato dall'email dell'utente
        return this.email;
    }

    // METODI RELATIVI ALLO STATUS DELL'ACCOUNT

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
