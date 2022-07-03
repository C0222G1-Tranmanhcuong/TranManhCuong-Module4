package com.codegym.furama.controller.customer;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.service.customer.ICustomerService;
import com.codegym.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping()
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;


    @GetMapping("/")
    public String showHome(){
        return "header";
    }

    @GetMapping("/customer")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Customer> customerList = iCustomerService.findAll(PageRequest.of(page, 2));
        model.addAttribute("customerList", customerList);
        return "/customer/list";
    }

    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/customer/save")
    public String save(Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/{id}/editCustomer")
    public String showEditForm(@PathVariable Integer id, Model model){
        model.addAttribute("customers", iCustomerService.findById(id));
        return "customer/editCustomer";
    }

    @PostMapping("/customer/update")
    public String update(Customer customer){
        iCustomerService.update(customer);
        return "redirect:/customer";
    }

    @GetMapping("customer/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
        iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/customer";
    }


}
