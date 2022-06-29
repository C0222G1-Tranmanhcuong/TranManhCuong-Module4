package com.codegym.library.controller;

import com.codegym.library.model.Book;
import com.codegym.library.model.Order;
import com.codegym.library.repository.IOderRepository;
import com.codegym.library.service.IBookService;
import com.codegym.library.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/book")
public class LibraryController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IOrderService iOrderService;

    @GetMapping("")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Book> list = iBookService.findAll(PageRequest.of(page, 2));
        model.addAttribute("bookList", list);
        model.addAttribute("order", new Order());
        return "list";
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable Integer id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "/view";
    }

    @PostMapping("/choice")
    public String update(@Valid @ModelAttribute Book book, RedirectAttributes redirectAttributes, Model model) {
        if (book.getQuantity() == 0) {
            redirectAttributes.addFlashAttribute("message", "Không còn sách để thuê");
            return "redirect:/book";
        } else {
            Integer code = (int) Math.floor((Math.random() * 89999) + 10000);
            Order order = new Order(code, book);
            iBookService.update(book);
            iOrderService.save(order);
            redirectAttributes.addFlashAttribute("message", "Mã thuê sách của bạn là: " + code);
            return "redirect:/book";
        }
    }


    @GetMapping("/giveBook")
    public String giveBook(Order order, RedirectAttributes redirectAttributes) {
        Order orderBook = iOrderService.findByOrderCode(order.getCodeOrder());
        if (orderBook != null) {
            Book book = orderBook.getBook();
            book.setQuantity(book.getQuantity() + 1);
            iBookService.giveBack(book);
            iOrderService.delete(orderBook);
            redirectAttributes.addFlashAttribute("message", "Trả sách thành công");
            return "redirect:/book";
        } else {
            redirectAttributes.addFlashAttribute("message", "Mã trả sách sai");
            return "redirect:/book";
        }
    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "error";
    }
}
