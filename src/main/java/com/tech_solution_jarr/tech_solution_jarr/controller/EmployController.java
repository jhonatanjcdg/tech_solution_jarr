package com.tech_solution_jarr.tech_solution_jarr.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech_solution_jarr.tech_solution_jarr.dto.CreateEmployRequest;
import com.tech_solution_jarr.tech_solution_jarr.dto.EmployResponse;
import com.tech_solution_jarr.tech_solution_jarr.service.EmployService;

@RestController
@RequestMapping("/api/emploies")
public class EmployController {

    private final EmployService employService;

    public EmployController(EmployService employService) {
        this.employService = employService;
    }

    @PostMapping
    public ResponseEntity<EmployResponse> create(@Valid @RequestBody CreateEmployRequest request) {
        EmployResponse response = employService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployResponse>> getAll() {
        List<EmployResponse> employees = employService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployResponse> getById(@PathVariable Long id) {
        EmployResponse response = employService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployResponse> update(@PathVariable Long id, @Valid @RequestBody CreateEmployRequest request) {
        EmployResponse response = employService.update(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
