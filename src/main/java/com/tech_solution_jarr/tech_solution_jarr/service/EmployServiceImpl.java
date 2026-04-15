package com.tech_solution_jarr.tech_solution_jarr.service;

import com.tech_solution_jarr.tech_solution_jarr.dto.CreateEmployRequest;
import com.tech_solution_jarr.tech_solution_jarr.dto.EmployResponse;
import com.tech_solution_jarr.tech_solution_jarr.entity.Employ;
import com.tech_solution_jarr.tech_solution_jarr.repository.EmployRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployServiceImpl implements EmployService {

    private final EmployRepository employRepository;

    // Constructor manual para asegurar la inyección de dependencias aunque Lombok falle
    public EmployServiceImpl(EmployRepository employRepository) {
        this.employRepository = employRepository;
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
        
        Employ savedEmploy = employRepository.save(employ);
        
        return new EmployResponse(
            savedEmploy.getId(), 
            savedEmploy.getName(),
            savedEmploy.getLastName(),
            savedEmploy.getEmail(),
            savedEmploy.getPosition(),
            savedEmploy.getSalary()
        );
    }

    @Override
    public List<EmployResponse> getAll() {
        return employRepository.findAll().stream()
                .map(e -> new EmployResponse(
                    e.getId(), 
                    e.getName(),
                    e.getLastName(),
                    e.getEmail(),
                    e.getPosition(),
                    e.getSalary()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public EmployResponse getById(Long id) {
        Employ employ = employRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        
        return new EmployResponse(
            employ.getId(), 
            employ.getName(),
            employ.getLastName(),
            employ.getEmail(),
            employ.getPosition(),
            employ.getSalary()
        );
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

        Employ updatedEmploy = employRepository.save(employ);

        return new EmployResponse(
            updatedEmploy.getId(), 
            updatedEmploy.getName(),
            updatedEmploy.getLastName(),
            updatedEmploy.getEmail(),
            updatedEmploy.getPosition(),
            updatedEmploy.getSalary()
        );
    }

    @Override
    public void delete(Long id) {
        if (!employRepository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        employRepository.deleteById(id);
    }
}
