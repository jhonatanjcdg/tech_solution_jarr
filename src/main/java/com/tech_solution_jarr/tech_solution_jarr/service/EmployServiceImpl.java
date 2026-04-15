package com.tech_solution_jarr.tech_solution_jarr.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tech_solution_jarr.tech_solution_jarr.dto.CreateEmployRequest;
import com.tech_solution_jarr.tech_solution_jarr.dto.EmployResponse;
import com.tech_solution_jarr.tech_solution_jarr.entity.Department;
import com.tech_solution_jarr.tech_solution_jarr.entity.Employ;
import com.tech_solution_jarr.tech_solution_jarr.repository.DepartmentRepository;
import com.tech_solution_jarr.tech_solution_jarr.repository.EmployRepository;

@Service
public class EmployServiceImpl implements EmployService {

    private final EmployRepository employRepository;
    private final DepartmentRepository departmentRepository;

    public EmployServiceImpl(EmployRepository employRepository, DepartmentRepository departmentRepository) {
        this.employRepository = employRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public EmployResponse create(CreateEmployRequest request) {
        if (employRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Employ employ = new Employ();
        employ.setName(request.getName());
        employ.setLastName(request.getLastName());
        employ.setEmail(request.getEmail());
        employ.setPosition(request.getPosition());
        employ.setSalary(request.getSalary());

        if (request.getDepartamentId() != null) {
            Department department = departmentRepository.findById(request.getDepartamentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            employ.setDepartment(department);
        }

        Employ savedEmploy = employRepository.save(employ);
        return mapToResponse(savedEmploy);
    }

    @Override
    public List<EmployResponse> getAll() {
        return employRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployResponse getById(Long id) {
        Employ employ = employRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return mapToResponse(employ);
    }

    @Override
    public EmployResponse update(Long id, CreateEmployRequest request) {
        Employ employ = employRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employ.setName(request.getName());
        employ.setLastName(request.getLastName());
        employ.setEmail(request.getEmail());
        employ.setPosition(request.getPosition());
        employ.setSalary(request.getSalary());

        if (request.getDepartamentId() != null) {
            Department department = departmentRepository.findById(request.getDepartamentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            employ.setDepartment(department);
        }

        Employ updatedEmploy = employRepository.save(employ);
        return mapToResponse(updatedEmploy);
    }

    @Override
    public void delete(Long id) {
        if (!employRepository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        employRepository.deleteById(id);
    }

    private EmployResponse mapToResponse(Employ employ) {
        return new EmployResponse(
            employ.getId(),
            employ.getName(),
            employ.getLastName(),
            employ.getEmail(),
            employ.getPosition(),
            employ.getSalary(),
            employ.getDepartment() != null ? employ.getDepartment().getId() : null,
            employ.getDepartment() != null ? employ.getDepartment().getName() : null
        );
    }
}
