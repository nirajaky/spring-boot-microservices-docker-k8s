package com.nirajaky.springbootdemo.service;

import com.nirajaky.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);

    public Employee getEmployeeByID(String id);

    public List<Employee> getAllEmployee();

    Employee deleteEmployeeByID(String id);
}
