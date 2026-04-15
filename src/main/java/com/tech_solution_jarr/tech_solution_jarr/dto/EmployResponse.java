package com.tech_solution_jarr.tech_solution_jarr.dto;

public class EmployResponse {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String position;
    private Double salary;
    private Long departamentId;
    private String departamentName;

    public EmployResponse() {}

    public EmployResponse(Long id, String name, String lastName, String email, String position, Double salary, Long departamentId, String departamentName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.departamentId = departamentId;
        this.departamentName = departamentName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
    public Long getDepartamentId() { return departamentId; }
    public void setDepartamentId(Long departamentId) { this.departamentId = departamentId; }
    public String getDepartamentName() { return departamentName; }
    public void setDepartamentName(String departamentName) { this.departamentName = departamentName; }
}
