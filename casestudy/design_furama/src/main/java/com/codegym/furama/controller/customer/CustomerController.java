package com.codegym.furama.controller.customer;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.service.customer.ICustomerService;
import com.codegym.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Customer> customerList = iCustomerService.findAll(PageRequest.of(page, 2));
        model.addAttribute("customerList", customerList);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model){
        model.addAttribute("customer", iCustomerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer){
        iCustomerService.update(customer);
        return "redirect:/customer";
    }

}
