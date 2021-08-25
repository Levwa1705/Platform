package com.example.studysystem.model;

import javax.persistence.*;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id ;
    @Column(name = "name")
    private String name;
    @Column(name = "content")
    private  String content;
    @Column(name = "educational_material")
    private  String education_material;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lesson;


    public Plan() {
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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
