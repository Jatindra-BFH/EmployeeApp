package com.example.EmployeeApplication.Models.ResponseModels;

import com.example.EmployeeApplication.Models.BaseModels.EmployeeDTO;
import com.example.EmployeeApplication.Models.BaseModels.Error;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetEmployeeResponse {
    public EmployeeDTO data;
    public Error error;
    public GetEmployeeResponse(EmployeeDTO data, Error error){this.data = data; this.error = error;}
}
