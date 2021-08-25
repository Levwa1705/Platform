package com.example.studysystem.dao;

import com.example.studysystem.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanDaoRepository extends JpaRepository<Plan,Integer> {
}
