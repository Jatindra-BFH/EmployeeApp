package com.example.EmployeeApplication.Models.ResponseModels;

import com.example.EmployeeApplication.Models.BaseModels.EmployeeDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.example.EmployeeApplication.Models.BaseModels.Error;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetEmployeesResponse {
    public List<EmployeeDTO> data;
    public Error error;
    public GetEmployeesResponse(List<EmployeeDTO> employeeDTOList, Error error){ this.data = employeeDTOList; this.error = error;}
}
