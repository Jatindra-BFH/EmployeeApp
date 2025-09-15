package com.example.EmployeeApplication.Controllers;

import com.example.EmployeeApplication.Models.RequestModels.CreateEmployeeRequest;
import com.example.EmployeeApplication.Models.RequestModels.DeleteEmployeeRequest;
import com.example.EmployeeApplication.Models.RequestModels.GetEmployeeRequest;
import com.example.EmployeeApplication.Models.RequestModels.UpdateEmployeeRequest;
import com.example.EmployeeApplication.Models.ResponseModels.*;
import com.example.EmployeeApplication.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    /// Create a new employee
    @PostMapping("/employee")
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        try {
            var response = service.createEmployee(createEmployeeRequest);
            if (response.error == null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /// Get all employees
    @GetMapping("employees")
    public ResponseEntity<GetEmployeesResponse> getAllEmployees() {
        try {
            var response = service.getAllEmployees();
            if (response.error == null) {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /// Get a single employee by ID
    @GetMapping("/employee/{id}")
    public ResponseEntity<GetEmployeeResponse> getEmployeeById(@PathVariable GetEmployeeRequest getEmployeeRequest) {
        try {
            var response = service.getEmployeeById(getEmployeeRequest);
            if(response.error == null) {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
            else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /// Get employees assigned to a project (by project ID)
    @GetMapping("/employees/project/{id}")
    public ResponseEntity<GetEmployeesResponse> getEmployeesByProjectId(@PathVariable GetEmployeeRequest getEmployeeRequest) {
        try {
            var response = service.getEmployeesByProjectId(getEmployeeRequest);
            if(response.error == null) {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /// Update an existing employee
    @PutMapping("/employee/{id}")
    public ResponseEntity<UpdateEmployeeResponse> updateEmployee(@PathVariable int id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        try {
            updateEmployeeRequest.employeeId = id;
            var response = service.updateEmployee(updateEmployeeRequest);
            if(response.error == null){
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /// Delete an employee by ID
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<DeleteEmployeeResponse> deleteEmployee(@PathVariable DeleteEmployeeRequest deleteEmployeeRequest) {
        try {
            var response = service.deleteEmployee(deleteEmployeeRequest);
            if(response.error == null){
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

