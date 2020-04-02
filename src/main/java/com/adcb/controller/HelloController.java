package com.adcb.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adcb.vo.Employee;
@RestController
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	private static final List<Employee> EMPLIST = new ArrayList<>();
	
	@RequestMapping("/")
	public String getIndex() {
		return "Hello Employee";
	}
	
	@RequestMapping("/employees")
	public List<Employee> getEmployees() {
		logger.info("get employees");
		return EMPLIST;
	}
	
	@RequestMapping("/employee/{id}")
	public Employee getSpecificEmployee(@PathVariable int id) {
		logger.info("get specific employee");
		return EMPLIST.get(id - 1);   //checkstyle
	}
	
	@PostMapping("/employee") 
	public String addEmployee(@RequestBody Employee employee) {
		logger.info("adding employee");
		EMPLIST.add(employee);
		logger.info("----------Employee added---------------");
		return "Added";
	}
	
	
	
}
