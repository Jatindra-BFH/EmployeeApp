package com.example.EmployeeApplication.Models.ResponseModels;

import com.example.EmployeeApplication.Models.BaseModels.EmployeeDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.example.EmployeeApplication.Models.BaseModels.Error;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateEmployeeResponse {
    public EmployeeDTO data;
    public Error error;
    public UpdateEmployeeResponse(EmployeeDTO data, Error error){this.data = data; this.error = error;}
}
