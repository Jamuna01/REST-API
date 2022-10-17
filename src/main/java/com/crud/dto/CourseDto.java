package com.crud.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CourseDto
{
	private int courseId;
	private String courseName;
	private String courseDescription;
	private boolean isCourseAvailable;
}
