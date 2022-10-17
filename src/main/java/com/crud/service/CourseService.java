package com.crud.service;

import java.util.List;

import com.crud.dto.CourseDto;

public interface CourseService {

	CourseDto addCourse(CourseDto courseDto);
	CourseDto updateCourse(CourseDto courseDto, Integer id);
	CourseDto getCourseById(Integer id);
	void deleteCourseById(Integer id);
	List<CourseDto> getAllCourse();
}
