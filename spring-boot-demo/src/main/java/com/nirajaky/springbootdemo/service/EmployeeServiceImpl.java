package com.nirajaky.springbootdemo.service;

import com.nirajaky.springbootdemo.custom.error.EmployeeNotFoundException;
import com.nirajaky.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeesRepository = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if (employee.getEmpID() == null ||
                employee.getEmpID().isEmpty()) {
            employee.setEmpID(UUID.randomUUID().toString());

        }
        employeesRepository.add(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeByID(String id) {
        employeesRepository.forEach((item) -> System.out.println(item.getEmpID()));
        System.out.println(id + "ID -----------");
        return employeesRepository
                .stream()
                .filter((item) -> item.getEmpID().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The Given Employee is not present in our System"));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeesRepository;
    }

    @Override
    public Employee deleteEmployeeByID(String id) {
        Employee employee = employeesRepository
                .stream()
                .filter((emp) -> Objects.equals(emp.getEmpID(), id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("No Employee with ID : " + id));
        employeesRepository.remove(employee);
        return employee;
    }
}
