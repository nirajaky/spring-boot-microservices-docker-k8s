package com.nirajaky.springbootdemo.service;

import com.nirajaky.springbootdemo.entities.EmployeeEntity;
import com.nirajaky.springbootdemo.model.Employee;
import com.nirajaky.springbootdemo.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {

        System.out.println(employee + "employee -----------------");
        if (employee.getEmpID() == null ||
                employee.getEmpID().isEmpty()) {
            employee.setEmpID(UUID.randomUUID().toString());

        }

        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);
        System.out.println("Reached******");
        return employee;
    }

    @Override
    public Employee getEmployeeByID(String id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        System.out.println(employeeEntity);
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = employeeEntities.stream()
                .map((emp) -> {
                    Employee e = new Employee();
                    BeanUtils.copyProperties(emp, e);
                    return e;
                })
                .toList();

        return employees;
    }

    @Override
    public Employee deleteEmployeeByID(String id) {
        employeeRepository.deleteById(id);
        return new Employee();
    }
}
