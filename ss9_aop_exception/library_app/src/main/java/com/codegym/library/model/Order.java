package com.codegym.library.model;

import javax.persistence.*;
import javax.validation.Valid;

@Entity(name = "oder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oder")
    private Integer idOrder;

    @Column(name = "code_oder")
    private Integer codeOrder;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id_Book")
    private Book book;

    public Order() {
    }

    public Order(Integer idOrder, Integer codeOrder, Book book) {
        this.idOrder = idOrder;
        this.codeOrder = codeOrder;
        this.book = book;
    }

    public Order(Integer code, Book book) {
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOder) {
        this.idOrder = idOder;
    }

    public Integer getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(Integer codeOder) {
        this.codeOrder = codeOder;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
