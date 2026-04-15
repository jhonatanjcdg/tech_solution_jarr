package com.tech_solution_jarr.tech_solution_jarr.service;

import com.tech_solution_jarr.tech_solution_jarr.dto.CreateEmployRequest;
import com.tech_solution_jarr.tech_solution_jarr.dto.EmployResponse;
import java.util.List;

public interface EmployService {
    EmployResponse create(CreateEmployRequest request);
    List<EmployResponse> getAll();
    EmployResponse getById(Long id);
}
