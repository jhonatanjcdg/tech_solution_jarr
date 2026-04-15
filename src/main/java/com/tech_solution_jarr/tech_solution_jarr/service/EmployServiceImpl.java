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
        // 1. Instancia un Employ
        Employ employ = new Employ();
        
        // 2. Mapea los datos del DTO
        employ.setName(request.getName());
        
        // 3. Usa repository.save()
        Employ savedEmploy = employRepository.save(employ);
        
        // 4. Retorna un EmployResponse
        return new EmployResponse(savedEmploy.getId(), savedEmploy.getName());
    }

    @Override
    public List<EmployResponse> getAll() {
        return employRepository.findAll().stream()
                .map(e -> new EmployResponse(e.getId(), e.getName()))
                .collect(Collectors.toList());
    }
}
