package com.crud.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.entities.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}
