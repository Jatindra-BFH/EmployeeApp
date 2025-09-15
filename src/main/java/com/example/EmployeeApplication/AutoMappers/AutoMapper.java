package com.example.EmployeeApplication.AutoMappers;

import com.example.EmployeeApplication.Entities.Employee;
import com.example.EmployeeApplication.Models.BaseModels.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class AutoMapper {

    public EmployeeDTO toDTO(Employee employee) {
        if (employee == null) return null;

        EmployeeDTO dto = new EmployeeDTO();
        dto.employeeId = employee.getEmployeeId();
        dto.employeeFirstName = employee.getEmployeeFname();
        dto.employeeMiddleName = employee.getEmployeeMname();
        dto.employeeLastName = employee.getEmployeeLname();
        dto.employeeDOB = employee.getEmployeeDob();
        dto.employeeCurrentAddress = employee.getEmployeeCurrAddr();
        dto.employeePermanentAddress = employee.getEmployeePermAddr();
        dto.employeeEmailId = employee.getEmployeeEmailId();
        dto.employeeContactNo = employee.getEmployeeContactNo();
        dto.projectId = employee.getProjectId();
        dto.companyId = employee.getCompanyId();

        return dto;
    }

    public Employee toEntity(EmployeeDTO dto) {
        if (dto == null) return null;

        Employee employee = new Employee();
        employee.setEmployeeId(dto.employeeId);
        employee.setEmployeeFname(dto.employeeFirstName);
        employee.setEmployeeMname(dto.employeeMiddleName);
        employee.setEmployeeLname(dto.employeeLastName);
        employee.setEmployeeDob(dto.employeeDOB);
        employee.setEmployeeCurrAddr(dto.employeeCurrentAddress);
        employee.setEmployeePermAddr(dto.employeePermanentAddress);
        employee.setEmployeeEmailId(dto.employeeEmailId);
        employee.setEmployeeContactNo(dto.employeeContactNo);
        employee.setProjectId(dto.projectId);
        employee.setCompanyId(dto.companyId);

        return employee;
    }
}
