package com.restdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restdemo.dao.CustomerDAO;
import com.restdemo.model.Course;
import com.restdemo.service.CourseService;

@RestController
public class CustomerRestController {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerRestController.class);

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public List<Course> getCourses() {
		return courseService.getAllCourses();
	}

	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable("id") String id) throws Exception {
		logger.debug("CLASS:[CustomerRestController] METHOD[getCourse] Starts");
		Course result = courseService.getCourse(id);
		logger.debug("CLASS:[CustomerRestController] METHOD[getCourse] Ends");
		return result;
	}

	/*@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerDAO.list();
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {

		Customer customer = customerDAO.get(id);
		if (customer == null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@PostMapping(value = "/customers")
	public ResponseEntity<Customer> createCustomer(
			@RequestBody Customer customer) {

		customerDAO.create(customer);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Long> deleteCustomer(@PathVariable Long id) {

		if (null == customerDAO.delete(id)) {
			return new ResponseEntity<Long>(id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Long>(id, HttpStatus.OK);

	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
			@RequestBody Customer customer) {

		customer = customerDAO.update(id, customer);

		if (null == customer) {
			return new ResponseEntity<Customer>(customer, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}*/

}
