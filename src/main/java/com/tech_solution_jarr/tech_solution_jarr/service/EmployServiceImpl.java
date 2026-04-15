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
@RequiredArgsConstructor
public class EmployServiceImpl implements EmployService {

    private final EmployRepository employRepository;

    @Override
    public EmployResponse create(CreateEmployRequest request) {
        // Lógica de negocio extra: validar que el email no se repita
        if (employRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // 1. Instancia un Employ
        Employ employ = new Employ();
        
        // 2. Mapea los datos del DTO
        employ.setName(request.getName());
        employ.setLastName(request.getLastName());
        employ.setEmail(request.getEmail());
        employ.setPosition(request.getPosition());
        employ.setSalary(request.getSalary());
        
        // 3. Usa repository.save()
        Employ savedEmploy = employRepository.save(employ);
        
        // 4. Retorna un EmployResponse
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
}
