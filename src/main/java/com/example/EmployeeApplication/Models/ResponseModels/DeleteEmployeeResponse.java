package com.example.EmployeeApplication.Models.ResponseModels;

import com.example.EmployeeApplication.Models.BaseModels.Error;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteEmployeeResponse {
    public boolean data;
    public Error error;
    public DeleteEmployeeResponse(boolean data, Error error){this.data = data; this.error = error;}
}
