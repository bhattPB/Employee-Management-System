package com.pb.employeemanagementsystem.service;


import com.pb.employeemanagementsystem.entity.Employee;
import com.pb.employeemanagementsystem.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpRepository empRepository;
    /**
     * @return List<Employee>
     */
    @Override
    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    /**
     * @param employee
     */
    @Override
    public void saveEmployee(Employee employee) {
        empRepository.save(employee);
    }

    /**
     * @param id
     * @return Optional<Employee>
     */
    @Override
    public Optional<Employee> getEmployeeById(String id) {
        return empRepository.findById(id);
    }

    /**
     * @param id
     */
    @Override
    public void deleteEmployeeById(String id) {
        empRepository.deleteById(id);
    }
}
