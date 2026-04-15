package com.tech_solution_jarr.tech_solution_jarr.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployRequest {

    @NotBlank(message = "Name is required")
    private String name;

}
