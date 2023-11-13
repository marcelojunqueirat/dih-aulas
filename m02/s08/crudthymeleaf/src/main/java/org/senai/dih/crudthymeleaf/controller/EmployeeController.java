package org.senai.dih.crudthymeleaf.controller;

import jakarta.validation.Valid;
import org.senai.dih.crudthymeleaf.model.Employee;
import org.senai.dih.crudthymeleaf.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/form")
    public String getEmployeesForm(Employee employee) {
        return "registerEmployeeForm";
    }

    @PostMapping("/register")
    public String register(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "redirect:/form";
        }

        this.employeeRepository.save(employee);
        return "redirect:/home";
    }

    @GetMapping("/form/{id}")
    public String update(Model model, @PathVariable("id") final Long id) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));

        model.addAttribute(employee);
        return "updateEmployeeForm";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@Valid Employee employee, BindingResult bindingResult, @PathVariable("id") final Long id) {
        if (bindingResult.hasFieldErrors()) {
            return "redirect:/form";
        }
        this.employeeRepository.save(employee);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id, Model model) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));

        this.employeeRepository.delete(employee);
        return "redirect:/home";
    }
}
