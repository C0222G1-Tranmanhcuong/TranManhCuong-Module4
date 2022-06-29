package com.codegym.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Integer idBook;

    @Column(name = "code_book")
    private String codeBook;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "name_author")
    private String nameAuthor;

    @Column(name = "category")
    private String category;

    @Column(name = "publish_year")
    private String publishYear;

    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private Set<Order> oders;

    public Book() {
    }

    public Book(Integer idBook,
                String codeBook,
                String bookName,
                String nameAuthor,
                String category,
                String publishYear,
                Integer quantity,
                Set<Order> oders) {
        this.idBook = idBook;
        this.codeBook = codeBook;
        this.bookName = bookName;
        this.nameAuthor = nameAuthor;
        this.category = category;
        this.publishYear = publishYear;
        this.quantity = quantity;
        this.oders = oders;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<Order> getOders() {
        return oders;
    }

    public void setOders(Set<Order> oders) {
        this.oders = oders;
    }
}
