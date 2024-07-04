package com.nirajaky.springbootdemo.controller;

import com.nirajaky.springbootdemo.model.Employee;
import com.nirajaky.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/employee")
public class EmployeeController {

    /*
        AOP - Aspect oriented programming
        - In this concept, we handle all the concern(Like Exception) of Controller in separate class,
        - As Controller has to process a lot of other things.
        - For this we need to use @ControllerAdvice

        - By default Json Jackson dependencies is integrated in Spring Boot.
        - To use xml format we need to add jackson-dataformat-xml dependencies and configure
          it globally or at individual endpoints.
    */
    @Qualifier("employeeServiceImpl")
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeByID(@PathVariable String id) {
        return employeeService.getEmployeeByID(id);
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployeeByID(@PathVariable String id) {
        return employeeService.deleteEmployeeByID(id);
    }
}
