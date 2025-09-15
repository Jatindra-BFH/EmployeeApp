package com.example.EmployeeApplication.Services;

import com.example.EmployeeApplication.AutoMappers.AutoMapper;
import com.example.EmployeeApplication.Models.RequestModels.CreateEmployeeRequest;
import com.example.EmployeeApplication.Models.RequestModels.DeleteEmployeeRequest;
import com.example.EmployeeApplication.Models.RequestModels.GetEmployeeRequest;
import com.example.EmployeeApplication.Models.RequestModels.UpdateEmployeeRequest;
import com.example.EmployeeApplication.Models.ResponseModels.*;
import com.example.EmployeeApplication.Repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EmployeeApplication.Models.BaseModels.Error;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AutoMapper autoMapper;

    /// Creates an employee record in the database
    @Transactional
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        CreateEmployeeResponse createEmployeeResponse;
        try {
            var response = employeeRepository.createEmployee(
                    createEmployeeRequest.employee.employeeId,
                    createEmployeeRequest.employee.employeeFirstName,
                    createEmployeeRequest.employee.employeeMiddleName,
                    createEmployeeRequest.employee.employeeLastName,
                    createEmployeeRequest.employee.employeeDOB,
                    createEmployeeRequest.employee.employeeCurrentAddress,
                    createEmployeeRequest.employee.employeePermanentAddress,
                    createEmployeeRequest.employee.employeeEmailId,
                    createEmployeeRequest.employee.employeeContactNo,
                    createEmployeeRequest.employee.projectId,
                    createEmployeeRequest.employee.companyId
            );
            createEmployeeResponse = new CreateEmployeeResponse(autoMapper.toDTO(response), null);
        }catch (Exception ex){
            createEmployeeResponse = new CreateEmployeeResponse(null, new Error(ex.getMessage()));
        }
        return createEmployeeResponse;
    }

    /// Retrieves all employees from the database
    @Transactional
    public GetEmployeesResponse getAllEmployees() {
        GetEmployeesResponse getEmployeesResponse;
        try {
            var response = employeeRepository.getAllEmployees();
            getEmployeesResponse = new GetEmployeesResponse(response.stream().map(autoMapper::toDTO).toList(), null);
        } catch (Exception ex) {
            getEmployeesResponse = new GetEmployeesResponse(null, new Error(ex.getMessage()));
        }
        return getEmployeesResponse;
    }

    /// retrieves an employee details from the database
    @Transactional
    public GetEmployeeResponse getEmployeeById(GetEmployeeRequest getEmployeeRequest) {
        GetEmployeeResponse getEmployeeResponse;
        try {
            var response = employeeRepository.getEmployeeById(getEmployeeRequest.id);
            getEmployeeResponse = new GetEmployeeResponse(autoMapper.toDTO(response), null);
        } catch (Exception ex) {
            getEmployeeResponse = new GetEmployeeResponse(null, new Error(ex.getMessage()));
        }
        return getEmployeeResponse;
    }

    /// Retrieves a list of employees working on a project
    @Transactional
    public GetEmployeesResponse getEmployeesByProjectId(GetEmployeeRequest getEmployeeRequest){
        GetEmployeesResponse getEmployeesResponse;
        try {
            var response = employeeRepository.getEmployeesByProjectId(getEmployeeRequest.id);
            getEmployeesResponse = new GetEmployeesResponse(response.stream().map(autoMapper::toDTO).toList(), null);
            return getEmployeesResponse;
        } catch (Exception ex) {
            getEmployeesResponse = new GetEmployeesResponse(null, new Error(ex.getMessage()));
        }
        return getEmployeesResponse;
    }

    /// Updates an employee
    @Transactional
    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
        UpdateEmployeeResponse updateEmployeeResponse;
        try {
            var response = employeeRepository.updateEmployee(
                    updateEmployeeRequest.employeeId,
                    updateEmployeeRequest.employee.employeeFirstName,
                    updateEmployeeRequest.employee.employeeMiddleName,
                    updateEmployeeRequest.employee.employeeLastName,
                    updateEmployeeRequest.employee.employeeDOB,
                    updateEmployeeRequest.employee.employeeCurrentAddress,
                    updateEmployeeRequest.employee.employeePermanentAddress,
                    updateEmployeeRequest.employee.employeeEmailId,
                    updateEmployeeRequest.employee.employeeContactNo,
                    updateEmployeeRequest.employee.projectId,
                    updateEmployeeRequest.employee.companyId
            );
            updateEmployeeResponse = new UpdateEmployeeResponse(autoMapper.toDTO(response), null);
        }catch (Exception ex){
            updateEmployeeResponse = new UpdateEmployeeResponse(null, new Error(ex.getMessage()));
        }

        return updateEmployeeResponse;
    }

    ///  Deletes an employee from the records
    @Transactional
    public DeleteEmployeeResponse deleteEmployee(DeleteEmployeeRequest deleteEmployeeRequest) {
        DeleteEmployeeResponse deleteEmployeeResponse;
        try{
            var response = employeeRepository.deleteEmployee(deleteEmployeeRequest.employeeId);
            deleteEmployeeResponse = new DeleteEmployeeResponse(response, null);
        }
        catch (Exception ex){
            deleteEmployeeResponse = new DeleteEmployeeResponse(false, new Error(ex.getMessage()));
        }
        return deleteEmployeeResponse;
    }
}
