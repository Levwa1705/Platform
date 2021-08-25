package com.example.studysystem.controller;

import com.example.studysystem.service.LessonService;
import com.example.studysystem.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    LessonService lessonService;
    @Autowired
    PlanService planService;

    @GetMapping({"/", "/home"})
    public String getHomePage(Model model) {
        return "index";
    }

    @GetMapping("/class")
    public String shop(Model model){
        model.addAttribute("lessons",lessonService.getListLessons());
        model.addAttribute("plans",planService.getPlans());
//        model.addAttribute("cartCount",GlobalData.cart.size());
        return "class";
    }
    @GetMapping("/class/lesson/{id}")
    public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("categories", lessonService.getListLessons());
        model.addAttribute("products", planService.getPlanById(id));
//        model.addAttribute("cartCount",GlobalData.cart.size());
        return "class";
    }
    @GetMapping("/class/viewlesson/{id}")
    public String viewProduct(Model model,@PathVariable int id){
        model.addAttribute("plan",planService.getPlanById(id).get());
//        model.addAttribute("cartCount",GlobalData.cart.size());

        return "viewLesson";

    }


}
