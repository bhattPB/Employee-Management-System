package com.pb.employeemanagementsystem.service;

import com.pb.employeemanagementsystem.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmpService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Optional<Employee> getEmployeeById(String id);
    public void deleteEmployeeById(String id);


}
