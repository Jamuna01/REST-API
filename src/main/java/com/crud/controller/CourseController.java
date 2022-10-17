package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dto.CourseDto;
import com.crud.entities.Course;
import com.crud.service.CourseService;

@RestController
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/hi")
	public String hello() {
		return "hello there..";
	}
	
	//insert data
	@PostMapping("/insert")
	public ResponseEntity<CourseDto> insertData(@RequestBody CourseDto courseDto) {
		
		CourseDto courseDto1 = courseService.addCourse(courseDto);
		
		return new ResponseEntity<>(courseDto1, HttpStatus.CREATED);
	}
	
	//get single data
	@GetMapping("/{id}")
	public ResponseEntity<CourseDto> getSingleData(@PathVariable("id") Integer id) {
		CourseDto courseDto = courseService.getCourseById(id);
		return ResponseEntity.ok(courseDto);
	}
	
	//update data
	@PutMapping("/{id}")
	public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto, @PathVariable("id") Integer id) {
		
		CourseDto courseDto1 = this.courseService.updateCourse(courseDto, id);
		return ResponseEntity.ok(courseDto1);
	}
	
	//delete data
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable("id") Integer id) {
		this.courseService.deleteCourseById(id);
		
		return ResponseEntity.ok("course deleted");
		
	}
	
	//get all data
	@GetMapping("/alldata")
	public ResponseEntity<List<CourseDto>> getAllCourse() {
		
		return ResponseEntity.ok(this.courseService.getAllCourse());
	}
}
