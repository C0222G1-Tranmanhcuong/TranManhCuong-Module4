package com.codegym.furama.controller.customer;

import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.service.customer.ICustomerService;
import com.codegym.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("customerType")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String home(Model model) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerType", new CustomerType());
        return "/customerType/listType";
    }

    @GetMapping("/createType")
    public String create(Model model) {
        model.addAttribute("customerType", new CustomerType());
        return "customerType/createType";
    }

    @PostMapping("/save")
    public String save(CustomerType customerType) {
        iCustomerTypeService.save(customerType);
        return "redirect:/customerType";
    }

    @GetMapping("/{id}/editType")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("customerType", iCustomerTypeService.findById(id));
        return "customerType/editType";
    }

    @PostMapping("/update")
    public String update(CustomerType customerType) {
        iCustomerTypeService.update(customerType);
        return "redirect:/customerType";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        iCustomerTypeService.delete(Integer.parseInt(id));
        return "redirect:/customerType";
    }
}
