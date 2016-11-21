package com.restdemo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.restdemo.dao.CourseDAO;
import com.restdemo.model.Course;

@Component
public class CourseDAOImpl extends JdbcDaoSupport implements CourseDAO{
	
	private static final Logger logger =
			LoggerFactory.getLogger(CourseDAOImpl.class);

	@Autowired
	public CourseDAOImpl(DataSource dataSource){
		this.setDataSource(dataSource);
	}
	
	public List<Course> getAllCourses() {
		System.out.println("CourseDAO start");
		List<Course> result = new ArrayList<Course>();
		String sql = "SELECT * FROM course_info";
		result = getJdbcTemplate().query(sql, new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setId(rs.getString("Course_Id"));
				course.setName(rs.getString("Course_Name"));
				course.setPeriod(rs.getInt("Period"));
				course.setFees(rs.getDouble("Course_Fees"));
				return course;
			}

		});

		System.out.println("Total Courses retrieved:" + result.size());
		System.out.println("CourseDAO end");
		return result;
	}
	
	@ReadThroughSingleCache(namespace = "CourseObj", expiration = 3600)
	public Course getCourse(@ParameterValueKeyProvider String id) throws Exception{
		logger.debug("CLASS:[CourseDAOImpl] METHOD[getCourse] Starts");
		String sql = "SELECT * FROM course_info where Course_Id=?";
		Course course = getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setId(rs.getString("Course_Id"));
				course.setName(rs.getString("Course_Name"));
				course.setPeriod(rs.getInt("Period"));
				course.setFees(rs.getDouble("Course_Fees"));
				return course;
			}

		});
		/*if(course!=null)
			throw new Exception("Exception thrown in DAO");*/
		logger.debug("CLASS:[CourseDAOImpl] METHOD[getCourse] Ends");
		return course;
		
	}
}
