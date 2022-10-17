package com.crud.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dto.CourseDto;
import com.crud.entities.Course;
import com.crud.exception.ResourceNotFoundException;
import com.crud.repo.CourseRepo;
import com.crud.service.CourseService;

import lombok.Setter;

@Service
public class CouseServiceImpl implements CourseService
{
	@Autowired
	private CourseRepo couseRepo;

	@Override
	public CourseDto addCourse(CourseDto courseDto) {
		
		Course course = new Course();
		course = this.dtoToCourse(courseDto);
		Course saveCourse = this.couseRepo.save(course);
		return this.courseToDto(saveCourse);
	}

	@Override
	public CourseDto updateCourse(CourseDto courseDto, Integer id) {
		
		Course course = this.couseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Couser id", id));
		course.setCourseName(courseDto.getCourseName());
		course.setCourseDescription(courseDto.getCourseDescription());
		course.setCourseAvailable(courseDto.isCourseAvailable());
		
		Course updateCouse = this.couseRepo.save(course);
		CourseDto courseDto1 = this.courseToDto(updateCouse);
		
		return courseDto1;
	}

	@Override
	public CourseDto getCourseById(Integer id) {
		
		Course course = this.couseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Couser id", id));
		
		
		return this.courseToDto(course);
	}

	@Override
	public void deleteCourseById(Integer id) {
		
		Course course = this.couseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Couser id", id));
		
		this.couseRepo.delete(course);
	}

	@Override
	public List<CourseDto> getAllCourse() {
		
		List<Course> allCourse = this.couseRepo.findAll();
		
		List<CourseDto> courseDto = allCourse.stream().map(course ->this.courseToDto(course)).collect(Collectors.toList());;
		return courseDto;
	}
	
	private Course dtoToCourse(CourseDto courseDto) {
		Course course = new Course();
		course.setCourseId(courseDto.getCourseId());
		course.setCourseName(courseDto.getCourseName());
		course.setCourseDescription(courseDto.getCourseDescription());
		course.setCourseAvailable(courseDto.isCourseAvailable());
		
		return course;
	}
	
	private CourseDto courseToDto(Course course) {
		CourseDto courseDto = new CourseDto();
		courseDto.setCourseId(course.getCourseId());
		courseDto.setCourseName(course.getCourseName());
		courseDto.setCourseDescription(course.getCourseDescription());
		courseDto.setCourseAvailable(course.isCourseAvailable());
		
		return courseDto;
	}

}
