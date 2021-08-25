package com.example.studysystem.controller;

import com.example.studysystem.dto.PlanDTO;
import com.example.studysystem.model.Lesson;
import com.example.studysystem.model.Plan;
import com.example.studysystem.service.LessonService;
import com.example.studysystem.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    LessonService lessonService;

    @GetMapping("/admin")
    public String index() {
        return "index";
    }

    @GetMapping("/admin/lesson")
    public String getLessons(Model model) {
        model.addAttribute("lessons",lessonService.getListLessons());
        return "les";
    }
    @GetMapping("/admin/lesson/add")
    public String getLessonAdd(Model model){
        model.addAttribute("lesson", new Lesson());
    return "lessonAdd";
    }
    @PostMapping("/admin/lesson/add")
    public String postLessonAdd(@ModelAttribute("lesson") Lesson lesson){
        lessonService.addLesson(lesson);
    return "redirect:/admin/lesson";
    }

    @GetMapping("/admin/lesson/update/{id}")
    public String updateLesson(@PathVariable int id, Model model){
        Optional<Lesson> lesson = lessonService.updateLessonById(id);
        if (lesson.isPresent()){
            model.addAttribute("lesson",lesson.get());
            return "lessonAdd";}
         else
                return "404";
    }
    @GetMapping("/admin/lesson/delete/{id}")
    public String deleteLesson(@PathVariable int id, Model model){
        lessonService.deleteLessonById(id);
        model.addAttribute(lessonService.getListLessons());
        return "redirect:/admin/lesson";
    }
/*------------------------------------------------ PlanController -----------------------------------------------------------*/
    @Autowired
   public PlanService planService;

    @GetMapping("/admin/plan")
    public String getPlan(Model model){
        model.addAttribute("plans",planService.getPlans());
        return "plan";
    }

    @GetMapping("/admin/plan/add")
    public String getPlanAdd(Model model){
    model.addAttribute("planDTO",new PlanDTO());
    model.addAttribute("lessons",lessonService.getListLessons());
        return "addPlan";
    }
    @PostMapping("/admin/plan/add")
    public String postPlanAdd(@ModelAttribute("planDTO") PlanDTO planDTO){
        Plan plan = new Plan();
        plan.setName(planDTO.getName());
        plan.setContent(planDTO.getContent());
        plan.setEducation_material(planDTO.getEducation_material());
        plan.setLesson(lessonService.updateLessonById(planDTO.getLesson_id()).get());
        planService.addPlan(plan);
        return "redirect:/admin/plan";
    }
    @GetMapping("/admin/plan/delete/{id}")
    public String deletePlan(@PathVariable int id,Model model){
        planService.deletePlan(id);
        model.addAttribute(planService.getPlans());
        return "redirect:/admin/plan";
    }
    @GetMapping ("/admin/plan/update/{id}")
    public String updatePlan(@PathVariable int id,Model model){
        Plan plan= planService.getPlanById(id).get();
        PlanDTO planDTO= new PlanDTO();
        planDTO.setName(plan.getName());
        planDTO.setLesson_id(plan.getId());
        planDTO.setEducation_material(plan.getEducation_material());
        planDTO.setContent(plan.getContent());
        model.addAttribute("planDTO",planDTO);
        model.addAttribute("lessons",lessonService.getListLessons());
        return "addPlan";

    }




}
