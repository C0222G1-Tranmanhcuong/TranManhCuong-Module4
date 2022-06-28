package com.codegym.library.model;

import javax.persistence.*;

@Entity(name = "oder")
public class Oder {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oder")
    private Integer idOder;

    @Column(name = "code_oder")
    private Integer codeOder;

    @ManyToOne
    @JoinColumn(name = "id_book",referencedColumnName = "idBook")
    private Book book;

    public Oder() {
    }

    public Oder(Integer idOder, Integer codeOder, Book book) {
        this.idOder = idOder;
        this.codeOder = codeOder;
        this.book = book;
    }

    public Integer getIdOder() {
        return idOder;
    }

    public void setIdOder(Integer idOder) {
        this.idOder = idOder;
    }

    public Integer getCodeOder() {
        return codeOder;
    }

    public void setCodeOder(Integer codeOder) {
        this.codeOder = codeOder;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
