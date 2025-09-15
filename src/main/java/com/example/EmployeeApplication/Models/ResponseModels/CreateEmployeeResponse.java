package com.example.EmployeeApplication.Models.ResponseModels;

import com.example.EmployeeApplication.Models.BaseModels.EmployeeDTO;
import com.example.EmployeeApplication.Models.BaseModels.Error;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateEmployeeResponse {
    public EmployeeDTO data;
    public com.example.EmployeeApplication.Models.BaseModels.Error error;
    public CreateEmployeeResponse(EmployeeDTO data, Error error){this.data = data; this.error = error;}
}
