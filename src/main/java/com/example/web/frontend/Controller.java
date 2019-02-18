package com.example.web.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    FeignEmployee feignClient;

    @GetMapping("/api/employees")
    public ResponseEntity<List<Employee>> list() {
        return feignClient.list();
    }

    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") final String id) {
        return feignClient.getEmployee(id);
    }

    @PostMapping("/api/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return feignClient.createEmployee(employee);
    }

    @PutMapping("/api/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") final String id,
            @RequestBody Employee employee) {
        employee.setId(id);
        return feignClient.updateEmployee(id, employee);
    }

    @DeleteMapping("/api/employees/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") final String id) {
        feignClient.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
