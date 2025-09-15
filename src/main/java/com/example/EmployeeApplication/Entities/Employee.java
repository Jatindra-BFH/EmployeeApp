package com.example.EmployeeApplication.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_fname")
    private String employeeFname;

    @Column(name = "employee_mname")
    private String employeeMname;

    @Column(name = "employee_lname")
    private String employeeLname;

    @Column(name = "employee_dob")
    private Date employeeDob;

    @Column(name = "employee_curr_addr")
    private String employeeCurrAddr;

    @Column(name = "employee_perm_addr")
    private String employeePermAddr;

    @Column(name = "employee_email_id", nullable = false)
    private String employeeEmailId;

    @Column(name = "employee_contact_no", nullable = false)
    private String employeeContactNo;

    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "company_id")
    private Integer companyId;

    public Integer getEmployeeId() { return employeeId; }
    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }

    public String getEmployeeFname() { return employeeFname; }
    public void setEmployeeFname(String employeeFname) { this.employeeFname = employeeFname; }

    public String getEmployeeMname() { return employeeMname; }
    public void setEmployeeMname(String employeeMname) { this.employeeMname = employeeMname; }

    public String getEmployeeLname() { return employeeLname; }
    public void setEmployeeLname(String employeeLname) { this.employeeLname = employeeLname; }

    public Date getEmployeeDob() { return employeeDob; }
    public void setEmployeeDob(Date employeeDob) { this.employeeDob = employeeDob; }

    public String getEmployeeCurrAddr() { return employeeCurrAddr; }
    public void setEmployeeCurrAddr(String employeeCurrAddr) { this.employeeCurrAddr = employeeCurrAddr; }

    public String getEmployeePermAddr() { return employeePermAddr; }
    public void setEmployeePermAddr(String employeePermAddr) { this.employeePermAddr = employeePermAddr; }

    public String getEmployeeEmailId() { return employeeEmailId; }
    public void setEmployeeEmailId(String employeeEmailId) { this.employeeEmailId = employeeEmailId; }

    public String getEmployeeContactNo() { return employeeContactNo; }
    public void setEmployeeContactNo(String employeeContactNo) { this.employeeContactNo = employeeContactNo; }

    public Integer getProjectId() { return projectId; }
    public void setProjectId(Integer projectId) { this.projectId = projectId; }

    public Integer getCompanyId() { return companyId; }
    public void setCompanyId(Integer companyId) { this.companyId = companyId; }
}
