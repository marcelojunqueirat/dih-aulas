package org.senai.dih.crudthymeleaf.controller;

import org.senai.dih.crudthymeleaf.model.Employee;
import org.senai.dih.crudthymeleaf.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final EmployeeRepository employeeRepository;

    public HomeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Employee> employees = this.employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "home";
    }
}
