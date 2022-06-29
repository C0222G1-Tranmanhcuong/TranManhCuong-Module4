package com.codegym.library.service;

import com.codegym.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    Book findById(Integer id);

    void update(Book book);

    void giveBack(Book book);

    boolean checkQuantity(Integer quantity);
}
