package com.codegym.library.service.imp;

import com.codegym.library.model.Book;
import com.codegym.library.repository.IBookRepository;
import com.codegym.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;


    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        iBookRepository.save(book);
    }

    @Override
    public void giveBack(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public boolean checkQuantity(Integer quantity) {
        if (quantity == 0) {
            return false;
        } else {
            return true;
        }
    }
}
