package com.restdemo.dao;

import java.util.List;

import com.restdemo.model.Course;

public interface CourseDAO {

	public List<Course> getAllCourses();

	public Course getCourse(String id) throws Exception;

}
