package com.tech_solution_jarr.tech_solution_jarr.service;

import java.util.List;

import com.tech_solution_jarr.tech_solution_jarr.dto.CreateEmployRequest;
import com.tech_solution_jarr.tech_solution_jarr.dto.EmployResponse;

public interface EmployService {
    EmployResponse create(CreateEmployRequest request);
    
    List<EmployResponse> getAll();
}
