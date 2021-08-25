package com.example.studysystem.service;

import com.example.studysystem.dao.PlanDaoRepository;
import com.example.studysystem.dto.PlanDTO;
import com.example.studysystem.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    @Autowired
    PlanDaoRepository planDaoRepository;

    public List<Plan> getPlans() {
        List<Plan> plans = planDaoRepository.findAll();
        return plans;
    }

    public void addPlan(Plan plan){
        planDaoRepository.save(plan);
    }
    public void deletePlan(int id){ planDaoRepository.deleteById(id);}
    public Optional<Plan> getPlanById(int id){
       Optional<Plan> plan= planDaoRepository.findById(id);
        return plan;
    }


}
