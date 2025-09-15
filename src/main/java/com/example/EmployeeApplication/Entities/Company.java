package com.example.EmployeeApplication.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;   // Primary key
    private String name;
    private String address;

    // getters and setters
}
