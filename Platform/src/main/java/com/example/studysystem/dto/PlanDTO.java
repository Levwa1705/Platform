package com.example.studysystem.dto;

import com.example.studysystem.model.Lesson;


public class PlanDTO {

    private  int id ;

    private String name;

    private  String content;

    private  String education_material;

    private int lesson_id;

    public PlanDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEducation_material() {
        return education_material;
    }

    public void setEducation_material(String education_material) {
        this.education_material = education_material;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }
}
