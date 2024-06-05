package com.nirajaky.springbootdemo.controller;

import com.nirajaky.springbootdemo.model.Employee;
import com.nirajaky.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/v2/employee")
public class EmployeeV2Controller {

    /*
        When we have multiple beans of the same type, and we need to specify which one
        should be autowired into a specific field, we use the @Qualifier annotation
        along with the @Autowired annotation. This is useful when you have different
        implementations of an interface or different configurations of a class.
    */

    @Qualifier("employeeV2ServiceImpl")
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
