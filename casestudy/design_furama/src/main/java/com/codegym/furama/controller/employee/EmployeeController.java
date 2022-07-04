package com.codegym.furama.controller.employee;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.repository.empolyee.IDivisionRepository;
import com.codegym.furama.repository.empolyee.IPositionRepository;
import com.codegym.furama.service.customer.ICustomerService;
import com.codegym.furama.service.customer.ICustomerTypeService;
import com.codegym.furama.service.employee.IEducationDegreeService;
import com.codegym.furama.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping()
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionRepository iDivisionRepository;
    @Autowired
    private IPositionRepository iPositionRepository;



    @GetMapping("/employee")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Employee> employeeList = iEmployeeService.findAll(PageRequest.of(page, 1));
        model.addAttribute("employeeList", employeeList);
        return "/employee/listEmployee";
    }

    @GetMapping("/employee/createEmployee")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("educationDegreeList",iEducationDegreeService.findAll());
        model.addAttribute("positionList",iPositionRepository.findAll());
        model.addAttribute("divisionList",iDivisionRepository.findAll());
        return "employee/createEmployee";
    }


    @PostMapping("/employee/save")
    public String save(Employee employee) {
        iEmployeeService.save(employee);
        return "redirect:/employee";
    }

//    @PostMapping("/customer/save")
//    public String save(Employee employee) {
//        iEmployeeService.save(employee);
//        return "redirect:/customer";
//    }
//
//    @GetMapping("/customer/{id}/editCustomer")
//    public String showEditForm(@PathVariable Integer id, Model model){
//        model.addAttribute("customers", iCustomerService.findById(id));
//        return "customer/editCustomer";
//    }
//
//    @PostMapping("/customer/update")
//    public String update(Customer customer){
//        iCustomerService.update(customer);
//        return "redirect:/customer";
//    }
//
//    @GetMapping("customer/delete/{id}")
//    public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
//        iCustomerService.remove(id);
//        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
//        return "redirect:/customer";
//    }


}
