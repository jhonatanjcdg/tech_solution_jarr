package com.tech_solution_jarr.tech_solution_jarr.repository;

import com.tech_solution_jarr.tech_solution_jarr.entity.Employ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepository extends JpaRepository<Employ, Long> {
}
