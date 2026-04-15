package com.tech_solution_jarr.tech_solution_jarr.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tech_solution_jarr.tech_solution_jarr.dto.CreateEmployRequest;
import com.tech_solution_jarr.tech_solution_jarr.dto.EmployResponse;
import com.tech_solution_jarr.tech_solution_jarr.entity.Employ;
import com.tech_solution_jarr.tech_solution_jarr.repository.EmployRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployServiceImpl implements EmployService {

    private final EmployRepository employRepository;

    @Override
    public EmployResponse create(CreateEmployRequest request) {
        Employ employ = new Employ();
        employ.setName(request.getName());
        
        Employ savedEmploy = employRepository.save(employ);
        
        return new EmployResponse(savedEmploy.getId(), savedEmploy.getName());
    }

    @Override
    public List<EmployResponse> getAll() {
        return employRepository.findAll().stream()
                .map(employ -> new EmployResponse(employ.getId(), employ.getName()))
                .collect(Collectors.toList());
    }
}
