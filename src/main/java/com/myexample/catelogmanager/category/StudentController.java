package com.myexample.catelogmanager.category;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@RequestMapping(method = RequestMethod.GET, value = "/students")
	public ResponseEntity<GroupBean> getAllCategory() {
		GroupBean grp = service.getAllStudent();
		return new ResponseEntity<GroupBean>(grp, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/student/{id}")
	public ResponseEntity<String> updateCategory(@Valid @RequestBody Student s, @PathVariable int id) {
		service.updateStudent(id, s.getStatus());
		return new ResponseEntity<String>("UPDATED!!!", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/student")
	public ResponseEntity<String> createStudent(@Valid @RequestBody Student s) {
		service.createStudent(s);
		return new ResponseEntity<String>("Created!!!", HttpStatus.OK);
	}

}
