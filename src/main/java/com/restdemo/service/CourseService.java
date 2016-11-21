package com.restdemo.service;

import java.util.List;

import com.restdemo.model.Course;

public interface CourseService {

	public Course getCourse(String id) throws Exception;

	public List<Course> getAllCourses();

}
