package com.restdemo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restdemo.dao.CourseDAO;
import com.restdemo.model.Course;
import com.restdemo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	private static final Logger logger =
			LoggerFactory.getLogger(CourseServiceImpl.class);
	
	@Autowired
	CourseDAO courseDAO;
	
	public Course getCourse(String id) throws Exception{
		logger.debug("CLASS:[CustomerRestController] METHOD[getCourse] Starts");
		Course result = courseDAO.getCourse(id);
		logger.debug("CLASS:[CustomerRestController] METHOD[getCourse] Ends");
		/*if(result!=null)
			throw new Exception("An Exception");*/
		return result;
	}
	
	public List<Course> getAllCourses(){
		return courseDAO.getAllCourses();
	}

}
