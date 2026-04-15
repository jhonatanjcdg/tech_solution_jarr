package com.tech_solution_jarr.tech_solution_jarr.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class CreateEmployRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    public CreateEmployRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
