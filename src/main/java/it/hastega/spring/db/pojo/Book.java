package it.hastega.spring.db.pojo;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String plot;

    @Column(nullable = false)
    private int readingNumber;

    @Column(nullable = false, unique = true)
    private String isbnCode;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = true)
    private LocalDate deletedAt;

    public Book() {
    }

    public Book(String title, String author, String plot, int readingNumber, String isbnCode) {
        setTitle(title);
        setAuthor(author);
        setPlot(plot);
        setReadingNumber(readingNumber);
        setIsbnCode(isbnCode);
        setCreatedAt(LocalDate.now());
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPlot() {
        return this.plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getReadingNumber() {
        return this.readingNumber;
    }

    public void setReadingNumber(int readingNumber) {
        this.readingNumber = readingNumber;
    }

    public String getIsbnCode() {
        return this.isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    private void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDeletedAt() {
        return this.deletedAt;
    }

    private void setDeletedAt(LocalDate deletedAt) {
        this.deletedAt = deletedAt;
    }

    public void markAsDeleted() {
        setDeletedAt(LocalDate.now());
    }

    @Override
    public String toString() {
        return "[ book_id: " + getId() + " ]"
                + "\nTitolo: " + getTitle()
                + "\nISBN: " + getIsbnCode();
    }
}