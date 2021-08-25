package com.example.studysystem.dao;

import com.example.studysystem.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonDaoRepository extends JpaRepository<Lesson,Integer> {
}
