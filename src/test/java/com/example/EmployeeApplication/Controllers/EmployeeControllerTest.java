package com.example.EmployeeApplication.Controllers;

import com.example.EmployeeApplication.Models.BaseModels.EmployeeDTO;
import com.example.EmployeeApplication.Models.RequestModels.*;
import com.example.EmployeeApplication.Models.ResponseModels.*;
import com.example.EmployeeApplication.Services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)  // Load only the controller layer
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;  // Used to perform mock HTTP requests

    @MockBean
    private EmployeeService service;  // Mock the service layer

    @Autowired
    private ObjectMapper objectMapper;  // Convert objects to JSON

    private CreateEmployeeRequest createRequest;
    private CreateEmployeeResponse createResponse;

    @BeforeEach
    void setUp() {
        createRequest = new CreateEmployeeRequest();
        createRequest.employee.employeeFirstName = "John";
        createRequest.employee.employeeLastName =  "Doe";
        createRequest.employee.employeeEmailId = "john.doe@gmail.com";
        createRequest.employee.companyId = 101;
        createRequest.employee.projectId = 302;

        var modelResponse = new EmployeeDTO();
        modelResponse.employeeId = 1000;
        createResponse = new CreateEmployeeResponse(modelResponse, null);
    }

    @Test
    void testCreateEmployee_Success() throws Exception {
        // Mock the service layer response
        Mockito.when(service.createEmployee(any(CreateEmployeeRequest.class)))
                .thenReturn(createResponse);

        mockMvc.perform(post("/api/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.employeeId").value(1))
                .andExpect(jsonPath("$.error").doesNotExist());
    }

    @Test
    void testGetAllEmployees_Success() throws Exception {
        GetEmployeesResponse response = new GetEmployeesResponse();
        response.error = null;
        Mockito.when(service.getAllEmployees()).thenReturn(response);

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetEmployeeById_Success() throws Exception {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.error = null;
        Mockito.when(service.getEmployeeById(any(GetEmployeeRequest.class)))
                .thenReturn(response);

        mockMvc.perform(get("/api/employee/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateEmployee_Success() throws Exception {
        UpdateEmployeeRequest updateRequest = new UpdateEmployeeRequest();
        updateRequest.name = "Updated John";

        UpdateEmployeeResponse updateResponse = new UpdateEmployeeResponse();
        updateResponse.error = null;

        Mockito.when(service.updateEmployee(any(UpdateEmployeeRequest.class)))
                .thenReturn(updateResponse);

        mockMvc.perform(put("/api/employee/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void testDeleteEmployee_Success() throws Exception {
        DeleteEmployeeResponse response = new DeleteEmployeeResponse();
        response.error = null;

        Mockito.when(service.deleteEmployee(any(DeleteEmployeeRequest.class)))
                .thenReturn(response);

        mockMvc.perform(delete("/api/employee/1"))
                .andExpect(status().isOk());
    }
}
