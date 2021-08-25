package com.example.studysystem.service;

import com.example.studysystem.dao.LessonDaoRepository;
import com.example.studysystem.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    LessonDaoRepository lessonDaoRepository;

    public List<Lesson> getListLessons(){
        List<Lesson> lessons= lessonDaoRepository.findAll();
        return lessons;
    }

    public  void addLesson(Lesson lesson){
        lessonDaoRepository.save(lesson);
    }
    public Optional<Lesson> updateLessonById(int id){
       Optional<Lesson>lesson= lessonDaoRepository.findById(id);
    return lesson;
    }

    public void deleteLessonById(int id){
        lessonDaoRepository.deleteById(id);
    }


}
