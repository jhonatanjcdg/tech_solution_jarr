package com.tech_solution_jarr.tech_solution_jarr.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class CreateEmployRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Position cannot be empty")
    private String position;

    private Double salary;

    private Long departamentId;

    public CreateEmployRequest() {}

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
}
