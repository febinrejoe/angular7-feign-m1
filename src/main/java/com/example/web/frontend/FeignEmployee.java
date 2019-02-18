package com.example.web.frontend;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "employees-api", url = "${employees-api.url}")
public interface FeignEmployee {

    @GetMapping("/api/employees")
    public ResponseEntity<List<Employee>> list();

    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") final String id);

    @PostMapping("/api/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee);

    @PutMapping("/api/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") final String id, @RequestBody Employee employee);

    @DeleteMapping("/api/employees/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") final String id);


}
