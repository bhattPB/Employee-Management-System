package com.pb.employeemanagementsystem.controller;


import com.pb.employeemanagementsystem.entity.Employee;
import com.pb.employeemanagementsystem.model.Response;
import com.pb.employeemanagementsystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/employees")
    public ResponseEntity<Response> getEmployeeList() {
        List<Employee> employeeList = empService.getAllEmployees();
        Response response;
        if (!employeeList.isEmpty()) {
            response = new Response("loaded successfully", "200", employeeList);
        } else {
            response = new Response("not loaded", "404", employeeList);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/employee/get/{id}")
    public ResponseEntity<Response> getEmployeeById(@PathVariable String id) {
        Optional<Employee> emp = empService.getEmployeeById(id);
        Response response;
        response = new Response("loaded successfully", "200", emp);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/employee/save")
    public ResponseEntity<Response> saveEmployee(@RequestBody Employee employee) {
        System.out.println(employee.toString());
        empService.saveEmployee(employee);
        Response response = new Response("saved successfully", "201", employee);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/employee/delete/{id}")
    public ResponseEntity<Response> deleteEmployee(@PathVariable String id) {
        Employee e = empService.getEmployeeById(id).orElse(null);
        if (e != null) {
            empService.deleteEmployeeById(id);
            Response response = new Response("deleted successfully", "200", "empid: " + id + " deleted");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("not found", "404", "empid: " + id + " not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

    }
}
